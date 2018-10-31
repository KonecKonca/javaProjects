import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Complieance complieance1 = new Complieance();
    private static Complieance complieance2 = new Complieance();
    private static Complieance equalsComplieance = new Complieance();

    public static void main(String[] args) {
        boolean end = false;
        while (!end){
            System.out.println("\n-----------------------------------------------");
//            System.out.println("0) Заполнить соответствия значениями по умолчанию");
            System.out.println("1) Ввести соответствие 1");
            System.out.println("2) Ввести соответствие 2");
            System.out.println("3) Вывести оба соответствия");
            System.out.println("4) Инверсия соответствия");
            System.out.println("5) Пересечение соответствий");
            System.out.println("6) Разность соответствий");
            System.out.println("7) Объединение соответствий");
            System.out.println("8) Продолжение");
            System.out.println("9) Симметрическая разность соответствий");
            System.out.println("10) Композиция соответствий");
            System.out.println("11) Образ");
            System.out.println("12) Прообраз");
            System.out.println("13) Продолжение");
            System.out.println("14) Сужение");
            System.out.println("15) Очистить график");
            System.out.println("16) выход");
            System.out.println("-----------------------------------------------\n");
            Scanner input = new Scanner(System.in);
            int answer = input.nextInt();

            switch (answer){
                case 0 :
                    complieance1 = new Complieance(new ArrayList<>(Arrays.asList("Ivanov", "Petrov", "Sidorov", "Smirnov")),
                            new ArrayList<>(Arrays.asList("5", "3", "1")),
                            new Grafic(new ArrayList<>(Arrays.asList("Ivanov", "Petrov", "Sidorov", "Smirnov")),
                                        new ArrayList<>(Arrays.asList("1", "3", "3", "5"))));

                    complieance2 = new Complieance(new ArrayList<>(Arrays.asList("Ivanova", "Petrov", "Sidorova", "Smirnova")),
                            new ArrayList<>(Arrays.asList("5", "9", "17", "3")),
                            new Grafic(new ArrayList<>(Arrays.asList("Ivanova", "Petrov", "Sidorova", "Smirnova")),
                                    new ArrayList<>(Arrays.asList("5", "3", "9", "17"))));
                    break;

                case 1 :
                    Graficsoperations.inputComplience(complieance1);
                    break;
                case 2 :
                    Graficsoperations.inputComplience(complieance2);
                    break;
                case 3 :
                    printCompliences();
                    break;
                case 4 :
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Введите номер соответствия");
                    int choice = scanner1.nextInt();
                    if(choice == 1){
                        System.out.println(Graficsoperations.inversionComplience(complieance1));
                    }
                    if(choice == 2){
                        System.out.println(Graficsoperations.inversionComplience(complieance2));
                    }
                    break;
                case 5 :
                    System.out.println(Graficsoperations.crossComplience(complieance1, complieance2));
                    break;
                case 6 :
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Введите номер соответсвия");
                    int choice1 = scanner2.nextInt();
                    if(choice1 == 1){
                        System.out.println(Graficsoperations.differenceComplience(complieance1, complieance2));
                    }
                    if(choice1 == 2){
                        System.out.println(Graficsoperations.differenceComplience(complieance2, complieance1));
                    }
                    break;
                case 7 :
                    System.out.println(Graficsoperations.unionComplience(complieance1, complieance2));
                    break;
                case 8 :
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Введите номер проверяемого соответствия");
                    int choice3 = scanner3.nextInt();
                    if(choice3 == 1){
                        System.out.println(Graficsoperations.continied(complieance1, complieance2));
                    }
                    if(choice3 == 2){
                        System.out.println(Graficsoperations.continied(complieance2, complieance1));
                    }
                    break;
                case 9 :
                    System.out.println(Graficsoperations.simmeticDifferenceComplience(complieance1, complieance2));
                    break;
                case 10 :
                    Scanner scanner10 = new Scanner(System.in);
                    System.out.println("Введите номер 1-го соответствия");
                    int choise10 = scanner10.nextInt();
                    if(choise10 == 1){
                        System.out.println(Graficsoperations.compositionComplience(complieance1, complieance2));
                    }
                    else if(choise10 == 2){
                        System.out.println(Graficsoperations.compositionComplience(complieance2, complieance1));
                    }
                    break;
                case 11 :
                    Scanner scanner11 = new Scanner(System.in);
                    System.out.println("Введи номер соответствия");
                    int choise11 = scanner11.nextInt();
                    if(choise11 == 1){
                        System.out.println(Graficsoperations.reflectionComplience(complieance1));
                    }
                    else if(choise11 == 2){
                        System.out.println(Graficsoperations.reflectionComplience(complieance2));
                    }
                    break;
                case 12 :
                    Scanner scanner12 = new Scanner(System.in);
                    System.out.println("Введи номер соответствия");
                    int choise12 = scanner12.nextInt();
                    if(choise12 == 1){
                        System.out.println(Graficsoperations.antiReflectionComplience(complieance1));
                    }
                    else if(choise12 == 2){
                        System.out.println(Graficsoperations.antiReflectionComplience(complieance2));
                    }
                    break;
                case 13 :
                    Scanner scanner13 = new Scanner(System.in);
                    System.out.println("Введи номер соответствия");
                    int choise13 = scanner13.nextInt();
                    if(choise13 == 1){
                        System.out.println(Graficsoperations.continied(complieance1, complieance2));
                    }
                    else if(choise13 == 2){
                        System.out.println(Graficsoperations.continied(complieance2, complieance1));
                    }
                    break;
                case 14 :
                    Scanner scanner14 = new Scanner(System.in);
                    System.out.println("Введи номер соответствия");
                    int choise14 = scanner14.nextInt();
                    if(choise14 == 1){
                        System.out.println(Graficsoperations.narroved(complieance1));
                    }
                    else if(choise14 == 2){
                        System.out.println(Graficsoperations.narroved(complieance2));
                    }
                    break;
                case 15 :
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите номер очищаемого соответствия");
                    int nomber = scanner.nextInt();
                    if(nomber == 1){
                        complieance1 = new Complieance();
                    }
                    if (nomber == 2){
                        complieance2 = new Complieance();
                    }
                    break;
                case 16 : System.exit(1);
            }
        }
    }

    static void printCompliences(){
        System.out.println(Graficsoperations.printCompliences(complieance1));
        System.out.println(Graficsoperations.printCompliences(complieance2));
    }
}
