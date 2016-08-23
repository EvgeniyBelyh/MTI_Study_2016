/**
 * ����� �������
 * @author ����� �������
 *
 */
public class Matrix {
	
	private int m = 3, n = 3; //����������� �������
	private double[][] matrixArray; //������ ��� �������� ��������
	public static Matrix identityMatrix = Matrix.getIdentityMatrix(3); //��������� �������
	
	//����������� �� ���������
	public Matrix() {
		//���������� �������� ����� �� ���������
		matrixArray = new double[m][n];
	}
	
	//����������� � �������������
	public Matrix(int m, int n) {
		//������ ���������� �������� �����
		this.m = m;
		this.n = n;
		matrixArray = new double[m][n];
	}

	//����������� � ���������� ���������
	public Matrix(double[][] array) {
		//������ ���������� �������� �����
		this.m = array.length;
		this.n = array[0].length;
		matrixArray = array;
	}
	
	//������ ����������� 
	public int getM() {
		return m;
	}
	//������ ����������� 
	public int getN() {
		return n;
	}
	//������ ������� �������� �������
	public double[][] getMatrixArray() {
		return matrixArray;
	}
	//������ ������� �������� �������
	public void setMatrixArray(double[][] matrixArray) {
		//������ ������ ��������
		this.matrixArray = matrixArray;
		//������������ �����������
		this.m = matrixArray.length;
		this.n = matrixArray[0].length;
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
				System.out.print(this.matrixArray[i][ii] + " ");
			}
			System.out.println("");
		}
	}

	/**
	 * ��������� ������� �� �����
	 * @param multi ���������
	 * @return ������� � ����������� ������������
	 */
	public Matrix numberMultiplication(int multi) {
		//������� ������ �������� ���������� ��������� 
		double[][] resultArray = new double[m][n];
		for(int i = 0; i < m; i++) {
			for(int ii = 0; ii < n; ii++){
				resultArray[i][ii] = matrixArray[i][ii] * multi;
			}
		}
		//���������� ������ ����� �������
		return new Matrix(resultArray);
	}
	
	/**
	 * ��������� ������� �� �������
	 * @param multi �������-���������
	 * @return ������� � ����������� ������������
	 */
	public Matrix matrixMultiplication(Matrix matrix) {
		
		//��������� ����������� ������
		if(this.matrixArray[0].length != matrix.getMatrixArray().length) {
			System.out.println("������! ���������� �������� ������� ������� �� ��������� " +
								"� ����������� ����� ������� �������.");
			return null;
		}
		
		//����� ������ �������� ������� �������
		double[][] multiArray = matrix.getMatrixArray();
		//������� ����� ������ ��� �������� ���������� ���������
		double[][] resultArray = new double[m][multiArray[0].length];
		
		//�������� �������
		for (int i = 0; i < m; i++) {
			for(int ii = 0; ii < multiArray[0].length; ii++) {
				for(int iii = 0; iii < multiArray.length; iii++) {
					resultArray[i][ii] = resultArray[i][ii] + (matrixArray[i][iii] * multiArray[iii][ii]);
				}
			}
		}
		
		//���������� ������ ����� �������
		return new Matrix(resultArray);
	}
	
	/**
	 * �������� ����������� ���� ������
	 * @param matrix ������� ��� ���������
	 * @return ������ ���� ������� � ����������� �������������
	 */
	private boolean dimensionCheck(Matrix matrix) {
		//��������� ����������� ������
		if(this.m == matrix.getM() && this.n == matrix.getN()) {
			return true;
		}
		//���� ������� �� ��������� ������� ���������
		System.out.println("������! ����������� ������ ������ ���� ���������");
		return false;
	}
	
	/**
	 * ����� ������
	 * @param matrix �������-���������
	 * @return ����� ������� - ����� ������� ������� � ���������
	 */
	public Matrix sumMatrix(Matrix matrix) {
		//��������� ����������� ������
		if(dimensionCheck(matrix) != true) {
			return null;
		}
		
		//������� ����� ������ ��� �������� ���������� ��������
		double[][] resultArray = new double[m][n];
		double[][] sumArray = matrix.getMatrixArray();
		for(int i = 0; i < m; i++) {
			for(int ii = 0; ii < n; ii++){
				resultArray[i][ii] = matrixArray[i][ii] + sumArray[i][ii];
			}
		}
		
		//���������� ������ ����� �������
		return new Matrix(resultArray);
	}
	
	/**
	 * �������� ������
	 * @param matrix �������-����������
	 * @return ����� ������� - �������� ������� ������� � ���������
	 */
	public Matrix subtructionMatrix(Matrix matrix) {
		//��������� ����������� ������
		if(dimensionCheck(matrix) != true) {
			return null;
		}
		//������� ������ ������� �������, ���������� �� -1	
		Matrix resultMatrix = matrix.numberMultiplication(-1);		

		//���������� ��������� �������� ������� ������� � ������� �������, ���������� �� -1
		return this.sumMatrix(resultMatrix);
		
	}
	
	/**
	 * �������� ��������� ������������ ������� �� ��������� ������
	 * @return ����� - ������������ ������� 
	 */
	public double determinant() {

        double determ = 1.0;
        double cloneMatrixArray[][] = new double[n][n];
        int row[] = new int[n];
        int hold, I_pivot;
        double pivot;
        double abs_pivot;
        
        //���������, ��� ������� ����������
        if (m != n) {
            System.out.println("������! ������� �� ����������");
        }
        
        // ������� ����� �������� ������� ���������
        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < n; ii++) {
            	cloneMatrixArray[i][ii] = this.matrixArray[i][ii];
            }
        }
        // ��������� ������ ������������
        for (int i = 0; i < n; i++) {
            row[i] = i;
        }
        
        // ������ ��������� �����
        for (int k = 0; k < n - 1; k++) {
            // ������� ��������� ������� ��� ������
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
            // ���� ������� ����� ������, �� ������ ���� ������������ � ������ ������� �������
            if (I_pivot != k) {
                hold = row[k];
                row[k] = row[I_pivot];
                row[I_pivot] = hold;
                determ = -determ;
            }
            // �������� �� ���� �� ������� ���������
            if (abs_pivot < 1.0E-10) {
                return 0.0;
            } else {
            	//�������� ������������� �������� ������������ �� �������� �������� ������� ���������
            	determ = determ * pivot;
                // ����� �� ������
                for (int j = k + 1; j < n; j++) {
                	cloneMatrixArray[row[k]][j] = cloneMatrixArray[row[k]][j] / cloneMatrixArray[row[k]][k];
                }
                //  ���������� ����
                for (int i = 0; i < n; i++) {
                    if (i != k) {
                        for (int j = k + 1; j < n; j++) {
                        	cloneMatrixArray[row[i]][j] = cloneMatrixArray[row[i]][j] - cloneMatrixArray[row[i]][k] * cloneMatrixArray[row[k]][j];
                        }
                    }
                }
            }
            // ����� ����������� �����
        }
        // ����� �������� �����
        return determ * cloneMatrixArray[row[n - 1]][n - 1];
					
	}
	
}
