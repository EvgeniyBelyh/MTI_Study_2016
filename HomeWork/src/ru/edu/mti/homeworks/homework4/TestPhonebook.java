package ru.edu.mti.homeworks.homework4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * тест телефонного справочника
 * @author Белых Евгений
 *
 */
public class TestPhonebook {

	public static void main(String[] args) {
		/* Заносим в телефонную книгу 100 000 контактов.
		 * У каждого контакта 10 связанных контактов.
		 * Итого для обхода 1 000 000 контактов.
		 */
		Phonebook phonebook = new Phonebook(100000);
		//запускаем обход списка
		System.out.println("\nЗапускаем обход списка");
		//засекаем время
		Long startTime = System.currentTimeMillis();
		//выводим результат обхода
		System.out.println(phonebook.reverseSearchInList());
		System.out.println("Затраченное время: " + Math.round(((System.currentTimeMillis() - startTime) / 1000)) + " сек.");
		
		//запускаем обход массива
		System.out.println("\nЗапускаем обход массива");
		//засекаем время
		startTime = System.currentTimeMillis();
		//выводим результат обхода
		System.out.println(phonebook.reverseSearchInArray());
		System.out.println("Затраченное время: " + Math.round(((System.currentTimeMillis() - startTime) / 1000)) + " сек.");
		
		//запускаем обход множества
		System.out.println("\nЗапускаем обход множества");
		//засекаем время
		startTime = System.currentTimeMillis();
		//выводим результат обхода
		System.out.println(phonebook.reverseSearchInSet());
		System.out.println("Затраченное время: " + Math.round(((System.currentTimeMillis() - startTime) / 1000)) + " сек.");
		
		//запускаем обход карты значений
		System.out.println("\nЗапускаем обход карты значений");
		//засекаем время
		startTime = System.currentTimeMillis();
		//выводим результат обхода
		System.out.println(phonebook.reverseSearchInMap());
		System.out.println("Затраченное время: " + Math.round(((System.currentTimeMillis() - startTime) / 1000)) + " сек.");
		
		
		/*
		 * ЗАДАНИЕ 2
		 */
		
		//запускаем тест класса - работник
		System.out.println("\nЗапускаем тест класса Работник");
		//создаем коллекцию работникв
		ArrayList<Employee> employees = new ArrayList<>();
		//заполняем коллекцию работникв для теста.
		//По 5 работников со стажем 10 и 8 лет
		for(int i = 0; i < 5; i++) {
			//добавляем в коллекцию работника по умолчанию со стажем 10 лет
			employees.add(new Employee());
			//добавляем в коллекцию иного работника со стажем 8 лет
			employees.add(new Employee("Иной работник", 8));
		}
		//выбираем работников со стажем 8 лет
		System.out.println("Работники со стажем 8 лет");
		Employee.printEmployee(employees, 8);
		//выбираем работников со стажем 10 лет
		System.out.println("\nРаботники со стажем 10 лет");
		Employee.printEmployee(employees, 10);
		
		
		/*
		 * ЗАДАНИЕ 3
		 */
		
		//запускаем тест операций с множествами
		System.out.println("\nЗапускаем тест операций с множествами");
		//создаем два множества с элементами от 1 до 10 и от 5 до 15
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		
		//заполняем множества элементами
		for(int i = 1; i < 11; i++) {
			set1.add(i);
		}
		
		for(int i = 5; i < 16; i++) {
			set2.add(i);
		}
		
		System.out.println("Объединение множеств");
		System.out.println(Multiplicity.union(set1, set2));
		
		System.out.println("Пересечение множеств");
		System.out.println(Multiplicity.intersect(set1, set2));
		
		//заполняем множества случайным образом
		//добавляем 100 элементов в каждое множество в диапазоне значений от 0 до 100;
		for(int i = 0; i < 100; i++) {
			set1.add((int) Math.round(Math.random() * 100));
			set2.add((int) Math.round(Math.random() * 100));
		}
		System.out.println("Заполняем множества случайными значениями");
		System.out.println(set1);
		System.out.println(set2);
		
		
		/*
		 * ЗАДАНИЕ 4
		 */
		System.out.println("\nТестируем удаление нечетных элементов списка");
		//создаем список из 70 элементов
		ArrayList<Integer> array = new ArrayList<Integer>();
		//заполняем элементами
		for(int i = 0; i < 70; i++) {
			array.add(i);
		}
		
		System.out.println("Список до удаления");
		System.out.println(array);
		
		//удаляем нечетные элементы обходя коллекцию с конца
		for(int i = array.size(); i >= 0; i--) {
			if(i%2 != 0) {
				array.remove(i);
			}
		}
		
		System.out.println("Список после удаления");
		System.out.println(array);
		
	}

}
