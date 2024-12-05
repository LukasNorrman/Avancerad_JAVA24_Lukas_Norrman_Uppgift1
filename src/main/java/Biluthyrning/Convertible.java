package Biluthyrning;

public class Convertible extends Vehicle {
    private int weight;

    public Convertible(String model, String registrationNumber, double pricePerDay, int weight) {
        super(model, registrationNumber, pricePerDay);
        this.weight = weight;
    }

    @Override
    public String getDetails() {
        return "Weight of vehicle: " + weight + " kg";
    }
}