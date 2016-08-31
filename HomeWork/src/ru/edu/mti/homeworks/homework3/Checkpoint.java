package ru.edu.mti.homeworks.homework3;

/**
 * Класс контрольно-пропускного пункта
 * @author Белых Евгений
 *
 */
public class Checkpoint {
	
	public static final double CARTAX = 1000.0; //стоимость проезда легкового авто
	public static final double TRUCKTAX = 2000.0; //стоимость проезда грузовика
	public static final double TRAILERTAX = 500.0; //стоимость проезда с прицепом
	public static final double OVERWEIGHT = 800.0; //плата за перегруз
	public static final double SPEEDLIMIT = 60.0; //разрешенная скорость движения
	
	/**
	 * Подсчитывает размер штрафа за превышение скорости согласно КоАП
	 * Для расчета берутся минимальные значения штрафов
	 * @param speed - скорость автомобиля
	 * @return - размер штрафа за превышение скорости
	 */
	private double fineCalculation(double speed) {
		double fine = 0.0; //размер штрафа
		double overSpeed = speed - Checkpoint.SPEEDLIMIT; //размер превышения
		
		//если нет превышения, то штрафа нет
		if(overSpeed <= 0) {
			return 0.0;
		}
		
		if(overSpeed > 20.0 && overSpeed <= 40.0) { // превышение до 40 км/ч
			fine = 500.0;
		} else if(overSpeed > 40.0 && overSpeed <= 60.0) { // превышение от 40 до 60 км/ч
			fine = 1000.0;
		} else if(overSpeed > 60.0 && overSpeed <= 80.0) { // превышение от 60 до 80 км/ч
			fine = 2000.0;
		} else if (overSpeed > 80.0){ // превышение свыше 80 км/ч
			fine = 5000.0;
		}
		
		//возвращаем размер штрафа
		return fine;
	}
	
	
	/**
	 * Расчитывает плату за проезд через КПП
	 * @param car - объект класса Car
	 * @return - размер платы за проезд
	 */
	private double fareCalculation(Car car) {
		double fare = 0.0;
		
		//если спец. транспорт, то плата не взимается
		if(car.isSpecial()) {
			return 0.0;
		}
		
		//определяем является ли машина грузовиком
		if(car instanceof Truck) {
			//делаем приведение к объекту грузовика
			Truck truck = (Truck) car;
			//добавляем стандартную плату за проезд
			fare = fare + Checkpoint.TRUCKTAX;
			//если есть прицеп, то добавляем плату за прицеп
			if(truck.isTrailer()) {
				fare = fare + Checkpoint.TRAILERTAX;
			}
			//если есть перевес, то взимаем плату за перевес
			if(truck.getWeight() > 10.0) {
				fare = fare + Checkpoint.OVERWEIGHT;
			}
			
		} else { // не является грузовиком
			fare = fare + Checkpoint.CARTAX;
		}
		
		return fare;
	}
	
	/**
	 * Проверяет автомобили на КПП. Выводит информацию об автомобиле и плату за проезд
	 * @param car объект автомобиля
	 * @throws InvalidHeightException 
	 * @throws OverspeedException 
	 */
	public void checkIn(Car car) throws InvalidHeightException, OverspeedException {
		double fare = 0.0;
		double fine = 0.0;
		
		//определяем является ли машина грузовиком
		if(car instanceof Truck) {
			//делаем приведение к объекту грузовика
			Truck truck = (Truck) car;
			//выводим информацию о грузовике
			System.out.println(truck);
			//если высота грузовика больше 4 метров, то
			if(truck.getHeight() > 4.0) {
				//генерируем ошибку несоответствия высоты грузовика
				throw new InvalidHeightException("Грузовик " + truck.getName() + 
						" не может проехать через КПП так как его высота больше 4 метров");			
			}
		} else {
			//выводим информацию о легковом автомобиле
			System.out.println(car);
		}
		
		//если скороть больше 180, то генерируем исключение
		if(car.getSpeed() > 180.0) {
			throw new OverspeedException("Скорость больше 180км/ч! Патруль уже выехал! " +
								"Кто-то скоро будет ходить пешком!!!");
		}
		
		//считаем плату за проезд
		fare = this.fareCalculation(car);
		//считаем размер штрафа
		fine = this.fineCalculation(car.getSpeed());
		
		//выводим сумму к оплате 
		System.out.println("Плата за проезд: " + fare + " руб. " +
							(fine != 0.0 ? "Сумма штрафа: " + fine + " руб. " : "") + 
							"Сумма к оплате: " + (fare + fine) + " руб.");
	}
	
}
