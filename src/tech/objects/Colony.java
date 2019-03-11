package tech.objects;
import tech.objects.techtypes.ColoniesTypes;
import tech.objects.techtypes.TechTypes;

public class Colony extends TechObject {
    private final Enum<TechTypes> objectTYPE = TechTypes.Colony;
    private Enum<ColoniesTypes> colonyTYPE;

    /*private Spaceport spaceport; // Фабрика кораблей*/

    public Colony(String name, Enum<ColoniesTypes> type, int setdate) {
        super(name, setdate);
        /*this.spaceport = new Spaceport();*/
        colonyTYPE = type;
    }
    public Colony(String name, Enum<ColoniesTypes> type) {
        super(name);
        /*this.spaceport = new Spaceport();*/
        colonyTYPE = type;
    }
    /// В ИНТЕРФЕЙС
    public static void showInfo(Colony colony) {
        getLocation(colony);
        System.out.println(
                "Colony " + colony.getObjectNAME() +
                        " is " + colony.getColonyTYPE() +
                        " was founded in " + colony.getEstDATE());
    }

    @Override
    public String toString() {
        return "Colony " + objectNAME +
                ", colonyTYPE: " + colonyTYPE +
                ", estDATE: " + estDATE + "]";
    }

    public Enum<TechTypes> getObjectTYPE() {
        return objectTYPE;
    }
    public Enum<ColoniesTypes> getColonyTYPE() {
        return colonyTYPE;
    }
}