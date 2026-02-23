public class DiscountRules {

    private static final DiscountRule STUDENT = new StudentDiscountRule();
    private static final DiscountRule STAFF = new StaffDiscountRule();

    public static double discountAmount(
            String customerType,
            double subtotal,
            int itemCount
    ) {
        if ("student".equalsIgnoreCase(customerType)) {
            return STUDENT.amount(subtotal, itemCount);
        }
        if ("staff".equalsIgnoreCase(customerType)) {
            return STAFF.amount(subtotal, itemCount);
        }
        return 0.0; 
    }
}