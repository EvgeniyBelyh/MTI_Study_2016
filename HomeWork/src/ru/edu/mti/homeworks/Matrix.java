package ru.edu.mti.homeworks;

import ru.edu.mti.homeworks.homework5.Quadratic;

/**
 * Класс Матрица
 * @author Белых Евгений
 *
 */
public class Matrix {
	
	private int m = 3, n = 3; //размерности матрицы
	private double[][] matrixArray; //массив для хранения значений
	public static Matrix identityMatrix = Matrix.getIdentityMatrix(3); //единичная матрица
	private int rang;
	
	//конструктор по умолчанию
	public Matrix() {
		//определяем значения полей по умолчанию
		matrixArray = new double[m][n];
	}
	
	//конструктор с размерностями
	@Quadratic
	public Matrix(int m, int n) {
		//ставим переданные значения полей
		this.m = m;
		this.n = n;
		matrixArray = new double[m][n];
	}

	//конструктор с значениями элементов
	public Matrix(double[][] array) {
		//ставим переданные значения полей
		this.m = array.length;
		this.n = array[0].length;
		matrixArray = array;
	}
	
	//геттер размерности 
	public int getM() {
		return m;
	}
	//геттер размерности 
	public int getN() {
		return n;
	}
	//геттер массива значений матрицы
	public double[][] getMatrixArray() {
		return matrixArray;
	}
	//сеттер массива значений матрицы
	public void setMatrixArray(double[][] matrixArray) {
		//ставим массив значений
		this.matrixArray = matrixArray;
		//корректируем размерности
		this.m = matrixArray.length;
		this.n = matrixArray[0].length;
	}

	/**
	 * Создает единичную матрицу заданной размерности
	 * @param dimension - размерность
	 * @return объект единичной матрицы
	 */
	public static Matrix getIdentityMatrix(int dimension) {
		//создаем квадратную матрицу
		Matrix matrix = new Matrix(dimension,dimension);
		//заполняем матрицу
		matrix.fillIdentityMatrix();
		//инициализируем статическую переменную
		identityMatrix = matrix;
		//возвращаем объект единичной матрицы
		return matrix;
	}
	
	/**
	 * Заполняет массив значений единичной матрицы
	 */
	private void fillIdentityMatrix() {
		int ii = 0;
		for(int i = 0; i < m; i++) {
				matrixArray[i][ii] = 1;
				ii++;
		}
	}
	
	/**
	 * Выводит в консоль значения элементов матрицы
	 */
	public void printMatrixArray() {
		System.out.println("Значения элементов матрицы");
		for(int i = 0; i < m; i++) {
			for(int ii = 0; ii < n; ii++){
				System.out.print(this.matrixArray[i][ii] + " ");
			}
			System.out.println("");
		}
	}
	
	/**
	 * Обертка метода печати для теста рефлексии
	 */
	private void printReflectionTest() {
		printMatrixArray();
	}
	
	
	/**
	 * Умножение матрицы на число
	 * @param multi множитель
	 * @return матрица с результатом произведения
	 */
	public Matrix numberMultiplication(int multi) {
		//создаем массив хранения результата умножения 
		double[][] resultArray = new double[m][n];
		for(int i = 0; i < m; i++) {
			for(int ii = 0; ii < n; ii++){
				resultArray[i][ii] = matrixArray[i][ii] * multi;
			}
		}
		//возвращаем объект новой матрицы
		return new Matrix(resultArray);
	}
	
	/**
	 * Умножение матрицы на матрицу
	 * @param multi матрица-множитель
	 * @return матрица с результатом произведения
	 */
	public Matrix matrixMultiplication(Matrix matrix) {
		
		//проверяем размерности матриц
		if(this.matrixArray[0].length != matrix.getMatrixArray().length) {
			System.out.println("Ошибка! Количество столбцов текущей матрицы не совпадает " +
								"с количеством строк входной матрицы.");
			return null;
		}
		
		//берем массив значений входной матрицы
		double[][] multiArray = matrix.getMatrixArray();
		//создаем новый массив для хранения результата умножения
		double[][] resultArray = new double[m][multiArray[0].length];
		
		//умножаем матрицы
		for (int i = 0; i < m; i++) {
			for(int ii = 0; ii < multiArray[0].length; ii++) {
				for(int iii = 0; iii < multiArray.length; iii++) {
					resultArray[i][ii] = resultArray[i][ii] + (matrixArray[i][iii] * multiArray[iii][ii]);
				}
			}
		}
		
		//возвращаем объект новой матрицы
		return new Matrix(resultArray);
	}
	
