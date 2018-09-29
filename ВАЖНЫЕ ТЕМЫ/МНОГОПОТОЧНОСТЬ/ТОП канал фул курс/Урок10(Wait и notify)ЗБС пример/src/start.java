import org.w3c.dom.NameList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class start {
    static List<String> strings = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws Exception {
        new Operator().start();
        new Machine().start();
    }

    static class Operator extends Thread{
        @Override
        public void run(){
            Scanner scanner = new Scanner(System.in);
            while(true){
                synchronized(strings){
                    strings.add(scanner.nextLine());
                    strings.notify();
                }
                try {
                    Thread.sleep(1);  // БЕз этого не будет работать
                }
                catch(Exception ex){}
            }
        }
    }

    static class Machine extends Thread{
        @Override
        public void run(){
            while(strings.isEmpty()){  // пока лист пустой
                synchronized(strings){
                    try {
                        strings.wait();
                    }
                    catch(Exception ex){}
                    System.out.println(strings.remove(0));
                }
            }
        }
    }
}
