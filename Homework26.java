package javaProdv.lesson6;

import javax.imageio.IIOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Homework26 {

}

class Server extends Thread {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        Thread thread1 = new Thread(() -> {
            try {
                while (true) {
                    String newMessage = dataInputStream.readUTF();
                    System.out.println("Клиент:" + newMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Scanner scanner = new Scanner(System.in);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        Thread thread2 = new Thread(() -> {
            try {
                while (true) {
                    String newMessage = scanner.nextLine();
                    dataOutputStream.writeUTF(newMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }
}


class Client extends Thread {
    public static void main(String[] args) throws IOException{

        Socket socket = new Socket("localhost", 8000);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        Thread thread1 = new Thread(() -> {
            try {
                while (true) {
                    String newMessage = dataInputStream.readUTF();
                    System.out.println("Сервер:" + newMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Scanner scanner = new Scanner(System.in);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        Thread thread2 = new Thread(() -> {
            try {
                while (true) {
                    String newMessage = scanner.nextLine();
                    dataOutputStream.writeUTF(newMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }
}
