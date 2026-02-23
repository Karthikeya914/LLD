public class CreditsRule implements EligibilityRule {

    @Override
    public boolean isViolated(StudentProfile profile) {
        return profile.earnedCredits < 20;
    }

    @Override
    public String reason() {
        return "insufficient credits";
    }
}