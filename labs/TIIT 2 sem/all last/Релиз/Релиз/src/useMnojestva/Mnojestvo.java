package useMnojestva;

import java.util.*;

public class Mnojestvo {
    public Mnojestvo(){
        lengthVlojMnoj = 0;
        lengthVlojkartej = 0;
        lengthDannie = 0;

        vlojMnoj = new Mnojestvo[lengthVlojMnoj];
        vlojKartej = new Kortej[lengthVlojkartej];
        dannie = new int[lengthDannie];
    }

    protected int lengthVlojMnoj;
    protected int lengthVlojkartej;
    protected int lengthDannie;

    protected Mnojestvo[] vlojMnoj;
    protected Kortej[] vlojKartej;
    protected int[] dannie;

    public int getLengthVlojMnoj(){return lengthVlojMnoj;}
    public int getLengthVlojkortej(){return lengthVlojkartej;}
    public int getLengthDannie(){return lengthDannie;}

    public Mnojestvo geElementVlojMnoj(int m){
        return vlojMnoj[m];
    }
    public Kortej geElementVlojKortej(int k){
        return vlojKartej[k];
    }
    public int geElementDannie(int d){
        return dannie[d];
    }

    public void addDannie(int n){
        for(int i = 0; i < lengthDannie; i++){
            if(dannie[i] == n){
                return;
            }
        }

        int[] newDannie = new int[lengthDannie + 1];
        for(int i = 0; i < lengthDannie; i++){
            newDannie[i] = dannie[i];
        }
        newDannie[lengthDannie++] = n;
        dannie = newDannie;
    }
    public void addMnojestvo(Mnojestvo mnojestvo){
        for(int i = 0; i < this.lengthVlojMnoj; i++){
            if(mnojestvo.sravnenie(this.vlojMnoj[i])){
                return;
            }
        }

        Mnojestvo[] newMnojestvo = new Mnojestvo[lengthVlojMnoj + 1];
        for(int i = 0; i < lengthVlojMnoj; i++){
            newMnojestvo[i] = vlojMnoj[i];
        }
        newMnojestvo[lengthVlojMnoj++] = mnojestvo;
        vlojMnoj = newMnojestvo;
    }
    public void addKortej(Kortej kortej){
        for(int i = 0; i < this.lengthVlojkartej; i++){
            if(kortej.sravnenie(this.vlojKartej[i])){
                return;
            }
        }

        Kortej[] newKortej = new Kortej[lengthVlojkartej + 1];
        for(int i = 0; i < lengthVlojkartej; i++){
            newKortej[i] = (Kortej) vlojKartej[i];
        }
        newKortej[lengthVlojkartej++] = kortej;
        vlojKartej = newKortej;
    }

    public void deleteDannie(int n){
        int[] newdannie;
        boolean cheaker = false;
        for(int i = 0; i < lengthDannie; i++){
            if(dannie[i] == n){
                cheaker = true;
            }
        }

        if(cheaker){
            newdannie = new int[lengthDannie - 1];
            int count = 0;
            for(int i = 0; i < lengthDannie; i++){
                if(dannie[i] == n){
                    continue;
                }
                newdannie[count++] = dannie[i];
            }
            lengthDannie--;
            dannie = newdannie;
        }
    }

    public void deleteMnojestvo(Mnojestvo mnojestvo){
        Mnojestvo[] newmnojestvo;
        boolean cheaker = false;
        for(int i = 0; i < lengthVlojMnoj; i++){
            if(vlojMnoj[i].sravnenie(mnojestvo)){
                cheaker = true;
            }
        }

        if(cheaker){
            newmnojestvo = new Mnojestvo[lengthVlojMnoj - 1];
            int count = 0;
            for(int i = 0; i < lengthVlojMnoj; i++){
                if(vlojMnoj[i].sravnenie(mnojestvo)){
                    continue;
                }
                newmnojestvo[count++] = vlojMnoj[i];
            }
            lengthVlojMnoj--;
            vlojMnoj = newmnojestvo;
        }
    }

