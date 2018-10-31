/**
 * Created by Андрей on 31.12.2017.
 */

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.lang.reflect.Array;
import java.util.*;

public class start {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");

        ObservableList<String> observableList = FXCollections.observableList(list);  // оба листа ссылаются на одни и те же объекты
        observableList.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> c) {
                System.out.println(" Added any element");
            }
        });

        observableList.add("three");  // обработчик собитй тут сработает
        list.add("four");   // а тут не сработает

        System.out.println("List --> " + list);
        System.out.println("ObserableList --> " + observableList);
    }
}
