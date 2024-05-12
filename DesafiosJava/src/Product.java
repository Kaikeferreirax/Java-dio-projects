import java.util.Date;

public class Product {

    private String name;
    private int id;
    private double price;

    public Product(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Product(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculateWeight(int weight){
        return this.price * weight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Product name: " + name +"\n");
        sb.append(" Product id: " + id +"\n");
        sb.append(" Product (KG) price: $" + String.format("%.2f",price * 1000) +"\n");


       return sb.toString();
    }
}
