import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import entity.Exam;
import entity.Person;
import entity.PersonAdress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;
import java.util.regex.Matcher;


public class MainClass {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();  // объект session должен быть синглетоном

        Transaction transaction = session.beginTransaction();

//        insertIntoStydents(session);
//        getFromStydents(session, 5);
//        getGradeById(session, 1);
//        HQLQery(session);


        transaction.commit();

        session.close();
        sessionFactory.close();

    }

    static void insertIntoStydents(Session session){
        List<String> fnames = new ArrayList(Arrays.asList("Andrei", "Kolian", "Vasia", "Petyshok", "Masha"));
        List<String> lnames = new ArrayList(Arrays.asList("X", "Y", "Z", "B", "N"));
        for(int i = 0; i < 7; i++){
            Person person = new Person();
            person.setAge((int)(Math.random()*100));
            person.setfName(fnames.get((int)(Math.random()*5)));
            person.setlName(lnames.get((int)(Math.random()*5)));

            PersonAdress personAdress = new PersonAdress();
            personAdress.setCity("City" + (int)(Math.random()*10));
            personAdress.setCountry("Country" + (int)(Math.random()*5));
            personAdress.setAddress("House " + (int)(Math.random()*25));

            person.setPersonAdress(personAdress);

            session.save(person);
        }
    }
    static void getFromStydents(Session session, int changeId){
        Person person = session.get(Person.class, changeId);
        // Persons person = session.load(Student.class, 5);  // в отличии от get в случае если такого нету
        person.setAge(999);                                     // кинет исключение  (get возвращает null)
    }
    static void getGradeById(Session session, int id){
        Person person = session.get(Person.class, id);
        Set<Exam> exams = person.getExams();
        Iterator<Exam> iterator = exams.iterator();
        while (iterator.hasNext()){
            Exam exam = iterator.next();
            System.out.println( exam.getGrade() + " " + exam.getId());
        }
    }

    static void HQLQery(Session session){
        Query query = session.createQuery("FROM Student");  // всё парвильно ((пох на крассный)
        List<Person> person = query.getResultList();    // на первом месте FROM на 2-ом имя класса (РАБОТАЕМ С КЛАССАМИ А НЕ ТАБЛИЦАМИ)
    }

}

