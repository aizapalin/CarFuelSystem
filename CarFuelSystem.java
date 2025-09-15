public class CarFuelSystem {
    // Private attributes (Encapsulation)
    private double fuelCapacity;
    private double currentFuel;
    private double fuelEfficiency; // km per liter

    // Constructor
    public CarFuelSystem(double fuelCapacity, double fuelEfficiency) {
        if (fuelCapacity <= 0 || fuelEfficiency <= 0) {
            throw new IllegalArgumentException("Capacity and efficiency must be positive values.");
        }
        this.fuelCapacity = fuelCapacity;
        this.fuelEfficiency = fuelEfficiency;
        this.currentFuel = 0; // starts empty
    }

    // Add fuel to the tank
    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Invalid input! Refuel amount must be greater than zero.");
            return;
        }
        if (currentFuel + liters > fuelCapacity) {
            System.out.println("Tank overflow! Filling up to maximum capacity.");
            currentFuel = fuelCapacity;
        } else {
            currentFuel += liters;
            System.out.println("Refueled: " + liters + "L");
        }
        System.out.println("Current fuel: " + String.format("%.2f", currentFuel) + "L");
    }

    // Drive a certain distance
    public void drive(double distance) {
        if (distance <= 0) {
            System.out.println("Invalid distance! Must be greater than zero.");
            return;
        }
        double fuelNeeded = distance / fuelEfficiency;
        if (fuelNeeded <= currentFuel) {
            currentFuel -= fuelNeeded;
            System.out.println("Driving " + distance + " km...");
            System.out.println("Fuel left: " + String.format("%.2f", currentFuel) + "L");
        } else {
            double possibleDistance = currentFuel * fuelEfficiency;
            System.out.println("Not enough fuel! You drove " 
                               + String.format("%.2f", possibleDistance) 
                               + " km until tank emptied.");
            currentFuel = 0;
            System.out.println("Fuel left: 0L");
        }
    }

    // Getter for current fuel
    public double getCurrentFuel() {
        return currentFuel;
    }

    // Check if the car can drive a distance
    public boolean canDrive(double distance) {
        return (distance / fuelEfficiency) <= currentFuel;
    }

    // Estimate possible range with current fuel
    public double estimateRange() {
        return currentFuel * fuelEfficiency;
    }

    
}
