import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeWork1 {

	public static void main(String[] args) {

		System.out.println("---------------------------------------");
		System.out.println("--------------«адание 1----------------");
		System.out.println("---------------------------------------");
		System.out.println("");

		int a = 0, b = 0, c = 0;
		
		InputStreamReader inputStreamReader = null;
		BufferedReader br = null;
		
		long l = 0;
		long root = 0;
		
		try {
			
			inputStreamReader = new InputStreamReader(System.in);
			br = new BufferedReader(inputStreamReader);
			
			System.out.println("¬ведите значение а");
			a = Integer.parseInt(br.readLine());

			System.out.println("¬ведите значение b");
			b = Integer.parseInt(br.readLine());

			System.out.println("¬ведите значение c");
			c = Integer.parseInt(br.readLine());

			//решаем квадратное уравнение
			System.out.println(squareEquation(a, b, c));
			
			System.out.println("");
			System.out.println("---------------------------------------");
			System.out.println("--------------«адание 3----------------");
			System.out.println("---------------------------------------");

			//извлекаем квадратный корень из числа

			System.out.println("¬ведите число дл€ расчета квадратного корн€");
			l = Long.parseLong(br.readLine());		

			root = squareRoot(l);

			if(root*root < l) {
				System.out.println("Ѕлижайшее целое значение квадратного корн€ числа " + l
						+ " равн€етс€ " + root);
			} else {
				System.out.println("«начение квадратного корн€ числа " + l
						+ " равн€етс€ " + root);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} 
		
		finally {
			try {
				br.close();
				inputStreamReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("--------------«адание 2----------------");
		System.out.println("---------------------------------------");
		System.out.println("");
		
		//выводим все простые числа в промежутке от 1 до 1000
		printSimpleNumbers(1000);

	}

	/*
	 * ћетод определ€ет простое число или нет
	 */

	public static boolean isSimpleNumber(long num) {

		long delCount = 0; //количество делителей
		//идем по всем делител€м введенного числа
		for(long i = 1; i <= num; i++) {
			//если число делитс€ без остатка, то увеличиваем счетчик на 1
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

	/*
	 * ¬ыводит все простые числа в диапазоне от 1 до maxnumber
	 */

	public static void printSimpleNumbers(long maxnumber) {
		for(int i = 1; i <= maxnumber; i++) {
			if(isSimpleNumber(i)) {
				System.out.print(i + " ");
			}
		}
	}

	/*
	 * ѕодсчитывает квадратный корень целого цисла сложением и вычитанием
	 */

	public static long squareRoot(long num) {
		long i = 0;

		//подбираем число, квадрат которого меньше или равен введенному числу
		while(degree(i+1) <= num) {
			i++;
		}
		//возвращаем ближайший целый корень введенного числа
		return i;
	}


	/*
	 * возводит число в степень сложением
	 */
	private static long degree(long num) {
		long result = 0;

		for(long i = 0; i < num; i++) {
			result = result + num;
		}

		return result;
	}

	/*
	 * решаем квадратное уравнение
	 */
	public static String squareEquation(int a, int b, int c) {

		//провер€ем значение а. ≈сли 0, то возвращаем текст с ошибкой
		if(a == 0) {
			return "ѕервый коэффициент не может быть 0";
		}

		String result = "";

		//считаем дискриминант
		int d = b*b - 4*a*c;

		//в зависимости от значени€ дискриминанта выводим решени€ уравнени€
		if(d == 0) {
			result = "”равнение имеет 2 одинаковых корн€ x1 = x2 = " + (-(b/2*a));
		} else if (d < 0) {
			result = "Ќет дейтвительных решений уравнени€";
		} else {
			result = "”равнение имеет 2 корн€ х1 = " + ((-b - Math.sqrt(d))/(2*a)) + " x2 = " +
					+((-b + Math.sqrt(d))/(2*a));
		}

		return result;
	}



}