    public void deleteKortej(Kortej kortej){
        Kortej[] newkortej;
        boolean cheaker = false;
        for(int i = 0; i < lengthVlojkartej; i++){
            if(vlojKartej[i].sravnenie(kortej)){
                cheaker = true;
            }
        }

        if(cheaker){
            newkortej = new Kortej[lengthVlojkartej - 1];
            int count = 0;
            for(int i = 0; i < lengthVlojkartej; i++){
                if(vlojKartej[i].sravnenie(kortej)){
                    continue;
                }
                newkortej[count++] = vlojKartej[i];
            }
            lengthVlojkartej--;
            vlojKartej = newkortej;
        }
    }

    public Mnojestvo raznost(Mnojestvo peredannoeMnojestvo){
        Mnojestvo mnojestvo = new Mnojestvo();
        Mnojestvo sovpad = searchOdinakov(peredannoeMnojestvo);

        for(int i = 0; i < this.lengthDannie; i++){
            mnojestvo.addDannie(this.dannie[i]);
        }
        for(int i = 0; i < this.lengthVlojMnoj; i++){
            mnojestvo.addMnojestvo(this.vlojMnoj[i]);
        }
        for(int i = 0; i < this.lengthVlojkartej; i++){
            mnojestvo.addKortej(this.vlojKartej[i]);
        }

        for(int i = 0; i < sovpad.lengthDannie; i++){
            mnojestvo.deleteDannie(sovpad.geElementDannie(i));
        }
        for(int i = 0; i < sovpad.lengthVlojMnoj; i++){
            mnojestvo.deleteMnojestvo(sovpad.geElementVlojMnoj(i));
        }
        for(int i = 0; i < sovpad.lengthVlojkartej; i++){
            mnojestvo.deleteKortej(sovpad.geElementVlojKortej(i));
        }

        return mnojestvo;
    }

    protected Mnojestvo searchOdinakov(Mnojestvo peredmnoj){
        Mnojestvo mnojestvo = new Mnojestvo();

        for(int i = 0; i < this.lengthVlojkartej; i++){
            for(int j = 0; j < peredmnoj.getLengthVlojkortej(); j++){
                if(this.vlojKartej[i].sravnenie((peredmnoj.geElementVlojKortej(j)))){
                    mnojestvo.addKortej(this.vlojKartej[i]);
                }
            }
        }

        for(int i = 0; i < this.lengthVlojMnoj; i++){
            for(int j = 0; j < peredmnoj.getLengthVlojMnoj(); j++){
                if(this.vlojMnoj[i].sravnenie((peredmnoj.geElementVlojMnoj(j)))){
                    mnojestvo.addMnojestvo(this.vlojMnoj[i]);
                }
            }
        }

        for(int i = 0; i < this.lengthDannie; i++){
            for(int j = 0; j < peredmnoj.getLengthDannie(); j++){
                if(this.dannie[i] == peredmnoj.geElementDannie(j)){
                    mnojestvo.addDannie(this.dannie[i]);
                }
            }
        }

        return mnojestvo;
    }

    protected boolean sravnenie(Mnojestvo mnojestvo){
        if(this.lengthVlojMnoj != mnojestvo.getLengthVlojMnoj()){
            return false;
        }
        if(this.lengthVlojkartej != mnojestvo.getLengthVlojkortej()){
            return false;
        }
        if(this.lengthDannie != mnojestvo.getLengthDannie()){
            return false;
        }

        int count = 0;
        for(int i = 0; i < this.getLengthDannie(); i++){
            for(int j = 0; j < mnojestvo.getLengthDannie(); j++){
                if(dannie[i] == mnojestvo.geElementDannie(j)){
                    count++;
                }
            }
        }
        if(count != lengthDannie){
            return false;
        }

        int count2 = 0;
        for(int i = 0; i < this.getLengthVlojMnoj(); i++){
            for(int j = 0; j < mnojestvo.getLengthVlojMnoj(); j++){
                if(vlojMnoj[i].sravnenie(mnojestvo.geElementVlojMnoj(j))){
                    count2++;
                }
            }
        }
        if(count2 != lengthVlojMnoj){
            return false;
        }

        int count3 = 0;
        for(int i = 0; i < this.getLengthVlojkortej(); i++){
            for(int j = 0; j < mnojestvo.getLengthVlojkortej(); j++){
                if(vlojKartej[i].sravnenie(mnojestvo.geElementVlojKortej(j))){
                    count3++;
                }
            }
        }
        if(count3 != lengthVlojkartej){
            return false;
        }
        return true;
    }
}
