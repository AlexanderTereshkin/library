package dao;

import models.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
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
        List <Book> listOfBooks = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            listOfBooks = session.createQuery("from Book").getResultList();

            Collections.sort(listOfBooks, (b1, b2) -> b1.compareTo(b2));

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
