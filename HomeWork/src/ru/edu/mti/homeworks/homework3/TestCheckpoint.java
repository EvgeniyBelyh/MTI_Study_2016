package ru.edu.mti.homeworks.homework3;

import java.util.ArrayList;

/**
 * ���� ������ ����������-����������� ������
 * @author ����� �������
 *
 */
public class TestCheckpoint {

	public static void main(String[] args) {
		
		//��������� ����
		System.out.println("��������� ���� ����������� ����� ����� ���");
		
		//������ ������ ������
		Car ambulance = new Car(70.0, true, "������ ������");
		//������ � ������� ���������
		Car goodDriver = new Car(65.0, false, "������� ��������");
		//������ ����������
		Car offender = new Car(95.0, false, "����������");
		//������ ��������� ����������
		Car violator = new Car(200.0, false, "�������� ����������");
		
		
		//�������� ������ � ����������� ��������
		Truck fireTruck = new Truck(100.0, true, "�������� ������ � ����������� ��������", 
				3.5, 5.0, false);
		//��������������� ��������
		Truck goodTruck = new Truck(70.0, false, "������� ��������", 4.0, 9.0, false);
		//��������������� �������� � ��������
		Truck goodTrailer = new Truck(65.0, false, "������� �������� � ��������", 3.5, 9.0, true);
		//�������� � ����������
		Truck overweightTruck = new Truck(65.0, false, "�������� � ����������", 3.5, 15.0, false);
		//�������� � ������� ���� �����
		Truck overheightTruck = new Truck(50.0, false, "������� ������� ��������", 4.5, 9.0, false);
				
		//������� ������ ���		
		Checkpoint checkpoint = new Checkpoint();
		//������� ��������� �������� �����
		ArrayList<Car> arrayList = new ArrayList<Car>();
		
		//��������� ������ ��������� Car
		arrayList.add(ambulance);
		arrayList.add(goodDriver);
		arrayList.add(offender);
		arrayList.add(violator);
		arrayList.add(fireTruck);
		arrayList.add(goodTruck);
		arrayList.add(goodTrailer);
		arrayList.add(overweightTruck);
		arrayList.add(overheightTruck);
		
		//���� �� ����� ������� � ��������� ������ ������ �� ���
		for (Car car : arrayList) {
			try {
				//��������� ������ �� ���
				checkpoint.checkIn(car);
			//������������ ������ ���������� ������ ���������
			} catch (InvalidHeightException e) {
				System.out.println(e.toString());
				continue;
				//������������ ������ ���������� ��������
			} catch (OverspeedException e) {
				System.out.println(e.toString());
				continue;
			}
			
		}
		
		//��������� ����
		System.out.println("\n���� ������� ��������");
		
	}

}
