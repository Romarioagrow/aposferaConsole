package tech.objects;
import tech.objects.techtypes.StationsTyps;
import tech.objects.techtypes.TechTypes;

public class Station extends TechObject {
    final Enum<TechTypes> objectTYPE = TechTypes.Station;
    public Enum<StationsTyps> stationTYPE;

    public Shipyard shipyard;

    public Station(String name, Enum<StationsTyps> type) {
        super(name);
        this.shipyard = new Shipyard();
        stationTYPE = type;
    }
    public Station(String name, Enum<StationsTyps> type, int setdate) {
        super(name, setdate);
        this.shipyard = new Shipyard();
        stationTYPE = type;
    }

    public static void showInfo(Station station) {
        getLocation(station);
        System.out.println("Colony " + station.getObjectNAME() + " is " + station.getStationTYPE() + " was built in " + station.getEstDATE());
    } /// В КОНТОРЛЛЕР

    @Override
    public String toString() {
        String showinfo =

                "Station " + objectNAME +
                        ", stationTYPE: " + stationTYPE +
                        ", estDATE: " + estDATE + "]";

        return	showinfo;
    }
    public Enum<TechTypes> getObjectTYPE() {
        return objectTYPE;
    }
    public Enum<StationsTyps> getStationTYPE() {
        return stationTYPE;
    }
}
