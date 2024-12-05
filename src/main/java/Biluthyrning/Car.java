package Biluthyrning;

public class Car extends Vehicle {
    private int doors;

    public Car(String model, String registrationNumber, double pricePerDay, int doors) {
        super(model, registrationNumber, pricePerDay);
        this.doors = doors;
    }

    @Override
    public String getDetails() {
        return "Amount of doors: " + doors;
    }
}