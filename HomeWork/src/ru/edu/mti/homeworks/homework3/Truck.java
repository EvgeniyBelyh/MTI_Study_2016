package ru.edu.mti.homeworks.homework3;

/**
 * Класс грузового автомобиля
 * @author Белых Евгений
 *
 */
public class Truck extends Car{
	
	private double height; //высота грузовика
	private double weight; //грузоподьемность
	private boolean trailer; //наличие прицепа
	
	//конструкторы
	public Truck() {
		this(60.0, false, "Default truck", 3.0, 10.0, false);
	}

	public Truck(double speed, boolean special, String name, double height, 
			double weight, boolean trailer) {
		super(speed, special, name);
		this.height = height;
		this.weight = weight;
		this.trailer = trailer;
	}
	
	//геттеры и сеттеры полей
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public boolean isTrailer() {
		return trailer;
	}

	public void setTrailer(boolean trailer) {
		this.trailer = trailer;
	}

	/**
	 * Переопределяем метод toString для вывода инфомрации об авто
	 */
	public String toString() {
		return ("\nАвтомобиль " + this.getName() + (this.isSpecial() ? " " : " не ") +
				"является спец. техникой, двигается со скоростью " + this.getSpeed() + 
				" км/ч. Высота " + this.height + " м., грузоподьемность " + this.weight +
				" тонн, " + (this.trailer ? "с прицепом." : "без прицепа."));
	}
	
}
