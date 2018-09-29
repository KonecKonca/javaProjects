import org.w3c.dom.NameList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Типо ждать конца действий в другом потоке, чтоб одновременно выполняться
public class start {
    public static void main(String[] args) throws Exception {
        ThreadB threadB = new ThreadB();
        threadB.start();
        synchronized(threadB){  // без этого нельзя вызывать (метод вызывается только из синхрон контекста)
            threadB.wait();  // в этото момент main поток засыпает, до момента когда в threadB вызовется notify (B говорит mainу подожди)
        }                       // ТЕКУЩИЙ ПОТОК ЖДЁТ NOTIFY ИЗ ПОТОКА threadB
        System.out.println(threadB.total);
    }
    static class ThreadB extends Thread{
        int total = 0;
        @Override
        public void run(){
            synchronized(this){
                for(int i = 0; i < 5; i++){
                    total+=i;
                    try {
                        sleep(100);
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                    notify();
                }
            }
        }
    }

}













































