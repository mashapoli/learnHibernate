package associations.OneToOne;


import associations.onetoone.sharedprimarykey.Client;
import associations.onetoone.sharedprimarykey.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.testng.Assert.assertEquals;


public class OneToOneShared {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Location someLocation = new Location("street", "0000", "City");
            entityManager.persist(someLocation);

            Client someClient = new Client(someLocation.getId(), "client name");
            entityManager.persist(someClient);

            someClient.setShippingLocation(someLocation);

            entityManager.getTransaction().commit();
            entityManager.close();


            Long CLIENT_ID = someClient.getId();
            Long LOCATION_ID = someLocation.getId();

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Client client = entityManager.find(Client.class, CLIENT_ID);
            assertEquals(client.getShippingLocation().getStreet(), "street");

            Location location = entityManager.find(Location.class, LOCATION_ID);
            assertEquals(location.getStreet(), "street");
            assertEquals(client.getId(), location.getId());

            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}