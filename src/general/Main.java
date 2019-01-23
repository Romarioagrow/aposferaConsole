package general;
import astro.*;
import astro.astrotypes.PlanetAtmosphere;
import astro.astrotypes.PlanetTypes;
import astro.astrotypes.StarsClasses;
import persons.*;
import tech.objects.*;
import tech.objects.techtypes.*;
import tech.ships.shipclasses.Ship;
import javax.sound.sampled.Port;
import static astro.AstrObject.getLocation;
import static astro.Star.showInfo;
import static astro.StarSystem.fullSystemInfo;
import static astro.Planet.showInfo;
import static astro.Moon.showInfo;
import static astro.astrotypes.PlanetAtmosphere.*;
import static astro.astrotypes.PlanetTypes.*;
import static astro.astrotypes.StarsClasses.*;
import static tech.objects.Colony.showInfo;
import static tech.objects.Station.showInfo;
import static tech.objects.TechObject.getLocation;
import static tech.objects.techtypes.ColoniesTypes.*;
import static tech.objects.techtypes.StationsTyps.*;
import static tech.ships.shipclasses.Ship.*;
import static tech.ships.shipsparameters.ShipClasses.*;

// V-ДОБАВИТЬ ПЕРЕЧИСЛЕНИЯ ДЛЯ ТИПОВ СТАНЦИЙ
// V-создать статический getLocation()
// V-инетрефейс Locationable
// настроить модификаторы доступа
// создать константы массы и размеров!
// создать интерфейсы астр. и тех. объектов!
// метод отображения информации об объектах
// подключить persistence
// создать отдельный класс для объявлений
// сделать отображение getObjectTYPE() для общего метода
/// СОЗДАТЬ КОНТРОЛЛЕР ДЛЯ УПРАВЛЕНИЯ ОБЪЕКТКАМИ, В КЛАССАХ ОБЪЕКТОВ ОСТАВИТЬ ТОЛЬКО ИХ СОБСТВЕННЫЕ ПОЛЯ И МЕТОДЫ

public class Main {
    public static void main(String[] args) {
        try {
            /*БЛОК ОБЪЯВЛЕНИЙ*/  ///ДОБАВИТЬ ФАБРИКУ ASTR/TECH OBJECTS /// В КОНТОРЛЛЕР
            // Объявление систем
            StarSystem solsys = new StarSystem("Sol");

            // Объявление звезд
            Star sol = new Star("Sol", G, 1, 1);
            sol.setStarParameters(6.5, 6500);

            // Объявление планет ///
            Planet mercury = new Planet("Mercury", Rock, None);
            mercury.setPlanetParameters(0.38, 2440, 3.72);
            Planet venus = new Planet("Venus", Titan_like, CO2);
            venus.setPlanetParameters(0.82, 6052, 8.87);
            Planet earth = new Planet("Earth", Terra_with_Life, O2);
            earth.setPlanetParameters(1, 6371, 9.8);
            Planet mars = new Planet("Mars", Metal, CO2);
            mars.setPlanetParameters(0.65, 3390, 3.71);

            // Объявление спутников
            Moon luna = new Moon("Luna", 0.25, 1737);
            luna.setLunarParameters(Rock, None, 30, 420, 0.23);
            Moon demos = new Moon("Demos", 0.15, 6);
            demos.setLunarParameters(Asteroid, None, 10, 100, 0.02);
            Moon fobos = new Moon("Fobos", 0.18, 11);
            fobos.setLunarParameters(Asteroid, None, 11, 110, 0.03);

            // Объявление станций
            Station iss = new Station("ISS", Science, 1999);
            Station marshorz = new Station("Mars Horizons", Hub, 2025);

            // Объявление колоний
            Colony gateway = new Colony("Gateway", Port, 2024);
            Colony ilonsport = new Colony("Ilonsport", Settlement, 2028);


            /*БЛОК ОПРЕДЕЛЕНИЯ ПРЕНАДЛЕЖНОСТИ*/ //СНАЧАЛА ОПРЕДЕЛЯЮТСЯ АСТР.ОБ СВЕРХУ ВНИЗ, ПОТОМ ТЕХ.ОБ
            solsys.addStars(sol);
            sol.addPlanets(mercury, venus, earth, mars);
            earth.addMoons(luna);
            mars.addMoons(demos, fobos);

            earth.addStations(iss);
            luna.addColonies(gateway);

            mars.addColonies(ilonsport);
            mars.addStations(marshorz);


            /*БЛОК УСТАНОВКИ ЛОКАЦИИ*/
            // Локации звезды
            sol.setLocation(solsys);
            // Локации планет
            mercury.setLocation(sol, solsys);
            venus.setLocation(sol, solsys);
            earth.setLocation(sol, solsys);
            mars.setLocation(sol, solsys);
            // Локации спутников
            luna.setLocation(earth, sol, solsys);
            demos.setLocation(mars, sol, solsys);
            fobos.setLocation(mars, sol, solsys);
            // Локации станций
            iss.setLocation(earth, sol, solsys);
            marshorz.setLocation(mars, sol, solsys);
            // Локации колоний
            gateway.setLocation(luna, earth, sol, solsys);
            ilonsport.setLocation(mars, sol, solsys);


            /*БЛОК СОЗДАНИЯ ЛИЧНОСТЕЙ*/
            //Pilot shepard = new Pilot("Shepard", 30, 5);


            ///*ACTION*///
            // Astro
            fullSystemInfo(solsys);


            // Tech
            /*shepard.sayGreet();
            Ship xenta = iss.shipyard.buildShip(ANACONDA);
            xenta.setShipNAME("Xenta");
            shepard.enterShip(xenta, shepard);
            shepard.tellAboutShip();
            ///В ОТДЕЛЬНЫЙ МЕТОД
            System.out.println("\nShip " + xenta.getShipNAME() + " info:");
            System.out.println("Type: " + getShipTYPE(xenta));
            System.out.println("Class: " + getShipCLASS(xenta));
            System.out.println("Size: " + getShipSIZE(xenta));*/
        }

        catch (NullPointerException exc) {
            System.out.println("Что-то не так");
            exc.printStackTrace();
        }
    }
}