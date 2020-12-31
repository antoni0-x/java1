package javaProdv.lesson8;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Server {

    List<ClientHandler> clients = new ArrayList<>();
    Map<String, List<Message>> chats = new HashMap<>();

    Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            AuthService authService = new AuthService();
            // Обработчик клиентов
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    new ClientHandler(authService, this, socket);
                }).start();
            }
        } catch (IOException e) {
            System.out.println("Сервер прекратил работу с ошибкой");
            e.printStackTrace();
        }
    }

//    synchronized void sendBroadCastMessage(Client sender, String text) {
//        for (int i = 0; i < clients.size(); i++) {
//            String recipientLogin = clients.get(i).client.login;
//            sendMessageTo(sender, recipientLogin, text);
//        }
//    }

    synchronized void sendMessageTo(Client client1, String client2, String message) {
        String senderLogin = client1.login;
        String key;
        if (client2 == null) {
            key = senderLogin;
        } else if (senderLogin.compareTo(client2) > 0) {
            key = senderLogin + client2;
        } else {
            key = client2 + senderLogin;
        }
        if (!chats.containsKey(key)) {
            chats.put(key, new ArrayList());
        }

        chats.get(key).add(new Message(client1, message));
        ClientHandler recipient = null;
        for (int i = 0; i < clients.size(); i++) {
            ClientHandler client = clients.get(i);
            if (client.client.login.equals(client2)) {
                recipient = client;
            }
        }

        if (recipient != null) {
            recipient.sendMessage(client1, message);
            System.out.println("Отправлено сообщение для " + client2);
        } else {
            for (int i = 0; i < clients.size(); i++) {
                ClientHandler recipient2 = clients.get(i);
                if (!recipient2.client.login.equals(senderLogin)) {
                    recipient2.sendMessage(client1, message);
                }
            }
            System.out.println("Отправлено сообщение для всех");
        }

    }

    synchronized void onNewClient(ClientHandler clientHandler) {
        clients.add(clientHandler);
        sendMessageTo(clientHandler.client, null, "Вошел в чат");
    }

    synchronized void onClientDisconnected(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        sendMessageTo(clientHandler.client, null, "Покинул чат");
    }

    public static void main(String[] args) {
        new Server();
    }
}