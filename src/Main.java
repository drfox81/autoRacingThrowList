public class Main {
    //public void carryTO(T transport)  проверка возможности провести ТО работником
    //public void support(T transport, int sum, Sponsor sponsor)метод спонсировать заезд,
    //                                       определяется авто для спонсирования и сумма
    //public void repairTransport(T transport)метод провести ремонт авто ( с учетом квалификации механика)
    //public static void printAllDrivers() вывод списка всех водителей
    //public static void printAllTransport() принт всех транспортных средств
    //public static void printAllSponsors() вывод списка всех спонсоров
    //public static void printAllMechanic() вывод списка всех механиков
    //public static void addQueue(Transport transport) добавить авто в очередь на ТО



    public static void main(String[] args) throws СhangeDriversLicense, СhangeDriversLicenseBus {

        Car ladaKalina = new Car("Lada", "Kalina", "бензин", "седан");
        Car bmw5 = new Car("BMW", "X5", "бензин", "хэтчбэк");
        Car kiaRio = new Car("Kia", "Rio", "дизель", 1.6);
        DrB sergeevDkalina = new DrB("Сергеев Сергей Сергеевич", 6, ladaKalina, Dr.DL_B);
        DrB sergeevDx5 = new DrB("Сергеевбмв Сергей Сергеевич", 6, bmw5, Dr.DL_B);
        DrB sergeevDrio = new DrB("Сергеевкиа Сергей Сергеевич", 6, kiaRio, Dr.DL_B);

        Trucks kamaz = new Trucks("Kamaz", "3008", "дизель", 3f);
        Trucks maz = new Trucks("Maz", "4008", "дизель", 17);
        DrC fedorovCramaz = new DrC("Федоров Федор Федорович", 6, kamaz, Dr.DL_C);
        DrC fedorovCmaz = new DrC("Федоровмаз Федор Федорович", 6, maz, Dr.DL_C);

        Bus paz = new Bus("Паз", "2645", "дизель", 30);
        DrD ivanovDpaz = new DrD("Иванов Иван Иванович", 6, paz, Dr.DL_D);

        Sponsor sponsorPetrovIO = new Sponsor("Петров ИО");
        sponsorPetrovIO.support(ladaKalina, 20000, sponsorPetrovIO);
        Sponsor sponsorOmega = new Sponsor("ООО Омега");
        sponsorOmega.support(kamaz, 50000, sponsorOmega);
        sponsorOmega.support(ladaKalina, 30000, sponsorOmega);


        Transport.printDriverTransport(kamaz);
        System.out.println(kamaz.printType());
        Mechanic demidovI = new Mechanic<>("Демидов", "Иван", "ООО Техник",
                TypeTransport.CAR);
        demidovI.carryTO(kamaz);
        demidovI.repairTransport(ladaKalina);
        demidovI.repairTransport(bmw5);

        allAboutTransport(ladaKalina);

        ServiceStation.addQueue(ladaKalina);
        ServiceStation.addQueue(bmw5);
        ServiceStation.addQueue(kamaz);

        ServiceStation<Transport, Mechanic> serviceStation = new ServiceStation<>();
        System.out.println(ServiceStation.getQueue().size());
        serviceStation.spendTO();
        System.out.println(ServiceStation.getQueue().size());
        System.out.println("\n");
        System.out.println("+++++++++++++++Домашнее задание 3 задание 1+++++++++++++++");
        Sponsor sponsorOmega1 = new Sponsor("ООО Омега");
        Sponsor.printAllSponsors();
        Car ladaKalina1 = new Car("Lada", "Kalina", "бензин", "седан");
        Transport.printAllTransport();
        DrC fedorovCramaz1 = new DrC("Федоров Федор Федорович", 6, kamaz, Dr.DL_C);
        Dr.printAllDrivers();
        Mechanic demidovI1 = new Mechanic<>("Демидов", "Иван", "ООО Техник",
                TypeTransport.CAR);
        Mechanic.printAllMechanic();





//
//        Transport.printAllTransport();
//        Sponsor.printAllSponsors();
//        Dr.printAllDrivers();


    }
    //метод определяет как зовут водителя авто, какие спонсоры и механики
    public static void allAboutTransport(Transport transport) {
        System.out.println("Транспортное средство - " + transport.getBrand() + " " + transport.getModel());
        System.out.println("Водитель - " + transport.getDriver().getNameDriver());
        System.out.println("Спонсор(ы) транспортного средства - ");
        for (int i = 0; i < transport.getSponsorTransport().size(); i++) {
            System.out.println(transport.getSponsorTransport().get(i));
        }
        System.out.println("Механик(и) - ");
        for (int i = 0; i < transport.getListMechanicTransport().size(); i++) {
            System.out.println(transport.getListMechanicTransport().get(i));
        }
    }

    // Прошграмма которая проверяет, что все объекты всех классов прошли диагностику.
    public static void passD(Transport... transports) throws СhangeDriversLicenseBus {
        for (Transport tr : transports) {
            try {
                if (tr.getClass() == Bus.class) {
                    throw new СhangeDriversLicenseBus();
                }
                if (tr.isDiagnostic()) {
                    System.out.println("Диагностика пройдена" + tr.isDiagnostic()
                            + " " + tr.getBrand() + " " + tr.getModel());
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (СhangeDriversLicenseBus e) {
                e.getMessage();
            }
        }

    }
}