package dao;

import models.Book;
import models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookDao {
    /**
     * Save Student
     * @param book
     */
    public void saveBook(Book book) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(book);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get all Books
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks() {

        Transaction transaction = null;
        List < Book > listOfBooks = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an student object

            listOfBooks = session.createQuery("From Book").getResultList();

            Collections.sort(listOfBooks, new Comparator<Book>() {
                @Override
                public int compare(Book b1, Book b2) {
                    return b1.compareTo(b2);
                }
            });

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfBooks;
    }
}
