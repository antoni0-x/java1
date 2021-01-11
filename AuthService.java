package javaProdv.lesson8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class AuthService {
    List<Client> clients = new ArrayList();



    AuthService() throws ClassNotFoundException, SQLException {
        getUsers();

    }

    synchronized Client auth(String login, String password) {
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            if (client.login.equals(login) && client.password.equals(password)) {
                return client;
            }
        }
        return null;
    }

    void getUsers() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:chatreg1.db");
        Statement statement = connection.createStatement();
//        statement.execute();
        ResultSet result = statement.executeQuery("SELECT * FROM users");

        while (result.next()) {                     // Пока есть строки
            clients.add(new Client(result.getString("name"),result.getString("login"),result.getString("password")));
        }

    }
}