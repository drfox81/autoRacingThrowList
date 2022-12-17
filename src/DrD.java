public class DrD extends Dr {
    public DrD(String nameDriver, int experience, Car car) {
        super(nameDriver, experience, car);
    }

    public DrD(String nameDriver, int experience, Transport car, String driverLicense) {
        super(nameDriver, experience, car, driverLicense);
    }

    public void getDriverAuto(Car auto) {
        if (getDriverLicense() == DL_D) {
            System.out.println("водитель -" + getNameDriver() + " управляет автомобилем -" + auto.getBrand() + " " +
                    auto.getModel() + " и будет участвовать в заезде");
        } else {
            System.out.println("поменяйте права");
        }
    }
}
