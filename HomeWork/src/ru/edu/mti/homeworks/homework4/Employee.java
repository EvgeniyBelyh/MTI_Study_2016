package ru.edu.mti.homeworks.homework4;

import java.util.Collection;
import java.util.Iterator;

/**
 * Класс работника
 * @author Белых Евгений
 *
 */
public class Employee {
	private String name; //ФИО работника
	private int workAge; //стаж работы
	
	//конструкторы
	public Employee() {
		this("Петров Петр Петрович", 10);
	}
	
	public Employee(String name, int workAge) {
		this.name = name;
		this.workAge = workAge;
	}
	
	//геттеры и сеттеры
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
	
	//форматируем вывод данных класса
	public String toString() {
		return name;
	}
	
	
	/**
	 * Выводит в консоль имена работников с указанным стажем из коллекции
	 * @param employees - коллекция работников
	 * @param workAge - стаж работы
	 */
	public static void printEmployee(Collection<Employee> employees, int workAge) {
		//обходим коллекцию при помощи итератора
		for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
			//определяем объект работника
			Employee employee = (Employee) iterator.next();
			//если стаж выбранного работника равен заданному, печатаем ФИО в консоль
			if(employee.getWorkAge() == workAge) {
				System.out.println(employee);
			}
		}
	}
}
