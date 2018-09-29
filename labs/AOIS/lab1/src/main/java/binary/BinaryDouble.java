//package binary;
//
//import java.util.ArrayList;
//
//public class BinaryDouble implements BinaryValue{
//    private ArrayList<Double> left = new ArrayList<>();
//    private ArrayList<Double> right = new ArrayList<>();
//    private String mark = "";
//
//    public BinaryDouble(int value) {
//        if(value < 0){
//            mark = "-";
//            value = Math.abs(value);
//        }
//
//        while (value != 1){
//            arrayList.add(value % 2);
//            value /= 2;
//        }
//        arrayList.add(1);
//
//        ArrayList<Integer> reverse = new ArrayList<>(arrayList.size());
//        for(int i = arrayList.size() - 1; i >= 0; i--){
//            reverse.add(arrayList.get(i));
//        }
//        arrayList = reverse;
//    }
//
//
//
//
//
//
//
//    @Override
//    public BinaryValue sum(BinaryValue binaryValue1, BinaryValue binaryValue2) {
//        return null;
//    }
//
//    @Override
//    public BinaryValue difference(BinaryValue binaryValue1, BinaryValue binaryValue2) {
//        return null;
//    }
//
//    @Override
//    public BinaryValue multiplication(BinaryValue binaryValue1, BinaryValue binaryValue2) {
//        return null;
//    }
//
//    @Override
//    public BinaryValue division(BinaryValue binaryValue1, BinaryValue binaryValue2) {
//        return null;
//    }
//
//    @Override
//    public String toString() {
//        String str = "";
//        for(double value : left){
//            str += value;
//        }
//        str += " ";
//        for(double value : right){
//            str += value;
//        }
//        return (mark + str);
//    }
//}
