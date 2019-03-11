package astro;
import astro.astrotypes.AstroTypes;
import astro.astrotypes.PlanetAtmosphere;
import astro.astrotypes.PlanetTypes;
import tech.objects.Colony;
import tech.objects.Station;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Planet extends AstroObject {
    private final Enum<AstroTypes> objectTYPE = AstroTypes.Planet;
    Enum<PlanetTypes> planetTYPE = null;
    Enum<PlanetAtmosphere> atmTYPE = null;
    Double GRAVITY;

    // Основной конструктор с главными параметрами
    public Planet(String name,  Enum<PlanetTypes> type, Enum<PlanetAtmosphere> atmo) {
        super(name);
        planetTYPE = type;
        atmTYPE = atmo;
    }
    Planet(String name, double mass, double diam) {
        super(name, mass, diam);
    }
    public Planet(String name) {
        super(name);
    }
    public Planet(){
    }

    /// В ИНТЕРФЕЙС, ПЕРЕПИСАТЬ КАК setAstroParameters(Star)(Planet)(Moon)
    // Установить дополнительные значения
    public void setPlanetParameters (double mass, double diam, double g) {
        this.MASS = mass;
        this.DIAMETER = diam;
        GRAVITY = g;
    }

    // Станции объекта
    LinkedHashSet<Station> stations = new LinkedHashSet<Station>();
    public void addStations(Station ... somestation) {
        this.stations.addAll(Arrays.asList(somestation));
    }

    // Колонии объекта
    LinkedHashSet<Colony> colonies = new LinkedHashSet<>();
    public void addColonies(Colony ... somecolony) {
        this.colonies.addAll(Arrays.asList(somecolony));
    }

    // Спутники объекта
    final LinkedList<Moon> moons = new LinkedList<>();
    public final void addMoons(Moon ... moon) {
        this.moons.addAll(Arrays.asList(moon));
    }

    boolean isScanned() {
        return this.planetTYPE != null && this.atmTYPE != null && (this.getGRAVITY() != null);
    }

    public Enum<AstroTypes> getObjectTYPE() {
        return objectTYPE;
    }
    Enum<PlanetTypes> getPlanetTYPE() {
        return planetTYPE;
    }
    Enum<PlanetAtmosphere> getAtmTYPE() {
        return atmTYPE;
    }
    Double getGRAVITY() {
        return GRAVITY;
    }

}