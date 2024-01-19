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

    public PassengerCar(int capacity, int numberOfPassengers) {
        super(capacity);
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
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

    public Train(Locomotive locomotive, Car[] cars) {
        this.locomotive = locomotive;
        this.cars = cars;
    }

    public int calculateTotalCapacity() {
        int totalCapacity = locomotive.getPower();

        for (Car car : cars) {
            totalCapacity += car.getCapacity();
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
        PassengerCar passengerCar1 = new PassengerCar(50, 30);
        PassengerCar passengerCar2 = new PassengerCar(40, 25);
        FreightCar freightCar1 = new FreightCar(100);
        FreightCar freightCar2 = new FreightCar(150);

        Train train = new Train(locomotive, new Car[]{passengerCar1, passengerCar2, freightCar1, freightCar2});

        System.out.println("Total Capacity of the Train: " + train.calculateTotalCapacity());
        System.out.println("Total Passenger Count in the Train: " + train.calculatePassengerCount());
        System.out.println("Total Freight Weight in the Train: " + train.calculateFreightWeight());
    }
}
