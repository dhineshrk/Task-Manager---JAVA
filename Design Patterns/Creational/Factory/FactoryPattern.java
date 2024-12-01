// Product Interface
interface Vehicle {
    void drive();
}

// Concrete Products
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike.");
    }
}

// Factory
class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            default:
                System.out.println("Error: Unknown vehicle type.");
                return null;
        }
    }
}

// Client Code
public class FactoryPattern {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.createVehicle("car");
        if (car != null) car.drive(); // Output: Driving a car.

        Vehicle bike = VehicleFactory.createVehicle("bike");
        if (bike != null) bike.drive(); // Output: Riding a bike.
    }
}
