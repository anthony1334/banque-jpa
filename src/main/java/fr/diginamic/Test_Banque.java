package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Test_Banque {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Banque banque = new Banque("Credit Agricol");
        em.persist(banque);
        Client client = new Client("DOE","John", LocalDate.of(1981,8,6),banque);
        em.persist(client);


        et.commit();
        em.close();

    }
}
