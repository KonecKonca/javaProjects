
// volatile --- переменные не кэштруются(не создаётся новая копии только для своего потока) и хранятся в очновной памяти
// также все операции с volatile являются атомарными (скорее дял атомарных будет всё ок, дял других хуйня типо инкремент)
public class start{
    static volatile int i = 0;

    public static void main(String[] args) throws Exception{
        MyThreadRead read = new MyThreadRead();
        MyThreadWrite write = new MyThreadWrite();

        Thread Read = new Thread(read);
        Thread Write = new Thread(write);

        Read.start();
        Write.start();
    }

    static class MyThreadWrite implements Runnable{
        @Override
        public void run(){
            while (i < 5){
                System.out.println("inctement i to " + (++i)); // из-за volatile изменяется исходная версия i
                try{
                    Thread.sleep(500);
                }
                catch (Exception ex){}
            }
        }
    }

    static class MyThreadRead implements Runnable{
        @Override
        public void run(){
            int localVar = i;
            while(localVar < 5){
                if(localVar != i){
                    System.out.println("new value is " + i);  // Не сработает без volatile
                    localVar = i;
                }
            }
        }
    }
}
