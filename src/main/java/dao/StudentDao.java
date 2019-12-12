package dao;

import models.Book;
import models.Student;

import org.hibernate.Transaction;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class StudentDao {

    /**
     * Save Student
     * @param student
     */
    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(student);
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
     * Update Student
     * @param student
     */
    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(student);
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
     * Delete Student
     * @param id
     */
    public void deleteStudent(int id) {

        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a student object
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                System.out.println("Student " + student.getName() + " is deleted.");
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
     * Get Student By ID
     * @param id
     * @return
     */
    public Student getStudent(int id) {

        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an student object
            student = session.get(Student.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;
    }

    /**
     * Get all Students
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Student> getAllStudents() {

        Transaction transaction = null;
        List < Student > listOfStudents = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // get student objects
            listOfStudents = session.createQuery("FROM STUDENT").getResultList();

            Collections.sort(listOfStudents, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return s1.compareTo(s2);
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
        return listOfStudents;
    }


}