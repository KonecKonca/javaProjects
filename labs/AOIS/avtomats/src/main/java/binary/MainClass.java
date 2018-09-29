package binary;

import binary.Constants.Constant;

public class MainClass {

    private static BinaryInteger binaryInteger1 = new BinaryInteger(Constant.VALUE1);
    private static BinaryInteger binaryInteger2 = new BinaryInteger(Constant.VALUE2);

    public static void main(String[] args) {
        fasad();
    }

    public static void fasad(){
        convert();
        straightSum();
    }

    public static void convert(){
        binaryInteger1 = new BinaryInteger(Constant.VALUE1);
        binaryInteger2 = new BinaryInteger(Constant.VALUE2);
        System.out.println("Value1 :\t" + Constant.VALUE1 + "\t" + binaryInteger1 + "    reverse:  " + binaryInteger1.toReverseFormat()
                + " additional: " + new BinaryInteger(Constant.VALUE1).toAdditionalFormat());
        System.out.println("Value2 :\t" + Constant.VALUE2 + "\t" + binaryInteger2 + "   reverse: " + binaryInteger2.toReverseFormat()
                + " additional: " + new BinaryInteger(Constant.VALUE2).toAdditionalFormat());

        binaryInteger1 = new BinaryInteger(-Constant.VALUE1);
        binaryInteger2 = new BinaryInteger(-Constant.VALUE2);
        System.out.println("-Value1 :\t" + Constant.VALUE1 + "\t" + binaryInteger1 + "    reverse:  " + binaryInteger1.toReverseFormat()
                + " additional: " + new BinaryInteger(-Constant.VALUE1).toAdditionalFormat());
        System.out.println("-Value2 :\t" + Constant.VALUE2 + "\t" + binaryInteger2 + "   reverse: " + binaryInteger2.toReverseFormat()
                + " additional: " + new BinaryInteger(-Constant.VALUE2).toAdditionalFormat());
    }
    public static void straightSum(){
        System.out.println("--------------------------------------------------------");
        System.out.println("--------------------------------------------------------");
        System.out.println("\n(1) Sum in straight code:\n");
        binaryInteger1 = new BinaryInteger(Constant.VALUE1);
        binaryInteger2 = new BinaryInteger(Constant.VALUE2);
        System.out.println("+/+ :  " + binaryInteger1 + " + " + binaryInteger2 + " = " + binaryInteger1.sum(binaryInteger1, binaryInteger2));

        binaryInteger1 = new BinaryInteger(-Constant.VALUE1);
        binaryInteger2 = new BinaryInteger(-Constant.VALUE2);
        System.out.println("-/- :  " + binaryInteger1 + " + " + binaryInteger2 + " = " + binaryInteger1.sum(binaryInteger1, binaryInteger2));

        binaryInteger1 = new BinaryInteger(-Constant.VALUE1);
        binaryInteger2 = new BinaryInteger(Constant.VALUE2);
        System.out.println("-/+ :  " + binaryInteger1 + " + " + binaryInteger2 + " = " + binaryInteger1.sum(binaryInteger1, binaryInteger2));

        binaryInteger1 = new BinaryInteger(Constant.VALUE1);
        binaryInteger2 = new BinaryInteger(-Constant.VALUE2);
        System.out.println("+/- :  " + binaryInteger1 + " + " + binaryInteger2 + " = " + binaryInteger1.sum(binaryInteger1, binaryInteger2));

        System.out.println("\nSum in reverse code\n");
        binaryInteger1 = new BinaryInteger(Constant.VALUE1).toReverseFormat();
        binaryInteger2 = new BinaryInteger(Constant.VALUE2).toReverseFormat();
        System.out.println("+/+ :  " + binaryInteger1 + " + " + binaryInteger2 + " = " + binaryInteger1.sum(binaryInteger1, binaryInteger2));

        binaryInteger1 = new BinaryInteger(-Constant.VALUE1).toReverseFormat();
        binaryInteger2 = new BinaryInteger(-Constant.VALUE2).toReverseFormat();
        System.out.println("-/- :  " + binaryInteger1 + " + " + binaryInteger2 + " = " + binaryInteger1.sum(binaryInteger1, binaryInteger2));

        binaryInteger1 = new BinaryInteger(Constant.VALUE1).toReverseFormat();
        binaryInteger2 = new BinaryInteger(-Constant.VALUE2).toReverseFormat();
        System.out.println("+/- :  " + binaryInteger1 + " + " + binaryInteger2 + " = " + binaryInteger1.sum(binaryInteger1, binaryInteger2));

        binaryInteger1 = new BinaryInteger(-Constant.VALUE1).toReverseFormat();
        binaryInteger2 = new BinaryInteger(Constant.VALUE2).toReverseFormat();
        System.out.println("-/+ :  " + binaryInteger1 + " + " + binaryInteger2 + " = " + binaryInteger1.sum(binaryInteger1, binaryInteger2));

        System.out.println("\nSum in additional code\n");

        System.out.println("--------------------------------------------------------");
        System.out.println("--------------------------------------------------------");
    }

}


// http://maksakov-sa.ru/EGEEInforman/TeoriaEGEEE/InformIKodirov/SlogObrDop/index.html
//  https://www.youtube.com/watch?v=F5OkBuzvI5g
// https://planetcalc.ru/910/
// http://calculatori.ru/perevod-chisel.html