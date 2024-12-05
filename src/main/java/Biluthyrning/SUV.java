package Biluthyrning;

public class SUV extends Vehicle {
    private String fuelType;

    public SUV(String model, String registrationNumber, double pricePerDay, String fuelType) {
        super(model, registrationNumber, pricePerDay);
        this.fuelType = fuelType;
    }

    @Override
    public String getDetails() {
        return "Type of fuel: " + fuelType;
    }
}