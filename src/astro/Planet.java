package astro;
import astro.astrotypes.AstroTypes;
import astro.astrotypes.PlanetAtmosphere;
import astro.astrotypes.PlanetTypes;
import tech.objects.Colony;
import tech.objects.Station;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Planet extends AstrObject {
    private final Enum<AstroTypes> objectTYPE = AstroTypes.Planet;
    Enum<PlanetTypes> planetTYPE;
    Enum<PlanetAtmosphere> atmTYPE;

    double GRAVITY;
    public boolean scanned = true; //

    // Основной конструктор с главными параметрами
    public Planet(String name,  Enum<PlanetTypes> type, Enum<PlanetAtmosphere> atmo) {

        super(name);
        planetTYPE = type;
        atmTYPE = atmo;
    }

    public Planet(String name, double mass, double diam) {

        super(name, mass, diam);
    }
    public Planet(String name) {

        super(name);
    }

    // Установить дополнительные значения /// В КОНТОРЛЛЕР
    public void setPlanetParameters (double mass, double diam, double g) {

        this.MASS = mass;
        this.DIAMETR = diam;
        GRAVITY = g;
    }

    // Спутники объекта
    public LinkedList<Moon> moons = new LinkedList<Moon>();
    // Добавить луны планеты /// В КОНТОРЛЛЕР
    public final void addMoons(Moon ... moon) {
        int amount = moon.length-1;

        for (int i = 0; i <= amount; i++)
            this.moons.add(moon[i]);
    }

    // Станции объекта
    public LinkedHashSet<Station> stations = new LinkedHashSet<Station>();
    // Добаввить станции объекта /// В КОНТОРЛЛЕР
    public void addStations(Station ... somestation) {
        int amount = somestation.length-1;

        for (int i = 0; i <= amount; i++) this.stations.add(somestation[i]); /// ДОБАВЛЯТЬ МАССИВАМИ
    }

    // Колонии объекта
    public LinkedHashSet<Colony> colonies = new LinkedHashSet<Colony>();
    // Добавить колонии объекта /// В КОНТОРЛЛЕР
    public void addColonies(Colony ... somecolony) { ///ЗАМЕНИТЬ НА УЛУЧШЕННЫЙ ВАРИАНТ
        int amount = somecolony.length-1;

        for (int i = 0; i <= amount; i++)
            this.colonies.add(somecolony[i]);
    }

    // Отобразить инормацию о планете /// В КОНТОРЛЛЕР
    public static void showInfo(Planet planet) {
        int i = 1;

        System.out.println("Planet " + planet.getObjectNAME());
        String scan = planet.isScanned() ? "Scanned: Yes" : "Scanned: No";///В ОТДЕЛЬНЫЙ МЕТОД
        System.out.println(scan);

        getLocation(planet);

        System.out.println("\nPlanet parameters: " + ///В ОТДЕЛЬНЫЙ МЕТОД

                "\nPlanet type = " + planet.getPlanetTYPE() +
                "\nAtmosphere = " + planet.getAtmTYPE() +
                "\nGravity = " + planet.getGRAVITY() +
                "\nDiameter = " + planet.getDIAMETR() +
                "\nMass = " + planet.getMASS());

        //Спутники планеты  /// В ОТДБЕЛЬНЫЕ МЕТОДЫ showplanets, moons, stations...
        if (planet.moons.size() != 0) {
            System.out.println("\nPlanet " + planet.getObjectNAME() + " moons:");
            for (Moon moon : planet.moons) {
                System.out.println("\n~~~>" + "Moon №" + i + " " + moon.getObjectNAME());
                ++i;
            }
        } else System.out.println("\nPlanet " + planet.getObjectNAME() + " has no moons");

        //Станции планеты
        if (planet.stations.size() != 0) {
            System.out.println("\nPlanet " + planet.getObjectNAME() + " stations:");
            for (Station station : planet.stations)
                System.out.println("--->" + station.getObjectNAME() + " " + station.getStationTYPE() + " Station");
        } else System.out.println("\nNo stations on " + planet.getObjectNAME());

        //Колонии планеты
        if (planet.colonies.size() != 0) {
            System.out.println("\nPlanet " + planet.getObjectNAME() + " colonies:");
            for (Colony colony : planet.colonies)
                System.out.println("===>" + colony.getObjectNAME() + " " + colony.getColonyTYPE());
        } else System.out.println("\nNo colonies on " + planet.getObjectNAME());

        System.out.println("______________________________|");
    }

    public Enum<PlanetTypes> getPlanetTYPE() {
        return planetTYPE;
    }
    public Enum<PlanetAtmosphere> getAtmTYPE() {
        return atmTYPE;
    }
    public double getGRAVITY() {
        return GRAVITY;
    }
    public Enum<AstroTypes> getObjectTYPE() {
        return objectTYPE;
    }
    public boolean isScanned() {
        return scanned;
    }
    public void setScanned(boolean scanned) {
        this.scanned = scanned;
    }
}