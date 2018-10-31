package useMnojestva;

public class Kortej extends Mnojestvo{
    private int[] allElements;
    public static int indikatorDannie = 1;
    public static int indikatorMnojestvo = 2;
    public static int indikatorKortej = 3;
    public int getFromAllElements(int nomber){
        return allElements[nomber];
    }

    public Kortej(){
        allElements = new int[lengthDannie + lengthVlojMnoj + lengthVlojkartej];
    }

    private int getAllLength(){
        return allElements.length;
    }

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

        for(int i = 0; i < kortej.getAllLength(); i++){
            if(this.allElements[i] != kortej.getFromAllElements(i)){
                return false;
            }
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

        int[] dopAllElements = new int[lengthDannie + lengthVlojMnoj + lengthVlojkartej];
        for(int i = 0; i < allElements.length; i++){
            dopAllElements[i] = allElements[i];
        }
        dopAllElements[allElements.length] = indikatorDannie;
        allElements = dopAllElements;
    }

    @Override
    public void addMnojestvo(Mnojestvo mnojestvo){
        Mnojestvo[] newMnojestvo = new Mnojestvo[lengthVlojMnoj + 1];
        for(int i = 0; i < lengthVlojMnoj; i++){
            newMnojestvo[i] = vlojMnoj[i];
        }
        newMnojestvo[lengthVlojMnoj++] = mnojestvo;
        vlojMnoj = newMnojestvo;

        int[] dopAllElements = new int[lengthDannie + lengthVlojMnoj + lengthVlojkartej];
        for(int i = 0; i < allElements.length; i++){
            dopAllElements[i] = allElements[i];
        }
        dopAllElements[allElements.length] = indikatorMnojestvo;
        allElements = dopAllElements;
    }

    @Override
    public void addKortej(Kortej kortej){
        Kortej[] newKortej = new Kortej[lengthVlojkartej + 1];
        for(int i = 0; i < lengthVlojkartej; i++){
            newKortej[i] = (Kortej) vlojKartej[i];
        }
        newKortej[lengthVlojkartej++] = kortej;
        vlojKartej = newKortej;

        int[] dopAllElements = new int[lengthDannie + lengthVlojMnoj + lengthVlojkartej];
        for(int i = 0; i < allElements.length; i++){
            dopAllElements[i] = allElements[i];
        }
        dopAllElements[allElements.length] = indikatorKortej;
        allElements = dopAllElements;
    }
}
