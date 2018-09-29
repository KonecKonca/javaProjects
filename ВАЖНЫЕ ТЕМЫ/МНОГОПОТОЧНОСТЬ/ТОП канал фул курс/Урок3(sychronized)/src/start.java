
public class start{
    public static void main(String[] args) throws Exception{
        Resource resource = new Resource();
        resource.i = 5;

        MyRunable myRunable1 = new MyRunable();
        myRunable1.setResource(resource);  // Все проблемы из-за преедачи 1-го и того же лбъекта
        Thread thread1 = new Thread(myRunable1);
        thread1.setName("One");
        thread1.start();

        MyRunable myRunable2 = new MyRunable();
        myRunable2.setResource(resource);  // Все проблемы из-за преедачи 1-го и того же лбъекта
        Thread thread2 = new Thread(myRunable2);
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Value  " + resource.i);
    }
}

class MyRunable implements Runnable{
    Resource resource;
    public void setResource(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run(){
        resource.changeI();
    }
}

class Resource{
    int i;

    public synchronized void changeI(){  // Закрывает доступ другим потокам к этой функции, пока предидущаяя не завершит работы с этим методом
        int i = this.i;
        // Есть возможность в этот момент прервётся поток и тогда результат будет 6!!!

        // С synchronized эта инструкция не сработает
        if(Thread.currentThread().getName().equals("One")){  // Для увеличения вероятности вызова другого потока в это время
            Thread.yield();
        }
        i++;
        this.i = i;

        /*synchronized(this){
            // и здесь необходимый дял синхронизации код
        }*/
    }
}
// synchronized ПОКА ! ПОТОК ЮЗАЕТ МЕТОД 2-ой НЕ МОЖЕТ ЕГО ЮЗАТЬ




