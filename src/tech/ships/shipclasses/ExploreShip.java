package tech.ships.shipclasses;
import tech.ships.shipsparameters.ShipType;

public abstract class ExploreShip extends Ship {
    static {
        shipTYPE = ShipType.EXPLORE;
    }

    public void scan() {
        System.out.println("Nothing to scan");
    }
}
