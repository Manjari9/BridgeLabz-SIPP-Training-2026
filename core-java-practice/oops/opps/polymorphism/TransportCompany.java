//1.A transport company manages a fleet: Vehicle[] containing Car, Bus, Bike objects. 
// Call fuelCost(km) on each - each type calculates differently.
//  Use instanceof before casting. Add a new ElectricCar without changing existing code (open/closed principle preview).
abstract class Vehicle {
    public abstract double fuelCost(double km);
}

class Car extends Vehicle {
    @Override
    public double fuelCost(double km) {
        return km * 0.12;
    }

    public void carInfo() {
        System.out.println("This is a Car.");
    }
}

class Bus extends Vehicle {
    @Override
    public double fuelCost(double km) {
        return km * 0.35;
    }

    public void busInfo() {
        System.out.println("This is a Bus.");
    }
}

class Bike extends Vehicle {
    @Override
    public double fuelCost(double km) {
        return km * 0.08;
    }

    public void bikeInfo() {
        System.out.println("This is a Bike.");
    }
}

class ElectricCar extends Vehicle {
    @Override
    public double fuelCost(double km) {
        return km * 0.05;
    }

    public void electricInfo() {
        System.out.println("This is an Electric Car.");
    }
}

public class TransportCompany {

    public static void main(String[] args) {

        Vehicle[] fleet = {
            new Car(),
            new Bus(),
            new Bike(),
            new ElectricCar()
        };

        double distance = 100.0;

        for (Vehicle vehicle : fleet) {

            // Runtime Polymorphism
            System.out.println("Fuel cost for " + distance +
                    " km = " + vehicle.fuelCost(distance));

            // Using instanceof before casting
            if (vehicle instanceof Car) {
                Car c = (Car) vehicle;
                c.carInfo();
            } else if (vehicle instanceof Bus) {
                Bus b = (Bus) vehicle;
                b.busInfo();
            } else if (vehicle instanceof Bike) {
                Bike bk = (Bike) vehicle;
                bk.bikeInfo();
            } else if (vehicle instanceof ElectricCar) {
                ElectricCar ec = (ElectricCar) vehicle;
                ec.electricInfo();
            }

            System.out.println();
        }
    }
}


