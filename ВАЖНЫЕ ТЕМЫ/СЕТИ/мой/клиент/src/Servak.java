import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servak extends JFrame{
    public static void main(String[] args){
        Serv serv = new Serv();
    }

    static class Serv extends JFrame{
        private static ServerSocket serverSocket;
        private static Socket socket;
        private static ObjectInputStream input;
        private static ObjectOutputStream output;

        public Serv(){
            super("Server");
            setLayout(new FlowLayout());
            setSize(300, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setLocationRelativeTo(null);  // по центру появляется

            JTextField jTextField = new JTextField(15);
            JButton jButton = new JButton("Send");
            add(jButton);
            add(jTextField);

            jButton.addActionListener(e -> {
                if(e.getSource() == jButton){
                    sentData(jTextField.getText());
                }
            });

            CheakerServer cheaker = new CheakerServer();
            cheaker.start();
        }

        private static class CheakerServer extends Thread{
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(6666, 10);  // 10 кол-во подключений
                } catch (IOException e) {
                    System.out.println("Server dont receive socket");
                }
                while(true){
                    try {
                        socket = serverSocket.accept(); // возврат сокета
                    } catch (IOException e) {
                        System.out.println("Server dont receive socket");
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
