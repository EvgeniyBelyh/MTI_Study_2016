package ru.edu.mti.homeworks.homework3;

import java.util.ArrayList;

/**
 * Тест работы контрольно-пропускного пункта
 * @author Белых Евгений
 *
 */
public class TestCheckpoint {

	public static void main(String[] args) {
		
		//запускаем тест
		System.out.println("Запускаем тест прохождения машин через КПП");
		
		//машина скорой помощи
		Car ambulance = new Car(70.0, true, "Скорая помощь");
		//машина с хорошим водителем
		Car goodDriver = new Car(65.0, false, "Хороший водитель");
		//машина нарушителя
		Car offender = new Car(95.0, false, "Нарушитель");
		//машина злостного нарушителя
		Car violator = new Car(200.0, false, "Злостный нарушитель");
		
		
		//пожарная машина с превышением скорости
		Truck fireTruck = new Truck(100.0, true, "Пожарная машина с превышением скорости", 
				3.5, 5.0, false);
		//добропорядочный грузовик
		Truck goodTruck = new Truck(70.0, false, "Хороший грузовик", 4.0, 9.0, false);
		//добропорядочный грузовик с прицепом
		Truck goodTrailer = new Truck(65.0, false, "Хороший грузовик с прицепом", 3.5, 9.0, true);
		//грузовик с перегрузом
		Truck overweightTruck = new Truck(65.0, false, "Грузовик с перегрузом", 3.5, 15.0, false);
		//грузовик с высотой выше нормы
		Truck overheightTruck = new Truck(50.0, false, "Слишком высокий грузовик", 4.5, 9.0, false);
				
		//создаем объект КПП		
		Checkpoint checkpoint = new Checkpoint();
		//создаем хранилище объектов машин
		ArrayList<Car> arrayList = new ArrayList<Car>();
		
		//заполняем массив объектами Car
		arrayList.add(ambulance);
		arrayList.add(goodDriver);
		arrayList.add(offender);
		arrayList.add(violator);
		arrayList.add(fireTruck);
		arrayList.add(goodTruck);
		arrayList.add(goodTrailer);
		arrayList.add(overweightTruck);
		arrayList.add(overheightTruck);
		
		//идем по всему массиву и запускаем каждую машину на КПП
		for (Car car : arrayList) {
			try {
				//запускаем машину на КПП
				checkpoint.checkIn(car);
			//обрабатываем ошибку превышения высоты грузовика
			} catch (InvalidHeightException e) {
				System.out.println(e.toString());
				continue;
				//обрабатываем ошибку превышения скорости
			} catch (OverspeedException e) {
				System.out.println(e.toString());
				continue;
			}
			
		}
		
		//завершаем тест
		System.out.println("\nТест успешно завершен");
		
	}

}
