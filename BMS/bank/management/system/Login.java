package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField  pinTextField;

    Login() {

        setTitle("Automated Teller Machine");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(130, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(250, 40, 400, 40);
        text.setForeground(new Color(70, 130, 180));
        add(text);

        JLabel cardno = new JLabel("Card No :");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        cardno.setForeground(new Color(240, 128, 128));
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(cardTextField);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        pin.setForeground(new Color(240, 128, 128));
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 280, 250, 30);
        login.setBackground(Color.PINK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 330, 100, 30);
        signup.setBackground(Color.PINK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        clear = new JButton("CLEAR");
        clear.setBounds(450, 330, 100, 30);
        clear.setBackground(Color.PINK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        getContentPane().setBackground(new Color(173, 216, 230));

        setSize(800, 480);
        setVisible(true);
        setLocation(450, 340);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        } else if (ae.getSource() == login) {

        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
