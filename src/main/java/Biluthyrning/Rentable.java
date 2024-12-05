package Biluthyrning;

public interface Rentable {
    void rentVehicle();
    void returnVehicle();
    double calculateCost(int days);
}
