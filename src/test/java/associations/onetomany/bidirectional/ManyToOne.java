package associations.onetomany.bidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Collection;

import static org.testng.Assert.assertEquals;

public class ManyToOne {


    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Product someProduct = new Product("Product");
            entityManager.persist(someProduct);

            Offer someOffer = new Offer(new BigDecimal("100.00"), someProduct);
            someProduct.getOffers().add(someOffer); // Don't forget!
           // entityManager.persist(someOffer);

            Offer secondOffer = new Offer(new BigDecimal("200.00"), someProduct);
            someProduct.getOffers().add(secondOffer);
            //entityManager.persist(secondOffer);

            entityManager.getTransaction().commit();
            entityManager.close();


            Long PRODUCT_ID = someProduct.getId();

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();


            Product product = entityManager.find(Product.class, PRODUCT_ID);
            assertEquals(product.getOffers().size(), 2);

            //Каскадная передача состояния хранения
            for  (Offer offer : product.getOffers()){
                entityManager.remove(offer);
            }
            entityManager.remove(product);

            entityManager.getTransaction().commit();
            entityManager.close();

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();


            Collection<Offer> offers =
                    entityManager.createQuery("select o from Offer o where o.product.id = :productId")
                            .setParameter("productId", PRODUCT_ID)
                            .getResultList();
            assertEquals(offers.size(), 2);

            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
