package ru.edu.mti.labworks;
/**
 * ������������ �������������� �������
 * @author ����� �������
 *
 */
public class TestLogger {
	
	public static void main(String[] args) {
		//������� ��� ������
		Logger logger1 = new Logger("Logger1",LoggerStatus.INFO,"Info Massage");
		Logger logger2 = new Logger("Logger2",LoggerStatus.WARN,"Warn Massage");
		Logger logger3 = new Logger("Logger3",LoggerStatus.CRITICAL,"Critical Massage");
		
		System.out.println("������ ���������. �������� ������");
		
		//�������� ������
		logger1.start();
		logger2.start();
		logger3.start();
		
	}
}
