package kz.aitu.oop.practice.practice2;

// Основной класс
public class Main {
    public static void main(String[] args) {
        // Создаем объекты: локомотив, пассажирский вагон, грузовой вагон
        Locomotive locomotive = new Locomotive(500); // Мощность локомотива 500
        PassengerCar passengerCar1 = new PassengerCar(50, 30); // Грузоподъемность 50, 30 пассажиров
        PassengerCar passengerCar2 = new PassengerCar(40, 25); // Грузоподъемность 40, 25 пассажиров
        FreightCar freightCar1 = new FreightCar(100); // Грузоподъемность 100
        FreightCar freightCar2 = new FreightCar(150); // Грузоподъемность 150

        // Создаем поезд с локомотивом и вагонами
        Train train = new Train(locomotive, new Car[]{passengerCar1, passengerCar2, freightCar1, freightCar2});

        // Выводим общую грузоподъемность поезда
        System.out.println("Total Capacity of the Train: " + train.calculateTotalCapacity());

        // Выводим общее количество пассажиров в поезде
        System.out.println("Total Passenger Count in the Train: " + train.calculatePassengerCount());

        // Выводим общий вес груза в поезде
        System.out.println("Total Freight Weight in the Train: " + train.calculateFreightWeight());
    }
}


