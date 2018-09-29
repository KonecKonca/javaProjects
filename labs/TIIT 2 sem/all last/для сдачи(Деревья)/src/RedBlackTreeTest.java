import java.util.Scanner;
import useRBTree.*;

public class RedBlackTreeTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        RBTree rbt = new RBTree(Integer.MIN_VALUE);
        System.out.println("Red Black Tree Test\n");

        boolean end = true;
        do {
            System.out.println("\nRed Black Tree Operations");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. clear tree");
            System.out.println("5. show tree in Graphics");
            System.out.println("6. avtoZapolnenie");
            System.out.println("7. poisk minimyma");
            System.out.println("8. poisk maximyma");
            System.out.println("9. poisk blijaishix k zadannomy");
            System.out.println("10. Remove element");
            System.out.println("11. exit\n");

            int choice = 11;

            boolean cheakVvod = true;
            while(cheakVvod){
                try {
                    Scanner vvod = new Scanner(System.in);
                    choice = vvod.nextInt();
                    cheakVvod = false;
                }
                catch (Exception ex){
                    System.out.println("Inncorrect input");
                }
            }
            if(choice > 11){
                choice = 11;
            }

            switch (choice) {
                case 1 :
                    System.out.println("Enter integer element to insert");
                    rbt.insert( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Enter integer element to search");
                    System.out.println("Search result : "+ rbt.search( scan.nextInt() ));
                    break;
                case 3 :
                    System.out.println("Nodes = "+ rbt.countNodes());
                    break;
                case 4 :
                    System.out.println("\nTree Cleared");
                    rbt.makeEmpty();
                    break;
                case 5 :
                    System.out.println("\n It is your tree");
                    rbt.visualShow();
                    break;
                case 6 :
                    System.out.println("\n Using avtovvod\n");
                    for(int i = 1; i < 50; i+=3){
                        rbt.insert(i);
                    }
                    break;
                case 7 :
                    System.out.print("\n Min znachenie: " + rbt.poiskMin() + "\n");
                    break;
                case 8 :
                    System.out.print("\n Max znachenie: " + rbt.poiskMax() + "\n");
                    break;
                case 9 :
                    System.out.print("Enter the nomber : ");
                    int forPoisk = scan.nextInt();
                    System.out.println();
                    System.out.println("Blijaish znachenia for " + forPoisk + " :");
                    if(rbt.blijMensh(forPoisk) == -1){
                        System.out.println("Blijaish mensh : You enter is a smallest nomber");
                    }
                    else {
                        System.out.println("Blijaish mensh : " + rbt.blijMensh(forPoisk));
                    }
                    if(rbt.blijBolsh(forPoisk) == -1){
                        System.out.println("Blijaish bolsh : You enter is a bigest nomber");
                    }
                    else {
                        System.out.println("Blijaish bolsh : " + rbt.blijBolsh(forPoisk));
                    }
                    break;
                case 10 :
                    Scanner input = new Scanner(System.in);
                    int del = input.nextInt();
                    rbt.remove(del);
                    System.out.println("Elemnt with nomber " + del + " is not a part of tree now");
                    break;
                case 11 :
                    System.out.println("\n End of the programm!!!");
                    end = false;
                    break;
                default:
                    System.out.println("Wrong Entry\n");
                    break;
            }
        } while (end);
    }
}