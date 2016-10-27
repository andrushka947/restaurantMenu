import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("JPATest");
        em = emf.createEntityManager();
        Dish dish = new Dish("meat steak", 120, 300, 12);
        Dish dish1 = new Dish("salad", 80, 150, 0);
        Dish dish2 = new Dish("wine", 200, 200, 5);
        Dish dish4 = new Dish("water", 10, 200, 0);
        Dish dish5 = new Dish("soup", 50, 300, 0);
        Dish dish6 = new Dish("borsch", 50, 300, 10);
        Dish dish7 = new Dish("pizza", 80, 600, 0);
        DataBase db = new DataBase();
        em.getTransaction().begin();
        try {
            em.persist(dish);
            em.persist(dish1);
            em.persist(dish2);
            em.persist(dish4);
            em.persist(dish5);
            em.persist(dish6);
            em.persist(dish7);
            db.viewDishes(em);
            System.out.println("______________________________");
            db.selectWithDiscount(em);
            System.out.println("______________________________");
            db.selectByPrice(em, 100, 300);
            System.out.println("______________________________");
            db.selectByWeight(em, 1500);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }

    }
}
