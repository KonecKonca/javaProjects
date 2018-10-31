package entity;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subject_id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return subject_id;
    }
    public void setId(int subject_id) {
        this.subject_id = subject_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Subjects{" +
                "id=" + subject_id +
                ", name='" + name + '\'' +
                '}';
    }
}
