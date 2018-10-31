
public class start{
    public static void main(String[] args) throws Exception{
        Resource.i = 5;

        MyRunable myRunable1 = new MyRunable();
        Thread thread1 = new Thread(myRunable1);
        thread1.setName("One");
        thread1.start();

        MyRunable myRunable2 = new MyRunable();
        Thread thread2 = new Thread(myRunable2);
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Value  " + Resource.i);
    }
}

class MyRunable implements Runnable{
    Resource resource;

    @Override
    public void run(){
        Resource.changeStaticI();
        new Resource().changeI(); // ПОЛНЫЙ ПИЗДЕЦ ИЗ-ЗА ОДНОВРЕМЕННОЙ СТАТИЧИСКОЙ И ОБЫЧНОЙ СИНХРОНИЗАЦИИ
    }
}

class Resource{
    static int i;

    public static synchronized void changeStaticI(){ // ЗДЕСЬ ЮЗАТЬ МОЖНО ТОЛЬКО СТАТИКУ(хотя по-другму и не выйдет)))
        int i = Resource.i;
        if(Thread.currentThread().getName().equals("One")){
            Thread.yield();
        }
        i++;
        Resource.i = i;

        // Для статики идёт синхронизация на уровне класса synchronized(this){} не канает, вмемсто этого
        // synchronized(Resource.class){}
    }

    public void changeI(){ // ЗДЕСЬ НЕЛЬЗЯ ЮЗАТЬ СТАТИКУ
        synchronized(this){
            int i = Resource.i;
            if(Thread.currentThread().getName().equals("One")){
                Thread.yield();
            }
            i++;
            Resource.i = i;
        }
    }

}





