
public class start {
    public static void main(String[] args){
        String str1 = "слово1";
        String str2 = "слово1";
        if(str1.equals(str2)){    // == ---> сравнивает ссылки на строки
            System.out.println("равны");   // а не значения объектов под нимми
        }
        if(str1 == new String("слово1")){
            System.out.println("РАВНЫ"); // equals учитывает регистр!!!
        }
        String c = "СЛОВО1";
        if(str2.equals(c)){
            System.out.println("Регистр не учитывается");
        }
        if(str2.equalsIgnoreCase(c)){
            System.out.println("Регистр учитывается");
        }
    }
}
