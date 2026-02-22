import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private int invoiceSeq = 1000;

    private final PricingService pricing;
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;
    private final InvoicePrinter printer;
    private final InvoiceStore store;

    public CafeteriaSystem(PricingService pricing, TaxPolicy taxPolicy, DiscountPolicy discountPolicy,
            InvoicePrinter printer, InvoiceStore store) {
        this.pricing = pricing;
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
        this.printer = printer;
        this.store = store;
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        double subtotal = pricing.computeSubtotal(lines, menu);
        List<String> lineDescriptions = pricing.buildLineDescriptions(lines, menu);

        double taxPct = taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);

        double discount = discountPolicy.discountAmount(customerType, subtotal, lines.size());

        double total = subtotal + tax - discount;

        String printable = printer.formatInvoice(invId, lineDescriptions, subtotal, taxPct, tax, discount, total);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
