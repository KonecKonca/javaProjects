import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Graficsoperations {
    static Grafic grafic1 = new Grafic();
    static Grafic grafic2 = new Grafic();

    private static Grafic egalsKorteji = new Grafic();
    private static Grafic resultGrafic = new Grafic();
    private static Grafic unicOfGragic1 = new Grafic();
    private static Grafic unicOfGrafic2 = new Grafic();

    static String proection(int nomberOfGrafic, int nomberOfProection){
        String result = "{";
        if(nomberOfGrafic == 1){
            if(nomberOfProection == 1){
                for(String str : grafic1.firstElements){
                    result += (str + " ");
                }
            }
            else {
                for(String str : grafic1.secondElements){
                    result += (str + " ");
                }
            }
        }
        else {
            if(nomberOfProection == 1){
                for(String str : grafic2.firstElements){
                    result += (str + " ");
                }
            }
            else {
                for(String str : grafic2.secondElements){
                    result += (str + " ");
                }
            }
        }
        result += "}";
        return result;
    }
    static String inversion(int nomberOfGrafic){
        String result = "{";
        if(nomberOfGrafic == 1){
            for(int i = 0; i < grafic1.firstElements.size(); i++){
                result += ("<" + grafic1.secondElements.get(i) + " " + grafic1.firstElements.get(i) + "> ");
            }
        }
        else {
            for(int i = 0; i < grafic2.firstElements.size(); i++){
                result += ("<" + grafic2.secondElements.get(i) + " " + grafic2.firstElements.get(i) + "> ");
            }
        }
        result += "}";
        return result;
    }
    static String crossing(){
        String result = "{";
        resultGrafic = new Grafic();
        searchEgualsKortejei();
        for(int i = 0; i < egalsKorteji.firstElements.size(); i++){
            result += ("<" + egalsKorteji.firstElements.get(i) + " " + egalsKorteji.secondElements.get(i) + "> ");
        }
        result += "}";
        return result;
    }
    static String difference(int index){
        String result = "{";
        if(index == 1){
            unicOfGragic1 = new Grafic();
            for(int i = 0; i < grafic1.firstElements.size(); i++){
                boolean isUnic = true;
                for (int j = 0; j < grafic2.firstElements.size(); j++){
                    if((grafic1.firstElements.get(i) == grafic2.firstElements.get(j) &&
                            grafic1.secondElements.get(i) == grafic2.secondElements.get(j))){
                        isUnic = false;
                    }
                }
                if(isUnic){
                    unicOfGragic1.firstElements.add(grafic1.firstElements.get(i));
                    unicOfGragic1.secondElements.add(grafic1.secondElements.get(i));
                    result += ("<" + grafic1.firstElements.get(i) + " " + grafic1.secondElements.get(i) + "> ");
                }
            }
        }
        else if(index == 2){
            unicOfGrafic2 = new Grafic();
            for(int i = 0; i < grafic2.firstElements.size(); i++){
                boolean isUnic = true;
                for (int j = 0; j < grafic1.firstElements.size(); j++){
                    if((grafic2.firstElements.get(i) == grafic1.firstElements.get(j) &&
                            grafic2.secondElements.get(i) == grafic1.secondElements.get(j))){
                        isUnic = false;
                    }
                }
                if(isUnic){
                    unicOfGrafic2.firstElements.add(grafic2.firstElements.get(i));
                    unicOfGrafic2.secondElements.add(grafic2.secondElements.get(i));
                    result += ("<" + grafic2.firstElements.get(i) + " " + grafic2.secondElements.get(i) + "> ");
                }
            }
        }
        result += "}";
        return result;
    }
    static Grafic difference(Grafic grafic1, Grafic grafic2){
        Grafic unicOfGragic1 = new Grafic();
        for(int i = 0; i < grafic1.firstElements.size(); i++){
            boolean isUnic = true;
            for (int j = 0; j < grafic2.firstElements.size(); j++){
                if((grafic1.firstElements.get(i) == grafic2.firstElements.get(j) &&
                        grafic1.secondElements.get(i) == grafic2.secondElements.get(j))){
                    isUnic = false;
                }
            }
            if(isUnic){
                unicOfGragic1.firstElements.add(grafic1.firstElements.get(i));
                unicOfGragic1.secondElements.add(grafic1.secondElements.get(i));
            }
        }
        return unicOfGragic1;
    }
    static String join(){
        String result = "{";
        difference(1);
        difference(2);
        for(int i = 0 ; i < unicOfGragic1.firstElements.size(); i++){
            result += ("<" + unicOfGragic1.firstElements.get(i) + " " + unicOfGragic1.secondElements.get(i) + "> ");
        }
        for(int i = 0 ; i < unicOfGrafic2.firstElements.size(); i++){
            result += ("<" + unicOfGrafic2.firstElements.get(i) + " " + unicOfGrafic2.secondElements.get(i) + "> ");
        }
        searchEgualsKortejei();
        for(int i = 0; i < egalsKorteji.firstElements.size(); i++){
            result += ("<" + egalsKorteji.firstElements.get(i) + " " + egalsKorteji.secondElements.get(i) + "> ");
        }
        result += "}";
        return result;
    }
    static Grafic join(Grafic grafic1, Grafic grafic2){
        String result = "{";
        unicOfGragic1 = difference(grafic1, grafic2);
        unicOfGrafic2 = difference(grafic2, grafic1);

        Grafic grafic = new Grafic();
        for(int i = 0 ; i < unicOfGragic1.firstElements.size(); i++){
            grafic.firstElements.add(unicOfGragic1.firstElements.get(i));
            grafic.secondElements.add( unicOfGragic1.secondElements.get(i));
        }
        for(int i = 0 ; i < unicOfGrafic2.firstElements.size(); i++){
            grafic.firstElements.add(unicOfGrafic2.firstElements.get(i));
            grafic.secondElements.add(unicOfGrafic2.secondElements.get(i));
        }
        searchEgualsKortejei(grafic1, grafic2);
        for(int i = 0; i < egalsKorteji.firstElements.size(); i++){
            grafic.firstElements.add(egalsKorteji.firstElements.get(i));
            grafic.secondElements.add(egalsKorteji.secondElements.get(i));
        }
        return grafic;
    }
    static String simmetricDifference(){
        difference(1);
        difference(2);
        String result = "{";
        for(int i = 0 ; i < unicOfGragic1.firstElements.size(); i++){
            result += ("<" + unicOfGragic1.firstElements.get(i) + " " + unicOfGragic1.secondElements.get(i) + "> ");
        }
        for(int i = 0 ; i < unicOfGrafic2.firstElements.size(); i++){
            result += ("<" + unicOfGrafic2.firstElements.get(i) + " " + unicOfGrafic2.secondElements.get(i) + "> ");
        }
        searchEgualsKortejei();
        result += "}";
        return result;
    }
    static String composition(int index){
        String result = "{";
        if(index == 1){
            for(int i = 0; i < grafic1.firstElements.size(); i++){
                for(int j = 0; j < grafic2.firstElements.size(); j++){
                    if(grafic1.secondElements.get(i) == grafic2.firstElements.get(j)){
                        result += ("<" + grafic1.firstElements.get(i) + " " + grafic2.secondElements.get(j) + "> ");
                    }
                }
            }
        }
        else if(index == 2){
            for(int i = 0; i < grafic2.firstElements.size(); i++){
                for(int j = 0; j < grafic1.firstElements.size(); j++){
                    if(grafic2.secondElements.get(i) == grafic1.firstElements.get(j)){
                        result += ("<" + grafic2.firstElements.get(i) + " " + grafic1.secondElements.get(j) + "> ");
                    }
                }
            }
        }
        result += "}";
        return result;
    }
    static Grafic composition(Complieance complieance1, Complieance complieance2){
        Grafic grafic1 = complieance1.grafic;
        Grafic grafic2 = complieance2.grafic;
        Grafic result = new Grafic();
        for(int i = 0; i < grafic1.firstElements.size(); i++){
            for(int j = 0; j < grafic2.firstElements.size(); j++){
                if(grafic1.secondElements.get(i) == grafic2.firstElements.get(j)){
                    result.firstElements.add(grafic1.firstElements.get(i));
                    result.secondElements.add(grafic2.secondElements.get(j));
                }
            }
        }

        return result;
    }

    static void searchEgualsKortejei(){
        egalsKorteji = new Grafic();
        for(int i = 0; i < grafic1.firstElements.size(); i++){
            for(int j = 0; j < grafic2.firstElements.size(); j++){
                if((grafic1.firstElements.get(i) == grafic2.firstElements.get(j) &&
                        grafic1.secondElements.get(i) == grafic2.secondElements.get(j))){
                    egalsKorteji.firstElements.add(grafic1.firstElements.get(i));
                    egalsKorteji.secondElements.add(grafic1.secondElements.get(i));
                }
            }
        }
    }
    static void searchEgualsKortejei(Grafic grafic1, Grafic grafic2){
        egalsKorteji = new Grafic();
        for(int i = 0; i < grafic1.firstElements.size(); i++){
            for(int j = 0; j < grafic2.firstElements.size(); j++){
                if((grafic1.firstElements.get(i) == grafic2.firstElements.get(j) &&
                        grafic1.secondElements.get(i) == grafic2.secondElements.get(j))){
                    egalsKorteji.firstElements.add(grafic1.firstElements.get(i));
                    egalsKorteji.secondElements.add(grafic1.secondElements.get(i));
                }
            }
        }
    }
    static String printGrafic(int index){
        String result = "{";
        if(index == 1){
            for(int i = 0; i < grafic1.firstElements.size(); i++){
                result += ("<" + grafic1.firstElements.get(i) + " " + grafic1.secondElements.get(i) + "> ");
            }
        }
        if(index == 2){
            for(int i = 0; i < grafic2.firstElements.size(); i++){
                result += ("<" + grafic2.firstElements.get(i) + " " + grafic2.secondElements.get(i) + "> ");
            }
        }
        if(index == 3){
            for(int i = 0; i < resultGrafic.firstElements.size(); i++){
                result += ("<" + resultGrafic.firstElements.get(i) + " " + resultGrafic.secondElements.get(i) + "> ");
            }
        }
        result += "}";
        return result;
    }

    // ---------------------------------------------------------------------- //
    private static Complieance equals = new Complieance();

    // вывод соответствий
    static String printCompliences(Complieance complieance){
        String str = "< ";

        str += "{ ";
        for(String string : complieance.oblZnach){
            str += string + " ";
        }
        str += "}, ";

        str += "{ ";
        for(String string : complieance.oblOpred){
            str += string + " ";
        }
        str += "}, ";

        str += "{ ";
        for(int i = 0; i < complieance.grafic.firstElements.size(); i++){
            str += ("<" + complieance.grafic.firstElements.get(i) + ", " + complieance.grafic.secondElements.get(i) + "> ");
        }
        str += "}, ";

        str += ">";
        return str;
    }
    // ввод соответствий вручную
    static void inputComplience(Complieance complieance){
        System.out.println("Вводите элементы области пределений по окончанию введите --- end");
        while (true){
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            if(str.equalsIgnoreCase("end")){
                break;
            }
            else {
                complieance.oblZnach.add(str);
            }
        }

        System.out.println("Вводите элементы области значений по окончанию введите --- end");
        while (true){
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            if(str.equalsIgnoreCase("end")){
                break;
            }
            else {
                complieance.oblOpred.add(str);
            }
        }

        System.out.println("Вводите элементы графика по окончанию введите --- end");
        while (true){
            System.out.println("1-ый элемент пары");
            Scanner scanner1 = new Scanner(System.in);
            String str1 = scanner1.next();
            if(str1.equalsIgnoreCase("end")){
                break;
            }

            System.out.println("2-ой элемент пары");
            Scanner scanner2 = new Scanner(System.in);
            String str2 = scanner2.next();
            if(str2.equalsIgnoreCase("end")){
                break;
            }
            else {
                complieance.grafic.firstElements.add(str1);
                complieance.grafic.secondElements.add(str2);
            }
        }
    }
    // пересечение
    static String crossComplience(Complieance complieance1, Complieance complieance2){
        equalsComplieance(complieance1, complieance2);
        return printCompliences(equals);
    }
    //объединение
    static String unionComplience(Complieance complieance1, Complieance complieance2){
        Complieance result = new Complieance();
        result.oblOpred.addAll(complieance1.oblOpred);
        result.oblZnach.addAll(complieance1.oblZnach);

        Complieance additional = differenceComplience(complieance2, complieance1, true);
        result.oblOpred.addAll(additional.oblOpred);
        result.oblZnach.addAll(additional.oblZnach);

        Grafic grafic = join(complieance1.grafic, complieance2.grafic);
        result.grafic = grafic;
        return printCompliences(result);
    }
    static Complieance unionComplience(Complieance complieance1, Complieance complieance2, int x){
        Complieance result = new Complieance();
        result.oblOpred.addAll(complieance1.oblOpred);
        result.oblZnach.addAll(complieance1.oblZnach);

        Complieance additional = differenceComplience(complieance2, complieance1, true);
        result.oblOpred.addAll(additional.oblOpred);
        result.oblZnach.addAll(additional.oblZnach);

        Grafic grafic = join(complieance1.grafic, complieance2.grafic);
        result.grafic = grafic;
        return result;
    }
    //разность
    static String differenceComplience(Complieance complieance1, Complieance complieance2){
        Complieance result = new Complieance();
        equalsComplieance(complieance1, complieance2);
        for(int i = 0; i < complieance1.oblOpred.size(); i++){
            boolean cheak = true;
            for(int j = 0; j < equals.oblOpred.size(); j++){
                if(complieance1.oblOpred.get(i).equals(equals.oblOpred.get(j))){
                    cheak = false;
                }
            }
            if(cheak){
                result.oblOpred.add(complieance1.oblOpred.get(i));
            }
        }
        for(int i = 0; i < complieance1.oblZnach.size(); i++){
            boolean cheak = true;
            for(int j = 0; j < equals.oblZnach.size(); j++){
                if(complieance1.oblZnach.get(i).equals(equals.oblZnach.get(j))){
                    cheak = false;
                }
            }
            if(cheak){
                result.oblZnach.add(complieance1.oblZnach.get(i));
            }
        }

        Grafic grafic = difference(complieance1.grafic, complieance2.grafic);
        result.grafic = grafic;

        return printCompliences(result);
    }
    static Complieance differenceComplience(Complieance complieance1, Complieance complieance2, int x){
        Complieance result = new Complieance();
        equalsComplieance(complieance1, complieance2);
        for(int i = 0; i < complieance1.oblOpred.size(); i++){
            boolean cheak = true;
            for(int j = 0; j < equals.oblOpred.size(); j++){
                if(complieance1.oblOpred.get(i).equals(equals.oblOpred.get(j))){
                    cheak = false;
                }
            }
            if(cheak){
                result.oblOpred.add(complieance1.oblOpred.get(i));
            }
        }
        for(int i = 0; i < complieance1.oblZnach.size(); i++){
            boolean cheak = true;
            for(int j = 0; j < equals.oblZnach.size(); j++){
                if(complieance1.oblZnach.get(i).equals(equals.oblZnach.get(j))){
                    cheak = false;
                }
            }
            if(cheak){
                result.oblZnach.add(complieance1.oblZnach.get(i));
            }
        }

        Grafic grafic = difference(complieance1.grafic, complieance2.grafic);
        result.grafic = grafic;

        return result;
    }
    // Симметрическая разность
    static String simmeticDifferenceComplience(Complieance complieance1, Complieance complieance2){
        Complieance temp1 = differenceComplience(complieance1, complieance2, 1);
        Complieance temp2 = differenceComplience(complieance2, complieance1, 1);
        return printCompliences(unionComplience(temp1, temp2, 1));
    }
    private static Complieance differenceComplience(Complieance complieance1, Complieance complieance2, boolean x){
        Complieance result = new Complieance();
        equalsComplieance(complieance1, complieance2);
        for(int i = 0; i < complieance1.oblOpred.size(); i++){
            boolean cheak = true;
            for(int j = 0; j < equals.oblOpred.size(); j++){
                if(complieance1.oblOpred.get(i).equals(equals.oblOpred.get(j))){
                    cheak = false;
                }
            }
            if(cheak){
                result.oblOpred.add(complieance1.oblOpred.get(i));
            }
        }
        for(int i = 0; i < complieance1.oblZnach.size(); i++){
            boolean cheak = true;
            for(int j = 0; j < equals.oblZnach.size(); j++){
                if(complieance1.oblZnach.get(i).equals(equals.oblZnach.get(j))){
                    cheak = false;
                }
            }
            if(cheak){
                result.oblZnach.add(complieance1.oblZnach.get(i));
            }
        }

        Grafic grafic = difference(complieance1.grafic, complieance2.grafic);
        result.grafic = grafic;

        return result;
    }
    //инверсия
    static String inversionComplience(Complieance complieance){
        String str = "< ";

        str += "{ ";
        for(String string : complieance.oblOpred){
            str += string + " ";
        }
        str += "}, ";

        str += "{ ";
        for(String string : complieance.oblZnach){
            str += string + " ";
        }
        str += "}, ";

        str += "{ ";
        for(int i = 0; i < complieance.grafic.firstElements.size(); i++){
            str += ("<" + complieance.grafic.secondElements.get(i) + ", " + complieance.grafic.firstElements.get(i) + "> ");
        }
        str += "}, ";

        str += ">";
        return str;
    }
    //Продолжение
    static String continied(Complieance complieance1, Complieance complieance2){
//        Complieance result = new Complieance();
//        boolean isContinued = true;
//        for(int i = 0; i < complieance1.oblOpred.size(); i++){
//            boolean cheaker = false;
//            for(int j = 0; j < complieance2.oblOpred.size(); j++){
//                if(complieance1.oblOpred.get(i).equals(complieance2.oblOpred.get(j))){
//                    cheaker = true;
//                }
//            }
//            if (!cheaker){
//                isContinued = false;
//            }
//        }
//        for(int i = 0; i < complieance1.oblZnach.size(); i++){
//            boolean cheaker = false;
//            for(int j = 0; j < complieance2.oblZnach.size(); j++){
//                if(complieance1.oblZnach.get(i).equals(complieance2.oblZnach.get(j))){
//                    cheaker = true;
//                }
//            }
//            if (!cheaker){
//                isContinued = false;
//            }
//        }
//
//        return "Является ли продолжением: " + isContinued;

        Complieance reSult = new Complieance();
        reSult.oblZnach.addAll(complieance1.oblZnach);
        reSult.oblOpred.addAll(complieance1.oblOpred);
        reSult.grafic = complieance1.grafic;

        System.out.println("Введите кортеж(и) типа (х∈X y∈Y)");
        System.out.println("По окончанию введите --- end");
        while (true){
            System.out.println("1-ый элемент пары");
            Scanner scanner1 = new Scanner(System.in);
            String str1 = scanner1.next();
            if(str1.equalsIgnoreCase("end")){
                break;
            }
            System.out.println("2-ой элемент пары");
            Scanner scanner2 = new Scanner(System.in);
            String str2 = scanner2.next();
            if(str2.equalsIgnoreCase("end")){
                break;
            }
            else {
                reSult.grafic.firstElements.add(str1);
                reSult.grafic.secondElements.add(str2);
            }
        }

        return printCompliences(reSult);
    }
    // сужение
    static String narroved(Complieance complieance){
        Complieance result = new Complieance();
        result.oblOpred = complieance.oblOpred;
        result.oblZnach = complieance.oblZnach;

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>(complieance.oblOpred);
        for(int i = 0; i < complieance.oblOpred.size(); i++){
            if(i%2 == 1){
                list1.add(complieance.oblOpred.get(i));
            }
        }

        Grafic grafic = new Grafic();
        for(int i = 0; i < list1.size(); i++){
            for(int j = 0; j < list2.size(); j++){
                grafic.firstElements.add(list1.get(i));
                grafic.secondElements.add(list2.get(j));
            }
        }

//        searchEgualsKortejei(grafic, complieance.grafic);
//        result.grafic = difference(grafic, complieance.grafic);

        searchEgualsKortejei(grafic, complieance.grafic);
        result.grafic = equals.grafic;
        return printCompliences(result);
    }
    // композиция
    static String compositionComplience(Complieance complieance1, Complieance complieance2){
        Complieance result = new Complieance();
        result.oblOpred = complieance1.oblOpred;
        result.oblZnach = complieance2.oblZnach;
        result.grafic = composition(complieance1, complieance2);
        return printCompliences(result);
    }
    // образ
    static String reflectionComplience(Complieance complieance){
        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < complieance.oblOpred.size(); i++){
            if(i%2 == 1){
                list.add(complieance.oblOpred.get(i));
            }
        }
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < complieance.grafic.secondElements.size(); j++){
                if(list.get(i).equals(complieance.grafic.secondElements.get(j))){
                    result.add(complieance.grafic.firstElements.get(j));
                }
            }
        }

        return result.toString();
    }
    // Прообраз
    static String antiReflectionComplience(Complieance complieance){
        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < complieance.oblZnach.size(); i++){
            if(i%2 == 0){
                list.add(complieance.oblZnach.get(i));
            }
        }
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < complieance.grafic.firstElements.size(); j++){
                if(list.get(i).equals(complieance.grafic.firstElements.get(j))){
                    result.add(complieance.grafic.secondElements.get(j));
                }
            }
        }

        return result.toString();
    }

    // поиск однинаковых элементов
    static void equalsComplieance(Complieance complieance1, Complieance complieance2){
        equals = new Complieance();
        for(int i = 0; i < complieance1.oblZnach.size(); i++){
            for(int j = 0; j < complieance2.oblZnach.size(); j++){
                if(complieance1.oblZnach.get(i).equals(complieance2.oblZnach.get(j))){
                    equals.oblZnach.add(complieance1.oblZnach.get(i));
                }
            }
        }
        for(int i = 0; i < complieance1.oblOpred.size(); i++){
            for(int j = 0; j < complieance2.oblOpred.size(); j++){
                if(complieance1.oblOpred.get(i).equals(complieance2.oblOpred.get(j))){
                    equals.oblOpred.add(complieance1.oblOpred.get(i));
                }
            }
        }
        searchEgualsKortejei(complieance1.grafic, complieance2.grafic);
        equals.grafic = egalsKorteji;
    }
}



















