package associations.manytomany;

import associations.manytomany.linkentity.CategorizedProduct;
import associations.manytomany.linkentity.Category;
import associations.manytomany.linkentity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.testng.Assert.assertEquals;

public class ManyToManyLin {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Category someCategory = new Category("Category");
            Category otherCategory = new Category("Other Category");

            entityManager.persist(someCategory);
            entityManager.persist(otherCategory);

            Product someProduct = new Product("Product");
            Product otherProduct = new Product("Other Product");

            entityManager.persist(someProduct);
            entityManager.persist(otherProduct);

            CategorizedProduct link1 = new CategorizedProduct("name", someCategory, someProduct);
            CategorizedProduct link2 = new CategorizedProduct("name", someCategory, otherProduct);
            CategorizedProduct link3 = new CategorizedProduct("name", otherCategory, someProduct);

            entityManager.persist(link1);
            entityManager.persist(link2);
            entityManager.persist(link3);

            entityManager.getTransaction().commit();
            entityManager.close();


            Long CATEGORY_ID = someCategory.getId();
            Long OTHER_CATEGORY_ID = otherCategory.getId();
            Long PRODUCT_ID = someProduct.getId();
            Long OTHER_PRODUCT_ID = otherProduct.getId();

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Category category1 = entityManager.find(Category.class, CATEGORY_ID);
            Category category2 = entityManager.find(Category.class, OTHER_CATEGORY_ID);

            Product product1 = entityManager.find(Product.class, PRODUCT_ID);
            Product product2 = entityManager.find(Product.class, OTHER_PRODUCT_ID);

            assertEquals(category1.getCategorizedProducts().size(), 2);
            assertEquals(product1.getCategorizedProducts().size(), 2);

            assertEquals(category2.getCategorizedProducts().size(), 1);
            assertEquals(product2.getCategorizedProducts().size(), 1);

            assertEquals(category2.getCategorizedProducts().iterator().next().getProduct(), product1);
            assertEquals(product2.getCategorizedProducts().iterator().next().getCategory(), category1);
            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
