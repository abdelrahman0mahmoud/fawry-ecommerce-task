
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        Product cheese = new ExpirableProduct("Cheese", 100, 10, LocalDate.now().plusDays(2), 0.2);
        Product biscuits = new ExpirableProduct("Biscuits", 150, 5, LocalDate.now().plusDays(5), 0.7);
        Product tv = new NonExpirableProduct("TV", 3000, 3);
        Product scratchCard = new NonShippableProduct("Scratch Card", 50, 10);

        Customer customer = new Customer("Abdelrahman", 1000);
        Cart cart = new Cart();
        cart.add(cheese , 2);
        cart.add(tv , 1);
        cart.add(scratchCard , 2);

        ShippableService shippingService = new ShippableService();
        Checkout checkoutService = new Checkout();
        checkoutService.checkout(customer, cart, shippingService);
    }
}
