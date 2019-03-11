package general;
import astro.*;
import tech.objects.*;
import static astro.astrotypes.PlanetAtmosphere.*;
import static astro.astrotypes.PlanetTypes.*;
import static astro.astrotypes.StarsClasses.*;
import static tech.objects.techtypes.ColoniesTypes.*;
import static tech.objects.techtypes.StationsTyps.*;
import static astro.Definable.fullSystemInfo;

/*
/// V-ДОБАВИТЬ ПЕРЕЧИСЛЕНИЯ ДЛЯ ТИПОВ СТАНЦИЙ
/// V-создать статический getLocation()
/// V-инетрефейс Definable
/// V-настроить модификаторы доступа
/// x-создать константы массы и размеров!
/// VV-создать интерфейсы астр. и тех. объектов!
/// VV-метод отображения информации об объектах
/// x-подключить persistence!
/// x-создать отдельный класс для объявлений!
/// V-сделать отображение getObjectTYPE() для общего метода
/// x-Создать контроллер для управления объектками
/// V-В классах объектов оставить только их собственные поля и методы
/// Сократить System.out.println;
*/

public class Main {
    public static void main(String[] args) {
        try {
            /// ДОБАВИТЬ Producer ASTRO/TECH OBJECTS
            /// ЛОГИКУ ОБЪЕКТОВ В КОНТОРЛЛЕР!
            /// ОБЪЕКТЫ В БД!
            ///! УЛУЧШИТЬ И ОПТИМИЗИРОВАТЬ ЛОГИКУ
            /*БЛОК ОБЪЯВЛЕНИЙ*/
            // Объявление систем
            StarSystem solsys = new StarSystem("Solar System");

            ///!
            // Объявление звезд
            Star sol = new Star("Sol", G, 1, 1);
            sol.setStarParameters(6.5, 6500);

            ///!
            // Объявление планет
            Planet mercury = new Planet("Mercury", Rock, None);
            mercury.setPlanetParameters(0.38, 2440, 3.72);

            Planet venus = new Planet("Venus", TitanLike, CO2);
            venus.setPlanetParameters(0.82, 6052, 8.87);

            Planet earth = new Planet("Earth", TerraWithLife, O2);
            earth.setPlanetParameters(1, 6371, 9.8);

            Planet mars = new Planet("Mars", Metal, CO2);
            mars.setPlanetParameters(0.65, 3390, 3.71);

            Planet jupiter = new Planet("Jupiter");
            Planet saturn = new Planet("Saturn");
            Planet uranus = new Planet("Uranus");
            Planet neptune = new Planet("Neptune");

            ///!
            // Объявление спутников
            Moon luna = new Moon("Luna", 0.25, 1737.0);
            luna.setLunarParameters(Rock, None, 30.0, 420.0, 0.23);

            Moon demos = new Moon("Demos", 0.15, 6.0);
            demos.setLunarParameters(Asteroid, None, 10.0, 100.0, 0.02);
            Moon fobos = new Moon("Fobos", 0.18, 11.0);
            fobos.setLunarParameters(Asteroid, None, 11.6, 110.0, 0.03);

            Moon io = new Moon("Io");
            Moon europa = new Moon("Europa");
            Moon ganymede  = new Moon("Ganymede");
            Moon callisto = new Moon("Callisto");

            Moon titan = new Moon("Titan");
            Moon umbriel = new Moon("Umbriel");
            Moon miranda = new Moon("Miranda");
            Moon triton = new Moon("Triton");

            ///!
            // Объявление станций
            Station iss = new Station("ISS", Science, 1999);
            Station marsvalley = new Station("Mars Horizons", Hub, 2025);

            ///!
            // Объявление колоний
            Colony gateway = new Colony("Gateway", Port, 2024);
            Colony ilon = new Colony("Ilon", Capital, 2028);


            /*БЛОК УСТАНОВКИ ИЕРАРХИИ*/  ///!
            /// АВТОМАТИЧЕСКИ устанавливать ЛОКАЦИЮ к звезде, палнете, спутнику
            /// СОКРАТИТЬ
            // Сперва по иерархии определеятся ASTRO, затем TECH
            {
                solsys.addStars(
                        sol
                );
                sol.addPlanets(
                        mercury,
                        venus,
                        earth,
                        mars,
                        jupiter,
                        saturn,
                        uranus,
                        neptune
                );
                // Для планет
                earth.addMoons(
                        luna
                );
                earth.addStations(
                        iss
                );
                mars.addMoons(
                        demos,
                        fobos
                );
                mars.addColonies(
                        ilon
                );
                mars.addStations(
                        marsvalley
                );
                jupiter.addMoons(
                        io,
                        europa,
                        ganymede,
                        callisto
                );
                saturn.addMoons(
                        titan
                );
                uranus.addMoons(
                        umbriel,
                        miranda
                );
                neptune.addMoons(
                        triton
                );
                {
                    // Для спутников
                    luna.addColonies(
                            gateway
                    );
                }
            }

            ///!
            /*БЛОК УСТАНОВКИ ЛОКАЦИИ*/
            {
                // Локации звезды
                sol.setLocation(
                        solsys
                );
                // Локации планет
                mercury.setLocation(
                        sol,
                        solsys
                );
                venus.setLocation(
                        sol,
                        solsys
                );
                earth.setLocation(
                        sol,
                        solsys
                );
                mars.setLocation(
                        sol,
                        solsys
                );
                jupiter.setLocation(
                        sol,
                        solsys
                );
                saturn.setLocation(
                        sol,
                        solsys
                );
                uranus.setLocation(
                        sol,
                        solsys
                );
                neptune.setLocation(
                        sol,
                        solsys
                );
                {
                    // Локации спутников
                    luna.setLocation(
                            earth,
                            sol,
                            solsys
                    );
                    demos.setLocation(
                            mars,
                            sol,
                            solsys
                    );
                    fobos.setLocation(
                            mars,
                            sol,
                            solsys
                    );
                    {
                        // Локации станций
                        iss.setLocation(
                                earth,
                                sol,
                                solsys
                        );
                        marsvalley.setLocation(
                                mars,
                                sol,
                                solsys
                        );
                        {
                            // Локации колоний
                            gateway.setLocation(
                                    luna,
                                    earth,
                                    sol,
                                    solsys
                            );
                            ilon.setLocation(
                                    mars,
                                    sol,
                                    solsys
                            );
                        }
                    }
                }
            }
            ///*ACTION*///
            fullSystemInfo(solsys);


            ///*END-ACTION*///
            /*
            // БЛОК PERSON
            Pilot shepard = new Pilot("Shepard", 30, 5);
            // Tech
            shepard.sayGreet();
            Ship xenta = iss.shipyard.buildShip(ANACONDA);
            xenta.setShipNAME("Xenta");
            shepard.enterShip(xenta, shepard);
            shepard.tellAboutShip();
            ///В ОТДЕЛЬНЫЙ МЕТОД
            System.out.println("\nShip " + xenta.getShipNAME() + " info:");
            System.out.println("Type: " + getShipTYPE(xenta));
            System.out.println("Class: " + getShipCLASS(xenta));
            System.out.println("Size: " + getShipSIZE(xenta));
            */
        }
        catch (NullPointerException exc) {
            System.out.println("Что-то не так");
            exc.printStackTrace();
        }
    }
}