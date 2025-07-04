

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippableService {
    private static final double SHIPPING_RATE = 10.0;
    public static void ship(List<Shippable> items) {
        if (items == null || items.isEmpty()) return;

        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        Map<String, Double> Weights = new HashMap<>();
        Map<String, Integer> Counts = new HashMap<>();
        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();

            Weights.put(name, Weights.getOrDefault(name, 0.0) + weight);
            Counts.put(name, Counts.getOrDefault(name, 0) + 1);
            totalWeight += weight;
        }
        for (Map.Entry<String, Integer> entry : Counts.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            double weight = Weights.get(name);
            System.out.printf("%dx %s %.0fg%n", count, name, weight * 1000);
        }
        System.out.printf("Total package weight %.1fkg%n", totalWeight);
        System.out.println();
    }

    public double calculateShippingFees(List<Shippable> items) {
        double totalWeight = 0;
        for (Shippable item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight * SHIPPING_RATE;
    }
}
