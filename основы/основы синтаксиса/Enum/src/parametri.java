/**
 * Created by Андрей on 03.01.2018.
 */
public enum parametri {
    x1(5343,3434),
    x2(53,652),
    x3(534,355),
    x4(45,34),
    xrenchik(777,777);

    private final int desk1;
    private final int desk2;

    parametri(int d1, int d2){
        desk1 = d1;
        desk2 = d2;
    }

    public int getdesk1() {
        return desk1;
    }

    public int getdesk2(){
        return desk2;
    }

}
