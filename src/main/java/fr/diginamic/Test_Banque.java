package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class Test_Banque {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Banque banque = new Banque("Credit Agricol");
        em.persist(banque);
        Compte compteJoint = new Compte("45678",4210.54);
        em.persist(compteJoint);
        Compte compte = new Compte("1234",1234.32);
        em.persist(compte);
        Compte compte1 = new Compte("4321",6450.32);
        em.persist(compte1);
        Compte assuranceVie = new AssuranceVie("6789",4521.00,LocalDate.of(2022,06,05),2.20);
        em.persist(assuranceVie);
        Compte livretA = new LivretA(0.50);
        em.persist(livretA);
        Virement virement1 = new Virement(LocalDateTime.of(2021,06,17,14,10,21),400.00,"virement",compte,"kiki");
        if (virement1.getMontant() > compte.getSolde()) {
            System.out.println(" operation impossible");

        }
        else{
            compte.setSolde(virement1.getMontant() + compte.getSolde());
            em.persist(virement1);
        }




        Operation virement = new Virement("toto");
        em.persist(virement);
        Operation operation = new Operation(LocalDateTime.of(2021,06,18,14,37,25), 200.00, "happy birthday",compte1);
        em.persist(operation);
        Operation operation1 = new Operation(LocalDateTime.of(2021,06,18,14,37,25), 800.00, "Coucou",compte1);
        em.persist(operation1);


        compte1.setOperations(Set.of(operation));
        compte1.setSolde(compte1.getSolde() + operation.getMontant());
        compte1.setSolde(compte1.getSolde() - operation1.getMontant());

        Virement virement2 = new Virement(LocalDateTime.of(2021,06,17,14,10,21),800.00,"virement",compte,"kiki");
        em.persist(virement2);


       /* compte.virementCredit(virement1);*/

        Virement virement3 = new Virement(LocalDateTime.of(2021,06,17,14,55,11),1200.00,"virement",assuranceVie,"Hello");
        em.persist(virement3);
        compte.virementCredit(virement3);









        Client client = new Client("DOE","John", LocalDate.of(1981,8,6),banque);
        em.persist(client);
        Client client1 = new Client("MORRISON","Jim",LocalDate.of(1983,04,06),banque );
        em.persist(client1);
        Client client3 = new Client("MARLEY","Bob",LocalDate.of(1945,02,06),banque);
        em.persist(client3);
        compteJoint.setClients(Set.of(client,client1));
        Set<Client> listeClients= compteJoint.getClients();
        listeClients.stream().forEach(client2 -> System.out.println(client2.getNom()));
        client3.setComptes(Set.of(livretA,assuranceVie));







        et.commit();
        em.close();

    }
}
