package astro;
import astro.astrotypes.AstroTypes;
import java.util.Arrays;
import java.util.LinkedHashSet;

public final class StarSystem extends AstroObject {
    private final Enum<AstroTypes> objectTYPE = AstroTypes.System;
    LinkedHashSet<Star> stars = new LinkedHashSet<>();

    public StarSystem(String name) {
        super (name);
    }

    // Добавить звезды в систему  /// В КОНТОРЛЛЕР!
    public void addStars(Star ... star) {
        this.stars.addAll(Arrays.asList(star));
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