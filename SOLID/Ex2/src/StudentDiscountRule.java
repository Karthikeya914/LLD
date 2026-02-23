public class StudentDiscountRule implements DiscountRule {

    @Override
    public double amount(double subtotal, int itemCount) {
        if (subtotal >= 180.0) {
            return 10.0;
        }
        return 0.0;
    }
}