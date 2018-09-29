import javafx.scene.input.DataFormat;
import javax.jws.soap.SOAPBinding;
import javax.xml.crypto.Data;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class start{
    public static void main(String[] args) throws Exception{
        Date date = new Date();  // Текущая дата (объект зранит миллисекунды, юзать не удобно(нужно всё считать))
        // считается с 1-го января 1970-го (создание Unix)  (если задать 0 в конструктор)
        System.out.println(date);

        // Calendar calendar = new Calendar();  нельзя т.к конструктор приватный
        Calendar calendar = Calendar.getInstance();  // больше функционала
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, 1); // добавить 1 неделю (самому считать не надо)
        System.out.println(calendar.getTime());  // calendar.getTime() --> ополная инфа

        DateFormat dataFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println(dataFormat.format(calendar.getTime())); // вывод в коротком формате

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");  // задание своего формата
        System.out.println(simpleDateFormat.format(calendar.getTime()));

        Date newDate = simpleDateFormat.parse("05/12/1985 05:22");
        System.out.println(newDate);
    }
}
