/**
 * ����� �������
 * @author ����� �������
 *
 */
public class Matrix {
	
	private int m = 3, n = 3; //����������� �������
	public int[][] matrixArray; //������ ��� �������� ��������
	public static Matrix identityMatrix = Matrix.getIdentityMatrix(3); //��������� �������
	
	//����������� �� ���������
	public Matrix() {
		//���������� �������� ����� �� ���������
		matrixArray = new int[m][n];
	}
	
	//����������� � �����������
	public Matrix(int m, int n) {
		//������ ���������� �������� �����
		this.m = m;
		this.n = n;
		matrixArray = new int[m][n];
	}
	
	//������� �����
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
	 * ������� ��������� ������� �������� �����������
	 * @param dimension - �����������
	 * @return ������ ��������� �������
	 */
	public static Matrix getIdentityMatrix(int dimension) {
		//������� ���������� �������
		Matrix matrix = new Matrix(dimension,dimension);
		//��������� �������
		matrix.fillIdentityMatrix();
		//�������������� ����������� ����������
		identityMatrix = matrix;
		//���������� ������ ��������� �������
		return matrix;
	}
	
	/**
	 * ��������� ������ �������� ��������� �������
	 */
	private void fillIdentityMatrix() {
		int ii = 0;
		for(int i = 0; i < m; i++) {
				matrixArray[i][ii] = 1;
				ii++;
		}
	}
	
	/**
	 * ������� � ������� �������� ��������� �������
	 */
	public void printMatrixArray() {
		System.out.println("�������� ��������� �������");
		for(int i = 0; i < m; i++) {
			for(int ii = 0; ii < n; ii++){
				System.out.print(matrixArray[i][ii] + " ");
			}
			System.out.println("");
		}
	}

	/**
	 * ��������� ������� �� �����
	 * @param multi ���������
	 */
	public void numberMultiplication(int multi) {
		for(int i = 0; i < m; i++) {
			for(int ii = 0; ii < n; ii++){
				matrixArray[i][ii] = matrixArray[i][ii] * multi;
			}
		}
	}
	
}
