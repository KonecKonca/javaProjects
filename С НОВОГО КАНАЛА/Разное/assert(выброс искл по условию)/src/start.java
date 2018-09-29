public class start {
    public static void main(String[] args) {
        someMetod(-3);
    }

    private static void someMetod(int a){
        assert(a > 0); // при (a < 0)(а не соответствующим условию) выпросится исключение
        System.out.println(a);

        // ассертион по умолчанию отключены т.е при запуске типа
        // javac start.java
        // java start ----- всё хорошо выполнится

        // javac start.java
        // java -ea start ---- будет ошибка
        // можно задать VM option   -ea  (по сути включение ассерта)

        // используетя для проверок кода
    }
}
