import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceStore store;

    public CafeteriaSystem() {
        this.store = new FileStore(); 
    }

    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format +
    // persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        Pricing pricing = new Pricing(menu);
        String invId = "INV-" + (++invoiceSeq);

        double subtotal = pricing.calculateSubtotal(lines);

        double taxPct = TaxRules.taxPercent(customerType);
        double tax = TaxRules.calculateTax(subtotal, customerType);
        double discount = DiscountRules.discountAmount(customerType, subtotal, lines.size());
        double total = subtotal + tax - discount;

        String printable = InvoiceFormatter.format(
                invId,
                lines,
                menu,
                subtotal,
                taxPct,
                tax,
                discount,
                total);

        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}