package associations.manytomany;


import associations.manytomany.bidirectional.Category;
import associations.manytomany.bidirectional.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.testng.Assert.assertEquals;

public class ManyToMany {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Category someCategory = new Category("Category");
            Category otherCategory = new Category("Other Category");

            Product someProduct = new Product("Product");
            Product otherProduct = new Product("Other Product");

            someCategory.getProducts().add(someProduct);
            someProduct.getCategories().add(someCategory);

            someCategory.getProducts().add(otherProduct);
            otherProduct.getCategories().add(someCategory);

            otherCategory.getProducts().add(someProduct);
            someProduct.getCategories().add(otherCategory);

            entityManager.persist(someCategory);
            entityManager.persist(otherCategory);

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

            assertEquals(category1.getProducts().size(), 2);
            assertEquals(product1.getCategories().size(), 2);

            assertEquals(category2.getProducts().size(), 1);
            assertEquals(product2.getCategories().size(), 1);

            assertEquals(category2.getProducts().iterator().next(), product1);
            assertEquals(product2.getCategories().iterator().next(), category1);

            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
