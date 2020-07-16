//package test;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//
//public class Main {
//    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
//
//        Clients clients = new Clients();
//        clients.setId(5);
//        clients.setName("HIHI");
//
//        Bank bank = new Bank();
//        bank.setText("Il");
//        System.out.println(bank.getText());
//
//
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(clients);
//        entityManager.persist(bank);
//        entityManager.getTransaction().commit();
//
//
//        entityManagerFactory.close();
//    }
//}
