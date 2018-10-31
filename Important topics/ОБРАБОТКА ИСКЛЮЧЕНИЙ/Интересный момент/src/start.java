import com.sun.deploy.util.SyncAccess;

import java.util.*;

// КОМПИЛЯТОР ПИСИМИСТ (т.е в случае если исключение можеь быть , а может и не быть, он выбирает самое жёчткое условие)
public class start {
    public static void main(String[] args) throws Exception{
        x();
    }

    public static void x() throws Exception{  // не запустится без этого
        // Тут компилятор прав пробросив exception
        // Exception ref = new IOException();

        // В данном примере перестраховка компилятора не нужна
        Exception ref = new RuntimeException();  // С Exception вылетит исключение
        try{
            throw ref;
        }
        catch(RuntimeException ex){
            System.out.println("RuntimeException");
        }
    }
}


// Компилятор проверяет по типу ссылки а не по её слдержимому(он не знает что такое полиморфизм)
// а JVM уже работает с фактическими значениями(в рантайме = во время исполнения)