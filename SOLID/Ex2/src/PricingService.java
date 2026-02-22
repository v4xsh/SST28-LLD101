import java.util.*;

public class PricingService {
    public double computeSubtotal(List<OrderLine> lines, Map<String, MenuItem> menu) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            subtotal += item.price * l.qty;
        }
        return subtotal;
    }

    public List<String> buildLineDescriptions(List<OrderLine> lines, Map<String, MenuItem> menu) {
        List<String> descriptions = new ArrayList<>();
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            descriptions.add(String.format("- %s x%d = %.2f", item.name, l.qty, lineTotal));
        }
        return descriptions;
    }
}
