package Biluthyrning;

abstract class Vehicle implements Rentable{
    private String model;
    private String registrationNumber;
    private double pricePerDay;
    private boolean available;


    public Vehicle(String model, String registrationNumber, double pricePerDay) {
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.pricePerDay = pricePerDay;
        this.available = true; // alla fordon är available i början
    }


    public void rentVehicle() {
        if (isAvailable()) {
            setAvailable(false);
            System.out.println(getModel() + " has been rented. ");
        } else {
            System.out.println(getModel() + " is already rented. ");
        }
    }


    public void returnVehicle() {
        if (!isAvailable()) {
            setAvailable(true);
            System.out.println(getModel() + " has been returned. ");
        } else {
            System.out.println(getModel() + " was not rented. ");
        }

    }


    public double calculateCost(int days) {
        return pricePerDay * days;
    }

    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract String getDetails();

}