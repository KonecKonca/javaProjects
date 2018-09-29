package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // авто-инкремент
    private int person_id;

    @Column(name = "fname")
    private String fName;

    @Column(name = "lname")
    private String lName;

    @Column(name = "age")
    private int age;

    @Embedded   // типо другой класс входи в структуры это таблицы
    private PersonAdress personAdress;

    // в subjects мы такой аннототации не устанавливали
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")  // mapped -- указание поля, по которому будет маппинг
    private Set<Exam> exams;                                    //  person  -- взято из связываемой таблицы

    public int getId() {
        return person_id;
    }
    public void setId(int person_id) {
        this.person_id = person_id;
    }
    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public PersonAdress getPersonAdress() {
        return personAdress;
    }
    public void setPersonAdress(PersonAdress personAdress) {
        this.personAdress = personAdress;
    }
    public Set<Exam> getExams() {
        return exams;
    }
    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return lName + " " + fName + " " + age;
    }
}
