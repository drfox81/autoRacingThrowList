import java.util.ArrayList;
import java.util.LinkedList;

public class ServiceStation<T extends Transport,M extends Mechanic> {
    private String nameServiceStation;
    private static ArrayList<Transport> queue = new ArrayList<>(10);
    private M person;

    public String getNameServiceStation() {
        return nameServiceStation;
    }

    public M getPerson() {
        return person;
    }

    public static ArrayList<Transport> getQueue() {
        return queue;
    }

    //добавить авто в очередь на ТО
    public static void addQueue(Transport transport) {
        if (!transport.getTypeTransport().equals(TypeTransport.BUS)
                && transport.isDiagnostic() == false) {
            if (!getQueue().contains(transport)) {
                getQueue().add(transport);
                System.out.println("Транспорт " + transport.getBrand() + " " + transport.getModel() + " поставлена в очередь " +
                        "на обслуживание под номером № " + getQueue().indexOf(transport));
            }
        } else {
            System.out.println("Автобусы не нуждаются в ТО");
        }
    }

    //провести ТО
    public void spendTO() {
        if (getQueue().size() != 0) {
            System.out.println("Механик - " + getQueue().get(0).getListMechanicTransport().get(0) +
                    " провожу ТО на транспорте " + getQueue().get(0).getBrand() + " " +
                    getQueue().get(0).getModel());
            //getQueue().get(0).getListMechanicTransport().get(0).carryTO(getQueue().get(0));
            //ServiceStation.getQueue().get(0).getListMechanicTransport().get(0).
            getQueue().get(0).setDiagnostic(true);
            getQueue().remove(0);
        } else {
            System.out.println("Все ТО проведены");
        }
    }
}
