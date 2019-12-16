package dao;

import models.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.Collections;
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
     * Update Book
     * @param book
     */
    public void updateBook(Book book) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the book object
            session.update(book);
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
     * Delete Book
     * @param id
     */
    public void deleteBook(int id) {

        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a book object
            Book book = session.get(Book.class, id);
            if (book != null) {
                session.delete(book);
                System.out.println("Book " + book.getTitle() + " is deleted.");
            }

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
     * Get Book By ID
     * @param id
     * @return
     */
    public Book getBook(int id) {

        Transaction transaction = null;
        Book book = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an book object
            book = session.get(Book.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return book;
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
