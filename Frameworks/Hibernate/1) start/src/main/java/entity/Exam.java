package entity;

import org.hibernate.boot.registry.selector.spi.StrategyCreator;

import javax.persistence.*;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exams_id;

    @ManyToOne(fetch = FetchType.LAZY)  // данные не сразу при получении объекта екзэмс, а при запросе
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subjects subject;

    @Column(name = "grade")
    private int grade;

    public int getId() {
        return exams_id;
    }
    public void setId(int exams_id) {
        this.exams_id = exams_id;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public Subjects getSubject() {
        return subject;
    }
    public void setSubject(Subjects subject) {
        this.subject = subject;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Exam{" +
                "id=" + exams_id +
                ", person=" + person +
                ", subject=" + subject +
                ", grade=" + grade +
                '}';
    }
}
