public class start {
    public static void main(String[] args) {
        String s1 = new String("abc");
        s1.concat("def");   // строки являются константами!!!!
        String s2 = s1.concat("def");

        System.out.println(s1);
        System.out.println(s2);

        s1 = s1 + "!!!!!!!!!!!!";   // т.к создаётся новый объект
        System.out.println(s1);

        // StringByfer(методы synchronysed) а StringBuilder нет

        StringBuilder stringBuilder = new StringBuilder("aaaaaa");
        stringBuilder.append("bbb"); // добавить
        stringBuilder.insert(0, "-");  // вставка

        System.out.println(stringBuilder);
    }
}
