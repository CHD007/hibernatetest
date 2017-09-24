package com.chernyshov777;

import com.chernyshov777.helloworld.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class HelloWorldJPA {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");

    public static void main(String[] args) {
        Message message = new Message();
        message.setText("Hello world");
        persistEntity(message);
    }

    private static <T> void persistEntity(T entity) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
