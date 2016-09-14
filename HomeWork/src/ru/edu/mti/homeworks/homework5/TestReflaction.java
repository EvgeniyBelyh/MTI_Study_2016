package ru.edu.mti.homeworks.homework5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ru.edu.mti.homeworks.*;

/**
 * Класс для тестов рефлексии
 * @author Белых Евгений
 *
 */
public class TestReflaction {

	public static void main(String[] args) {
		
		//создаем экземпляры класса матриц
		Class matrixClass1 = Matrix.class;
		
		Matrix matrix = new Matrix();
		Class matrixClass2 = matrix.getClass();
		
		try {
			Class matrixClass3 = Class.forName("ru.edu.mti.homeworks.Matrix");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//создаем объекты класса матриц, вызывая разные конструкторы
		try {
			//вызываем конструктор по умолчанию и приводим объект к типу Matrix
			Matrix matrix1 = (Matrix) matrixClass1.newInstance();
			Matrix matrix2 = null;
			
			System.out.println("Вызываем конструктор по умолчанию. Должны получить матрицу 3х3");
			System.out.println("Проверяем размеры: " + matrix1.getM() + "x" + matrix1.getN());
			
			/*
			 * вызываем конструктор матрицы с параметрами
			 */
			
			//получаем масси конструкторов класса матриц
			Constructor[] constructors = matrixClass2.getConstructors();
			//обходим массив и ищем конструктор с аннотацией Quadratic
			for(Constructor constructor : constructors) {
				if(constructor.getAnnotation(Quadratic.class) != null) {
					matrix2 = (Matrix) constructor.newInstance(5,5);
					Quadratic quad = (Quadratic) constructor.getAnnotation(Quadratic.class);
					System.out.println("\nТест аннотации Quadratic\nЗначение аннотации " + quad.isQuadratic());
					break;
				}
			}
			
			
			System.out.println("\nВызываем конструктор с параметрами. Должны получить матрицу 5х5");
			System.out.println("Проверяем размеры: " + matrix2.getM() + "x" + matrix2.getN());
			
			//получаем поля класса
			Field[] fields = matrixClass1.getDeclaredFields();
			System.out.println("\nСписок полей класса матриц");
			//выводим имя и тип поля в консоль
			for(Field field : fields) {
				System.out.println("Имя поля: " + field.getName() + "  ---  Тип поля: " + field.getType());
			}
			
			//получаем методы класса матриц
			Method[] methods = matrixClass1.getDeclaredMethods();
			System.out.println("\nСписок методов класса матриц");
			//выводим методы класса матриц в консоль
			for(Method method : methods) {
				System.out.println("Имя метода: " + method.getName());
			}
			
			/*
			 * тестируем сложение и вычитание матриц
			 */
			
			//создаем массивы с элементами матрицы
			double[][] array1 = {{33, 34, 12},
				  	 			 {33, 19, 10},
				  	 			 {43, 71, 21}};
			
			double[][] array2 = {{1, 3, 5},
		  				 		 {5, 3, 4},
		  				 		 {9, 6, 7}};
			
			//вызываем конструктор, который принимает массив
			Constructor constructor = matrixClass1.getConstructor(double[][].class);
			matrix1 = (Matrix) constructor.newInstance(array1);
			matrix2 = (Matrix) constructor.newInstance(array2);
			
			Matrix matrixResult = null;
			
			//бежим по всем методам и ищем методы сложения и вычитания
			for(Method method : methods) {
				//если нашли сложение, то складываем матрицы
				if(method.getName() == "sumMatrix") {
					matrixResult = (Matrix) method.invoke(matrix1, matrix2);
					System.out.println("\nСложение матриц через рефлексию");
					matrixResult.printMatrixArray();
				}
				
				//если нашли вычитание, то вычитаем матрицы
				if(method.getName() == "subtructionMatrix") {
					matrixResult = (Matrix) method.invoke(matrix1, matrix2);
					System.out.println("\nВычетание матриц через рефлексию");
					matrixResult.printMatrixArray();
				}
			}
			
			//Пытаемся вызвать приватный метод печати матрицы
			System.out.println("\nВызываем приватный метод печати матрицы. Печатаем результат сложения");
			//создаем объект метода мечати
			Method method = matrixClass1.getDeclaredMethod("printReflectionTest", null);
			//делаем его доступным для выполнения
			method.setAccessible(true);
			//запускаем метод
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
