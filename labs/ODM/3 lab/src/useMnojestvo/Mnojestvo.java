package useMnojestvo;
import java.util.*;

public class Mnojestvo {
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public int getArraylenth(){
        return arrayList.size();
    }

    public int getArrayEl(int i){
        return arrayList.get(i);
    }

    public void show(){
        //System.out.println("Vashe mnojestvo");
        for(int i = 0; i< arrayList.size(); i++){
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println("\n");
    }

    public Mnojestvo cheakcomplience(){
        Set<Integer> set = new HashSet<>();
        set.addAll(arrayList);
        arrayList.clear();
        arrayList.addAll(set);
        Mnojestvo mnojestvo = new Mnojestvo();
        mnojestvo.arrayList.addAll(arrayList);
        return mnojestvo;
    }

    public static void showArray(ArrayList<Mnojestvo> arrayList){
        byte zapiataja = 0;
        int j;
        int newRow = arrayList.get(0).arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++){
            System.out.print("{");
            for(j = 0; j < arrayList.get(i).arrayList.size(); j++){
                if(zapiataja++ < (arrayList.get(i).arrayList.size() - 1)) {
                    System.out.print(arrayList.get(i).arrayList.get(j) + ", ");
                }
                else {
                    System.out.print(arrayList.get(i).arrayList.get(j));
                    zapiataja = 0;
                }
            }
            System.out.print("}");
            newRow++;
            if (newRow != arrayList.get(i).arrayList.get(j - 1)) {
                System.out.println();
                newRow = arrayList.get(i).arrayList.get(j - 1);
            }
        }
        System.out.println();
    }

    public void sort(){
        Collections.sort(arrayList);
    }

    private ArrayList<Integer> searchOdinakov(Mnojestvo mnojestvo2){
        ArrayList<Integer> sovpadenia = new ArrayList<>();
        for(int i = 0; i < this.arrayList.size(); i++){
            for(int j = 0; j < mnojestvo2.arrayList.size(); j++){
                if(this.arrayList.get(i) == mnojestvo2.arrayList.get(j)){
                    sovpadenia.add(this.arrayList.get(i));
                }
            }
        }
        return sovpadenia;
    }

    public Mnojestvo searchOdinakov(Mnojestvo mnojestvo1, Mnojestvo mnojestvo2){
        ArrayList<Integer> sovpadenia = new ArrayList<>();
        for(int i = 0; i < mnojestvo1.arrayList.size(); i++){
            for(int j = 0; j < mnojestvo2.arrayList.size(); j++){
                if(this.arrayList.get(i) == mnojestvo2.arrayList.get(j)){
                    sovpadenia.add(mnojestvo1.arrayList.get(i));
                }
            }
        }
        Mnojestvo mnojestvo = new Mnojestvo();
        mnojestvo.arrayList.addAll(sovpadenia);
        return mnojestvo;
    }

    public void add(int element){
        arrayList.add(element);
    }

    public void delete(Integer element){
        this.arrayList.remove(element);
    }

    public Mnojestvo raznost(Mnojestvo mnojestvo2){
        Mnojestvo mnojestvo = new Mnojestvo();
        ArrayList<Integer> sovpadenia = searchOdinakov(mnojestvo2);
        for(int i = 0; i < this.arrayList.size(); i++){
            mnojestvo.add(this.arrayList.get(i));
        }
        for(int i = 0; i < sovpadenia.size(); i++){
            mnojestvo.arrayList.remove(sovpadenia.get(i));
        }
        return mnojestvo;
    }

    public Mnojestvo raznost(Mnojestvo mnojestvo1, Mnojestvo mnojestvo2){
        Mnojestvo mnojestvo = new Mnojestvo();
        ArrayList<Integer> sovpadenia = searchOdinakov(mnojestvo2);
        for(int i = 0; i < mnojestvo1.arrayList.size(); i++){
            mnojestvo.add(mnojestvo1.arrayList.get(i));
        }
        for(int i = 0; i < sovpadenia.size(); i++){
            mnojestvo.arrayList.remove(sovpadenia.get(i));
        }
        return mnojestvo;
    }

    public Mnojestvo objedinenie(Mnojestvo mnojestvo2){
        Mnojestvo mnojestvo = new Mnojestvo();
        mnojestvo.arrayList.addAll(this.arrayList);
        Mnojestvo dop = new Mnojestvo();
        dop = raznost(mnojestvo2, this);
        mnojestvo.arrayList.addAll(dop.arrayList);
        return mnojestvo;
    }

    public Mnojestvo simmetrichajaRaznost(Mnojestvo mnojestvo2){
        Mnojestvo mnojestvo = new Mnojestvo();
        Mnojestvo dop = new Mnojestvo();
        dop = raznost(mnojestvo2, this);
        mnojestvo.arrayList.addAll(dop.arrayList);
        dop = raznost(this, mnojestvo2);
        mnojestvo.arrayList.addAll(dop.arrayList);
        return mnojestvo;
    }

    public ArrayList<Mnojestvo> decartmnojestvo(ArrayList<Mnojestvo> arrayMnojestv, Mnojestvo mnojestvo2){
        for(int i = 0; i < this.arrayList.size(); i++){
            for(int j = 0; j < mnojestvo2.arrayList.size(); j++){
                Mnojestvo dopMn = new Mnojestvo();
                dopMn.add(this.arrayList.get(i));
                dopMn.add(mnojestvo2.arrayList.get(j));
                arrayMnojestv.add(dopMn);
            }
        }
        return arrayMnojestv;
    }

    public Mnojestvo dopolnenie(Mnojestvo Nadmnoj){
        Mnojestvo mnojestvo = new Mnojestvo();
        for(int i = 0; i < Nadmnoj.getArraylenth(); i++){
            mnojestvo.add(Nadmnoj.arrayList.get(i));
        }
        for(int i = 0; i < mnojestvo.getArraylenth(); i++){
            for(int j = 0; j < this.getArraylenth(); j++){
                if(mnojestvo.arrayList.get(i) == this.arrayList.get(j)){
                    mnojestvo.arrayList.remove(mnojestvo.arrayList.get(i));
                }
            }
        }
        return mnojestvo;
    }

}



