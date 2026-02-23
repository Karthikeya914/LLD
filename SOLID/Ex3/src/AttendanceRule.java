public class AttendanceRule implements EligibilityRule {

    @Override
    public boolean isViolated(StudentProfile profile) {
        return profile.attendancePct < 75;
    }

    @Override
    public String reason() {
        return "attendance below 75";
    }
}