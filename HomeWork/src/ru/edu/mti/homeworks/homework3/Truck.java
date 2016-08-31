package ru.edu.mti.homeworks.homework3;

/**
 * ����� ��������� ����������
 * @author ����� �������
 *
 */
public class Truck extends Car{
	
	private double height; //������ ���������
	private double weight; //����������������
	private boolean trailer; //������� �������
	
	//������������
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
	
	//������� � ������� �����
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
	 * �������������� ����� toString ��� ������ ���������� �� ����
	 */
	public String toString() {
		return ("\n���������� " + this.getName() + (this.isSpecial() ? " " : " �� ") +
				"�������� ����. ��������, ��������� �� ��������� " + this.getSpeed() + 
				" ��/�. ������ " + this.height + " �., ���������������� " + this.weight +
				" ����, " + (this.trailer ? "� ��������." : "��� �������."));
	}
	
}
