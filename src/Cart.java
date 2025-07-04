

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }
    public List<CartItem> getItems() {
        return items;
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public void add(Product product, int quantity) throws Exception {
        if (!product.isAvailable(quantity)) {
            throw new Exception("Insufficient stock for " + product.getName());
        }
        if (product.isExpired()) {
            throw new Exception("Product " + product.getName() + " is expired");
        }
        items.add(new CartItem(product, quantity));
    }
    public double getSubtotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice(); // product price × quantity
        }
        return total;
    }
    public List<Shippable> getShippableItems() {
        List<Shippable> shippableItems = new ArrayList<>();
        for (CartItem item : items) {
            Product p = item.getProduct();
            if (p instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add((Shippable) p);
                }
            }
        }
        return shippableItems;
    }
}
