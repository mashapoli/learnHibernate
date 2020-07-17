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
            Item someItem = new Item("Some Item");
            entityManager.persist(someItem);

            Bid someBid = new Bid(new BigDecimal("123.00"), someItem);
            someItem.getBids().add(someBid); // Don't forget!
            entityManager.persist(someBid);

            Bid secondBid = new Bid(new BigDecimal("456.00"), someItem);
            someItem.getBids().add(secondBid);
            entityManager.persist(secondBid);

            entityManager.getTransaction().commit();
            entityManager.close();


            Long ITEM_ID = someItem.getId();

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();


            Item item = entityManager.find(Item.class, ITEM_ID);
            assertEquals(item.getBids().size(), 2);


            entityManager.getTransaction().commit();
            entityManager.close();

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();


            Collection<Bid> bids =
                    entityManager.createQuery("select b from Bid b where b.item.id = :itemId")
                            .setParameter("itemId", ITEM_ID)
                            .getResultList();
            assertEquals(bids.size(), 2);

            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
