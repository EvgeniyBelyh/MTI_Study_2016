package ru.edu.mti.homeworks.homework3;

/**
 * Класс легкового автомобиля
 * @author Белых Евгений
 *
 */
public class Car {
	private double speed; //скорость автомобиля
	private boolean special; //флаг спец. транспорта
	private String name; //наименование
	
	//конструкторы
	public Car() {
		this(60.0, false, "Default car");
	}
	
	public Car(double speed, boolean special, String name) {
		this.speed = speed;
		this.special = special;
		this.name = name;
	}
	
	//геттеры и сеттеры полей
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Переопределяем метод toString для вывода инфомрации об авто
	 */
	public String toString() {
		return ("\nАвтомобиль " + this.name + (this.special ? " " : " не ") +
				"является спец. техникой, двигается со скоростью " + this.speed + " км/ч");
	}

}
