package astro;
import astro.astrotypes.AstroTypes;
import astro.astrotypes.StarsClasses;
import java.util.Arrays;
import java.util.LinkedList;

public class Star extends AstrObject {
    private final Enum<AstroTypes> objectTYPE = AstroTypes.Star;
    private final Enum<StarsClasses> starCLASS;

    private double AGE, TEMPR;

    // Основной конструктор с главными параметрами
    public Star (String name, Enum<StarsClasses> starclass, double mass, double diam) {
        super (name, mass, diam);
        starCLASS = starclass;
    }

    // Установить дополнительные значения /// В КОНТОРЛЛЕР
    public void setStarParameters (double age, double temp) {
        AGE = age;
        TEMPR = temp;
    }

    // Планеты объекта
    public LinkedList<Planet> planets = new LinkedList<Planet>();

    // Добавить планеты вокруг звезды /// В КОНТОРЛЛЕР
    public void addPlanets(Planet ... planet){
        int amount = planet.length-1;

        //this.planets.addAll(Arrays.asList(planet).subList(0, amount + 1));
        for (int i = 0; i <= amount; i++)
            this.planets.add(planet[i]);
    }

    public static void showInfo(Star star) {
        int i = 1;
        System.out.println("This is " + star.getObjectTYPE() + " " + star.getObjectNAME());
        getLocation(star);
        System.out.println("Star parameters:" + "\nStar class = " + star.getStarCLASS() + "\nAge = " + star.getAGE() + "\nTemperature = " + star.getTEMPR());

        System.out.println("Star " + star.getObjectNAME() + " has " + star.planets.size() + " planets:");
        for (Planet planet : star.planets) {
            System.out.println("Planet №" + i + " "+ planet.getObjectNAME());
            i++;
        }
        System.out.println("______________________________|");
    } /// В КОНТОРЛЛЕР

    @Override
    public String toString(){
        String showinfo =

                "Star " + this.getObjectNAME()
                        + "\n [objectTYPE = " + objectTYPE
                        + ",\n starCLASS = " + starCLASS
                        + ",\n AGE = " + AGE
                        + ",\n TEMPR = " + TEMPR
                        + "\n Planets: " + planets + "\n\n\n]";

        return showinfo;
    }

    public double getAGE() {
        return AGE;
    }
    public double getTEMPR() {
        return TEMPR;
    }
    public Enum<AstroTypes> getObjectTYPE() {
        return objectTYPE;
    }
    public Enum<StarsClasses> getStarCLASS() {
        return starCLASS;
    }
}
