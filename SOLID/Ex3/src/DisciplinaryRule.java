public class DisciplinaryRule implements EligibilityRule {

    @Override
    public boolean isViolated(StudentProfile profile) {
        return profile.disciplinaryFlag != 0;
    }

    @Override
    public String reason() {
        return "disciplinary flag present";
    }
}