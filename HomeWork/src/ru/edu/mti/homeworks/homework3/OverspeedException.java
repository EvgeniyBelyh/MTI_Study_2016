package ru.edu.mti.homeworks.homework3;

/**
 * Класс ошибки превышения скорости
 * @author Белых Евгений
 *
 */
public class OverspeedException extends Exception {
	
	public OverspeedException(String message) {
		super(message);
	}
}
