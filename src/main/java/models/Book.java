package models;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id_student")
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
