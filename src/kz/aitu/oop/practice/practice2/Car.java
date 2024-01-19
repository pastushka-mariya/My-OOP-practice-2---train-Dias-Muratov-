package kz.aitu.oop.practice.practice2;

// Определение базового класса "Вагон"
public class Car {
    private int capacity; // Грузоподъемность вагона

    // Конструктор для инициализации грузоподъемности вагона
    public Car(int capacity) {
        this.capacity = capacity;
    }

    // Геттер для получения грузоподъемности
    public int getCapacity() {
        return capacity;
    }
}


