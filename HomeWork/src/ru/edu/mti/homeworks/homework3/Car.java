package ru.edu.mti.homeworks.homework3;

/**
 * ����� ��������� ����������
 * @author ����� �������
 *
 */
public class Car {
	private double speed; //�������� ����������
	private boolean special; //���� ����. ����������
	private String name; //������������
	
	//������������
	public Car() {
		this(60.0, false, "Default car");
	}
	
	public Car(double speed, boolean special, String name) {
		this.speed = speed;
		this.special = special;
		this.name = name;
	}
	
	//������� � ������� �����
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
	 * �������������� ����� toString ��� ������ ���������� �� ����
	 */
	public String toString() {
		return ("\n���������� " + this.name + (this.special ? " " : " �� ") +
				"�������� ����. ��������, ��������� �� ��������� " + this.speed + " ��/�");
	}

}
