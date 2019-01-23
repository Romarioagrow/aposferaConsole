package tech.ships.shipclasses;
import persons.Pilot;
import tech.ships.shipsparameters.*;
import java.util.LinkedList;

public class Ship {
    protected String shipNAME;

    protected static Enum<ShipClasses> shipCLASS;
    protected static Enum<ShipType> shipTYPE;
    protected static Enum<ShipSize> shipSIZE;

    protected int hullIntegrity, jumpRange, speedMax, cargoMax, fuelTank; /// НЕ СТАТИК!
    protected short pilotesMAX, slots;

    public LinkedList<Pilot> pilots= new LinkedList<Pilot> ();

    protected void lockTarget() {}
    protected void flyTO() {}
    protected void jumpTO() {}
    protected void reFuel() {}

    public String getShipNAME() {
        return shipNAME;
    }
    public void setShipNAME(String shipNAME) {
        this.shipNAME = shipNAME;
    }

    public static Enum<ShipType> getShipTYPE(Ship ship) {
        return ship.shipTYPE;
    }
    public static Enum<ShipClasses> getShipCLASS(Ship ship) {
        return ship.shipCLASS;
    }
    public static Enum<ShipSize> getShipSIZE(Ship ship) {
        return ship.shipSIZE;
    }

    public int getFuelTank() {
        return fuelTank;
    }
    public int getSpeedMaxd() {
        return speedMax;
    }
    public int getJumpRange() {
        return jumpRange;
    }
    public int getcargoMax() {
        return cargoMax;
    }
    public int getHullIntegrity() {
        return hullIntegrity;
    }
    public int getSlots() {
        return slots;
    }
    public short getPilotesMAX() {
        return pilotesMAX;
    }

}
