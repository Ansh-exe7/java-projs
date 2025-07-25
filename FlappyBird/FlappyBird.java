import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird implements ActionListener, KeyListener {
    public static FlappyBird flappyBird;
    public final int WIDTH = 800, HEIGHT = 600;
    public Renderer renderer;
    public Rectangle bird;
    public ArrayList<Rectangle> columns;
    public int ticks, yMotion, score;
    public boolean gameOver, started;
    public Random rand;

    public FlappyBird() {
        JFrame jframe = new JFrame();
        
        // Increased the delay from 20ms to 30ms for smoother gameplay
        Timer timer = new Timer(25, this);

        renderer = new Renderer();
        rand = new Random();

        jframe.setVisible(true);
        jframe.add(renderer);
        jframe.setBounds(470, 270, 600, 400);
        jframe.setTitle("Flappy Bird");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.addKeyListener(this);
        jframe.setResizable(false);
        jframe.setVisible(true);

        bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
        columns = new ArrayList<>();

        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);

        timer.start();
    }

    public void addColumn(boolean start) {
        int space = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);

        if (start) {
            columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 120, width, height));
            columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 0, width, HEIGHT - height - space));
        } else {
            columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
            columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));
        }
    }

    public void paintColumn(Graphics g, Rectangle column) {
        g.setColor(Color.green.darker());
        g.fillRect(column.x, column.y, column.width, column.height);
    }

    public void jump() {
        if (gameOver) {
            bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
            columns.clear();
            yMotion = 0;
            score = 0;

            addColumn(true);
            addColumn(true);
            addColumn(true);
            addColumn(true);

            gameOver = false;
        }

        if (!started) {
            started = true;
        } else if (!gameOver) {
            if (yMotion > 0) {
                yMotion = 0;
            }

            yMotion -= 7;  // Reduced jump height for smoother gameplay
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int speed = 7;  // Reduced speed from 10 to 7 for smoother and slower movement

        ticks++;

        if (started) {
            if (!gameOver) {
                for (int i = 0; i < columns.size(); i++) {
                    Rectangle column = columns.get(i);
                    column.x -= speed;
                }

                if (ticks % 2 == 0 && yMotion < 15) {
                    yMotion += 1;  // Reduced acceleration for smoother descent
                }

                for (int i = 0; i < columns.size(); i++) {
                    Rectangle column = columns.get(i);

                    if (column.x + column.width < 0) {
                        columns.remove(column);

                        if (column.y == 0) {
                            addColumn(false);
                        }
                    }
                }

                bird.y += yMotion;

                for (Rectangle column : columns) {
                    if (column.y == 0 && bird.x + bird.width / 2 > column.x + column.width / 2 - 10 && bird.x + bird.width / 2 < column.x + column.width / 2 + 10) {
                        score++;
                    }

                    if (column.intersects(bird)) {
                        gameOver = true;

                        if (bird.x <= column.x) {
                            bird.x = column.x - bird.width;
                        } else {
                            if (column.y != 0) {
                                bird.y = column.y - bird.height;
                            } else if (bird.y < column.height) {
                                bird.y = column.height;
                            }
                        }
                    }
                }

                if (bird.y > HEIGHT - 120 || bird.y < 0) {
                    gameOver = true;
                }

                if (bird.y + yMotion >= HEIGHT - 120) {
                    bird.y = HEIGHT - 120 - bird.height;
                    gameOver = true;
                }
            }
        }

        renderer.repaint();
    }

    public void repaint(Graphics g) {
        g.setColor(new Color(135, 206, 250));
        g.fillRect(0, 0, WIDTH, HEIGHT);
    
        g.setColor(new Color(255, 255, 160));
        g.fillRect(0, HEIGHT - 120, WIDTH, 120);
    
        g.setColor(new Color(119, 221, 119));
        g.fillRect(0, HEIGHT - 120, WIDTH, 20);
    
        g.setColor(Color.red);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);
    
        for (Rectangle column : columns) {
            paintColumn(g, column);
        }
    
        g.setColor(Color.white);
    
        if (!started) {
            g.setFont(new Font("DialogInput", Font.BOLD, 48));
            String startText = "Press SPACE to Start";
            g.drawString(startText, (WIDTH - g.getFontMetrics().stringWidth(startText)) / 2, HEIGHT / 2 - 50);
        }
    
        if (gameOver) {
            g.setFont(new Font("Monospaced", Font.PLAIN, 72));
            String gameOverText = "Game Over!";
            g.drawString(gameOverText, (WIDTH - g.getFontMetrics().stringWidth(gameOverText)) / 2, HEIGHT / 2 - 50);
    
            // Display the final score when the game is over
            g.setFont(new Font("Monospaced", Font.ITALIC, 48));
            String finalScoreText = "Final Score: " + score;
            g.drawString(finalScoreText, (WIDTH - g.getFontMetrics().stringWidth(finalScoreText)) / 2, HEIGHT / 2 + 25);

            g.setFont(new Font("Courier New", Font.BOLD, 30));
            String playAgainText = "Press SPACE to start again!! ";
            g.drawString(playAgainText, (WIDTH - g.getFontMetrics().stringWidth(playAgainText)) / 2, HEIGHT / 2 + 70);
        }
    
        if (!gameOver && started) {
            g.setFont(new Font("Monospaced", Font.ITALIC, 100));
            String scoreText = String.valueOf(score);
            g.drawString(scoreText, (WIDTH - g.getFontMetrics().stringWidth(scoreText)) / 2, 100);
        }
    }  

    public static void main(String[] args) {
        flappyBird = new FlappyBird();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
