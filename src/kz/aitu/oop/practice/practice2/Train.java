package kz.aitu.oop.practice.practice2;

// Класс "Поезд", использующий композицию вагонов и локомотива
public class Train {
    private Locomotive locomotive; // Локомотив поезда
    private Car[] cars; // Массив вагонов

    // Конструктор для создания поезда с заданным локомотивом и массивом вагонов
    public Train(Locomotive locomotive, Car[] cars) {
        this.locomotive = locomotive;
        this.cars = cars;
    }

    // Метод для подсчета общей грузоподъемности поезда
    public int calculateTotalCapacity() {
        int totalCapacity = locomotive.getPower(); // Грузоподъемность локомотива

        for (Car car : cars) {
            totalCapacity += car.getCapacity(); // Грузоподъемность каждого вагона
        }

        return totalCapacity;
    }

    // Метод для подсчета общего количества пассажиров в поезде
    public int calculatePassengerCount() {
        int passengerCount = 0;

        for (Car car : cars) {
            if (car instanceof PassengerCar) {
                passengerCount += ((PassengerCar) car).getNumberOfPassengers();
            }
        }

        return passengerCount;
    }

    // Метод для подсчета общего веса груза в поезде
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


