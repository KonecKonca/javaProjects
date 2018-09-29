import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Book{
    String autor;
    String name;

    public String toString(){
        return ("Book. " + autor + " : " + name);
    }
}

class Ticket{
    int nomber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return nomber == ticket.nomber;
    }

    @Override
    public int hashCode() {
        return nomber;
    }
}

public class start{
    public static void main(String[] args) throws Exception {
        Book book = new Book();
        book.autor = "Karnegi";
        book.name = "How to get friends";
        Ticket ticket1 = new Ticket();
        ticket1.nomber = 123;

        Map<Ticket, Book> library = new HashMap<>();
        library.put(ticket1,book);
        System.out.println(library.get(ticket1));

        Ticket ticket2 = new Ticket();
        ticket2.nomber = 123;
        System.out.println(library.get(ticket2));  // без прееопред. equals и hashcode не сработает
        // если не переопред hash, то досткп к объекты будет утерян,
        // при его переопред hash у одинаковых объектов будет одинаковым
    }
}

