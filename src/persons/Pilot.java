/*package persons;
import tech.ships.shipclasses.Ship;
import java.util.ArrayList;
public class Pilot extends Person {
    private int exp;
    public Pilot (String name, int age, int exp) {
        super(name, age);
        this.exp = exp;
    }
    private ArrayList<Ship> currentShip = new ArrayList<Ship>();
    public void tellAboutShip() {
        if (currentShip.size() == 0) {
            System.out.println("I dont have any ship!");
        } else {
             for (Ship ship : currentShip) {
                 System.out.println("\nPilot " + getPersonNAME() + "`s ship is " + ship.getShipNAME());
                 return;
             }
        }
    }
    public void sayGreet() {
        System.out.println("\nHi, this is your pilot " + getPersonNAME() + ", get ready to fly!\n");
    }
    public void enterShip (Ship ship, Pilot pilot) {
        this.currentShip.add(ship);
        ship.pilots.add(pilot);
        System.out.println("The ship " + ship.getShipNAME() + " is under pilot " + pilot.getPersonNAME() + " control now");
    }
}*/
