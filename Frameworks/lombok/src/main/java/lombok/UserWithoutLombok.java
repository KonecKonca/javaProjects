package lombok;

import javax.annotation.PreDestroy;
import java.util.Date;
import java.util.Objects;

public class UserWithoutLombok {
    private String name;
    private String lastNale;
    private Integer age;
    private Boolean active;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNale() {
        return lastNale;
    }

    public void setLastNale(String lastNale) {
        this.lastNale = lastNale;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserWithoutLombok{" +
                "name='" + name + '\'' +
                ", lastNale='" + lastNale + '\'' +
                ", age=" + age +
                ", active=" + active +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserWithoutLombok)) return false;
        UserWithoutLombok that = (UserWithoutLombok) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getLastNale(), that.getLastNale()) &&
                Objects.equals(getAge(), that.getAge()) &&
                Objects.equals(getActive(), that.getActive()) &&
                Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastNale(), getAge(), getActive(), getDate());
    }
}
