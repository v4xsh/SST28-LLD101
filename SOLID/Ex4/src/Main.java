import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        java.util.List<FeeComponent> components = java.util.List.of(
                new RoomPricing(),
                new AddOnPricing());
        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo(), components);
        calc.process(req);
    }
}
