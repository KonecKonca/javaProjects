
import com.sun.xml.internal.ws.server.ServerRtException;

import java.awt.*;
import java.io.*;
import java.net.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.*;

public class Klien extends JFrame{
    private JTextField userInputText;

    //private JTextArea chatWindow;
    private JLabel label;
    private List<String> allMesages = new ArrayList<>();

    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private String message = "";
    private String serverIP;
    private Socket socket;

    public Klien(String host){
        super("КЛИЕНТ");
        serverIP = host;
        userInputText = new JTextField();
        userInputText.setEditable(false);
        userInputText.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sendMessage(e.getActionCommand());
                        userInputText.setText("");
                    }
                }
        );
        add(userInputText, BorderLayout.NORTH);
        label = new JLabel("");
        add(new JScrollPane(label), BorderLayout.CENTER);
        setSize(300, 600);
        setVisible(true);
    }

    //запуск клиента
    public void startClient(){
        try {
            connectToServer();
            setupStreams();
            whileChatting();
        }
        catch (EOFException eofException){
            showMessage("\n Клиент оборвал соединение");
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
        finally {
            closeConnection();
        }
    }

    // подключаемся к серверу
    private void connectToServer() throws IOException{
        showMessage("Пытаемся подключиться к серверу...\n");
        socket = new Socket(InetAddress.getByName(serverIP), 7777);
        showMessage("Соединение установлено\n\t" + socket.getInetAddress().getHostName());
    }

    //настройка потоков для отправки и получения сообщений
    private void setupStreams() throws  IOException{
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.flush();
        inputStream = new ObjectInputStream(socket.getInputStream());
        showMessage("\n Потоки готовы к работе!!!");
    }

    //обработка данных во время общения
    private void whileChatting() throws IOException{
        readyToType(true);
        do{
            try {
                message = (String) inputStream.readObject();
                showMessage("\n" + message);
            }
            catch (ClassNotFoundException classNotFoundException){
                showMessage("\n НЕПОНЯТНОЕ СООБЩЕНИЕ");
            }
        }while (!message.equals("СЕРВЕР - *"));
    }

    //закрытие потоков и сокетов
    private void closeConnection(){
        showMessage("\nЗакрываем соединение");
        readyToType(false);
        try {
            outputStream.close();
            inputStream.close();
            socket.close();
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    //отправка сообщенией на сервер
    private void sendMessage(String message){
        try{
            outputStream.writeObject("КЛИЕНТ - " + message);
            outputStream.flush();
            String str = "КЛИЕНТ - " + message;
            showMessage(str);   // "\nКЛИЕНТ - " + message
        }
        catch (IOException ioException){
            label.setText("\nСообщение не отправлено:(((");
        }
    }

    //обновления окна чата
    private void showMessage(final String msg){
        addMessage(msg);
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {   // обновление графического элемента
                        String str = "<html>";
                        for(String s : allMesages){
                            if(s.contains("Админ::>")){
                                str += "<FONT color=red>" + s + "<br>" + "</FONT>";
                            }
                            else {
                                str += s + "<br>";
                            }
                        }
                        str += "</html>";
                        label.setText(str);
                    }
                }
        );
    }

    //установка прав на ввод текста\
    private void readyToType(final boolean trueOrFalse){
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        userInputText.setEditable(trueOrFalse);
                    }
                }
        );
    }

    private void addMessage(String str){
        if(allMesages.size() == 1000){
            for(int i =0; i < 100; i++){
                allMesages.remove(i);
            }
        }
        allMesages.add(str);
    }
}
