public class Bus extends Transport implements Competing {

    private BodyTypeBus capacityBus;
    public final TypeTransport typeTransport = TypeTransport.BUS;

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    public Bus(String brand, String model, String fuel, int capacityBus) {
        super(brand, model, fuel);
        this.capacityBus = BodyTypeBus.change(capacityBus);
    }

    @Override
    public String printType() {
        return "тип транспортного средства " + getBrand() + " " + getModel() + " - " + getTypeTransport().name();
    }

    public Bus(String brand, String model, String fuel, double engineCapacity) {
        super(brand, model, fuel, engineCapacity);
    }

    public BodyTypeBus getCapacityBus() {
        return capacityBus;
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
        return false;
    }

    @Override
    public String toString() {
        return getBrand() + " " + getModel() + " вместимость: " + capacityBus.getCapacityDown() +
                " - " + capacityBus.getCapacityUp() + " мест";
    }


}
