package kz.aitu.oop.practice.practice2;

// Класс "Пассажирский вагон", наследуется от базового класса "Вагон"
public class PassengerCar extends Car {
    private int numberOfPassengers; // Количество пассажиров

    // Конструктор для инициализации грузоподъемности и количества пассажиров
    public PassengerCar(int capacity, int numberOfPassengers) {
        super(capacity);
        this.numberOfPassengers = numberOfPassengers;
    }

    // Метод для получения количества пассажиров
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
}


