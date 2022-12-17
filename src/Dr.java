import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Dr<T extends Transport> implements GeneralMethods {
    private String nameDriver;
    private String driverLicense;
    public static final String DL_B = "Права категория В";
    public static final String DL_C = "Права категория С";
    public static final String DL_D = "Права категория D";
    private int experience;
    private T car;
    private static Set<Dr> allDriver = new HashSet<>();

    public static Set<Dr> getAllDriver() {
        return allDriver;
    }

    public T getCar() {
        return car;
    }

    public Dr(String nameDriver, int experience, T car, String driverLicense) {
        setNameDriver(nameDriver);
        setDriverLicense(driverLicense);
        setExperience(experience);
        this.car = car;
        this.car.setDriver(this);
        Dr.getAllDriver().add(this);//добавляем в список всех водителей

    }

    // вывод списка всех водителей
    public static void printAllDrivers() {
        for (Dr dr : allDriver) {
            System.out.println(dr);
        }
    }

    public Dr(String nameDriver, int experience, T car) {
        setNameDriver(nameDriver);
        setDriverLicense(driverLicense);
        setExperience(experience);
        this.car = car;
    }

    public String getNameDriver() {
        return nameDriver;
    }

    public void setNameDriver(String nameDriver) {
        if (getNameDriver() == null || getNameDriver().isEmpty() || getNameDriver().isBlank()) {
            Pattern pattern = Pattern.compile("^[А-Я]{1}[а-я]{1,20}\\s" +
                    "[А-Я]{1}[а-я]{1,20}\\s[А-Я]{1}[а-я]{1,20}$");
            Matcher matcher = pattern.matcher(nameDriver);
            if (matcher.matches() == true) {
                this.nameDriver = nameDriver;
            } else {
                System.out.println("введите ФИО с большой буквы через пробел");
            }
        }
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        if (driverLicense == DL_B || driverLicense == DL_D || driverLicense == DL_C) {
            this.driverLicense = driverLicense;
        } else {
            System.out.println("Проверьте категорию прав и введите верное");
        }
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        if (experience < 0) {
            this.experience = Math.abs(experience);
        } else {
            this.experience = experience;
        }

    }

    @Override
    public String toString() {
        return "Dr{" +
                "nameDriver='" + nameDriver + '\'' +
                ", driverLicense='" + driverLicense + '\'' +
                ", experience=" + experience +
                ", car=" + car +
                '}';
    }

    @Override
    public final void start() {
        System.out.println("Начинаю движение - " + getNameDriver());
    }

    @Override
    public final void stop() {
        System.out.println("Останавливаю авто - " + getNameDriver());
    }


    public final void refill(Transport auto, int quantity) {
        if (auto.getFuel() == "дизель") {
            System.out.println("Зправляем дизелем " + auto.getBrand() +
                    " " + auto.getModel() + " - " + quantity + " литров");
        } else if (auto.getFuel() == auto.PETROL) {
            System.out.println("Зправляем бензином " + auto.getBrand() +
                    " " + auto.getModel() + " - " + quantity + " литров");
        } else if (auto.getFuel() == auto.ELECTRO) {
            System.out.println("Заряжаем на " + auto.getBrand() +
                    " " + auto.getModel() + " - на " + quantity + "рублей");
        } else {
            System.out.println("Определите тип топлива для начала");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dr<?> dr = (Dr<?>) o;
        return Objects.equals(nameDriver, dr.nameDriver) && Objects.equals(driverLicense, dr.driverLicense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameDriver, driverLicense);
    }
}
