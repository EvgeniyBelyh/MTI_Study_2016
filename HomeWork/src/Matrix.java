/**
 * Класс Матрица
 * @author Белых Евгений
 *
 */
public class Matrix {
	
	private int m = 3, n = 3; //размерности матрицы
	private double[][] matrixArray; //массив для хранения значений
	public static Matrix identityMatrix = Matrix.getIdentityMatrix(3); //единичная матрица
	
	//конструктор по умолчанию
	public Matrix() {
		//определяем значения полей по умолчанию
		matrixArray = new double[m][n];
	}
	
	//конструктор с размерностями
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
	 * Пытаемся расчитать определитель матрицы по алгоритму Гаусса
	 * @return число - определитель матрицы 
	 */
	public double determinant() {

        double determ = 1.0;
        double cloneMatrixArray[][] = new double[n][n];
        int row[] = new int[n];
        int hold, I_pivot;
        double pivot;
        double abs_pivot;
        
        //проверяем, что матрица квадратная
        if (m != n) {
            System.out.println("Ошибка! Матрица не квадратная");
        }
        
        // создаем копию текущего массива элементов
        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < n; ii++) {
            	cloneMatrixArray[i][ii] = this.matrixArray[i][ii];
            }
        }
        // заполняем вектор перестановок
        for (int i = 0; i < n; i++) {
            row[i] = i;
        }
        
        // начало основного цикла
        for (int k = 0; k < n - 1; k++) {
            // находим наиболший элемент для основы
            pivot = cloneMatrixArray[row[k]][k];
            abs_pivot = Math.abs(pivot);
            I_pivot = k;
            for (int i = k; i < n; i++) {
                if (Math.abs(cloneMatrixArray[row[i]][k]) > abs_pivot) {
                    I_pivot = i;
                    pivot = cloneMatrixArray[row[i]][k];
                    abs_pivot = Math.abs(pivot);
                }
            }
            // если нашлась такая основа, то меняем знак определителя и меняем местами столбцы
            if (I_pivot != k) {
                hold = row[k];
                row[k] = row[I_pivot];
                row[I_pivot] = hold;
                determ = -determ;
            }
            // проверка на ноль на главной диагонали
            if (abs_pivot < 1.0E-10) {
                return 0.0;
            } else {
            	//умножаем промежуточное значение определителя на значение элемента главной диагонали
            	determ = determ * pivot;
                // делим на основу
                for (int j = k + 1; j < n; j++) {
                	cloneMatrixArray[row[k]][j] = cloneMatrixArray[row[k]][j] / cloneMatrixArray[row[k]][k];
                }
                //  внутренний цикл
                for (int i = 0; i < n; i++) {
                    if (i != k) {
                        for (int j = k + 1; j < n; j++) {
                        	cloneMatrixArray[row[i]][j] = cloneMatrixArray[row[i]][j] - cloneMatrixArray[row[i]][k] * cloneMatrixArray[row[k]][j];
                        }
                    }
                }
            }
            // конец внутреннего цикла
        }
        // конец главного цикла
        return determ * cloneMatrixArray[row[n - 1]][n - 1];
					
	}
	
}
