import java.util.ArrayList;

public class Mechanic<T extends Transport> {
    private String firstName;// Фамилия
    private String secondName;// Имя
    private String companyName;// название компании
    private TypeTransport type;//тип ТС
    private ArrayList<Transport> listTransport = new ArrayList<>();// список транспорта механика
    private static ArrayList<Mechanic> listMechanic = new ArrayList<>();

    public static ArrayList<Mechanic> getListMechanic() {
        return listMechanic;
    }

    public ArrayList<Transport> getListTransport() {
        return listTransport;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public TypeTransport getType() {
        return type;
    }

    public void setType(TypeTransport type) {
        this.type = type;
    }

    public Mechanic(String firstName, String secondName, String companyName, TypeTransport type) {
        this.firstName = chekString(firstName);
        this.secondName = chekString(secondName);
        this.companyName = chekString(companyName);
        this.type = type;
        getListMechanic().add(this);
    }

    //вывод списка всех механиков
    public static void printAllMechanic() {
        for (int i = 0; i < Mechanic.getListMechanic().size(); i++) {
            System.out.println(Mechanic.getListMechanic().get(i));
        }
    }

    // проверка квалификации механика (с каким ТС может работать)
    public boolean checkTransportTO(T transport) {
        boolean chek;
        if (!type.equals(transport.getTypeTransport())) {
            System.out.println("Я не могу работать с вашим транспортным средством, " +
                    "я механик работы с типом - " + type + ", а ты тип - " + transport.getTypeTransport());
            chek = false;
        } else {
            chek = true;
        }
        return chek;
    }

    // метод провести ремонт авто ( с учетом квалификации механика)
    public void repairTransport(T transport) {
        if (checkTransportTO(transport)) {
            System.out.println("Ремонтирую авто " + transport);
            System.out.println("Ремонт закончен!");
            if (!getListTransport().contains(transport)) {
                getListTransport().add(transport);
                transport.getListMechanicTransport().add(this);
            }
        }
    }


    //провести ТО работником
    public void carryTO(T transport) {
        if (checkTransportTO(transport)) {
            System.out.println("Провожу техническое обслуживание" + transport);
            System.out.println("ТО закончено!");
            transport.setDiagnostic(true);
            if (!getListTransport().contains(transport)) {
                getListTransport().add(transport);
                transport.getListMechanicTransport().add(this);
            }
        }
    }


    //проверка вводимых данных
    public String chekString(String string) {
        if (string != null || !string.isBlank() || !string.isEmpty()) {
            return string;
        } else {
            string = null;
        }
        return string;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName;
    }
}
