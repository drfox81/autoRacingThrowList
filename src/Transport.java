import java.util.*;

public abstract class Transport<S extends Sponsor, D extends Dr> implements GeneralMethods {
    private boolean diagnostic; // false нуждается в ТО, true прошел ТО
    private static Set<Transport> allAuto = new HashSet<>();
    private ArrayList<S> sponsorTransport = new ArrayList<>();
    private ArrayList<Mechanic> listMechanicTransport=new ArrayList<>();

    public ArrayList<Mechanic> getListMechanicTransport() {
        return listMechanicTransport;
    }

    private int sponsorSum;
    private String brand;
    private String model;
    private double engineCapacity;
    private String fuel;
    public final String DESEL = "дизель";
    final String PETROL = "бензин";
    final String ELECTRO = "электричество";
    private D driver;

    private TypeTransport typeTransport;

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    public D getDriver() {
        return driver;
    }

    public void setDriver(D driver) {
        this.driver = driver;
    }

    public abstract String printType();

    public ArrayList<S> getSponsorTransport() {
        return sponsorTransport;
    }

    public int getSponsorSum() {
        return sponsorSum;
    }

    public void setSponsorSum(int sponsorSum) {
        this.sponsorSum = sponsorSum;
    }

    public static Set<Transport> getAllAuto() {
        return allAuto;
    }

    public boolean isDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(boolean diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        if (this.fuel == null || this.fuel.isEmpty() || this.fuel.isBlank()) {
            if (fuel == DESEL) {
                this.fuel = fuel;
            } else if (fuel == PETROL) {
                this.fuel = fuel;
            } else if (fuel == ELECTRO) {
                this.fuel = fuel;
            }
        }
    }

    public Transport(String brand, String model, String fuel) {
        this(brand, model, fuel, 0);
    }

    //принт всех транспортных средств
    public static void printAllTransport() {
        for (Transport transport : allAuto) {
            System.out.println(transport);
        }
    }

    //принт водителя авто
    public final static void printDriverTransport(Transport transport) {
        System.out.println("Транспортным средством " + transport.getBrand()
                + " " + transport.getModel() + " управляет - " + transport.getDriver().getNameDriver());
    }

    public Transport(String brand, String model, String fuel, double engineCapacity) {
        setBrand(brand);
        setModel(model);
        setFuel(fuel);
        setEngineCapacity(engineCapacity);
        Transport.getAllAuto().add(this);//добавляем в список всех авто
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (this.brand == null || this.brand.isBlank() || this.brand.isEmpty()) {
            this.brand = brand;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (this.model == null || this.model.isBlank() || this.model.isEmpty()) {
            this.model = model;
        }
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        if (engineCapacity <= 0) {
            this.engineCapacity = Math.abs(engineCapacity);
        } else {
            this.engineCapacity = engineCapacity;
        }
    }

    @Override
    public final void start() {
        System.out.println("Начать движение - " + getBrand() + " " + getModel());
    }

    @Override
    public final void stop() {
        System.out.println("Закончить движение - " + getBrand() + " " + getModel());
    }

    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", fuel='" + fuel + '\'' +
                ", DESEL='" + DESEL + '\'' +
                ", PETROL='" + PETROL + '\'' +
                ", ELECTRO='" + ELECTRO + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport<?, ?> transport = (Transport<?, ?>) o;
        return Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model) && typeTransport == transport.typeTransport;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, typeTransport);
    }
}
