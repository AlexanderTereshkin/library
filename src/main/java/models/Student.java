package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_generator")
    @SequenceGenerator(name = "c_generator", sequenceName = "SEQUENCE_ID_STUDENT")
    @Column(name = "student_id")
    private int id;

    private String name;

    private String email;

    private int age;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
    private List<Book> bookList = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Student(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int compareTo(Student anotherStudent) {
        if (this.getId() > anotherStudent.getId()) {
            return 1;
        } else {
            if (this.getId() < anotherStudent.getId()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
