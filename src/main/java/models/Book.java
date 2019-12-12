package models;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_generator")
    @SequenceGenerator(name = "c_generator", sequenceName = "SEQUENCE_ID_BOOK")
    @Column(name = "book_id")
    private int id;

    private String title;

    private String author;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn (name = "student_id", nullable = false)
    private Student student;

    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int compareTo(Book anotherBook) {
        if (this.getId() > anotherBook.getId()) {
            return 1;
        } else {
            if (this.getId() < anotherBook.getId()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
