package astro;
import astro.astrotypes.AstroTypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import static astro.Star.showInfo;
import static astro.Planet.showInfo;
import static astro.Moon.showInfo;

public final class StarSystem extends AstrObject{
    private final Enum<AstroTypes> objectTYPE = AstroTypes.System;
    public LinkedHashSet<Star> stars = new LinkedHashSet<Star>();

    public StarSystem(String name) {
        super (name);
    }

    // Добавить звезды в систему  /// В КОНТОРЛЛЕР
    public void addStars(Star ... star) {
        this.stars.addAll(Arrays.asList(star));

        /*int amount = star.length-1;
        for (int i = 0; i <= amount; i++) this.stars.add(star[i]);*/
    }

    public static void fullSystemInfo(StarSystem system) {
        String systemname = system.getObjectNAME() + " system";
        System.out.println(systemname + " detailed info:");

        System.out.println(systemname + " has " + system.stars.size() + " stars:");
        for (Star star : system.stars) {
            System.out.println(star.getObjectNAME());
        }

        for (Star star : system.stars) {
            showInfo(star);
            for (Planet planet : star.planets) {
                showInfo(planet);
                for (Moon moon : planet.moons) {
                    showInfo(moon);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "StarSystem " + objectNAME +
                ", stars: \n" + stars + "]";
    }
    public Enum<AstroTypes> getObjectTYPE() {
        return objectTYPE;
    }
}