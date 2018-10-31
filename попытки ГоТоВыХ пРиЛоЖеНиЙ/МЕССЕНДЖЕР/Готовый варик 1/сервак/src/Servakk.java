/**
 * Created by Андрей on 04.02.2018.
 */
import java.io.*;
import java.net.*;  // сетевые ресурсы
import java.awt.*;  // графика
import java.awt.event.*;
import javax.swing.*;

public class Servakk extends JFrame{
    private JTextField userInputText;
    private JTextArea chatWindow;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private ServerSocket serverSocket;
    private Socket connection;

    public Servakk(){
        super("Серверная часть!!!");
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
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow));
        setSize(300, 600);
        setVisible(true);
    }

    // настройка и запуск серверной части
    public void startServer(){
        try {
            serverSocket = new ServerSocket(7777, 100); // backlog ограничивает кол-во подключений
            while (true){
                try{
                    waitForConnection();
                    setUpStreams();
                    whileChating();
                }
                catch (EOFException eofException){
                    showMessage("\n Сервер оборвал соединение!!!");
                }
                finally {
                    closeConnection();
                }
            }
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    // ожидагие соединения и отображение инфы о подключении
    private void waitForConnection() throws IOException{
        showMessage("Ожидание подключения клиентов...\n");
        connection = serverSocket.accept();
        showMessage("Соединён с \n" + connection.getInetAddress().getHostName()); // .getHostName() -- перевод в строку
    }

    // настройка потоков для отправки и получнеия данных
    private void setUpStreams() throws IOException{
        outputStream = new ObjectOutputStream(connection.getOutputStream());
        outputStream.flush();
        inputStream = new ObjectInputStream(connection.getInputStream());
        showMessage("\nПоток установлен!!!\n");
    }

    //обработка данных во время общения
    private void whileChating() throws IOException{
        String message = "Вы подключены!!!";
        sendMessage(message);
        readyToType(true);
        do {
            try {
                message = (String) inputStream.readObject();
                showMessage("\n" + message);
            }
            catch (ClassNotFoundException classNotFoundException){
                showMessage("\n Я тупой осёл");  // если юзер отправит хуйню
            }
        }while (!message.equals("Клиент - *"));
    }

    // закрываем сокеты и потоки
    private void closeConnection(){
        showMessage("\nЗакрытие соединения");
        readyToType(false);
        try {
            outputStream.close();
            inputStream.close();
            connection.close();
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    //отправка сообщений клиенту
    private void sendMessage(String message){
        try{
            outputStream.writeObject("Админ::> "+ message);
            outputStream.flush();
            showMessage("\nАдмин::> "+ message);
        }
        catch (IOException ioException){
            chatWindow.append("\nОШИБКА: Эта хуйня не отправится");
        }
    }

    //обновление окна чата
    private void showMessage(final String text){
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        chatWindow.append(text);
                    }
                }
        );
    }

    // установка прав на ввод данных
    private void readyToType(final boolean tryOrFalse){
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {        // так изменяются св-ва уже использующихся графич объектов
                        userInputText.setEditable(tryOrFalse);
                    }
                }
        );
    }
}
