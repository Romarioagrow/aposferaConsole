package tech.ships.ships;
import tech.ships.shipclasses.ExploreShip;
import tech.ships.shipsparameters.*;

public class Anaconda extends ExploreShip {
    public Anaconda() {
        shipCLASS = ShipClasses.ANACONDA;
        shipSIZE = ShipSize.L;
        this.pilotsMAX = 3;

        this.hullIntegrity = 500; // HP
        this.speedMax = 220; // m/s
        this.slots = 10;
        this.cargoMax = 10; // Tons
        this.fuelTank = 32; // Tons

        this.jumpRange = 25; // Light years
    }

    //public Anaconda() {}/// MAKE PRIVATE
    private Anaconda(String name) { /// MAKE PRIVATE!
        this.shipNAME = name;
    }
}
