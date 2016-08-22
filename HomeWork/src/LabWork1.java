/**
 * ������������ ������ �1
 * @author ����� �������
 *
 */
public class LabWork1 {

	public static void main(String[] args) {
		
		//������� ������ 19 ������ ������������������ ���������
		System.out.println("������������������ ��������� (������ 19 �����)");
		int[] fibArray = fibonacciNumbers(19);
		for(int i : fibArray) {
			System.out.print(i + " ");
		}
		System.out.println("");
		
		//���������� 43 ���� ������������������ ���������
		fibArray = fibonacciNumbers(43);
		System.out.println("43 ���� ������������������ ���������: " + fibArray[42]);
		
		//���������� �������� �� 41 ���� ������������������ ������� ������
		fibArray = fibonacciNumbers(41);
		System.out.println("41 ���� ������������������ ���������: " + fibArray[40] +
				(isSimpleNumber(fibArray[40]) ? " �������� " : " �� �������� ") + 
				"������� ������");
		
		//���������� ���������� ����� ����� 1836311903 � ������������������ ���������		
		int i = 43;
		
		while(true) {
			fibArray = fibonacciNumbers(i);
			if(fibArray[i-1] == 1836311903) break;
			i++;
		}
		
		System.out.println("����� ����� 1836311903 � ������������������ ���������: " + i);
		
	}

	/**
	 * ������������ ������������������ ���������
	 * @param maxNumber - ����� ���������� ����� ������������������
	 * @return ������ �� ���������� ������������������ ���������
	 */
	public static int[] fibonacciNumbers(int maxNumber) {
		//������� ������ ��� �������� �����
		int[] fibArray = new int[maxNumber];
		//���������� ����� ��������
		fibArray[0] = 0;
		fibArray[1] = 1;
		
		//��������� ������ ���������� ����� ��������� �� maxNumber
		for(int i = 2; i < maxNumber; i++) {
			fibArray[i] = fibArray[i-1] + fibArray[i-2];
		}
		
		return fibArray;
	}
	
	
	/**
	 * ���������� ������� ����� ��� ���
	 * @param num ����� ��� ��������
	 * @return ������ - ���� ����� �������
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
		if(delCount <= 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
