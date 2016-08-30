package ru.edu.mti.homeworks;
/**
 * ����� ��� ������ ������
 * @author ����� �������
 *
 */
public class TestMatrix {

	public static void main(String[] args) {
		//���������� ��� ���������� ������� �������� ������� ��� ���������� ������
		double[][] array1 = {{33, 34, 12},
						  	 {33, 19, 10},
						  	 {43, 71, 21}};

		double[][] array2 = {{1, 3, 5},
	  		  				 {5, 3, 4},
	  		  				 {9, 6, 7}};
		
		//������� ������� ���� ������ 
		Matrix matrix1 = new Matrix(array1);				
		Matrix matrix2 = new Matrix(array2);	
		
		//���� �������� ������
		Matrix resultMatrix = matrix1.sumMatrix(matrix2);
		System.out.println("���� ����� ���� ������ � ���������������� ������ � �������");
		
		resultMatrix.printMatrixArray();
		resultMatrix = null;
		
		//���� �������� ������
		resultMatrix = matrix1.subtructionMatrix(matrix2);
		System.out.println("----------------------------------------------------------");
		System.out.println("���� �������� ���� ������");
		resultMatrix.printMatrixArray();
		resultMatrix = null;
		
		//������� ��������� �������
		System.out.println("----------------------------------------------------------");
		System.out.println("������� ��������� ������� 4 �������");
		System.out.println("����� �����");
		Matrix.getIdentityMatrix(4).printMatrixArray();;
		System.out.println("����� ����������� ����");
		Matrix.identityMatrix.printMatrixArray();;
		
		//���� �������� �����������
		System.out.println("----------------------------------------------------------");
		System.out.println("���� �������� �����������");
		System.out.println("� ������ ������� " + matrix1.getM() + " ������ � " + 
							matrix1.getN() + " �������");
		
		//���� ��������� ������� �� �����
		System.out.println("----------------------------------------------------------");
		System.out.println("���� ��������� ������� �� ����� 2");
		resultMatrix = matrix1.numberMultiplication(2);
		resultMatrix.printMatrixArray();
		
		//���� ������������ ���� ������
		System.out.println("----------------------------------------------------------");
		System.out.println("���� ������������ ���� ������");
		resultMatrix = matrix1.matrixMultiplication(matrix2);
		resultMatrix.printMatrixArray();
		
		//���� ������� ������������
		System.out.println("----------------------------------------------------------");
		System.out.println("���� ������� ������������");
		System.out.println("������������ ������ ������� ����� " + matrix1.determinant());
		
		//���� ����������� ����� �������
		System.out.println("----------------------------------------------------------");
		System.out.println("���� ����������� ����� �������");
		System.out.println("���� ������ ������� ����� " + matrix1.rang());

		//���� ������� �������� �������
		System.out.println("----------------------------------------------------------");
		System.out.println("���� ������� �������� �������");
		matrix1.printMatrixArray();

		System.out.println("\n�������� �������");
		
		Matrix matrix3 = matrix1.inverse();
		matrix3.printMatrixArray();
		
		System.out.println("\n�������� �������� ������� �� ��������");
		resultMatrix = new Matrix(matrix1.matrixMultiplication(matrix3).getMatrixArray());
		resultMatrix.printMatrixArray();
	
		//�������������� ������
		System.out.println("----------------------------------------------------------");
		System.out.println("���� �������������� ������");
		System.out.println("�������������� ������� �������");
		matrix1.selfInvert();
		matrix1.printMatrixArray();
		System.out.println("�������������� ������� �������");
		Matrix.invertMatrix(matrix1);
		matrix1.printMatrixArray();
		
	}

}
