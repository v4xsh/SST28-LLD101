import java.util.Map;

public class RoomPricing implements FeeComponent {
    private final Map<Integer, Double> basePrices = Map.of(
            LegacyRoomTypes.SINGLE, 14000.0,
            LegacyRoomTypes.DOUBLE, 15000.0,
            LegacyRoomTypes.TRIPLE, 12000.0,
            LegacyRoomTypes.DELUXE, 16000.0);

    @Override
    public Money monthlyAmount(BookingRequest req) {
        double price = basePrices.getOrDefault(req.roomType, 16000.0);
        return new Money(price);
    }
}
