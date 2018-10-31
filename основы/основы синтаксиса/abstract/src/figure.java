/**
 * Created by Андрей on 05.01.2018.
 */
abstract public class figure { // объект абстрактоного класса нельзя создать
    public abstract void square(); // abstract метод всегда обязан быть перезаписан в производном классе
    public void vivod(){
        System.out.println("Фигура(общая)");
    }
}

// абстрактные методы могут находиться только в абстрактных классах
