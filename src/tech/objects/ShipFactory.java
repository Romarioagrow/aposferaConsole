package tech.objects;
import tech.ships.shipclasses.Ship;
import tech.ships.ships.Anaconda;
import tech.ships.shipsparameters.ShipClasses;

public class ShipFactory {
    public Ship buildShip(ShipClasses type) throws NullPointerException { ///ДОБАВИТЬ NAME В ФАБРИКУ
        switch (type) {
            case ANACONDA:
                return new Anaconda();
            default:
                System.out.println("Type is missing");
                return null;
        }
    }

    public void buyShip() {}
}
