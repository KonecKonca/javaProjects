import java.io.Serializable;

public class User implements Serializable{
    int healthpoints;
    static int staticField; // статика не сериализуется
    Mech mech1;
    transient Mech mech2; // не участвует в сериализакции (при вводе в прогу приймут значения по умолчанию)

    // transient(не сериализуемые поля) не использутся при переопределении equals и hashCode
}
