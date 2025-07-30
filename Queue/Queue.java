import java.util.Scanner;

public class Queue {
    private int[] arr;
    private int front; 
    private int rear;  
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }

    public void enqueue(int item) {
        if (rear == capacity) {
            System.out.println("Queue is full!");
        } else {
            arr[rear] = item;
            rear++;
            System.out.println(item + " added to the queue.");
        }
    }

    public void dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty!");
        } else {
            int removed = arr[front];
            for (int i = 0; i < rear - 1; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            System.out.println(removed + " removed from the queue.");
        }
    }

   
    public void display() {
        if (front == rear) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i < rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();
        Queue queue = new Queue(size);

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Enqueue (add)");
            System.out.println("2. Dequeue (remove)");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter value to add: ");
                int val = sc.nextInt();
                queue.enqueue(val);
            } else if (choice == 2) {
                queue.dequeue();
            } else if (choice == 3) {
                queue.display();
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}