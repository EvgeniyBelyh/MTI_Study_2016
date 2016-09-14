package ru.edu.mti.homeworks;

import ru.edu.mti.homeworks.homework5.Quadratic;

/**
 * ����� �������
 * @author ����� �������
 *
 */
public class Matrix {
	
	private int m = 3, n = 3; //����������� �������
	private double[][] matrixArray; //������ ��� �������� ��������
	public static Matrix identityMatrix = Matrix.getIdentityMatrix(3); //��������� �������
	private int rang;
	
	//����������� �� ���������
	public Matrix() {
		//���������� �������� ����� �� ���������
		matrixArray = new double[m][n];
	}
	
	//����������� � �������������
	@Quadratic
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
	 * ������� ������ ������ ��� ����� ���������
	 */
	private void printReflectionTest() {
		printMatrixArray();
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
	 * ����������� ������� �������
	 */
	public void selfInvert() {
		//��������� ����� �������������� �������� ������� � ������� �� �������
		Matrix.invertMatrix(this);		
		
    }
	
	/**
	 * ����������� ������� �������
	 * @param matrix - �������
	 */
	public static void invertMatrix(Matrix matrix) {
		//����� ������ ��������� ������� �������
		double[][] array = matrix.getMatrixArray();
		//������� ������ ��� �������� ����������� ��������������
		double[][] transArray = new double[matrix.getM()][matrix.getN()];
		
		//����� �� ���� ��������� ������� � ����������� �������
		for(int i = 0; i < matrix.getM(); i++) {
			for(int ii = 0; ii < matrix.getN(); ii++){
				transArray[ii][i] = array[i][ii];
			}
		}
		//��������� ��������������� ������ � ������ ������� �������
		for(int i = 0; i < matrix.getM(); i++) {
			for(int ii = 0; ii < matrix.getN(); ii++){
				array[i][ii] = transArray[i][ii];
			}
		}	
	}
	
	/**
	 * �������� ������� � ������������ ���� ������� ������
	 * @return ��������� ������ � ���������� ����������� �������
	 */
	private double[][] transformMatrix() {
		int i = 0, j = 0, k = 0, l = 0; //���������� �������
		double r; //������������ �������� �������� 
		
		//������ ����� �������� ������� ���������
		double array[][] = new double[m][n];		
		for(int z = 0; z < m; z++) {
			for(int zz = 0; zz < n; zz++){
				array[z][zz] = this.matrixArray[z][zz];
			}
		}
		    
		while (i < m && j < n) {
	        // ���� ������������ ������� � j-� �������,
	        // ������� � i-� ������
	        r = 0.0;
	        for (k = i; k < m; ++k) {
	            if (Math.abs(array[k][j]) > r) {
	                l = k;      // �������� ����� ������
	                r = Math.abs(array[k][j]); // � ������������ �������
	            }
	        }

	        if (l != i) {
	            // ������ ������� i-� � l-� ������
	            for (k = j; k < n; ++k) {
	                r = array[i][k];
	                array[i][k] = array[l][k];
	                array[l][k] = (-r); // ������ ���� ������
	            }
	        }

	        // �������� j-� �������, ������� �� ������ i+1,
	        // �������� ����. �������������� ������� ����
	        for (k = i + 1; k < m; ++k) {
	            r = (-array[k][j] / array[i][j]);

	            // � k-� ������ ���������� i-�, ���������� �� r
	            array[k][j] = 0.0;
	            for (l = j+1; l < n; ++l) {
	            	array[k][l] = array[k][l] + r * array[i][l];
	            }
	        }

	        ++i; ++j;   // ��������� � ���������� ������
	    }
		
		this.rang = i; //���������� ���� �������, ��� ���������� ��������� �����
		
	    return array; // ������ ���������, ����������� � ������������ ����
	}

	
	/**
	 * ������������ ������������ �������
	 * @return ����� - ������������ �������
	 */
	public double determinant() {
		if(m != n) {
			System.out.println("������! ������� �� ����������. ���������� ������������ ����������");
			return 0;
		}
		
		//����� ����������� �������
		double array[][] = this.transformMatrix();
		//����������� �������� �� ������� ���������
		int ii = 0; 
		double result = 1.0;
		for(int i = 0; i < m; i++) {
			result = result * array[i][ii];
			ii++;
		}
		
		return Math.round(result);
		
	}
	
	/**
	 * ���������� ���� �������
	 * @return ����� - ���� �������
	 */
	public int rang() {
		//��������� ����� ���������� ������� � ������������ ����
		//����� ���������� ���������� ��������� �����
		this.transformMatrix();
		//���������� ���� �������
		return this.rang;
	}
	
	
	/**
	 * ������������ �������� �������
	 * @return ������ �������
	 */
	public Matrix inverse()
	{   		
		/* ���������� �������������� ������� �������� ���������
	       ��������� ��������� ������� */
		double[][] result = Matrix.getIdentityMatrix(m).getMatrixArray();
	    
	    //������� ����� ������� ��������� ������� �������
	    double[][] copy = new double[m][n];    
	    for(int z = 0; z < m; z++) {
	    	for(int zz = 0; zz < n; zz++){
	    		copy[z][zz] = this.matrixArray[z][zz];
	    	}
	    }
	    
	    /* �������� �� ��������� ������� �������
	       ������ ����. �� ������ ����� ���������� ������ ���
	       � �������� ������� ������������ � ������� ����������� */
	    for (int k = 0; k < m; ++k)
	    {
	        /* ���� ������� �� ������� ��������� � ��������
	           ������ - ����, �� ���� ������, ��� �������
	           ���� �� ������� �� �������, � ������ ������
	           ������� */
	        if (Math.abs(copy[k][k]) < 1e-8)
	        {           
	            // ��� �� �������, ������������� ���� ��������
	            for (int i = k + 1; i < m; ++i)
	            {
	                /* ���� ����� ������, ��� � ��� �� �������
	                   ������� ��������� ������� */
	                if (Math.abs(copy[i][k]) > 1e-8)
	                {
	                    /* ������ ��������� � �������� ������ �������
	                       ��� � �������� �������, ��� � � ��������� */
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
	        
	        // ���������� �������� - ������������ �������
	        double div = copy[k][k];
	        
	        /* ��� �������� �������� ������ ����� �� ������������
	           ������� ��� � �������� �������, ��� � � ��������� */
	        for (int j = 0; j < m; ++j)
	        {
	            copy[k][j] = copy[k][j] / div;
	            result[k][j] = result[k][j] / div;
	        }
	        
	        // ��� �� �������, ������� ����������� ���� ��������
	        for (int i = k + 1; i < m; ++i)
	        {
	            /* ���������� ��������� - ������� ��������� ������,
	               ������������� ��� ������������ ��������� ��������
	               ������ */
	            double multi = copy[i][k];
	            
	            /* �������� �� ��������� ������ ��������, ����������
	               �� ���������� ����� ��������� ��� � ��������,
	               ��� � � ��������� ������� */
	            for (int j = 0; j < m; ++j)
	            {
	                copy[i][j]   = copy[i][j] - multi * copy[k][j];
	                result[i][j] = result[i][j] - multi * result[k][j];
	            }
	        }
	    }
	    
	    
	    /* �������� �� �������� ����������� �������, ����������
	       �� ������ ����, ����� �����
	       �� ������ ����� ���������� �������� ���, � �� ��������
	       ������� ������������ ����������� ���������, � �� ��������� -
	       �������� */
	    for (int k = m - 1; k > 0; --k)
	    {
	        // ��� �� �������, ������� ����������� ���� ��������
	        for (int i = k - 1; i + 1 > 0; --i)
	        {
	            /* ���������� ��������� - ������� ��������� ������,
	               ������������� ��� ������������ ��������� ��������
	               ������ */
	            double multi = copy[i][k];
	            
	            /* �������� �� ��������� ������ ��������, ����������
	               �� ���������� ����� ��������� ��� � ��������,
	               ��� � � ��������� ������� */
	            for (int j = 0; j < m; ++j)
	            {
	                copy[i][j]   = copy[i][j] - multi * copy[k][j];
	                result[i][j] = result[i][j] - multi * result[k][j];
	            }
	        }
	    }
	    
	    // ���������� �������� �������
	    return new Matrix(result);
	}
	
	
}
