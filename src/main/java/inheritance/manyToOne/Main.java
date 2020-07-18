//package inheritance.manyToOne;
//
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//
//public class Main {
//
//    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
//
//        CreditCard cc = new CreditCard(
//                "John Doe", "1234123412341234", "06", "2015"
//        );
//        Clients johndoe = new Clients("johndoe");
//        johndoe.setDefaultBilling(cc);
//
//
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(cc);
//        entityManager.persist(johndoe);
////        entityManager.
//        entityManager.getTransaction().commit();
//
//
//        entityManagerFactory.close();
//    }
//}
