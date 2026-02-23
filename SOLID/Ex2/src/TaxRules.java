public class TaxRules {

    private static final TaxRule STUDENT = new StudentTaxRule();
    private static final TaxRule STAFF = new StaffTaxRule();

    public static double taxPercent(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) {
            return STUDENT.rate();
        }
        if ("staff".equalsIgnoreCase(customerType)) {
            return STAFF.rate();
        }
        return 0.0;  
    }

    public static double calculateTax(double subtotal, String customerType) {
        double pct = taxPercent(customerType);
        return subtotal * pct / 100.0;
    }
}