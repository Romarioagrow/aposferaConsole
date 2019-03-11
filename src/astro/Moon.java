package astro;
import astro.astrotypes.AstroTypes;
import astro.astrotypes.PlanetAtmosphere;
import astro.astrotypes.PlanetTypes;

public class Moon extends Planet {
    private final Enum<AstroTypes> objectTYPE = AstroTypes.Moon;
    private Double rotationTIME, planetDISTANCE;

    public Moon(String name) {
        super(name);
    }
    public Moon(String name, Double mass, Double diam) {
        super(name, mass, diam);
    }

    /// В ИНТЕРФЕЙС
    public void setLunarParameters (
            Enum<PlanetTypes> type,
            Enum<PlanetAtmosphere> atm,
            Double time, Double dist, Double g)
    {
        this.planetTYPE = type;
        this.atmTYPE = atm;
        this.GRAVITY = g;
        rotationTIME = time;
        planetDISTANCE = dist;
    }

    public Enum<AstroTypes> getObjectTYPE() {
        return objectTYPE;
    }
    Double getRotationTIME() {
        return rotationTIME;
    }
    Double getPlanetDISTANCE() {
        return planetDISTANCE;
    }
}
