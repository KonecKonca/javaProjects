package hiber;

import hiber.lib.lesson1.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@херабл
public class MainClass {
    public static void main(String[] args) {
        EntityManagerFactory emf = new Persistence().createEntityManagerFactory("bookUnit");
        EntityManager em = emf.createEntityManager();

        Book book = new Book();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();

        em.close();
        emf.close();
    }
}

@interface херабл{

}