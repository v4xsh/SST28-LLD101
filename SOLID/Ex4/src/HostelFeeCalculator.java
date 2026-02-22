import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final List<FeeComponent> components;

    public HostelFeeCalculator(FakeBookingRepo repo, List<FeeComponent> components) {
        this.repo = repo;
        this.components = components;
    }

    public void process(BookingRequest req) {
        Money monthly = new Money(0);
        for (FeeComponent comp : components) {
            monthly = monthly.plus(comp.monthlyAmount(req));
        }
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }
}
