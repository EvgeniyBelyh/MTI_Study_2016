/**
 * Лабораторная работа №1
 * @author Белых Евгений
 *
 */
public class LabWork1 {

	public static void main(String[] args) {
		
		//выводим первые 19 членов последовательности Фибоначчи
		System.out.println("Последовательность Фибоначчи (первые 19 чисел)");
		int[] fibArray = fibonacciNumbers(19);
		for(int i : fibArray) {
			System.out.print(i + " ");
		}
		System.out.println("");
		
		//определяем 43 член последовательности Фибоначчи
		fibArray = fibonacciNumbers(43);
		System.out.println("43 член последовательности Фибоначчи: " + fibArray[42]);
		
		//определяем является ли 41 член последовательности простым числом
		fibArray = fibonacciNumbers(41);
		System.out.println("41 член последовательности Фибоначчи: " + fibArray[40] +
				(isSimpleNumber(fibArray[40]) ? " является " : " не является ") + 
				"простым числом");
		
		//определяем порядковый номер числа 1836311903 в последовательности Фибоначчи		
		int i = 43;
		
		while(true) {
			fibArray = fibonacciNumbers(i);
			if(fibArray[i-1] == 1836311903) break;
			i++;
		}
		
		System.out.println("Номер числа 1836311903 в последовательности Фибоначчи: " + i);
		
	}

	/**
	 * Рассчитывает последовательность Фибоначчи
	 * @param maxNumber - номер последнего члена последовательности
	 * @return массив со значениями последовательности Фибоначчи
	 */
	public static int[] fibonacciNumbers(int maxNumber) {
		//создаем массив для хранения чисел
		int[] fibArray = new int[maxNumber];
		//определяем перые значения
		fibArray[0] = 0;
		fibArray[1] = 1;
		
		//заполняем массив значениями чисел Фибоначчи до maxNumber
		for(int i = 2; i < maxNumber; i++) {
			fibArray[i] = fibArray[i-1] + fibArray[i-2];
		}
		
		return fibArray;
	}
	
	
	/**
	 * Определяет простое число или нет
	 * @param num число для проверки
	 * @return истина - если число простое
	 */
	public static boolean isSimpleNumber(long num) {

		long delCount = 0; //количество делителей
		//идем по всем делителям введенного числа
		for(long i = 1; i <= num; i++) {
			//если число делится без остатка, то увеличиваем счетчик на 1
			if(num%i == 0) {
				delCount++;
			}
		}
		//если делителей не больше 2, т.е. 1 и введенное число, то число простое
		if(delCount <= 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
