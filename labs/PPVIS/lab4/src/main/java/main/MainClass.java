package main;

import main.library.GrafIterator;
import main.library.NoOrientedGrafCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MainClass {
    public static void main(String[] args) {
        fasad();
    }

    public static void fasad(){
        NoOrientedGrafCollection<GrafObject> collection = new NoOrientedGrafCollection<>();
        GrafObject grafObject1 = new GrafObject().builder().list(new HashSet<>(Arrays.asList(2, 3, 4))).id(1).data("xxx").build();
        GrafObject grafObject2 = new GrafObject().builder().list(new HashSet<>(Arrays.asList(7, 1, 3))).id(2).data("yyy").build();
        GrafObject grafObject3 = new GrafObject().builder().list(new HashSet<>(Arrays.asList(1))).id(3).data("yyy").build();
        collection.add(grafObject1);
        collection.add(grafObject2);
        collection.add(grafObject3);
        collection.add(new GrafObject());

        // добавление ребра
        collection.add(2, 3);
        // удаление ребра
        collection.delete(2, 3);
        //удаление Вершины
        collection.delete(grafObject3);

        test(grafObject1, grafObject2, grafObject3, collection);
    }

    public static void test(GrafObject grafObject1, GrafObject grafObject2, GrafObject grafObject3, NoOrientedGrafCollection<GrafObject> collection){
        System.out.println("Ribs: " + collection.getNomberOfRibs());
        System.out.println("Vertexes: " + collection.getNomberOfVertex());
        System.out.println("Is empty: " + collection.isEmpty());
        System.out.println("Search: " + collection.findElement(new GrafObject()));
        System.out.println("Are vertex connected: " + collection.cheakReabBetwen(grafObject1, grafObject2));
        System.out.println("Degree of vertex: " + collection.getRateOfVertex(grafObject2));

        System.out.println("\n-----------------------------------");
        System.out.println("All vertex with Iterator");
        GrafIterator<GrafObject> iterator = collection.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("---|||---");
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
        System.out.println("\n-----------------------------------");

        System.out.println("\n-----------------------------------");
        System.out.println("All ribs with Iterator");
        GrafIterator<String> ribsIterator = collection.getRibsIterator();
        while (ribsIterator.hasNext()){
            System.out.println(ribsIterator.next());
        }
        System.out.println("---|||---");
        while (ribsIterator.hasPrevious()){
            System.out.println(ribsIterator.previous());
        }
        System.out.println("\n-----------------------------------");

        System.out.println("\n-----------------------------------");
        System.out.println("All ribs with SeparateRibsIterator");
        GrafIterator<String> separateRibsIterator = collection.getSeparateRibsIterator(grafObject1);
        while (separateRibsIterator.hasNext()){
            System.out.println(separateRibsIterator.next());
        }
        System.out.println("---|||---");
        while (separateRibsIterator.hasPrevious()){
            System.out.println(separateRibsIterator.previous());
        }
        System.out.println("\n-----------------------------------");

        System.out.println("\n-----------------------------------");
        System.out.println("All ribs with SeparateRibsIterator");
        GrafIterator<GrafObject> separateVertexIterator = collection.getSeparateVertexIterator(grafObject2);
        while (separateVertexIterator.hasNext()){
            System.out.println(separateVertexIterator.next());
        }
        System.out.println("---|||---");
        while (separateVertexIterator.hasPrevious()){
            System.out.println(separateVertexIterator.previous());
        }
        System.out.println("\n-----------------------------------");

    }

}


