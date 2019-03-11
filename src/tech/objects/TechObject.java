package tech.objects;
import astro.*;
import astro.Definable;
import tech.objects.techtypes.TechTypes;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class TechObject implements Definable { ///! ПЕРЕОПРЕДЕЛИТЬ ИНТЕРФЕЙС!
    private static Enum<TechTypes> objectTYPE; // ДОБАВИТЬ В СТАТИК БЛОК НА СТАНЦИИ
    String objectNAME;
    Integer estDATE;

    TechObject (String name) {
        objectNAME = name;
    }
    TechObject(String name, int setdate) {
        objectNAME = name;
        estDATE = setdate;
    }

    // Локация объекта
    private LinkedHashMap<String, AstroObject> location = new LinkedHashMap<>();

    // Установить локацию станции /// В КОНТОРЛЛЕР
    public void setLocation(
            Moon moon,
            Planet planet,
            Star star,
            StarSystem system)
    {
        this.location.put("Moon", moon);
        this.location.put("Planet ", planet);
        this.location.put("Star ", star);
        this.location.put("System ", system);
    }
    public void setLocation(
            Planet planet,
            Star star,
            StarSystem system)
    {
        this.location.put("Planet ", planet);
        this.location.put("Star ", star);
        this.location.put("System ", system);
    }

    /// В ИНТЕРФЕЙС ДЛЯ getLocation(TechObject obj)!
    // Определение локации TechObject
    static void getLocation(TechObject obj){
        String object = obj.getObjectTYPE() + " " + obj.getObjectNAME();
        if (obj.getObjectTYPE() == TechTypes.Colony) {
            System.out.println("\n" + object + " is situated on: ");
        }
        else System.out.println("\n" + object + " is rotating around: ");

        for(Entry<String, AstroObject>  pair : obj.location.entrySet()) {
            AstroObject value = pair.getValue();
            String val = value.getObjectNAME();
            String key = pair.getKey();
            System.out.println(key + val);
        }
    }

    // Геттеры и Сеттеры
    public String getObjectNAME() {
        return objectNAME;
    }
    public Enum<TechTypes> getObjectTYPE() {
        return objectTYPE;
    }
    Integer getEstDATE() {
        return estDATE;
    }
    public void setObjectNAME(String objectNAME) {
        this.objectNAME = objectNAME;
    }
    public void setEstDATE(int estDATE) {
        this.estDATE = estDATE;
    }
}

