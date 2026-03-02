public class Projector implements PowerControllable {

    @Override
    public void powerOn() {
        System.out.println("Projector ON (HDMI-1)");
    }

    @Override
    public void powerOff() {
        System.out.println("Projector OFF");
    }
}