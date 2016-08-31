package ru.edu.mti.homeworks.homework3;

/**
 * Класс ошибки превышения высоты грузовика
 * @author Белых Евгений
 *
 */
public class InvalidHeightException extends Exception {
	
	public InvalidHeightException(String message) {
		super(message);
	}
}
