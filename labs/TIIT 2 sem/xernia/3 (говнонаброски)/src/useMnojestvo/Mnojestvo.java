package useMnojestvo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

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
        Mnojestvo mnojestvo = new Mnojestvo();
        mnojestvo.arrayList.addAll(this.arrayList);
        ArrayList<Integer> doparray = new ArrayList<>();
        for(int i = 0; i < arrayList.size(); i++){
            for(int j = (i + 1); j < arrayList.size(); j++){
                if(arrayList.get(i) == arrayList.get(j)){
                    doparray.add(arrayList.get(i));
                }
            }
        }

        for(int i = 0; i < doparray.size(); i++){
            System.out.print(doparray.get(i) + " ");
        }

        for(int i = 0; i < doparray.size(); i++){
            for(int j = 0; j < mnojestvo.arrayList.size(); j++){
                if(mnojestvo.arrayList.get(j) == doparray.get(i)){
                    mnojestvo.arrayList.remove(arrayList.get(j));
                    break;
                }
            }
        }
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
        arrayList.sort(new Comparator<Integer>() {
            @Override   // http://info.javarush.ru/translation/2014/06/14/%D0%9A%D0%B0%D0%BA-%D0%BF%D1%80%D0%B0%D0%B2%D0%B8%D0%BB%D1%8C%D0%BD%D0%BE-%D0%B4%D0%B5%D0%BB%D0%B0%D1%82%D1%8C-%D1%81%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D1%83-%D0%B2-Java.html
            public int compare(Integer o1, Integer o2) {
                return o1.toString().compareTo(o2.toString());
                //
            }
        });
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

    public void delete(int element){
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

    /*public ArrayList<Mnojestvo> booleanMnojestva(ArrayList<Mnojestvo> boolenMnoj){
        Mnojestvo dopMn = new Mnojestvo();
        for(int i = 0; i < this.arrayList.size(); i++){
            for(int j = 0; j < mnojestvo2.arrayList.size(); j++){
                dopMn.add(this.arrayList.get(i));
            }
            arrayMnojestv.add();
        }
        return arrayMnojestv;
    }*/
}



