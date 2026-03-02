public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) {
        this.reg = reg;
    }

    public void startClass() {

        PowerControllable projector = reg.getDevice(PowerControllable.class);
        projector.powerOn();

        BrightnessControllable lights = reg.getDevice(BrightnessControllable.class);
        lights.setBrightness(60);

        TemperatureControllable ac = reg.getDevice(TemperatureControllable.class);
        ac.setTemperatureC(24);

        AttendanceScannable scanner = reg.getDevice(AttendanceScannable.class);
        System.out.println(
                "Attendance scanned: present=" + scanner.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        for (PowerControllable d : reg.getAllDevices(PowerControllable.class)) {
            d.powerOff();
        }
    }
}