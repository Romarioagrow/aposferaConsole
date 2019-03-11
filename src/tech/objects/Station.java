package tech.objects;
import tech.objects.techtypes.StationsTyps;
import tech.objects.techtypes.TechTypes;

public class Station extends TechObject {
    private final Enum<TechTypes> objectTYPE = TechTypes.Station;
    private Enum<StationsTyps> stationTYPE;

    /*public Shipyard shipyard;*/

    public Station(String name,
                   Enum<StationsTyps> type)
    {
        super(name);
        /*this.shipyard = new Shipyard();*/
        stationTYPE = type;
    }
    public Station(
            String name,
            Enum<StationsTyps> type,
            Integer setdate)
    {
        super(name, setdate);
        /*this.shipyard = new Shipyard();*/
        stationTYPE = type;
    }

    /// В ИНТЕРФЕЙС
    public static void showInfo(Station station) {
        getLocation(station);
        System.out.println(
                "Colony " + station.getObjectNAME() +
                        " is " + station.getStationTYPE() +
                        " was built in " + station.getEstDATE());
    }

    @Override
    public String toString() {
        return "Station " + objectNAME +
                ", stationTYPE: " + stationTYPE +
                ", estDATE: " + estDATE + "]";
    }

    public Enum<TechTypes> getObjectTYPE() {
        return objectTYPE;
    }
    public Enum<StationsTyps> getStationTYPE() {
        return stationTYPE;
    }
}
