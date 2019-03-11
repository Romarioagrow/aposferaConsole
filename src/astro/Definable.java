package astro;
import astro.astrotypes.AstroTypes;
import tech.objects.Colony;
import tech.objects.Station;
import java.util.Map;

////!-->СТРУКТУРИРОВАТЬ НА БОЛЕЕ МЕЛКИЕ МЕТОДЫ!

////! setAstroParameters(Star)(Planet)(Moon)

////! getLocation(TechObject obj)

public interface Definable {
    String br = "______________________________|"; /// В ВСПОМОГАТЕЛЬНЫЙ КЛАСС

    static void getLocation(AstroObject obj) {
        String info = obj.getObjectTYPE() + " " + obj.getObjectNAME();

        if (!obj.getObjectTYPE().equals(AstroTypes.Moon)) /// В boolean tabulated!
            System.out.println("\nLocation of " + info + " is: ");
        else {
            System.out.println("\n\tLocation of " + info + " is: ");
        }

        /// ЗАМЕНИТЬ НА СТРИМ!
        for(Map.Entry<String, AstroObject> pair : obj.location.entrySet()) {
            AstroObject value = pair.getValue();

            String val = value.getObjectNAME();
            String key = pair.getKey();

            if (!obj.getObjectTYPE().equals(AstroTypes.Moon)) { /// В boolean tabulated
                System.out.println(key + "" + val);
            }
            else {
                System.out.println("\t" + key + "" + val);
            }
        }
    }

    /// РАЗБИТЬ НА !СТРИМЫ!
    static void fullSystemInfo(StarSystem system) {
        String systemNAME = system.getObjectNAME() + " system";
        System.out.println(systemNAME + " detailed info.");

        System.out.println(systemNAME + " has " + system.stars.size() + " stars:"); /// В .ForEach()
        for (Star star : system.stars) {
            System.out.println(star.getObjectNAME());
        }

        for (Star star : system.stars) { /// В СТРИМ!
            Definable.showInfo(star);
            for (Planet planet : star.planets) {
                Definable.showInfo(planet);
                for (Moon moon : planet.moons) {
                    Definable.showInfo(moon);
                }
            }
        }
    }

    static void showInfo(Star star) {
        int i = 1;
        System.out.println("\nThis is " + star.getObjectTYPE() + " " + star.getObjectNAME());

        Definable.getLocation(star);

        /// В МЕТОД starParameters() интерфейса Definable
        starParameter(star);

        /// В МЕТОД starPlanets() интерфейса Definable
        System.out.println("\nStar " + star.getObjectNAME() + " has " + star.planets.size() + " planets:");
        for (Planet planet : star.planets) {
            System.out.println("Planet №" + i + " "+ planet.getObjectNAME());
            i++;
        }
        System.out.println(br);
    }

    static void starParameter(Star star) {
        /// V-В МЕТОД starParameters() ИНТЕРФЕЙСА Definable
        System.out.println(
                "\nStar parameters" +
                        "\nStar class: " + star.getStarCLASS() +
                        "\nAge: " + star.getAGE() + " b.y." +
                        "\nTemperature: " + star.getTEMPER() + "K");
    }

    static void showInfo(Planet planet) {
        int i = 1;
        System.out.println("Planet " + planet.getObjectNAME());

        String scan = planet.isScanned() ? "Scanned: Yes" : "Scanned: No";///В ОТДЕЛЬНЫЙ МЕТОД!
        System.out.println(scan);

        Definable.getLocation(planet);

        /// В МЕТОД planetParameters() ИНТЕРФЕЙСА Definable
        System.out.println(
                "\nPlanet parameters " + ///В ОТДЕЛЬНЫЙ МЕТОД!
                        "\nPlanet type: " + planet.getPlanetTYPE() +
                        "\nAtmosphere: " + planet.getAtmTYPE() +
                        "\nGravity: " + planet.getGRAVITY() +
                        "\nDiameter: " + planet.getDIAMETER() +
                        "\nMass: " + planet.getMASS()+"\n");

        //Станции планеты /// ОПТИМИЗИРОВАТЬ!
        if (planet.stations.size() != 0) {
            System.out.println("Planet " + planet.getObjectNAME() + " stations:");
            for (Station station : planet.stations) {
                System.out.println("--->" + station.getObjectNAME() + " " + station.getStationTYPE() + " Station\n");
            }
        }
        else System.out.println("No stations on " + planet.getObjectNAME());

        //Колонии планеты
        if (planet.colonies.size() != 0) {
            System.out.println("Planet " + planet.getObjectNAME() + " settlements:");
            for (Colony colony : planet.colonies)
                System.out.println("===>" + colony.getObjectNAME() + " " + colony.getColonyTYPE());
        }
        else System.out.println("No settlements on " + planet.getObjectNAME());

        /// В ОТДБЕЛЬНЫЕ МЕТОДЫ showplanets, moons, STATION(PLANET)(MOON)..!
        //Спутники планеты
        if (planet.moons.size() != 0) {
            System.out.println("\nPlanet " + planet.getObjectNAME() + " moons:");
            for (Moon moon : planet.moons) {
                System.out.println("~~~>" + "Moon №" + i + " " + moon.getObjectNAME());
                ++i;
            }
        }
        else System.out.println("\nPlanet " + planet.getObjectNAME() + " has no moons");
        System.out.print(br + "\n");
    }
    static void showInfo(Moon moon) {
        System.out.println("\tMoon " + moon.getObjectNAME());

        String scan = moon.isScanned() ? "\tScanned: Yes" : "\tScanned: No";
        System.out.println(scan);

        System.out.print("\t");
        Definable.getLocation(moon);

        /// В МЕТОД moonParameters() ИНТЕРФЕЙСА Definable
        System.out.println(
                "\n\tMoon parameters " +
                        "\n\tPlanet type: " + moon.getPlanetTYPE() +
                        "\n\tAtmosphere: " + moon.getAtmTYPE() +
                        "\n\tGravity: " + moon.getGRAVITY() +
                        "\n\tDiameter: " + moon.getDIAMETER() +
                        "\n\tMass: " + moon.getMASS() +
                        "\n\tRotation time: " + moon.getRotationTIME() +
                        "\n\tDistance to planet: " + moon.getPlanetDISTANCE());

        if (moon.stations.size() != 0) {
            System.out.println("\n\tMoon " + moon.getObjectNAME() + " stations: ");
            for (Station station : moon.stations)
                System.out.print("\t" + station.getObjectNAME() + " " + station.getStationTYPE() + " Station");
        } else System.out.println("\n\tNo stations on " + moon.getObjectNAME());

        if (moon.colonies.size() != 0) {
            System.out.println("\n\tMoon " + moon.getObjectNAME() + " settlements: ");
            for (Colony colony : moon.colonies)
                System.out.println("\t===>" + colony.getObjectNAME() + " " + colony.getColonyTYPE());
        } else System.out.println("\tNo settlements on " + moon.getObjectNAME());
        System.out.println("\t" + br);
    }
}

/*
/// V-МЕТОД ТОЛЬКО ДЛЯ GetLocation()
/// МЕТОД ShowInfo() { getObjectNAME() + GetLocation()
public static void showInfo() {}
*/