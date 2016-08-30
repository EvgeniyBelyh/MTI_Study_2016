package ru.edu.mti.labworks;
import java.io.*;
import java.text.DateFormat;
import java.util.Date;

/**
 * ������������� ������
 * @author ����� �������
 *
 */
public class Logger extends Thread {
	
	private LoggerStatus status; //������������ �������� ������
	private String message; //���������
	private static final Long startTime = System.currentTimeMillis(); //����� ������� ������
	private File file = new File("logger.txt"); //���� ����
	
	public Logger() {
		this(null, LoggerStatus.INFO, "Default message");
	}
	
	public Logger(String name, LoggerStatus status, String message) {
		super(name);
		this.status = status;
		this.message = message;
	}
	
	public void run(){
		//����� � ������� � ������ ������ ������
		System.out.println("����� " + this.getName() + " ����� ���� ������");
		//�������� ������
		while((System.currentTimeMillis() - Logger.startTime) < 60000) {
			//����� � ���� ���������
			this.writeLog();
			try {
				//�������� �� ������������ ����� �� 5 ������
				Thread.sleep(Math.round((5000 * Math.random())));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//����� � ������� � ���������� ������ ������
		System.out.println("����� " + this.getName() + " �������� ���� ������");
	}
	
	/**
	 * ����� ��������� � ���� ����
	 */
	private synchronized void writeLog() {
		//���� ����� ���, �� ������� ���
		if(!this.file.exists()) {
			this.createLogFile();
		}

		FileWriter fileWriter = null;
				
		try {
			//��������� ���� ��� ���������� �������
			fileWriter = new FileWriter(this.file, true);
			//��������� ���������
			fileWriter.append(DateFormat.getTimeInstance().format(new Date(System.currentTimeMillis())) + " " +
				this.status + " " + this.getName() + " " + this.message +"\r\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				//��������� ����
				fileWriter.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ������� ���� ��� ������� ����
	 */
	public void createLogFile() {
		//���� ���� ����������, �� ������� �� ������
		if(this.file.exists()) {
			return;
		}
		//������� ��������� ���� � ����� ������� ��� ������� ����
		try {
			this.file.createNewFile();
		} catch (IOException e) {
			System.out.println("������ �������� ����� ����!");
			e.printStackTrace();
		}
	}
	
	
}
