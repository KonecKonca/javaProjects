import org.w3c.dom.NameList;
import sun.util.cldr.CLDRLocaleProviderAdapter;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class start {
    static long NUMOFOPERATIONS = 30_000_000_000L;
    static int NumOfTreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws Exception {
        // Одно поточный варик(в разы дольше)
//        System.out.println(new Date());
//        long j = 0;
//        for(long i = 0; i < NUMOFOPERATIONS; i++){
//            j +=i;
//        }
//        System.out.println(j);
//        System.out.println(new Date());

        // Многопоточное решение

        System.out.println(new Date());
        ForkJoinPool pool = new ForkJoinPool(NumOfTreads);
        System.out.println(pool.invoke(new MyFork(0, NUMOFOPERATIONS)));
        System.out.println(new Date());
    }

    static class  MyFork extends RecursiveTask<Long>{
        long from;
        long to;

        public MyFork(long from, long to){
            this.from = from;
            this.to = to;
        }

        @Override
        protected  Long compute(){
            if((to - from) <= NUMOFOPERATIONS/NumOfTreads){  // Если операция разбита на достаточное кол-во частей(так быстрее), тогда выполняем операцию
                long j = 0;
                for(long i = from; i < to; i++ ){
                    j +=i;
                }
                return j;
            }
            else{  // если нет, то разбиваем на части поменьше
                long middle = (to + from)/2;
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();

                MyFork secondHalf = new MyFork(middle + 1, to);
                long secondValue = secondHalf.compute();

                return firstHalf.join() + secondValue;
            }
        }
    }

}
