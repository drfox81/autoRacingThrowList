public class Trucks extends Transport implements Competing {
    private BodyTypeTruck loadCapacity;
    public final TypeTransport typeTransport = TypeTransport.TRUCK;
    private boolean diagnostic;

    public boolean isDiagnostic() {
        return diagnostic;
    }

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    public BodyTypeTruck getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(BodyTypeTruck loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Trucks(String brand, String model, String fuel, float loadCapacity) {
        super(brand, model, fuel);
        this.loadCapacity = BodyTypeTruck.change(loadCapacity);
    }

    @Override
    public String printType() {
        return "тип транспортного средства " + getBrand() + " " + getModel() + " - " + getTypeTransport().name()
                +" ("+getLoadCapacity().name()+") "+getLoadCapacity().getWeigtNumberUp() +"-"+getLoadCapacity().getWeigtNumberDown();
    }

    public Trucks(String brand, String model, String fuel, double engineCapacity) {
        super(brand, model, fuel, engineCapacity);
    }

    @Override
    public void pitStop() {
        System.out.println("Провести pit-stop \n" + "pit-stop - проведен!");
    }

    @Override
    public void bestTime() {
        System.out.println(getBrand() + " " + getModel() + " - показал лучшее время на этом круге!!!");
    }

    @Override
    public void maxSpeed() {
        System.out.println("достиг максимальной скорости 150 км/ч");
    }

    @Override
    public boolean passDiagnostics(Dr driver) throws СhangeDriversLicense {
        if (driver.getDriverLicense() != Dr.DL_C){
            throw new СhangeDriversLicense();
        }
        return this.diagnostic = true;
    }

    @Override
    public String toString() {
        return getBrand() + " " + getModel() + " грузоподъемность от: " + getLoadCapacity().getWeigtNumberUp() + " тонн до "
                + getLoadCapacity().getWeigtNumberDown() + " тонн";
    }
}
