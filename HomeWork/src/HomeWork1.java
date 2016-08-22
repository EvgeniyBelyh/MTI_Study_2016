import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeWork1 {

	public static void main(String[] args) {

		System.out.println("---------------------------------------");
		System.out.println("--------------������� 1----------------");
		System.out.println("---------------------------------------");
		System.out.println("");

		int a = 0, b = 0, c = 0;
		
		InputStreamReader inputStreamReader = null;
		BufferedReader br = null;
		
		long l = 0;
		long root = 0;
		
		try {
			
			inputStreamReader = new InputStreamReader(System.in);
			br = new BufferedReader(inputStreamReader);
			
			System.out.println("������� �������� �");
			a = Integer.parseInt(br.readLine());

			System.out.println("������� �������� b");
			b = Integer.parseInt(br.readLine());

			System.out.println("������� �������� c");
			c = Integer.parseInt(br.readLine());

			//������ ���������� ���������
			System.out.println(squareEquation(a, b, c));
			
			System.out.println("");
			System.out.println("---------------------------------------");
			System.out.println("--------------������� 3----------------");
			System.out.println("---------------------------------------");

			//��������� ���������� ������ �� �����

			System.out.println("������� ����� ��� ������� ����������� �����");
			l = Long.parseLong(br.readLine());		

			root = squareRoot(l);

			if(root*root < l) {
				System.out.println("��������� ����� �������� ����������� ����� ����� " + l
						+ " ��������� " + root);
			} else {
				System.out.println("�������� ����������� ����� ����� " + l
						+ " ��������� " + root);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} 
		
		finally {
			try {
				br.close();
				inputStreamReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("--------------������� 2----------------");
		System.out.println("---------------------------------------");
		System.out.println("");
		
		//������� ��� ������� ����� � ���������� �� 1 �� 1000
		printSimpleNumbers(1000);

	}

	/*
	 * ����� ���������� ������� ����� ��� ���
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

	/*
	 * ������� ��� ������� ����� � ��������� �� 1 �� maxnumber
	 */

	public static void printSimpleNumbers(long maxnumber) {
		for(int i = 1; i <= maxnumber; i++) {
			if(isSimpleNumber(i)) {
				System.out.print(i + " ");
			}
		}
	}

	/*
	 * ������������ ���������� ������ ������ ����� ��������� � ����������
	 */

	public static long squareRoot(long num) {
		long i = 0;

		//��������� �����, ������� �������� ������ ��� ����� ���������� �����
		while(degree(i+1) <= num) {
			i++;
		}
		//���������� ��������� ����� ������ ���������� �����
		return i;
	}


	/*
	 * �������� ����� � ������� ���������
	 */
	private static long degree(long num) {
		long result = 0;

		for(long i = 0; i < num; i++) {
			result = result + num;
		}

		return result;
	}

	/*
	 * ������ ���������� ���������
	 */
	public static String squareEquation(int a, int b, int c) {

		//��������� �������� �. ���� 0, �� ���������� ����� � �������
		if(a == 0) {
			return "������ ����������� �� ����� ���� 0";
		}

		String result = "";

		//������� ������������
		int d = b*b - 4*a*c;

		//� ����������� �� �������� ������������� ������� ������� ���������
		if(d == 0) {
			result = "��������� ����� 2 ���������� ����� x1 = x2 = " + (-(b/2*a));
		} else if (d < 0) {
			result = "��� ������������� ������� ���������";
		} else {
			result = "��������� ����� 2 ����� �1 = " + ((-b - Math.sqrt(d))/(2*a)) + " x2 = " +
					+((-b + Math.sqrt(d))/(2*a));
		}

		return result;
	}



}
