package useMnojestva;

public class Kortej extends Mnojestvo{

    public boolean sravnenie(Kortej kortej){
        if(this.lengthVlojMnoj != kortej.lengthVlojMnoj){
            return false;
        }
        if(this.lengthVlojkartej != kortej.lengthVlojkartej){
            return false;
        }
        if(this.lengthDannie != kortej.lengthDannie){
            return false;
        }

        for(int i = 0; i < kortej.lengthDannie; i++){
            if(dannie[i] != kortej.geElementDannie(i)){
               return false;
            }
        }

        for(int i = 0; i < kortej.lengthVlojMnoj; i++){
            if(!vlojMnoj[i].sravnenie(kortej.geElementVlojMnoj(i))){
                return false;
            }
        }

        for(int i = 0; i < kortej.lengthVlojkartej; i++){
            if(!vlojKartej[i].sravnenie(kortej.geElementVlojKortej(i))){
                return false;
            }
        }

        return true;
    }

    @Override
    public void addDannie(int n){
        int[] newDannie = new int[lengthDannie + 1];
        for(int i = 0; i < lengthDannie; i++){
            newDannie[i] = dannie[i];
        }
        newDannie[lengthDannie++] = n;
        dannie = newDannie;
    }

    @Override
    public void addMnojestvo(Mnojestvo mnojestvo){
        Mnojestvo[] newMnojestvo = new Mnojestvo[lengthVlojMnoj + 1];
        for(int i = 0; i < lengthVlojMnoj; i++){
            newMnojestvo[i] = vlojMnoj[i];
        }
        newMnojestvo[lengthVlojMnoj++] = mnojestvo;
        vlojMnoj = newMnojestvo;
    }

    @Override
    public void addKortej(Kortej kortej){
        Kortej[] newKortej = new Kortej[lengthVlojkartej + 1];
        for(int i = 0; i < lengthVlojkartej; i++){
            newKortej[i] = (Kortej) vlojKartej[i];
        }
        newKortej[lengthVlojkartej++] = kortej;
        vlojKartej = newKortej;
    }
}
