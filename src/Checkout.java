

import java.util.List;

public class Checkout {
    public void checkout(Customer customer, Cart cart, ShippableService shippingService) throws Exception {
        if (cart.isEmpty()) throw new Exception("model.Cart is empty");

        double subtotal = cart.getSubtotal();
        List<Shippable> shippableItems = cart.getShippableItems();
        double shippingFee = shippingService.calculateShippingFees(shippableItems);
        double total = subtotal + shippingFee;

        if (!customer.hasEnoughBalance(total)) {
            throw new Exception("Insufficient balance for customer " + customer.getName());
        }
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        customer.deductBalance(total);
        ShippableService.ship(shippableItems);
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f\n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shippingFee);
        System.out.printf("Amount %.0f\n", total);
        System.out.printf("Current Balance is: %.0f\n", customer.getBalance());
        System.out.println("Have a nice day!");

    }
}
