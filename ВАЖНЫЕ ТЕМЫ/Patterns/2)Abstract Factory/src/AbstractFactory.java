public class AbstractFactory {
    Factory createFactory(String  typeOfFactory){
        switch (typeOfFactory){
            case "CarFactory" : return new CarFactory();
            case "TankFactory" : return new TankFactory();
            default: return null;
        }
    }
}

interface Factory <TypeOfFactory>{
    TypeOfFactory create(String typeOfF);
}
class CarFactory implements Factory{
    @Override
    public Car create(String str){
        switch (str){
            case ("Toyota") : return new Toyota();
            case ("Mazda") : return new Mazda();
            case ("Mersedes") : return new Mersedes();
            default: return null;
        }
    }
}
class TankFactory implements Factory{
    @Override
    public Tank create(String str){
        switch (str){
            case ("Armata") : return new Armata();
            case ("Abrams") : return new Abrams();
            default: return null;
        }
    }
}