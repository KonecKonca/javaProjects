import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean end = false;
        while (!end){
            System.out.println("\n-----------------------------------------------");
            System.out.println("0) Заполнить графики значениями по умолчанию");
            System.out.println("1) Ввести график 1");
            System.out.println("2) Ввести график 2");
            System.out.println("3) Вывести оба графика");
            System.out.println("4) Проекция");
            System.out.println("5) Пересечение");
            System.out.println("6) Инверсия");
            System.out.println("7) Мощность множеств");
            System.out.println("8) Разность");
            System.out.println("9) Объединение");
            System.out.println("10) Симметрическая разность");
            System.out.println("11) Композиция");
            System.out.println("12) выход");
            System.out.println("-----------------------------------------------\n");
            Scanner input = new Scanner(System.in);
            int answer = input.nextInt();

            if(answer == 0){
                Graficsoperations.grafic1.firstElements = new ArrayList<>(Arrays.asList("3", "7", "8", "5", "1"));
                Graficsoperations.grafic1.secondElements = new ArrayList<>(Arrays.asList("5", "1", "2", "5", "4"));

                Graficsoperations.grafic2.firstElements = new ArrayList<>(Arrays.asList("7", "1", "f", "5"));
                Graficsoperations.grafic2.secondElements = new ArrayList<>(Arrays.asList("1", "7", "e", "5"));

            }
            else if(answer == 1){
                Graficsoperations.grafic1 = new Grafic();
                System.out.println("Введите кол-во кортежей");
                Scanner inputGrafic = new Scanner(System.in);
                int numOfKortej = inputGrafic.nextInt();
                for (int i = 0; i < numOfKortej; i++){
                    System.out.println("Введите 1-ый элемент кортежа");
                    Scanner firstEl = new Scanner(System.in);
                    Graficsoperations.grafic1.firstElements.add(firstEl.next());

                    System.out.println("Введите 2-ой элемент кортежа");
                    Scanner seconfEl = new Scanner(System.in);
                    Graficsoperations.grafic1.secondElements.add(seconfEl.next());
                }
            }
            else if(answer == 2){
                Graficsoperations.grafic2 = new Grafic();
                System.out.println("Введите кол-во кортежей");
                Scanner inputGrafic = new Scanner(System.in);
                int numOfKortej = inputGrafic.nextInt();
                for (int i = 0; i < numOfKortej; i++){
                    System.out.println("Введите 1-ый элемент кортежа");
                    Scanner firstEl = new Scanner(System.in);
                    Graficsoperations.grafic2.firstElements.add(firstEl.next());

                    System.out.println("Введите 2-ой элемент кортежа");
                    Scanner seconfEl = new Scanner(System.in);
                    Graficsoperations.grafic2.secondElements.add(seconfEl.next());
                }
            }
            else if(answer == 3){
                printGrafics();
            }
            else if(answer == 4){
                System.out.println("Введите № графика");
                Scanner nGrafic = new Scanner(System.in);
                int nomberOfGrafic = nGrafic.nextInt();
                System.out.println("Введите № проекции");
                Scanner nProection = new Scanner(System.in);
                int nomderOfProection = nProection.nextInt();

                String proection = Graficsoperations.proection(nomberOfGrafic, nomderOfProection);
                System.out.println(proection);
            }
            else if(answer == 5){
                printGrafics();
                String result = Graficsoperations.crossing();
                System.out.println("Результат Пересечения: " + result);
            }
            else if(answer == 6){
                printGrafics();
                System.out.println("Введите номер инверсируемого графика");
                Scanner nGrafic = new Scanner(System.in);
                int nobmerOfGrafic = nGrafic.nextInt();
                System.out.println("Результат инверсии: " + Graficsoperations.inversion(nobmerOfGrafic));
            }
            else if(answer == 7){
                printGrafics();
                System.out.println("Можность 1-го множества: " + Graficsoperations.grafic1.firstElements.size());
                System.out.println("Можность 2-го множества: " + Graficsoperations.grafic2.firstElements.size());
            }
            else if(answer == 8){
                printGrafics();
                System.out.println("Разность 1-го/2-му: " + Graficsoperations.difference(1));
                System.out.println("Разность 2-го/1-му: " + Graficsoperations.difference(2));
            }
            else if(answer == 9){
                printGrafics();
                System.out.println("Результат объединения: " + Graficsoperations.join());
            }
            else if(answer == 10){
                printGrafics();
                System.out.println("Результат объединения: " + Graficsoperations.simmetricDifference());
            }
            else if(answer == 11){
                printGrafics();
                System.out.println("Композиция 1-го/2-му: " + Graficsoperations.composition(1));
                System.out.println("Композиция 2-го/1-му: " + Graficsoperations.composition(2));
            }
            else if(answer == 12){
                end = true;
            }
        }
    }

    static void printGrafics(){
        System.out.println("1-ый график: " + Graficsoperations.printGrafic(1));
        System.out.println("2-ой график: " + Graficsoperations.printGrafic(2));
    }
}
