package javaProdv.lesson8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;

import java.util.TimerTask;

class ClientHandler {
    AuthService authService;
    Server server;
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    Client client;

    ClientHandler(AuthService authService, Server server, Socket socket) {
        this.authService = authService;
        this.server = server;
        this.socket = socket;
        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());

            if (!auth(dataInputStream, dataOutputStream)) {

                // Удаляемся из сервера
                dataInputStream.close();
                dataOutputStream.close();
                socket.close();
                server.onClientDisconnected(this);
                return;
            }
            server.onNewClient(this);
            messageListener(dataInputStream);
        } catch (IOException e) {
            // Удаляемся из сервера
            try {
                dataInputStream.close();
                dataOutputStream.close();
                socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            server.onClientDisconnected(this);
            e.printStackTrace();
        }
    }

    void sendMessage(Client client, String text) {
        try {
            dataOutputStream.writeUTF("/nm " + client.name + ": " + text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean auth(DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws IOException {
        Timer timer = new Timer();
        // Цикл ожидания авторизации клиентов
        int tryCount = 0;
        int maxTryCount = 5;
        String newMessage;
        while (true) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        dataInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        dataOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Время авторизации истекло");
                }
            }, 120000);
            // Читаем комманду от клиента
            newMessage = dataInputStream.readUTF();
            // Разбиваем сообщение на состовляющие комманды
            String[] messageData = newMessage.split("\\s");
            // Проверяем соответсует ли комманда комманде авторизации
            if (messageData.length == 3 && messageData[0].equals("/auth")) {
                tryCount++;
                String login = messageData[1];
                String password = messageData[2];
                // Зарегистрирован ли данных пользователь
                client = authService.auth(login, password);

                if (client != null) {
                    // Если получилось авторизоваться то выходим из цикла
                    dataOutputStream.writeUTF("/auth ok");
                    System.out.println("Login success");
                    break;
                } else {
                    dataOutputStream.writeUTF("Неправильные логин и пароль!");
                }

            } else {
                dataOutputStream.writeUTF("Ошибка авторизации!");
            }
            if (tryCount == maxTryCount) {
                dataOutputStream.writeUTF("Первышен лимит попыток!");
                dataInputStream.close();
                dataOutputStream.close();
                socket.close();
                return false;
            }

        }
        timer.cancel();
        return true;


    }

//


    private void messageListener(DataInputStream dataInputStream) throws IOException {

        while (true) {
            String newMessage = dataInputStream.readUTF();
            if (newMessage.startsWith("/exit")) {
                dataInputStream.close();
                dataOutputStream.close();
                socket.close();
//                    server.onClientDisconnected(this);
            }
            if (newMessage.startsWith("/w")) {
                String withoutCmnd = newMessage.substring(3);
                int messageIndex = withoutCmnd.indexOf(" ");
                String client2 = withoutCmnd.substring(0, messageIndex);
                String message = withoutCmnd.substring(messageIndex);
                server.sendMessageTo(client, client2, message);
            } else {
                String client2 = null;
                server.sendMessageTo(client, client2, newMessage);
            }
        }
    }
}