import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Sponsor<T extends Transport> {
    private String name;// имя спонсора
    private int sum;// сумма спонсирования
    private static Set<Sponsor> allSponsor = new HashSet<>(); //все объявленные спонсоры
    public Sponsor(String name) {
        this.name = name;
        Sponsor.getAllSponsor().add(this);//записываем споносра в список спонсоров
    }

    //вывод списка всех спонсоров
    public static void printAllSponsors() {
        for (Sponsor sponsor : allSponsor) {
            System.out.println(sponsor);
        }
    }

    public static Set<Sponsor> getAllSponsor() {
        return allSponsor;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    // метод спонсировать заезд, определяется авто для спонсирования и сумма
    public void support(T transport, int sum, Sponsor sponsor) {
        if (transport.getSponsorTransport() != null) {
            this.sum = this.sum + sum;
            transport.setSponsorSum(transport.getSponsorSum() + sum);
        } else {
            this.sum = sum;
            transport.setSponsorSum(sum);
        }
        transport.getSponsorTransport().add(sponsor);
    }


    @Override
    public String toString() {
        return "Sponsor{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                ", allTransport=" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor<?> sponsor = (Sponsor<?>) o;
        return Objects.equals(name, sponsor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