	/**
	 * Проверка размерности двух матриц
	 * @param matrix матрица для сравнения
	 * @return истина если матрицы с одинаковыми размерностями
	 */
	private boolean dimensionCheck(Matrix matrix) {
		//проверяем размерность матриц
		if(this.m == matrix.getM() && this.n == matrix.getN()) {
			return true;
		}
		//если размеры не совпадают выводим сообщение
		System.out.println("Ошибка! Размерности матриц должны быть идентичны");
		return false;
	}
	
	/**
	 * Сумма матриц
	 * @param matrix матрица-слагаемое
	 * @return новая матрица - сумма текущей матрицы и параметра
	 */
	public Matrix sumMatrix(Matrix matrix) {
		//проверяем размерность матриц
		if(dimensionCheck(matrix) != true) {
			return null;
		}
		
		//создаем новый массив для хранения результата сложения
		double[][] resultArray = new double[m][n];
		double[][] sumArray = matrix.getMatrixArray();
		for(int i = 0; i < m; i++) {
			for(int ii = 0; ii < n; ii++){
				resultArray[i][ii] = matrixArray[i][ii] + sumArray[i][ii];
			}
		}
		
		//возвращаем объект новой матрицы
		return new Matrix(resultArray);
	}
	
	/**
	 * Разность матриц
	 * @param matrix матрица-вычитаемое
	 * @return новая матрица - разность текущей матрицы и параметра
	 */
	public Matrix subtructionMatrix(Matrix matrix) {
		//проверяем размерность матриц
		if(dimensionCheck(matrix) != true) {
			return null;
		}
		//создаем объект входной матрицы, умноженной на -1	
		Matrix resultMatrix = matrix.numberMultiplication(-1);		

		//возвращаем результат сложения текущей матрицы и входной матрицы, умноженной на -1
		return this.sumMatrix(resultMatrix);
		
	}
	
	/**
	 * Инвертирует текущую матрицу
	 */
	public void selfInvert() {
		//запускаем метод инвертирования внешнеий матрицы с ссылкой на текущую
		Matrix.invertMatrix(this);		
		
    }
	
	/**
	 * Инвертирует входную матрицу
	 * @param matrix - матрица
	 */
	public static void invertMatrix(Matrix matrix) {
		//берем массив элементов входной матрицы
		double[][] array = matrix.getMatrixArray();
		//создаем массив для хранения результатов инвертирования
		double[][] transArray = new double[matrix.getM()][matrix.getN()];
		
		//бежим по всем элементам массива и инвертируем матрицу
		for(int i = 0; i < matrix.getM(); i++) {
			for(int ii = 0; ii < matrix.getN(); ii++){
				transArray[ii][i] = array[i][ii];
			}
		}
		//переносим инвертированный массив в массив входной матрицы
		for(int i = 0; i < matrix.getM(); i++) {
			for(int ii = 0; ii < matrix.getN(); ii++){
				array[i][ii] = transArray[i][ii];
			}
		}	
	}
	
	/**
	 * Приводит матрицу к ступенчатому виду методом Гаусса
	 * @return двумерный массив с элементами ступенчатой матрицы
	 */
	private double[][] transformMatrix() {
		int i = 0, j = 0, k = 0, l = 0; //определяем индексы
		double r; //максимальное значение элемента 
		
		//делаем копию текущего массива элементов
		double array[][] = new double[m][n];		
		for(int z = 0; z < m; z++) {
			for(int zz = 0; zz < n; zz++){
				array[z][zz] = this.matrixArray[z][zz];
			}
		}
		    
		while (i < m && j < n) {
	        // ищем максимальный элемент в j-м столбце,
	        // начиная с i-й строки
	        r = 0.0;
	        for (k = i; k < m; ++k) {
	            if (Math.abs(array[k][j]) > r) {
	                l = k;      // запомним номер строки
	                r = Math.abs(array[k][j]); // и максимальный элемент
	            }
	        }

	        if (l != i) {
	            // меняем местами i-ю и l-ю строки
	            for (k = j; k < n; ++k) {
	                r = array[i][k];
	                array[i][k] = array[l][k];
	                array[l][k] = (-r); // Меняем знак строки
	            }
	        }

	        // обнуляем j-й столбец, начиная со строки i+1,
	        // применяя элем. преобразования второго рода
	        for (k = i + 1; k < m; ++k) {
	            r = (-array[k][j] / array[i][j]);

	            // к k-й строке прибавляем i-ю, умноженную на r
	            array[k][j] = 0.0;
	            for (l = j+1; l < n; ++l) {
	            	array[k][l] = array[k][l] + r * array[i][l];
	            }
	        }

	        ++i; ++j;   // переходим к следующему минору
	    }
		
		this.rang = i; //определяем ранг матрицы, как количество ненулевых строк
		
	    return array; // массив элементов, приведенный к ступенчатому виду
	}

	
	/**
	 * Рассчитывает определитель матрицы
	 * @return число - определитель матрицы
	 */
	public double determinant() {
		if(m != n) {
			System.out.println("Ошибка! Матрица не квадратная. Рассчитать определитель невозможно");
			return 0;
		}
		
		//берем ступенчатую матрицу
		double array[][] = this.transformMatrix();
		//перемножаем элементы на главной диагонали
		int ii = 0; 
		double result = 1.0;
		for(int i = 0; i < m; i++) {
			result = result * array[i][ii];
			ii++;
		}
		
		return Math.round(result);
		
	}
	
