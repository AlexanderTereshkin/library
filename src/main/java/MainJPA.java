import models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainJPA {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryDB");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Student student = new Student("Name","email",21);
        entityManager.persist(student);

        entityManager.getTransaction().commit();

        entityManager.close();

        factory.close();
    }
}
