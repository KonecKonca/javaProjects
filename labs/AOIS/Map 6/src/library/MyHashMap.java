package library;

import java.util.*;
import java.util.function.Consumer;

public class MyHashMap<K, V>{
    private List<List<Node<K, V>>> hashTable;
    private int numOfBackets = 16;
    private int numOfAllElements = 0;

    public MyHashMap() {
        hashTable = new ArrayList<>();
        for(int i = 0 ; i < numOfBackets; i++){
            hashTable.add(new LinkedList<>());
        }
    }
    public boolean isEpmty(){
        if(numOfAllElements == 0){
            return true;
        }
        return false;
    }
    public int getSize(){
        return numOfAllElements;
    }
    public String getAllDataInVisual(){
        StringBuilder str = new StringBuilder();
        str.append("Nomber of buckets: " + hashTable.size() + "\n");
        str.append("Nomber of elements: " + numOfAllElements + "\n");
        str.append("-----------------------------------------------------\n");
        int counter = 0;
        for(List<Node<K, V>> list : hashTable){
            str.append("bucket " + counter + ":\t");
            for(Node<K, V> value : list){
                str.append((value + "\t\t"));
            }
            counter++;
            str.append("\n");
        }
        str.append("-----------------------------------------------------\n");
        return str.toString();
    }
    public void add(K key, V value){
        hashTable.get(Math.abs(key.hashCode() % numOfBackets)).add(new Node<>(key, value));
        numOfAllElements++;
    }
    public V get(K key){
        for(Node<K, V> node : hashTable.get(key.hashCode() % numOfBackets)){
            if(node.key.equals(key)){
                return node.value;
            }
        }
        return null;
    }
    public void remove(K key){
        for(Node<K, V> node : hashTable.get(key.hashCode() % numOfBackets)){
            if(node.key.equals(key)){
                hashTable.get(key.hashCode() % numOfBackets).remove(node);
                numOfAllElements--;
                return;
            }
        }
    }
    public Iterator<V> iterator(){
        return new MyHashIterator<>();
    }

    public class MyHashIterator<V> implements Iterator<V>{
        int counter = 0;

        public K nextkey(){
            if(counter >= numOfAllElements){
                return null;
            }
            int localCounter = 0;
            for(int i = 0 ; i < hashTable.size(); i++){
                for(int j = 0; j < hashTable.get(i).size(); j++){
                    if(localCounter == counter){
                        counter++;
                        return (K) hashTable.get(i).get(j).getKey();
                    }
                    localCounter++;
                }
            }
            return null;
        }

        @Override
        public V next(){
            if(counter >= numOfAllElements){
                return null;
            }
            int localCounter = 0;
            for(int i = 0 ; i < hashTable.size(); i++){
                for(int j = 0; j < hashTable.get(i).size(); j++){
                    if(localCounter == counter){
                        counter++;
                        return (V) hashTable.get(i).get(j).getValue();
                    }
                    localCounter++;
                }
            }
            return null;
        }
        @Override
        public boolean hasNext(){
            if(counter >= numOfAllElements){
                return false;
            }
            return true;
        }

        @Override
        public void remove() {
            throw new MyNoSupportedException();
        }
        @Override
        public void forEachRemaining(Consumer<? super V> action) {
            throw new MyNoSupportedException();
        }
    }

    class Node<K,V> {
        int hashCode = 0;
        K key;
        V value;

        public Node(K key, V value){
            hashCode = value.hashCode();
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            if(((Node)o).key.equals(this.key)){
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return hashCode;
        }
    }

}
