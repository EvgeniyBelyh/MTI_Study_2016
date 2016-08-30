package ru.edu.mti.labworks;
import java.io.*;
import java.text.DateFormat;
import java.util.Date;

/**
 * Многопоточный логгер
 * @author Белых Евгений
 *
 */
public class Logger extends Thread {
	
	private LoggerStatus status; //перечисление статусов потока
	private String message; //сообщение
	private static final Long startTime = System.currentTimeMillis(); //время запуска потока
	private File file = new File("logger.txt"); //файл лога
	
	public Logger() {
		this(null, LoggerStatus.INFO, "Default message");
	}
	
	public Logger(String name, LoggerStatus status, String message) {
		super(name);
		this.status = status;
		this.message = message;
	}
	
	public void run(){
		//пишем в консоль о начале работы потока
		System.out.println("Поток " + this.getName() + " начал свою работу");
		//засекаем минуту
		while((System.currentTimeMillis() - Logger.startTime) < 60000) {
			//пишем в файл сообщение
			this.writeLog();
			try {
				//засыпаем на произвольное время до 5 секунд
				Thread.sleep(Math.round((5000 * Math.random())));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//пишем в консоль о завершении работы потока
		System.out.println("Поток " + this.getName() + " закончил свою работу");
	}
	
	/**
	 * Пишет сообщение в файл лога
	 */
	private synchronized void writeLog() {
		//если файла нет, то создаем его
		if(!this.file.exists()) {
			this.createLogFile();
		}

		FileWriter fileWriter = null;
				
		try {
			//открываем файл для добавления записей
			fileWriter = new FileWriter(this.file, true);
			//добавляем сообщение
			fileWriter.append(DateFormat.getTimeInstance().format(new Date(System.currentTimeMillis())) + " " +
				this.status + " " + this.getName() + " " + this.message +"\r\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				//закрываем файл
				fileWriter.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Создает файл для ведения лога
	 */
	public void createLogFile() {
		//если файл существует, то выходим из метода
		if(this.file.exists()) {
			return;
		}
		//создаем текстовый файл в папке проекта для ведения лога
		try {
			this.file.createNewFile();
		} catch (IOException e) {
			System.out.println("Ошибка создания файла лога!");
			e.printStackTrace();
		}
	}
	
	
}
