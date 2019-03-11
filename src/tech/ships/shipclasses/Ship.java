package tech.ships.shipclasses;
/*import persons.Pilot;*/
import tech.ships.shipsparameters.*;

public class Ship {
    protected String shipNAME;
    protected static Enum<ShipClasses> shipCLASS;
    static Enum<ShipType> shipTYPE;
    protected static Enum<ShipSize> shipSIZE;
    protected Integer hullIntegrity, jumpRange, speedMax, cargoMax, fuelTank; /// НЕ СТАТИК!
    protected Short pilotsMAX, slots;

    /*public LinkedList<Pilot> pilots= new LinkedList<Pilot> ();*/

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
        return shipTYPE;
    }
    public static Enum<ShipClasses> getShipCLASS(Ship ship) {
        return shipCLASS;
    }
    public static Enum<ShipSize> getShipSIZE(Ship ship) {
        return shipSIZE;
    }
    public Integer getFuelTank() {
        return fuelTank;
    }
    public Integer getSpeedMax() {
        return speedMax;
    }
    public Integer getJumpRange() {
        return jumpRange;
    }
    public Integer getcargoMax() {
        return cargoMax;
    }
    public Integer getHullIntegrity() {
        return hullIntegrity;
    }
    public Short getSlots() {
        return slots;
    }
    public Short getPilotsMAX() {
        return pilotsMAX;
    }
}
