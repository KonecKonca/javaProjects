package main;

public class Arichmetics {

    public double sum(double a, double b){
        return a + b;
    }

    public double deduct(double a, double b){
        return a - b;
    }

    public double mult(double a, double b){
        return a*b;
    }

    public double div(double a, double b){
        if(b == 0){
            throw new ArithmeticException();  // ебучая странность ЕСЛИ ЭТО ЗАКОММЕНТИТЬ И КИНУТЬ 0 ИСКЛ БУДЕТ, а ТЕСТ ЗАФЕЙЛИТ
        }
        return a/b;
    }

    public void time(){
        try {
            Thread.sleep(99);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
