package binary;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryInteger implements BinaryValue {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> getBitsArray(){
        return arrayList;
    }
    private int leftBit;

    public BinaryInteger(int value) {
        boolean isMinus = false;
        if(value < 0){
            value = Math.abs(value);
                isMinus = true;
        }

        while (value != 1){
            arrayList.add(value % 2);
            value /= 2;
        }
        arrayList.add(1);

        ArrayList<Integer> reverse = new ArrayList<>(arrayList.size());
        for(int i = arrayList.size() - 1; i >= 0; i--){
            reverse.add(arrayList.get(i));
        }
        arrayList = reverse;

        if(isMinus){
            BinaryInteger binaryInteger = new BinaryInteger(arrayList).toAdditionalFormat();
            arrayList = binaryInteger.getBitsArray();
        }
    }
    public BinaryInteger(ArrayList<Integer> arrayList){
        this.arrayList = arrayList;
    }
    public BinaryInteger(){}
    public BinaryInteger(ArrayList<Integer> arrayList, boolean isReverse){
        ArrayList<Integer> reverse = new ArrayList<>(arrayList.size());
        for(int i = arrayList.size() - 1; i >= 0; i--){
            reverse.add(arrayList.get(i));
        }
        this.arrayList = reverse;
    }

    public BinaryInteger toAdditionalFormat(){
        toReverseFormat();
        BinaryInteger binaryInteger = (BinaryInteger) sum(this, new BinaryInteger(new ArrayList<>(Arrays.asList(1))));
        arrayList = binaryInteger.getBitsArray();
        return new BinaryInteger(arrayList);
    }
    public BinaryInteger toReverseFormat(){
        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i) == 0){
                arrayList.set(i, 1);
            }
            else {
                arrayList.set(i, 0);
            }
        }
        return new BinaryInteger(arrayList);
    }

    @Override
    public BinaryValue sum(BinaryValue binaryValue1, BinaryValue binaryValue2) {
        BinaryInteger binaryInteger1 = (BinaryInteger) binaryValue1;
        BinaryInteger binaryInteger2 = (BinaryInteger) binaryValue2;

        ArrayList<Integer> arrayList1 = binaryInteger1.getBitsArray();
        ArrayList<Integer> arrayList2 = binaryInteger2.getBitsArray();
        ArrayList<Integer> result = new ArrayList<>();

        int border;
        String cheaker = "";
        if(arrayList1.size() >= arrayList2.size()){
            border = arrayList1.size() - 1;
            cheaker = "array1";
        }
        else {
            border = arrayList2.size() - 1;
            cheaker = "array2";
        }
        int remain = 0;
        int difference = Math.abs(arrayList1.size() - arrayList2.size());
        for(int i = border; i >= 0; i-- ){
            if(cheaker.equals("array1")){
                if((arrayList1.get(i) + remain + arrayList2.get(i - difference)) == 0){
                    result.add(0);
                    remain = 0;
                }
                else if((arrayList1.get(i) + remain + arrayList2.get(i - difference)) == 1){
                    result.add(1);
                    remain = 0;
                }
                else if((arrayList1.get(i) + remain + arrayList2.get(i - difference)) == 2){
                    result.add(0);
                    remain = 1;
                }
                else if((arrayList1.get(i) + remain + arrayList2.get(i - difference)) == 3){
                    result.add(1);
                    remain = 1;
                }
            }

            if(cheaker.equals("array2")){
                if((arrayList1.get(i - difference) + remain + arrayList2.get(i)) == 0){
                    result.add(0);
                    remain = 0;
                }
                else if((arrayList1.get(i - difference) + remain + arrayList2.get(i)) == 1){
                    result.add(1);
                    remain = 0;
                }
                else if((arrayList1.get(i - difference) + remain + arrayList2.get(i)) == 2){
                    result.add(0);
                    remain = 1;
                }
                else if((arrayList1.get(i - difference) + remain + arrayList2.get(i)) == 3){
                    result.add(1);
                    remain = 1;
                }
            }

            if(i == difference){
                break;
            }
        }
        if(cheaker.equals("array1")){
            for(int i = (difference - 1); i >= 0; i-- ){
                if((remain + arrayList1.get(i)) == 0){
                    result.add(0);
                    remain = 0;
                }
                else if((remain + arrayList1.get(i)) == 1){
                    result.add(1);
                    remain = 0;
                }
                else if((remain + arrayList1.get(i)) == 2){
                    result.add(0);
                    remain = 1;
                }
            }
        }
        else {
            for(int i = (difference - 1); i >= 0; i-- ){
                if((remain + arrayList2.get(i)) == 0){
                    result.add(0);
                    remain = 0;
                }
                else if((remain + arrayList2.get(i)) == 1){
                    result.add(1);
                    remain = 0;
                }
                else if((remain + arrayList2.get(i)) == 2){
                    result.add(0);
                    remain = 1;
                }
            }
        }

        while (remain != 0){
            result.add(1);
            remain --;
        }
        return new BinaryInteger(result, true);
    }

    @Override
    public BinaryValue difference(BinaryValue binaryValue1, BinaryValue binaryValue2) {
        return null;
    }

    @Override
    public BinaryValue multiplication(BinaryValue binaryValue1, BinaryValue binaryValue2) {
        return null;
    }

    @Override
    public BinaryValue division(BinaryValue binaryValue1, BinaryValue binaryValue2) {
        return null;
    }



    @Override
    public String toString() {
        int counter = 0;
        for(int i = arrayList.size() - 1 ; i > 0; i-- ){
            if(arrayList.get(i) == 0){
                counter++;
            }
        }
        if(counter == (arrayList.size()-1)){
            arrayList.remove(0);
        }

        String str = "";
        for(int value : arrayList){
            str += value;
        }
        return str;
    }
}
