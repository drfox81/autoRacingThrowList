import java.util.ArrayList;

public class Sponsor<T extends Transport> {
    private String name;// имя спонсора
    private int sum;// сумма спонсирования
    private static ArrayList<Sponsor> allSponsor = new ArrayList<>(); //все объявленные спонсоры
    public Sponsor(String name) {
        this.name = name;
        Sponsor.getAllSponsor().add(this);//записываем споносра в список спонсоров
    }

    //вывод списка всех спонсоров
    public static void printAllSponsors() {
        for (int i = 0; i < Sponsor.getAllSponsor().size(); i++) {
            System.out.println(Sponsor.getAllSponsor().get(i));
        }
    }

    public static ArrayList<Sponsor> getAllSponsor() {
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
}
