package astro;
import astro.astrotypes.AstroTypes;
import astro.astrotypes.StarsClasses;
import java.util.Arrays;
import java.util.LinkedList;

public class Star extends AstroObject {
    private final Enum<AstroTypes> objectTYPE = AstroTypes.Star;
    private final Enum<StarsClasses> starCLASS;
    private Double AGE;
    private Integer TEMPER;

    // Основной конструктор с главными параметрами
    public Star (String name, Enum<StarsClasses> starclass, double mass, double diam) {
        super (name, mass, diam);
        starCLASS = starclass;
    }

    // Установить дополнительные значения /// В КОНТОРЛЛЕР-ИНТЕРФЕЙС
    public void setStarParameters (Double age, Integer temp) {
        AGE = age;
        TEMPER = temp;
    }

    // Планеты объекта
    LinkedList<Planet> planets = new LinkedList<>();

    // Добавить планеты вокруг звезды
    /// В КОНТОРЛЛЕР-ИНТЕРФЕЙС
    /// Автоаматически устанавливать колацию к звезде, палнете, спутнику!
    public void addPlanets(Planet ... planet){
        this.planets.addAll(Arrays.asList(planet));
    }

    ///!
    @Override
    public String toString(){
        return "Star " + this.getObjectNAME()
                + "\n [objectTYPE = " + objectTYPE
                + ",\n starCLASS = " + starCLASS
                + ",\n AGE = " + AGE
                + ",\n TEMPER = " + TEMPER
                + "\n Planets: " + planets + "\n\n\n]";
    }

    public Enum<AstroTypes> getObjectTYPE() {
        return objectTYPE;
    }
    Double getAGE() {
        return AGE;
    }
    Integer getTEMPER() {
        return TEMPER;
    }
    Enum<StarsClasses> getStarCLASS() {
        return starCLASS;
    }
}
