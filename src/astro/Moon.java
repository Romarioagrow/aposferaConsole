package astro;
import astro.astrotypes.AstroTypes;
import astro.astrotypes.PlanetAtmosphere;
import astro.astrotypes.PlanetTypes;
import tech.objects.Colony;
import tech.objects.Station;

public class Moon extends Planet {
    private final Enum<AstroTypes> objectTYPE = AstroTypes.Moon;

    private double rotationTIME;
    private double planetDISTANCE;

    public Moon(String name) {
        super(name);
    }
    public Moon(String name, double mass, double diam) {
        super(name, mass, diam);
    }

    /// В КОНТОРЛЛЕР
    public void setLunarParameters (Enum<PlanetTypes> type, Enum<PlanetAtmosphere> atm,  double time, double dist, double g) {

        this.planetTYPE = type;
        this.atmTYPE = atm;
        this.GRAVITY = g;
        rotationTIME = time;
        planetDISTANCE = dist;
    }

    public static void showInfo(Moon moon) {
        System.out.println("Moon " + moon.getObjectNAME());
        String scan = moon.isScanned() ? "Scanned: Yes" : "Scanned: No";
        System.out.println(scan);

        getLocation(moon);

        System.out.println("\nMoon parameters: " +

                "\nPlanet type = " + moon.getPlanetTYPE() +
                "\nAtmosphere = " + moon.getAtmTYPE() +
                "\nGravity = " + moon.getGRAVITY() +
                "\nDiameter = " + moon.getDIAMETR() +
                "\nMass = " + moon.getMASS() +
                "\nRotation time = " + moon.getRotationTIME() +
                "\nDistance to planet = " + moon.getPlanetDISTANCE());

        if (moon.stations.size() != 0) {
            System.out.println("\nMoon " + moon.getObjectNAME() + " stations: ");
            for (Station station : moon.stations)
                System.out.print(station.getObjectNAME() + " " + station.getStationTYPE() + " Station");
        } else System.out.println("\nNo stations on " + moon.getObjectNAME());

        if (moon.colonies.size() != 0) {
            System.out.println("\nMoon " + moon.getObjectNAME() + " colonies: ");
            for (Colony colony : moon.colonies)
                System.out.print(colony.getObjectNAME() + " " + colony.getColonyTYPE());
        } else System.out.println("\nNo colonies on " + moon.getObjectNAME());
    } /// В КОНТОРЛЛЕР

    public double getRotationTIME() {
        return rotationTIME;
    }
    public double getPlanetDISTANCE() {
        return planetDISTANCE;
    }
    public Enum<AstroTypes> getObjectTYPE() {
        return objectTYPE;
    }
}
