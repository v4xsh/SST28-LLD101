import java.util.Map;

public class AddOnPricing implements FeeComponent {
    private final Map<AddOn, Double> addonPrices = Map.of(
            AddOn.MESS, 1000.0,
            AddOn.LAUNDRY, 500.0,
            AddOn.GYM, 300.0);

    @Override
    public Money monthlyAmount(BookingRequest req) {
        double total = 0.0;
        for (AddOn a : req.addOns) {
            total += addonPrices.getOrDefault(a, 0.0);
        }
        return new Money(total);
    }
}
