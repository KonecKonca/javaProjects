import java.io.File;
import java.io.InputStream;
import java.util.*;

public class start {
    public static void main(String[] args) {

        CounterofTriangles counterofTriangles = new CounterofTriangles();
        counterofTriangles.fillCombinations();
        counterofTriangles.commounOutput();
        counterofTriangles.countFuckingTriangles();
        System.out.println("Кол-во: " + counterofTriangles.getCountOfTriangles());

    }
}

class CounterofTriangles{
    private List<List<Integer>> allCombinations = new ArrayList<>();
    private Map<MyKey, Integer> map = new HashMap<>();
    private int countOfTriangles = 0;
    public int getCountOfTriangles() {
        return countOfTriangles;
    }

    public CounterofTriangles() {
        map.put(new MyKey(1, 2), 2);
        map.put(new MyKey(2, 3), 3);
        map.put(new MyKey(3, 1), 1);
        map.put(new MyKey(4, 3), 3);
        map.put(new MyKey(1, 4), 4);
    }

    public void fillCombinations(){
        int[] mass = null;
        while ((mass = Combinations.generateCombinations(mass)) != null){
            List<Integer> list = new ArrayList<>();
            for(int el : mass){
                list.add(el);
            }
            allCombinations.add(list);
        }
    }
    public void countFuckingTriangles(){
        countOfTriangles = 0;
        for(List<Integer> list : allCombinations){
            int value1 = list.get(0);
            int value2 = list.get(1);
            int value3 = list.get(2);

//            if((map.get(new MyKey(value1, value2)) == value2) && (map.get(new MyKey(2, 3)) == value3) && (map.get(new MyKey(3, 1)) == value1)){
//                countOfTriangles++;
//            }
//            if((map.get(new MyKey(1, 3)) == value3) && (map.get(new MyKey(3, 2)) == value2) && (map.get(new MyKey(2, 1)) == value1)){
//                countOfTriangles++;
//            }

//            if((map.get(value1) == value2) && (map.get(value2) == value3) && (map.get(value3) == value1)){
//                countOfTriangles++;
//            }
//            if((map.get(value1) == value3) && (map.get(value3) == value2) && (map.get(value2) == value1)){
//                countOfTriangles++;
//            }
        }
    }
    public void commounOutput(){
        for(List<Integer> list : allCombinations){
            System.out.println(list);
        }
    }
    public String massToStr(int[] mass) {
        List<Integer> list = new ArrayList<>();
        for(int el : mass){
            list.add(el);
        }
        return list.toString();
    }
}

class MyKey{
    int value1;
    int value2;

    public MyKey(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyKey)) return false;
        MyKey myKey = (MyKey) o;
        return getValue1() == myKey.getValue1() &&
                getValue2() == myKey.getValue2();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getValue1(), getValue2());
    }
}

class Combinations {
    private static int M = 3;
    private static int N = 4;

    public static void getDiapazon(int m, int n){
        M = m;
        N = n;
    }

    public static int[] generateCombinations(int[] arr) {
        if (arr == null) {
            arr = new int[M];
            for (int i = 0; i < M; i++) {
                arr[i] = i + 1;
            }
            return arr;
        }
        for (int i = M - 1; i >= 0; i--) {
            if (arr[i] < N - M + i + 1) {
                arr[i]++;
                for (int j = i; j < M - 1; j++)
                    arr[j + 1] = arr[j] + 1;
                return arr;
            }
        }
        return null;
    }
}





class DininDolboeb{
    public List<List<Integer>> combinationsXyi(int[] mass, int n){
        List combinations = new ArrayList();
        int k = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(mass[i] != mass[j]){
                    for (k=j+1; k<n; k++){
                        if (mass[k]!=mass[i] && mass[k]!=mass[j]){
                            combinations.add(new ArrayList<>(Arrays.asList(mass[i], mass[j], mass[k])));
                            combinations.add(new ArrayList<>(Arrays.asList(mass[i], mass[j], mass[k])));
                            combinations.add(new ArrayList<>(Arrays.asList(mass[i], mass[j], mass[k])));
                            combinations.add(new ArrayList<>(Arrays.asList(mass[i], mass[j], mass[k])));
                            combinations.add(new ArrayList<>(Arrays.asList(mass[i], mass[j], mass[k])));
                            combinations.add(new ArrayList<>(Arrays.asList(mass[i], mass[j], mass[k])));
                        }
                    }
                }
            }
        }

        return combinations;
    }
}
