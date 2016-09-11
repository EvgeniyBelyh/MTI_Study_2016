package ru.edu.mti.homeworks.homework4;

/**
 * Номер контакта (для теста работы хэшкодов
 * @author Белых Евгений
 *
 */
public class ContactNumber {
	 private int number; //номер контакта

	 //конструктор
	 public ContactNumber(int number) {
		 this.number = number;
	 }
	 
	 public boolean equals(Object obj) {
		 //если объект другого типа, то возвращаем ложь
		 if(!(obj instanceof ContactNumber)) return false;
		 //приводим объект к типу контакта
		 ContactNumber contactNumber = (ContactNumber) obj;

		 return this.number == contactNumber.number;
	 }
	 
	 
	 public int hashCode() {
			//определяем стартовое значение хэшкода и умножаем на 1
			int prime = 44;
			int result = prime * 1;
			//добавляем хэшкоды, определенные в классе String 
			result = result + Integer.valueOf(this.number).hashCode();
			//возвращаем результат
			return result;
	 }
}
