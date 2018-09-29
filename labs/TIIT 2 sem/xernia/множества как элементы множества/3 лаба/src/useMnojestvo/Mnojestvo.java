package useMnojestvo;
import java.util.*;

public class Mnojestvo {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private List<Mnojestvo> vlojMnojestvo = new ArrayList<>();

    public int getArraylenth(){
        return arrayList.size();
    }

    public int getVlojMnojLength(){
        return vlojMnojestvo.size();
    }

    public int getArrayEl(int i) {
        return arrayList.get(i);
    }
    public Mnojestvo getElVlojMnojestvo(int i){
        return vlojMnojestvo.get(i);
    }
    public List<Mnojestvo> getVloj(){ return vlojMnojestvo; }

    public Mnojestvo cheakcomplience(){
        Set<Integer> set = new HashSet<>();
        set.addAll(arrayList);
        arrayList.clear();
        arrayList.addAll(set);

        Set<Mnojestvo> setMn = new HashSet<>();
        setMn.addAll(vlojMnojestvo);
        vlojMnojestvo.clear();
        vlojMnojestvo.addAll(setMn);

        Mnojestvo mnojestvo = new Mnojestvo();
        mnojestvo.arrayList.addAll(arrayList);
        mnojestvo.vlojMnojestvo.addAll(vlojMnojestvo);
        return mnojestvo;
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

    private List<Mnojestvo> searchOdinakovMN(Mnojestvo mnojestvo2){
        List<Mnojestvo> sovpadenia = new ArrayList<>();
        for(int i = 0; i < this.vlojMnojestvo.size(); i++){
            for(int j = 0; j < mnojestvo2.vlojMnojestvo.size(); j++){
                if(this.vlojMnojestvo.get(i).equals(mnojestvo2.vlojMnojestvo.get(j))){
                    sovpadenia.add(this.vlojMnojestvo.get(i));
                }
            }
        }
        return sovpadenia;
    }

    public Mnojestvo searchOdinakov(Mnojestvo mnojestvo1, Mnojestvo mnojestvo2){
        ArrayList<Integer> sovpadenia = new ArrayList<>();
        List<Mnojestvo> listMn = new ArrayList<>();
        for(int i = 0; i < mnojestvo1.arrayList.size(); i++){
            for(int j = 0; j < mnojestvo2.arrayList.size(); j++){
                if(mnojestvo1.arrayList.get(i) == mnojestvo2.arrayList.get(j)){
                    sovpadenia.add(mnojestvo1.arrayList.get(i));
                }
            }
        }

        for(int i = 0; i<mnojestvo1.vlojMnojestvo.size(); i++){
            for(int j = 0; j < mnojestvo2.vlojMnojestvo.size(); j++){
                if(mnojestvo1.vlojMnojestvo.get(i).equals(mnojestvo2.vlojMnojestvo.get(j))){
                    listMn.add(mnojestvo1.vlojMnojestvo.get(i));
                }
            }
        }
        Mnojestvo mnojestvo = new Mnojestvo();
        mnojestvo.arrayList.addAll(sovpadenia);
        mnojestvo.vlojMnojestvo.addAll(listMn);
        return mnojestvo;
    }

    public void add(int element){
        arrayList.add(element);
    }

    public void add(Mnojestvo mnojestvo){
        vlojMnojestvo.add(mnojestvo);
    }

    public void delete(Integer element){
        this.arrayList.remove(element);
    }

    public void delete(Mnojestvo element){
        this.vlojMnojestvo.remove(element);
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

        List<Mnojestvo> mnList = searchOdinakovMN(mnojestvo2);
        for(int i = 0; i < this.vlojMnojestvo.size(); i++){
            mnojestvo.add(this.vlojMnojestvo.get(i));
        }
        for(int i = 0; i < mnList.size(); i++){
            mnojestvo.vlojMnojestvo.remove(mnList.get(i));
        }
        return mnojestvo;
    }

    /////////////////////////////////////////////////////////////////////// must be changed

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

    /////////////////////////////////////////////////////////////////////// must be changed
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

    @Override
    public int hashCode() {
        int result = arrayList != null ? arrayList.hashCode() : 0;
        result = 31 * result + (vlojMnojestvo != null ? vlojMnojestvo.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mnojestvo mnojestvo = (Mnojestvo) o;

        if (arrayList != null ? !arrayList.equals(mnojestvo.arrayList) : mnojestvo.arrayList != null) return false;
        return vlojMnojestvo != null ? vlojMnojestvo.equals(mnojestvo.vlojMnojestvo) : mnojestvo.vlojMnojestvo == null;
    }
}



