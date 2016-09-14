package ru.edu.mti.homeworks.homework5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ru.edu.mti.homeworks.*;

/**
 * ����� ��� ������ ���������
 * @author ����� �������
 *
 */
public class TestReflaction {

	public static void main(String[] args) {
		
		//������� ���������� ������ ������
		Class matrixClass1 = Matrix.class;
		
		Matrix matrix = new Matrix();
		Class matrixClass2 = matrix.getClass();
		
		try {
			Class matrixClass3 = Class.forName("ru.edu.mti.homeworks.Matrix");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//������� ������� ������ ������, ������� ������ ������������
		try {
			//�������� ����������� �� ��������� � �������� ������ � ���� Matrix
			Matrix matrix1 = (Matrix) matrixClass1.newInstance();
			Matrix matrix2 = null;
			
			System.out.println("�������� ����������� �� ���������. ������ �������� ������� 3�3");
			System.out.println("��������� �������: " + matrix1.getM() + "x" + matrix1.getN());
			
			/*
			 * �������� ����������� ������� � �����������
			 */
			
			//�������� ����� ������������� ������ ������
			Constructor[] constructors = matrixClass2.getConstructors();
			//������� ������ � ���� ����������� � ���������� Quadratic
			for(Constructor constructor : constructors) {
				if(constructor.getAnnotation(Quadratic.class) != null) {
					matrix2 = (Matrix) constructor.newInstance(5,5);
					Quadratic quad = (Quadratic) constructor.getAnnotation(Quadratic.class);
					System.out.println("\n���� ��������� Quadratic\n�������� ��������� " + quad.isQuadratic());
					break;
				}
			}
			
			
			System.out.println("\n�������� ����������� � �����������. ������ �������� ������� 5�5");
			System.out.println("��������� �������: " + matrix2.getM() + "x" + matrix2.getN());
			
			//�������� ���� ������
			Field[] fields = matrixClass1.getDeclaredFields();
			System.out.println("\n������ ����� ������ ������");
			//������� ��� � ��� ���� � �������
			for(Field field : fields) {
				System.out.println("��� ����: " + field.getName() + "  ---  ��� ����: " + field.getType());
			}
			
			//�������� ������ ������ ������
			Method[] methods = matrixClass1.getDeclaredMethods();
			System.out.println("\n������ ������� ������ ������");
			//������� ������ ������ ������ � �������
			for(Method method : methods) {
				System.out.println("��� ������: " + method.getName());
			}
			
			/*
			 * ��������� �������� � ��������� ������
			 */
			
			//������� ������� � ���������� �������
			double[][] array1 = {{33, 34, 12},
				  	 			 {33, 19, 10},
				  	 			 {43, 71, 21}};
			
			double[][] array2 = {{1, 3, 5},
		  				 		 {5, 3, 4},
		  				 		 {9, 6, 7}};
			
			//�������� �����������, ������� ��������� ������
			Constructor constructor = matrixClass1.getConstructor(double[][].class);
			matrix1 = (Matrix) constructor.newInstance(array1);
			matrix2 = (Matrix) constructor.newInstance(array2);
			
			Matrix matrixResult = null;
			
			//����� �� ���� ������� � ���� ������ �������� � ���������
			for(Method method : methods) {
				//���� ����� ��������, �� ���������� �������
				if(method.getName() == "sumMatrix") {
					matrixResult = (Matrix) method.invoke(matrix1, matrix2);
					System.out.println("\n�������� ������ ����� ���������");
					matrixResult.printMatrixArray();
				}
				
				//���� ����� ���������, �� �������� �������
				if(method.getName() == "subtructionMatrix") {
					matrixResult = (Matrix) method.invoke(matrix1, matrix2);
					System.out.println("\n��������� ������ ����� ���������");
					matrixResult.printMatrixArray();
				}
			}
			
			//�������� ������� ��������� ����� ������ �������
			System.out.println("\n�������� ��������� ����� ������ �������. �������� ��������� ��������");
			//������� ������ ������ ������
			Method method = matrixClass1.getDeclaredMethod("printReflectionTest", null);
			//������ ��� ��������� ��� ����������
			method.setAccessible(true);
			//��������� �����
			method.invoke(matrixResult, null);
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		

	}

}
