package main.library;

import main.library.Grafable;

import java.util.*;

public class NoOrientedGrafCollection<T extends Grafable> {
    private int size = 0;
    // id     ::    list<id>
    private HashMap<Integer, Set<Integer>> hashMap;
    private List<Integer> allVertex;
    private List<T> allData;

    public NoOrientedGrafCollection(){
        hashMap = new HashMap<>();
        allVertex = new ArrayList<>();
        allData = new ArrayList<>();
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }
    public void add(T element){
        hashMap.put(element.id(), element.Allconected());
        allVertex.add(element.id());
        allData.add(element);
        size++;
    }
    public void add(int nomber1, int nomber2){
        hashMap.get(nomber1).add(nomber2);
        hashMap.get(nomber2).add(nomber1);
    }
    public void delete(T element){
        hashMap.remove(element.id());
        for(int i = 0 ; i < allVertex.size(); i++){
            if(allVertex.get(i).equals(element.id())){
                allVertex.remove(i);
            }
            if(allData.get(i).id() == element.id()){
                allData.remove(i);
            }
        }
        size--;
    }
    public void delete(int nomber1, int nomber2){
        hashMap.get(nomber1).remove(nomber2);
        hashMap.get(nomber2).remove(nomber1);
    }
    public int getNomberOfVertex(){
        return size;
    }
    public int getNomberOfRibs(){
        int result = 0;

        for(int i = 0; i < allVertex.size(); i++){
            for(int j = allVertex.size() - 1; j > 0; j--){
                if(j < i){
                    return result;
                }
                if(hashMap.get(allVertex.get(i)).contains(allVertex.get(j)) && hashMap.get(allVertex.get(j)).contains(allVertex.get(i))){
                    result++;
                }
            }
        }

        return result;
    }
    public boolean findElement(T element){
        for(T el : allData){
            if(el.equals(element)){
                return true;
            }
        }
        return false;
    }
    public boolean cheakReabBetwen(T element1, T element2){
        int nomber1 = element1.id();
        int nomber2 = element2.id();
        if(hashMap.get(nomber1).contains(nomber2)){
            return true;
        }
        return false;
    }
    public int getRateOfVertex(T element){
        return hashMap.get(element.id()).size();
    }

        // methods for Iterator
    // обычный итератор
    public Iterator getIterator(){
        return new Iterator();
    }
    // итератор для ребер
    public RibsIterator getRibsIterator(){
        return new RibsIterator();
    }
    // итератор для инцидентных ребер
    public SeparateRibsIterator getSeparateRibsIterator(T element){
        return new SeparateRibsIterator(element);
    }
    // итератор для смежных вершин
    public SeparateVertexIterator getSeparateVertexIterator(T element){
        return new SeparateVertexIterator(element);
    }


    class Iterator implements GrafIterator<T>{
        int position = 0;

        @Override
        public boolean hasNext() {
            if(position < allData.size()){
                return true;
            }
            return false;
        }
        @Override
        public T next() {
            return allData.get(position++);
        }

        @Override
        public boolean hasPrevious() {
            if(position > 0){
                return true;
            }
            return false;
        }
        @Override
        public T previous() {
            return allData.get(--position);
        }
    }
    class RibsIterator implements GrafIterator<String>{
        int position = 0;
        ArrayList<String> list;

        public RibsIterator(){
            Set<String> set = new HashSet<>();
            for(int i = 0; i < allData.size(); i++){
                String added = "";
                added += allData.get(i).id();
                Set<Integer> helpSet = allData.get(i).Allconected();

                java.util.Iterator iterator = helpSet.iterator();
                while(iterator.hasNext()){
                    String add = added + iterator.next();
                    set.add(add);
                }
            }
            list = new ArrayList<>(set);
        }



        @Override
        public boolean hasNext() {
            if(position < list.size()){
                return true;
            }
            return false;
        }
        @Override
        public String next() {
            return list.get(position++);
        }

        @Override
        public boolean hasPrevious() {
            if(position > 0){
                return true;
            }
            return false;
        }
        @Override
        public String previous() {
            return list.get(--position);
        }
    }
    class SeparateRibsIterator implements GrafIterator<String>{
        int position = 0;
        ArrayList<String> list;
        int id;

        public SeparateRibsIterator(T element){
            list = new ArrayList<>();
            id = element.id();

            java.util.Iterator<Integer> iterator = hashMap.get(id).iterator();
            while (iterator.hasNext()){
                String added = "";
                added += id;
                added += iterator.next();
                list.add(added);
            }
        }

        @Override
        public boolean hasNext() {
            if(position < list.size()){
                return true;
            }
            return false;
        }
        @Override
        public String next() {
            return list.get(position++);
        }

        @Override
        public boolean hasPrevious() {
            if(position > 0){
                return true;
            }
            return false;
        }
        @Override
        public String previous() {
            return list.get(--position);
        }
    }
    class SeparateVertexIterator implements GrafIterator<T>{
        int position = 0;
        ArrayList<T> list;

        public SeparateVertexIterator(T element){
            list = new ArrayList<>();

            ArrayList<Integer> arrayList = new ArrayList<>();
            java.util.Iterator<Integer> iterator = hashMap.get(element.id()).iterator();
            while (iterator.hasNext()){
                arrayList.add(iterator.next());
            }

            for(int i = 0; i < allData.size(); i++){
                for(int j = 0; j < arrayList.size(); j++){
                    if(allData.get(i).id() == arrayList.get(j)){
                        list.add(allData.get(i));
                    }
                }
            }
        }

        @Override
        public boolean hasNext() {
            if(position < list.size()){
                return true;
            }
            return false;
        }
        @Override
        public T next() {
            return list.get(position++);
        }

        @Override
        public boolean hasPrevious() {
            if(position > 0){
                return true;
            }
            return false;
        }
        @Override
        public T previous() {
            return list.get(--position);
        }
    }


}
