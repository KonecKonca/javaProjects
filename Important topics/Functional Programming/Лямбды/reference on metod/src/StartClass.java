

public class StartClass{
    public static void main(String[] args){
        String str1 = "a b c d";
        System.out.println(str1);
        System.out.println(reverse(str1));
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");

        System.out.println(str1);
        anyDo.done(StartClass::reverse,str1);
    }

    public static String reverse(String str){
        String strNew = "";
        for(int i = str.length() - 1; i >= 0; i--){
            strNew += str.charAt(i);
        }
        return strNew;
    }
}

class anyDo{
     static void done(Inter in, String str){
         System.out.println(in.function(str));
     }
}

@FunctionalInterface
interface Inter{
    static void x(){    // КРИТЕРИЙ ДЛЯ НАЗВАНИЯ ИНТЕРФЕЙСА ФУНКЦИОНАЛЬНЫМ --- НАЛИЧИЕ ТОЛЬКО 1-ГО АБСТРАКТНОГО МЕТОДА
        System.out.println("xxxx");
    }

     String function(String name);
}