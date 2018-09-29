public class start {

    public static void main(String[] args) {
        start star = new start();
        star.method();
    }

    public void method(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                start outer = start.this;  // ссылка на объемлющий класс
            }
        };
    }
}

