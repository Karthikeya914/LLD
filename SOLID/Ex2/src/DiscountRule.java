public interface DiscountRule {
    double amount(double subtotal, int itemCount);
}