package ru.edu.mti.homeworks.homework4;

/**
 * ����� �������� (��� ����� ������ ��������
 * @author ����� �������
 *
 */
public class ContactNumber {
	 private int number; //����� ��������

	 //�����������
	 public ContactNumber(int number) {
		 this.number = number;
	 }
	 
	 public boolean equals(Object obj) {
		 //���� ������ ������� ����, �� ���������� ����
		 if(!(obj instanceof ContactNumber)) return false;
		 //�������� ������ � ���� ��������
		 ContactNumber contactNumber = (ContactNumber) obj;

		 return this.number == contactNumber.number;
	 }
	 
	 
	 public int hashCode() {
			//���������� ��������� �������� ������� � �������� �� 1
			int prime = 44;
			int result = prime * 1;
			//��������� �������, ������������ � ������ String 
			result = result + Integer.valueOf(this.number).hashCode();
			//���������� ���������
			return result;
	 }
}
