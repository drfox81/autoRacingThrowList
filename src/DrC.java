public class DrC extends Dr {
    public DrC(String nameDriver, int experience, Car car) {
        super(nameDriver, experience, car);
    }

    public DrC(String nameDriver, int experience, Transport car, String driverLicense) {
        super(nameDriver, experience, car, driverLicense);
    }

    public void getDriverAuto(Car auto) {
        if (getDriverLicense() == DL_C) {
            System.out.println("водитель -" + getNameDriver() + " управляет автомобилем -" + auto.getBrand() + " " +
                    auto.getModel() + " и будет участвовать в заезде");
        } else {
            System.out.println("поменяйте права");
        }
    }
}
