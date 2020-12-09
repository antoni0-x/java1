package javaProdv.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Chat extends JFrame {
    public List message = new ArrayList<String>();;

    public Chat() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 720, 670);
        setLayout(new BorderLayout());


        JPanel[] jp = new JPanel[3];
//        jp1.setLayout(new BorderLayout());
        for (int i = 0; i < 3; i++) {
            jp[i] = new JPanel();
        }
        add(jp[0], BorderLayout.PAGE_START);
        add(jp[1], BorderLayout.CENTER);
        add(jp[2], BorderLayout.PAGE_END);

        jp[0].setLayout(new BorderLayout());
        JTextArea field1 = new JTextArea();
        JScrollPane jsp = new JScrollPane(field1);
        jsp.setPreferredSize(new Dimension(500, 500));
        jp[0].add(jsp, BorderLayout.CENTER);

        jp[1].setLayout(new BorderLayout());
        JTextField field2 = new JTextField();
        field2.setPreferredSize(new Dimension(300, 20));
        jp[1].add(field2, BorderLayout.LINE_START);
//
        jp[2].setLayout(new BorderLayout());
        JButton sendBtn = new JButton("Send message");
        sendBtn.setPreferredSize(new Dimension(150, 50));
        jp[2].add(sendBtn, BorderLayout.LINE_START);


        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message.add(field2.getText()+"\n");
                field1.setText(message.toString());
                field2.setText("");
            }
        });
        field2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message.add(field2.getText()+"\n");
                field1.setText(message.toString());
                field2.setText("");
            }
        });

//
//
//


        setVisible(true);
    }
}
