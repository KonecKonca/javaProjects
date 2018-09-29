import com.sun.jndi.toolkit.url.Uri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Client client = new Client(args);
    }

    static class Client extends JFrame{
        private static Socket socket;
        private static ObjectInputStream input;
        private static ObjectOutputStream output;

        public Client(String[] args){
            super("Client");
            setLayout(new FlowLayout());
            setSize(300, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setLocationRelativeTo(null);  // по центру появляется

            JTextField jTextField = new JTextField(20);
            JButton jButton = new JButton("Send");
            add(jButton);
            add(jTextField);

            jButton.addActionListener(e -> {
                if(e.getSource() == jButton){
                    sentData(jTextField.getText());
                }
            });

            CheakerClient cheakerClient = new CheakerClient();
            cheakerClient.getStr(args[0]);
            cheakerClient.start();
        }

        private static class CheakerClient extends Thread{
            private String string = "";

            @Override
            public void run() {
                while(true){
                    try {
                        if(!(string.equals(""))){
                            socket = new Socket(string, 6666);
                        }
                        else {
                            socket = new Socket("localhost", 6666);
                        }
                    } catch (IOException e) {
                        System.out.println("Connection is not created");
                    }

                    try {
                        output = new ObjectOutputStream(socket.getOutputStream());
                        input = new ObjectInputStream(socket.getInputStream());
                        JOptionPane.showMessageDialog(null, (String)input.readObject());
                    } catch (Exception e) {
                        System.out.println("Troubles with input\\output");
                        System.exit(-1);
                    }
                }
            }

            private void getStr(String str){
                string = str;
            }
        }

        private static void sentData(Object object){
            try {
                output.flush();
                output.writeObject(object);
            } catch (IOException e) {
                System.out.println("Data is not sended");
            }
        }
    }
}