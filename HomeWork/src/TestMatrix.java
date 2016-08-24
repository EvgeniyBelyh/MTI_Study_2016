/**
 * Класс для тестов матриц
 * @author Белых Евгений
 *
 */
public class TestMatrix {

	public static void main(String[] args) {
		//определяем два квадратных массива третьего порядка для дальнейших тестов
		double[][] array1 = {{33, 34, 12},
						  	 {33, 19, 10},
						  	 {43, 71, 21}};

		double[][] array2 = {{1, 3, 5},
	  		  				 {5, 3, 4},
	  		  				 {9, 6, 7}};
		
		//создаем объекты двух матриц 
		Matrix matrix1 = new Matrix(array1);				
		Matrix matrix2 = new Matrix(array2);	
		
		//тест сложения матриц
		Matrix resultMatrix = matrix1.sumMatrix(matrix2);
		System.out.println("Тест суммы двух матриц и форматированного вывода в консоль");
		
		resultMatrix.printMatrixArray();
		resultMatrix = null;
		
		//тест разности матриц
		resultMatrix = matrix1.subtructionMatrix(matrix2);
		System.out.println("----------------------------------------------------------");
		System.out.println("Тест разности двух матриц");
		resultMatrix.printMatrixArray();
		resultMatrix = null;
		
		//инвертирование матриц
		System.out.println("----------------------------------------------------------");
		System.out.println("Тест инвертирования матриц");
		System.out.println("Инвертирование текущей матрицы");
		matrix1.selfInvert();
		matrix1.printMatrixArray();
		System.out.println("Инвертирование входной матрицы");
		Matrix.invertMatrix(matrix1);
		matrix1.printMatrixArray();
		
		//возврат единичной матрицы
		System.out.println("----------------------------------------------------------");
		System.out.println("Возврат единичной матрицы 4 порядка");
		System.out.println("Через метод");
		Matrix.getIdentityMatrix(4).printMatrixArray();;
		System.out.println("Через статическое поле");
		Matrix.identityMatrix.printMatrixArray();;
		
		//тест геттеров размерности
		System.out.println("----------------------------------------------------------");
		System.out.println("Тест геттеров размерности");
		System.out.println("В первой матрице " + matrix1.getM() + " строки и " + 
							matrix1.getN() + " столбца");
		
		//тест умножения матрицы на число
		System.out.println("----------------------------------------------------------");
		System.out.println("Тест умножения матрицы на число 2");
		resultMatrix = matrix1.numberMultiplication(2);
		resultMatrix.printMatrixArray();
		
		//тест произведения двух матриц
		System.out.println("----------------------------------------------------------");
		System.out.println("Тест произведения двух матриц");
		resultMatrix = matrix1.matrixMultiplication(matrix2);
		resultMatrix.printMatrixArray();
		
		//тест расчета определителя
		System.out.println("----------------------------------------------------------");
		System.out.println("Тест расчета определителя");
		System.out.println("Определитель первой матрицы равен " + matrix1.determinant());
	}

}
