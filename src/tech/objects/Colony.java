package tech.objects;
import astro.AstrObject;
import tech.objects.techtypes.ColoniesTypes;
import tech.objects.techtypes.TechTypes;
import java.util.Map;

public class Colony extends TechObject {
    private final Enum<TechTypes> objectTYPE = TechTypes.Colony;
    public Enum<ColoniesTypes> colonyTYPE;

    public Spaceport spaceport; // Фабрика кораблей

    public Colony(String name, Enum<ColoniesTypes> type, int setdate) {
        super(name, setdate);
        this.spaceport = new Spaceport();
        colonyTYPE = type;
    }
    public Colony(String name, Enum<ColoniesTypes> type) {
        super(name);
        this.spaceport = new Spaceport();
        colonyTYPE = type;
    }

    public static void showInfo(Colony colony) {
        getLocation(colony);
        System.out.println("Colony " + colony.getObjectNAME() + " is " + colony.getColonyTYPE() + " was founded in " + colony.getEstDATE());
    } /// В КОНТОРЛЛЕР

    @Override
    public String toString() {
        String showinfo =

                "Colony " + objectNAME +
                        ", colonyTYPE: " + colonyTYPE +
                        ", estDATE: " + estDATE + "]";

        return showinfo;
    }
    public Enum<TechTypes> getObjectTYPE() {
        return objectTYPE;
    }
    public Enum<ColoniesTypes> getColonyTYPE() {
        return colonyTYPE;
    }
}