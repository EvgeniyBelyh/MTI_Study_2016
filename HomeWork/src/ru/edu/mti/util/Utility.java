package ru.edu.mti.util;
/**
 * ����� ������
 * @author ����� �������
 *
 */
public class Utility {
	
	/**
	 * ���������� ������� ����� ��� ���
	 * @param num - ����� ��� ��������
	 * @return ������ ���� ����� �������
	 */
	public static boolean isSimpleNumber(long num) {

		long delCount = 0; //���������� ���������
		//���� �� ���� ��������� ���������� �����
		for(long i = 1; i <= num; i++) {
			//���� ����� ������� ��� �������, �� ����������� ������� �� 1
			if(num%i == 0) {
				delCount++;
			}
		}
		//���� ��������� �� ������ 2, �.�. 1 � ��������� �����, �� ����� �������
		return delCount <= 2;
	}
}
