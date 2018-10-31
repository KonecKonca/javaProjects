public class MainClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cash cash = new Cash();
        cash.setStudent(new Student(1, 1));

        Student student1 = cash.getStudent();
        Student student2 = student1.clone();
        System.out.println(student1.a + "\t" +  student1.b);
        System.out.println(student2.a + "\t" +  student2.b);

        student1.a = 999;
        student2.b = 666;
        System.out.println(student1.a + "\t" +  student1.b);
        System.out.println(student2.a + "\t" +  student2.b);

    }
}

class Student implements Cloneable{
    public int a = 4;
    public int b = 7;

    public Student(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }
}

class Cash{
    private Student student;

    public Student getStudent() throws CloneNotSupportedException {
        return student.clone();
    }

    public void setStudent(Student student){
        this.student = student;
    }
}