public class StaffDiscountRule implements DiscountRule {

    @Override
    public double amount(double subtotal, int itemCount) {
        if (itemCount >= 3) {
            return 15.0;
        }
        return 5.0;
    }
}