import javax.persistence.*;


@Entity
@Table(name = "Dishes")
public class Dish {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int price;
    private int weight;
    private int discount;

    public Dish() {}
    public Dish(String name, int price, int weight, int discount) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "name: " + name + ", price: " + price + ", weight: " + weight + ", discount: " + discount + "%";
    }
}


/*
Создать таблицу «Меню в ресторане». Колонки: название блюда,
его стоимость, вес, наличие скидки. Написать код для
добавления записей в таблицу и их выборки по критериям
«стоимость от-до», «только со скидкой», выбрать набор блюд
так, чтобы их суммарный вес был не более 1 КГ.
* */