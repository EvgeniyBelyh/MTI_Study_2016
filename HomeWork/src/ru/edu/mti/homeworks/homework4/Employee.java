package ru.edu.mti.homeworks.homework4;

import java.util.Collection;
import java.util.Iterator;

/**
 * ����� ���������
 * @author ����� �������
 *
 */
public class Employee {
	private String name; //��� ���������
	private int workAge; //���� ������
	
	//������������
	public Employee() {
		this("������ ���� ��������", 10);
	}
	
	public Employee(String name, int workAge) {
		this.name = name;
		this.workAge = workAge;
	}
	
	//������� � �������
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWorkAge() {
		return workAge;
	}

	public void setWorkAge(int workAge) {
		this.workAge = workAge;
	}
	
	//����������� ����� ������ ������
	public String toString() {
		return name;
	}
	
	
	/**
	 * ������� � ������� ����� ���������� � ��������� ������ �� ���������
	 * @param employees - ��������� ����������
	 * @param workAge - ���� ������
	 */
	public static void printEmployee(Collection<Employee> employees, int workAge) {
		//������� ��������� ��� ������ ���������
		for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
			//���������� ������ ���������
			Employee employee = (Employee) iterator.next();
			//���� ���� ���������� ��������� ����� ���������, �������� ��� � �������
			if(employee.getWorkAge() == workAge) {
				System.out.println(employee);
			}
		}
	}
}
