import java.util.*;

public class Pricing {
    private final Map<String, MenuItem> menu;

    public Pricing(Map<String, MenuItem> menu) {
        this.menu = menu;
    }

    public double calculateSubtotal(List<OrderLine> lines) {
        double subtotal = 0.0;

        for (OrderLine line : lines) {
            MenuItem item = menu.get(line.itemId);
            subtotal += item.price * line.qty;
        }

        return subtotal;
    }
}