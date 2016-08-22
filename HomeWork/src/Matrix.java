/**
 *  ласс ћатрица
 * @author Ѕелых ≈вгений
 *
 */
public class Matrix {
	
	private int m = 3, n = 3; //размерности матрицы
	public int[][] matrixArray; //массив дл€ хранени€ значений
	public static Matrix identityMatrix = Matrix.getIdentityMatrix(3); //единична€ матрица
	
	//конструктор по умолчанию
	public Matrix() {
		//определ€ем значени€ полей по умолчанию
		matrixArray = new int[m][n];
	}
	
	//конструктор с параметрами
	public Matrix(int m, int n) {
		//ставим переданные значени€ полей
		this.m = m;
		this.n = n;
		matrixArray = new int[m][n];
	}
	
	//геттеры полей
	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}

	public int[][] getMatrixArray() {
		return matrixArray;
	}

	/**
	 * —оздает единичную матрицу заданной размерности
	 * @param dimension - размерность
	 * @return объект единичной матрицы
	 */
	public static Matrix getIdentityMatrix(int dimension) {
		//создаем квадратную матрицу
		Matrix matrix = new Matrix(dimension,dimension);
		//заполн€ем матрицу
		matrix.fillIdentityMatrix();
		//инициализируем статическую переменную
		identityMatrix = matrix;
		//возвращаем объект единичной матрицы
		return matrix;
	}
	
	/**
	 * «аполн€ет массив значений единичной матрицы
	 */
	private void fillIdentityMatrix() {
		int ii = 0;
		for(int i = 0; i < m; i++) {
				matrixArray[i][ii] = 1;
				ii++;
		}
	}
	
	/**
	 * ¬ыводит в консоль значени€ элементов матрицы
	 */
	public void printMatrixArray() {
		System.out.println("«начени€ элементов матрицы");
		for(int i = 0; i < m; i++) {
			for(int ii = 0; ii < n; ii++){
				System.out.print(matrixArray[i][ii] + " ");
			}
			System.out.println("");
		}
	}

	/**
	 * ”множение матрицы на число
	 * @param multi множитель
	 */
	public void numberMultiplication(int multi) {
		for(int i = 0; i < m; i++) {
			for(int ii = 0; ii < n; ii++){
				matrixArray[i][ii] = matrixArray[i][ii] * multi;
			}
		}
	}
	
}
