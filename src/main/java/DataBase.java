import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataBase {


    public void addDish(EntityManager em, Scanner sc) {
        System.out.println("Enter dish name: ");
        String name = sc.nextLine();
        System.out.println("Enter dish price: ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("Enter dish weight: ");
        int weight = Integer.parseInt(sc.nextLine());
        System.out.println("Does dish have a discount?(enter percent of discount) ");
        int discount = Integer.parseInt(sc.nextLine());

        Dish dish = new Dish(name, price, weight, discount);
        em.persist(dish);
    }

    public void viewDishes(EntityManager em) {
        Query query = em.createQuery("SELECT d FROM Dish d", Dish.class);
        List<Dish> dishes = query.getResultList();

        for (Dish d : dishes) {
            System.out.println(d);
        }

    }

    public void selectWithDiscount(EntityManager em) {
        Query query = em.createQuery("SELECT d FROM Dish d WHERE d.discount != 0", Dish.class);
        List<Dish> list = query.getResultList();

        for (Dish d : list) {
            System.out.println(d);
        }
    }

    public void selectByPrice(EntityManager em, int more, int less) {
        Query query = em.createQuery("SELECT d FROM Dish d WHERE d.price > " + more + " and d.price < " + less);
        List<Dish> list = query.getResultList();

        for (Dish d : list) {
            System.out.println(d);
        }

    }

    public void selectByWeight(EntityManager em, int max) {
        Query query = em.createQuery("SELECT d FROM Dish d");
        List<Dish> dishes = query.getResultList();

        for (int i = 0; i < dishes.size(); i++) {
            Dish[] list = new Dish[dishes.size()];
            int commonWeight = 0;
            int n = 0;

            for (int j = 0 + i; j < dishes.size(); j++) {
                Dish d = dishes.get(j);
                if (d.getWeight() <= max && (commonWeight + d.getWeight()) <= max) {
                    list[n] = d;
                    n++;
                    commonWeight += d.getWeight();
                }
            }
            for (Dish di : list) {
                if (di != null) System.out.print(di.getName() + ", ");
            }
            System.out.println();
            continue;

        }
    }

    private void getArray() {

    }
}
