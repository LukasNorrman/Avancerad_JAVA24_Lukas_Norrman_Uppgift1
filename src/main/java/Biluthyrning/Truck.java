package Biluthyrning;

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String model, String registrationNumber, double pricePerDay, double loadCapacity) {
        super(model, registrationNumber, pricePerDay);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String getDetails() {
        return "load Capacity: " + loadCapacity + " kilos";
    }
}