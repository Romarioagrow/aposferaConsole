package astro;
import astro.astrotypes.AstroTypes;
import general.Locationable;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;

public class AstrObject{
    private static Enum<AstroTypes> objectTYPE;

    String objectNAME;
    double MASS;
    double DIAMETR;

    AstrObject (String name, double mass, double diam) {
        objectNAME = name;
        MASS = mass;
        DIAMETR = diam;
    }
    AstrObject (double mass, double diam) {
        MASS = mass;
        DIAMETR = diam;
    }
    AstrObject (String name) {
        objectNAME = name;
    }

    // Локация объекта
    public LinkedHashMap<String, AstrObject> location = new LinkedHashMap<String, AstrObject>();

    // Установить локацию звезды /// В КОНТОРЛЛЕР
    public void setLocation(StarSystem system){
        this.location.put("System ", system);
    }

    // Установить локацию планеты /// В КОНТОРЛЛЕР
    public void setLocation(Star star, StarSystem system){
        this.location.put("Star ", star);
        this.location.put("System ", system);
    }

    // Установить локацию спутника /// В КОНТОРЛЛЕР
    public void setLocation(Planet planet, Star star, StarSystem system){
        this.location.put("Planet ", planet);
        this.location.put("Star ", star);
        this.location.put("System ", system);
    }

    // Определение локации AstrObject /// В КОНТОРЛЛЕР
    public static void getLocation(AstrObject obj) {
        String info = obj.getObjectTYPE() + " " + obj.getObjectNAME();
        System.out.println("\nLocation of " + info + " is: ");

        for(Entry<String, AstrObject>  pair : obj.location.entrySet()) { // В ИНТЕРФЕЙС LOCATIONABLE ДЛЯ STAR/TECH OBJECT, ДЛЯ PERSON, ДЛЯ star
            AstrObject value = pair.getValue();
            String val = value.getObjectNAME();
            String key = pair.getKey();
            System.out.println(key + "" + val);
        }
    }

    // Геттеры и Сеттеры
    public String getObjectNAME() {
        return objectNAME;
    }
    public Enum<AstroTypes> getObjectTYPE() {
        return objectTYPE;
    }
    public double getMASS() {
        return MASS;
    }
    public double getDIAMETR() {
        return DIAMETR;
    }

    public void setObjectNAME(String name) {
        objectNAME = name;
    }
    public void setMASS(double mass) {
        MASS = mass;
    }
    public void setDIAMETR(double diametr) {
        DIAMETR = diametr;
    }
}