	/**
	 * Определяет ранг матрицы
	 * @return число - ранг матрицы
	 */
	public int rang() {
		//запускаем метод приведения матрицы к ступенчатому виду
		//чтобы определить количество ненулевых строк
		this.transformMatrix();
		//возвращаем ранг матрицы
		return this.rang;
	}
	
	
	/**
	 * Рассчитывает обратную матрицу
	 * @return объект Матрица
	 */
	public Matrix inverse()
	{   		
		/* Изначально результирующая матрица является единичной
	       Заполняем единичную матрицу */
		double[][] result = Matrix.getIdentityMatrix(m).getMatrixArray();
	    
	    //создаем копию массива элементов текущей матрицы
	    double[][] copy = new double[m][n];    
	    for(int z = 0; z < m; z++) {
	    	for(int zz = 0; zz < n; zz++){
	    		copy[z][zz] = this.matrixArray[z][zz];
	    	}
	    }
	    
	    /* Проходим по исходными строкам матрицы
	       сверху вниз. На данном этапе происходит прямой ход
	       и исходная матрица превращается в верхнюю треугольную */
	    for (int k = 0; k < m; ++k)
	    {
	        /* Если элемент на главной диагонали в исходной
	           строке - нуль, то ищем строку, где элемент
	           того же столбца не нулевой, и меняем строки
	           местами */
	        if (Math.abs(copy[k][k]) < 1e-8)
	        {           
	            // Идём по строкам, расположенным ниже исходной
	            for (int i = k + 1; i < m; ++i)
	            {
	                /* Если нашли строку, где в том же столбце
	                   имеется ненулевой элемент */
	                if (Math.abs(copy[i][k]) > 1e-8)
	                {
	                    /* Меняем найденную и исходную строки местами
	                       как в исходной матрице, так и в единичной */
	                    double[] swap1 = new double[n];
	                	
	                    for(int z = 0; z < n; z++) {
	                    	swap1[z] = copy[k][z];
	                    	copy[k][z] = copy[i][z];
	                    	copy[i][z] = swap1[z];
	                    	
	                    	swap1[z] = result[k][z];
	                    	result[k][z] = result[i][z];
	                    	result[i][z] = swap1[z];
	                    }

	                    break;
	                }
	            }
	        }
	        
	        // Запоминаем делитель - диагональный элемент
	        double div = copy[k][k];
	        
	        /* Все элементы исходной строки делим на диагональный
	           элемент как в исходной матрице, так и в единичной */
	        for (int j = 0; j < m; ++j)
	        {
	            copy[k][j] = copy[k][j] / div;
	            result[k][j] = result[k][j] / div;
	        }
	        
	        // Идём по строкам, которые расположены ниже исходной
	        for (int i = k + 1; i < m; ++i)
	        {
	            /* Запоминаем множитель - элемент очередной строки,
	               расположенный под диагональным элементом исходной
	               строки */
	            double multi = copy[i][k];
	            
	            /* Отнимаем от очередной строки исходную, умноженную
	               на сохранённый ранее множитель как в исходной,
	               так и в единичной матрице */
	            for (int j = 0; j < m; ++j)
	            {
	                copy[i][j]   = copy[i][j] - multi * copy[k][j];
	                result[i][j] = result[i][j] - multi * result[k][j];
	            }
	        }
	    }
	    
	    
	    /* Проходим по вернхней треугольной матрице, полученной
	       на прямом ходе, снизу вверх
	       На данном этапе происходит обратный ход, и из исходной
	       матрицы окончательно формируется единичная, а из единичной -
	       обратная */
	    for (int k = m - 1; k > 0; --k)
	    {
	        // Идём по строкам, которые расположены выше исходной
	        for (int i = k - 1; i + 1 > 0; --i)
	        {
	            /* Запоминаем множитель - элемент очередной строки,
	               расположенный над диагональным элементом исходной
	               строки */
	            double multi = copy[i][k];
	            
	            /* Отнимаем от очередной строки исходную, умноженную
	               на сохранённый ранее множитель как в исходной,
	               так и в единичной матрице */
	            for (int j = 0; j < m; ++j)
	            {
	                copy[i][j]   = copy[i][j] - multi * copy[k][j];
	                result[i][j] = result[i][j] - multi * result[k][j];
	            }
	        }
	    }
	    
	    // возвращаем обратную матрицу
	    return new Matrix(result);
	}
	
	
}
