public class CgrRule implements EligibilityRule {

    @Override
    public boolean isViolated(StudentProfile profile) {
        return profile.cgr < 7.5;
    }

    @Override
    public String reason() {
        return "CGR below 7.5";
    }
}