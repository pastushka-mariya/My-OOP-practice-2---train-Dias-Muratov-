package firstcode;

import java.util.Scanner;

class Car {
    private int capacity;

    public Car(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

class PassengerCar extends Car {
    private int numberOfPassengers;
    private int maxPassengerCapacity;
    private String[] passengerInfo;

    public PassengerCar(int capacity, int maxPassengerCapacity) {
        super(capacity);
        this.maxPassengerCapacity = maxPassengerCapacity;
        this.passengerInfo = new String[maxPassengerCapacity];
        this.numberOfPassengers = 0;
    }

    public void addPassengerInfo(String info) {
        if (numberOfPassengers < maxPassengerCapacity) {
            passengerInfo[numberOfPassengers++] = info;
        } else {
            System.out.println("Maximum passenger capacity reached for this car.");
        }
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void displayPassengerInfo() {
        System.out.println("Passenger Information:");
        for (String info : passengerInfo) {
            if (info != null) {
                System.out.println(info);
            }
        }
    }
}

class FreightCar extends Car {
    public FreightCar(int capacity) {
        super(capacity);
    }
}

class Locomotive {
    private int power;

    public Locomotive(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}

class Train {
    private Locomotive locomotive;
    private Car[] cars;
    private int maxPassengerCars;
    private int maxFreightCars;
    private int passengerCarCount;
    private int freightCarCount;

    public Train(Locomotive locomotive, int maxPassengerCars, int maxFreightCars) {
        this.locomotive = locomotive;
        this.maxPassengerCars = maxPassengerCars;
        this.maxFreightCars = maxFreightCars;
        this.cars = new Car[maxPassengerCars + maxFreightCars];
        this.passengerCarCount = 0;
        this.freightCarCount = 0;
    }

    public void addPassengerCar(PassengerCar passengerCar) {
        if (passengerCarCount < maxPassengerCars) {
            cars[passengerCarCount++] = passengerCar;
        } else {
            System.out.println("Maximum passenger cars reached for this train.");
        }
    }

    public void addFreightCar(FreightCar freightCar) {
        if (freightCarCount < maxFreightCars) {
            cars[maxPassengerCars + freightCarCount++] = freightCar;
        } else {
            System.out.println("Maximum freight cars reached for this train.");
        }
    }

    public int calculateTotalCapacity() {
        int totalCapacity = locomotive.getPower();

        for (Car car : cars) {
            if (car != null) {
                totalCapacity += car.getCapacity();
            }
        }

        return totalCapacity;
    }

    public int calculatePassengerCount() {
        int passengerCount = 0;

        for (Car car : cars) {
            if (car instanceof PassengerCar) {
                passengerCount += ((PassengerCar) car).getNumberOfPassengers();
            }
        }

        return passengerCount;
    }

    public int calculateFreightWeight() {
        int freightWeight = 0;

        for (Car car : cars) {
            if (car instanceof FreightCar) {
                freightWeight += car.getCapacity();
            }
        }

        return freightWeight;
    }
}

public class Main {
    public static void main(String[] args) {
        Locomotive locomotive = new Locomotive(500);
        PassengerCar passengerCar1 = new PassengerCar(50, 3);
        PassengerCar passengerCar2 = new PassengerCar(40, 2);
        FreightCar freightCar1 = new FreightCar(100);
        FreightCar freightCar2 = new FreightCar(150);

        Train train = new Train(locomotive, 5, 3);

        train.addPassengerCar(passengerCar1);
        train.addPassengerCar(passengerCar2);
        train.addFreightCar(freightCar1);
        train.addFreightCar(freightCar2);

        System.out.println("Total Capacity of the Train: " + train.calculateTotalCapacity());
        System.out.println("Total Passenger Count in the Train: " + train.calculatePassengerCount());
        System.out.println("Total Freight Weight in the Train: " + train.calculateFreightWeight());

        passengerCar1.addPassengerInfo("John, 25, Male, From A to B");
        passengerCar1.addPassengerInfo("Anna, 30, Female, From B to C");

        passengerCar1.displayPassengerInfo();
    }
}
