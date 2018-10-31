import javax.swing.text.html.HTMLDocument;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        PriorBank priorBank = new PriorBank();
        priorBank.setList(new ArrayList<>(Arrays.asList("vasia", "Petia", "Andrei", "x", "y", "Z")));
        AlfaBank alfaBank = new AlfaBank();
        alfaBank.setList(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "4", "77")));

        print(alfaBank.getIterator());
        print(priorBank.getIterator());
        print(alfaBank.getIterator());
    }

    public static void print(MyIterator myIterator){
        while (myIterator.hasNext()){
            System.out.print(myIterator.next() + "\t");
        }
        System.out.println("\n-----------------------------\n");
    }
}

interface MyIterator{
    boolean hasNext();
    String next();
}


class PriorBank{
    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }

    class PriorIterator implements MyIterator{
        private int counter = 0;

        @Override
        public boolean hasNext() {
            if(counter < list.size()){
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public String next(){
            return list.get(counter++);
        }
    }

    public PriorIterator getIterator(){
        return new PriorIterator();
    }
}

class AlfaBank{
    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }

    class AlfaIerator implements MyIterator{
        private int counter = 0;

        @Override
        public boolean hasNext() {
            if(counter < list.size()){
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public String next(){
            return list.get(counter++);
        }
    }

    public AlfaIerator getIterator(){
        return new AlfaIerator();
    }
}






















































