package astro;
import astro.astrotypes.AstroTypes;
import java.util.*;

public class AstroObject implements Definable {
    private static Enum<AstroTypes> objectTYPE = null;
    String objectNAME;
    Double MASS, DIAMETER;

    AstroObject(String name, Double mass, Double diam) {
        objectNAME = name;
        MASS = mass;
        DIAMETER = diam;
    }
    AstroObject(String name) {
        objectNAME = name;
    }
    AstroObject() {}

    // Локация объекта
    LinkedHashMap<String, AstroObject> location = new LinkedHashMap<>();

    /// В КОНТОРЛЛЕР-ИНТЕРФЕЙС
    // Установить локацию ASTRO
    public void setLocation(StarSystem system){
        this.location.put("System ", system);
    }
    public void setLocation(Star star, StarSystem system){
        this.location.put("Star ", star);
        this.location.put("System ", system);
    }
    public void setLocation(Planet planet, Star star, StarSystem system){
        this.location.put("Planet ", planet);
        this.location.put("Star ", star);
        this.location.put("System ", system);
    }

    // Геттеры и Сеттеры
    public String getObjectNAME() {
        return objectNAME;
    }
    public Enum<AstroTypes> getObjectTYPE() {
        return objectTYPE;
    }
    Double getMASS() {
        return MASS;
    }
    Double getDIAMETER() {
        return DIAMETER;
    }

    public void setObjectNAME(String name) {
        objectNAME = name;
    }
    public void setMASS(Double mass) {
        MASS = mass;
    }
    public void setDIAMETER(Double diametr) {
        DIAMETER = diametr;
    }
}