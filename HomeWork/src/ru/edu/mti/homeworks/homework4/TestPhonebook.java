package ru.edu.mti.homeworks.homework4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * ���� ����������� �����������
 * @author ����� �������
 *
 */
public class TestPhonebook {

	public static void main(String[] args) {
		/* ������� � ���������� ����� 100 000 ���������.
		 * � ������� �������� 10 ��������� ���������.
		 * ����� ��� ������ 1 000 000 ���������.
		 */
		Phonebook phonebook = new Phonebook(100000);
		//��������� ����� ������
		System.out.println("\n��������� ����� ������");
		//�������� �����
		Long startTime = System.currentTimeMillis();
		//������� ��������� ������
		System.out.println(phonebook.reverseSearchInList());
		System.out.println("����������� �����: " + Math.round(((System.currentTimeMillis() - startTime) / 1000)) + " ���.");
		
		//��������� ����� �������
		System.out.println("\n��������� ����� �������");
		//�������� �����
		startTime = System.currentTimeMillis();
		//������� ��������� ������
		System.out.println(phonebook.reverseSearchInArray());
		System.out.println("����������� �����: " + Math.round(((System.currentTimeMillis() - startTime) / 1000)) + " ���.");
		
		//��������� ����� ���������
		System.out.println("\n��������� ����� ���������");
		//�������� �����
		startTime = System.currentTimeMillis();
		//������� ��������� ������
		System.out.println(phonebook.reverseSearchInSet());
		System.out.println("����������� �����: " + Math.round(((System.currentTimeMillis() - startTime) / 1000)) + " ���.");
		
		//��������� ����� ����� ��������
		System.out.println("\n��������� ����� ����� ��������");
		//�������� �����
		startTime = System.currentTimeMillis();
		//������� ��������� ������
		System.out.println(phonebook.reverseSearchInMap());
		System.out.println("����������� �����: " + Math.round(((System.currentTimeMillis() - startTime) / 1000)) + " ���.");
		
		
		/*
		 * ������� 2
		 */
		
		//��������� ���� ������ - ��������
		System.out.println("\n��������� ���� ������ ��������");
		//������� ��������� ���������
		ArrayList<Employee> employees = new ArrayList<>();
		//��������� ��������� ��������� ��� �����.
		//�� 5 ���������� �� ������ 10 � 8 ���
		for(int i = 0; i < 5; i++) {
			//��������� � ��������� ��������� �� ��������� �� ������ 10 ���
			employees.add(new Employee());
			//��������� � ��������� ����� ��������� �� ������ 8 ���
			employees.add(new Employee("���� ��������", 8));
		}
		//�������� ���������� �� ������ 8 ���
		System.out.println("��������� �� ������ 8 ���");
		Employee.printEmployee(employees, 8);
		//�������� ���������� �� ������ 10 ���
		System.out.println("\n��������� �� ������ 10 ���");
		Employee.printEmployee(employees, 10);
		
		
		/*
		 * ������� 3
		 */
		
		//��������� ���� �������� � �����������
		System.out.println("\n��������� ���� �������� � �����������");
		//������� ��� ��������� � ���������� �� 1 �� 10 � �� 5 �� 15
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		
		//��������� ��������� ����������
		for(int i = 1; i < 11; i++) {
			set1.add(i);
		}
		
		for(int i = 5; i < 16; i++) {
			set2.add(i);
		}
		
		System.out.println("����������� ��������");
		System.out.println(Multiplicity.union(set1, set2));
		
		System.out.println("����������� ��������");
		System.out.println(Multiplicity.intersect(set1, set2));
		
		//��������� ��������� ��������� �������
		//��������� 100 ��������� � ������ ��������� � ��������� �������� �� 0 �� 100;
		for(int i = 0; i < 100; i++) {
			set1.add((int) Math.round(Math.random() * 100));
			set2.add((int) Math.round(Math.random() * 100));
		}
		System.out.println("��������� ��������� ���������� ����������");
		System.out.println(set1);
		System.out.println(set2);
		
		
		/*
		 * ������� 4
		 */
		System.out.println("\n��������� �������� �������� ��������� ������");
		//������� ������ �� 70 ���������
		ArrayList<Integer> array = new ArrayList<Integer>();
		//��������� ����������
		for(int i = 0; i < 70; i++) {
			array.add(i);
		}
		
		System.out.println("������ �� ��������");
		System.out.println(array);
		
		//������� �������� �������� ������ ��������� � �����
		for(int i = array.size(); i >= 0; i--) {
			if(i%2 != 0) {
				array.remove(i);
			}
		}
		
		System.out.println("������ ����� ��������");
		System.out.println(array);
		
	}

}
