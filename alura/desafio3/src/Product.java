public class Product implements Comparable<Product> {
    private double price;
    private String name;

    public Product(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Product p) {
        return Double.compare(this.price, p.price);
    }

    @Override
    public String toString() {
        return "Nome: " + this.getName()
                + " | Preço: " + this.getPrice();
    }
}
