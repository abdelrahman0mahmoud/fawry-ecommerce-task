public abstract class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public void reduceQuantity(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
        }
    }
    public boolean isAvailable(int requestedQuantity) {
        return quantity >= requestedQuantity;
    }
    public abstract boolean isExpired();
    public abstract boolean requiresShipping();

}
