import org.w3c.dom.NameList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class start {
    public static void main(String[] args) throws Exception {
        NameList nameList = new NameList();
        nameList.add("First");

        class MyThread implements Runnable{
            @Override
            public void run(){
                System.out.println(nameList.removeFirst());
            }
        }

        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        thread1.setName("one");
        Thread thread2 = new Thread(myThread);
        thread2.setName("two");

        thread1.start();
        thread2.start();
    }

    static class NameList{
        private List list = Collections.synchronizedList(new ArrayList<>());

        public void add(String name){
            list.add(name);
        }

        public synchronized String removeFirst(){ // мало того что методы коллекции синхрон(но нужно и свои не атомарные операции синхронить)
            if(list.size() > 0){
                if(Thread.currentThread().getName().equals("one")){
                    Thread.yield(); // передаё управление другому потоку(скорее увеличиваем щанс поломки)
                }
                return (String)list.remove(0);
            }
            /// В данный момент может запуститься другой поток(и будет хуйня) пофиг что юзаем синхронизированную коллекцию
            return null;
        }
    }
}
