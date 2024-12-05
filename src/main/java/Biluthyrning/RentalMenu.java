package Biluthyrning;

import java.util.ArrayList;
import java.util.Scanner;

public class RentalMenu {
    private ArrayList <Vehicle> vehicles;

    public RentalMenu() {
        vehicles = new ArrayList<>();
        vehicleMenu();

    }
    public void vehicleMenu() {
        vehicles.add(new Car("Nissan Skyline", "ABC123", 1200, 4));
        vehicles.add(new SUV("Volvo XC90", "BCD234", 800,  "Gas"));
        vehicles.add(new Truck("Volvo VNL", "CDE345", 1000, 116450));
        vehicles.add(new Convertible("Mazda MX-5", "DEF456", 700, 1100));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n - Rental Menu - ");
            System.out.println("1. View Vehicles");
            System.out.println("2. Rent Vehicle");
            System.out.println("3. Return Vehicle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {listVehicles();
                    System.out.println("Press enter to return to the menu...");
                    scanner.nextLine();
                }
                case 2 -> rentVehicle(scanner);
                case 3 -> returnVehicle(scanner);
                case 4 -> {
                    System.out.println("Exiting. Thank you!");
                    running = false;
                }
                default -> System.out.println("Invalid input. Try again.");
            }
        }
        scanner.close();
    }

    private void listVehicles() {
        System.out.println("\nVehicles: ");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getModel() + " (" + vehicle.getRegistrationNumber() + "): "
                    + vehicle.getDetails() + " - "
                    + (vehicle.isAvailable() ? "Available" : "Rented"));
        }
    }

    private void rentVehicle(Scanner scanner) {
        System.out.println("Enter the registration number for the vehicle you want to rent: ");
        String registrationNumber = scanner.nextLine();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                if (vehicle.isAvailable()){
                    vehicle.rentVehicle();
                } else {
                    System.out.println("This vehicle is already rented. ");
                }
                return;
            }
        }
        System.out.println("Vehicle not found");
    }

    private void returnVehicle(Scanner scanner) {
        System.out.println("Enter the registration number for the vehicle you want to return: ");
        String registrationNumber = scanner.nextLine();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                if (!vehicle.isAvailable()){
                    vehicle.returnVehicle();
                    System.out.println("The cost of renting " + vehicle.getModel() + " was " + vehicle.calculateCost(1) + " SEK ");
                } else {
                    System.out.println("This vehicle was not rented. ");
                }
                return;
            }
        }
        System.out.println("Vehicle not found");
    }
}