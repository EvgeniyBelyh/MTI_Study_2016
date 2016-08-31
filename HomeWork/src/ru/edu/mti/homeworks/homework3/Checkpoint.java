package ru.edu.mti.homeworks.homework3;

/**
 * ����� ����������-����������� ������
 * @author ����� �������
 *
 */
public class Checkpoint {
	
	public static final double CARTAX = 1000.0; //��������� ������� ��������� ����
	public static final double TRUCKTAX = 2000.0; //��������� ������� ���������
	public static final double TRAILERTAX = 500.0; //��������� ������� � ��������
	public static final double OVERWEIGHT = 800.0; //����� �� ��������
	public static final double SPEEDLIMIT = 60.0; //����������� �������� ��������
	
	/**
	 * ������������ ������ ������ �� ���������� �������� �������� ����
	 * ��� ������� ������� ����������� �������� �������
	 * @param speed - �������� ����������
	 * @return - ������ ������ �� ���������� ��������
	 */
	private double fineCalculation(double speed) {
		double fine = 0.0; //������ ������
		double overSpeed = speed - Checkpoint.SPEEDLIMIT; //������ ����������
		
		//���� ��� ����������, �� ������ ���
		if(overSpeed <= 0) {
			return 0.0;
		}
		
		if(overSpeed > 20.0 && overSpeed <= 40.0) { // ���������� �� 40 ��/�
			fine = 500.0;
		} else if(overSpeed > 40.0 && overSpeed <= 60.0) { // ���������� �� 40 �� 60 ��/�
			fine = 1000.0;
		} else if(overSpeed > 60.0 && overSpeed <= 80.0) { // ���������� �� 60 �� 80 ��/�
			fine = 2000.0;
		} else if (overSpeed > 80.0){ // ���������� ����� 80 ��/�
			fine = 5000.0;
		}
		
		//���������� ������ ������
		return fine;
	}
	
	
	/**
	 * ����������� ����� �� ������ ����� ���
	 * @param car - ������ ������ Car
	 * @return - ������ ����� �� ������
	 */
	private double fareCalculation(Car car) {
		double fare = 0.0;
		
		//���� ����. ���������, �� ����� �� ���������
		if(car.isSpecial()) {
			return 0.0;
		}
		
		//���������� �������� �� ������ ����������
		if(car instanceof Truck) {
			//������ ���������� � ������� ���������
			Truck truck = (Truck) car;
			//��������� ����������� ����� �� ������
			fare = fare + Checkpoint.TRUCKTAX;
			//���� ���� ������, �� ��������� ����� �� ������
			if(truck.isTrailer()) {
				fare = fare + Checkpoint.TRAILERTAX;
			}
			//���� ���� �������, �� ������� ����� �� �������
			if(truck.getWeight() > 10.0) {
				fare = fare + Checkpoint.OVERWEIGHT;
			}
			
		} else { // �� �������� ����������
			fare = fare + Checkpoint.CARTAX;
		}
		
		return fare;
	}
	
	/**
	 * ��������� ���������� �� ���. ������� ���������� �� ���������� � ����� �� ������
	 * @param car ������ ����������
	 * @throws InvalidHeightException 
	 * @throws OverspeedException 
	 */
	public void checkIn(Car car) throws InvalidHeightException, OverspeedException {
		double fare = 0.0;
		double fine = 0.0;
		
		//���������� �������� �� ������ ����������
		if(car instanceof Truck) {
			//������ ���������� � ������� ���������
			Truck truck = (Truck) car;
			//������� ���������� � ���������
			System.out.println(truck);
			//���� ������ ��������� ������ 4 ������, ��
			if(truck.getHeight() > 4.0) {
				//���������� ������ �������������� ������ ���������
				throw new InvalidHeightException("�������� " + truck.getName() + 
						" �� ����� �������� ����� ��� ��� ��� ��� ������ ������ 4 ������");			
			}
		} else {
			//������� ���������� � �������� ����������
			System.out.println(car);
		}
		
		//���� ������� ������ 180, �� ���������� ����������
		if(car.getSpeed() > 180.0) {
			throw new OverspeedException("�������� ������ 180��/�! ������� ��� ������! " +
								"���-�� ����� ����� ������ ������!!!");
		}
		
		//������� ����� �� ������
		fare = this.fareCalculation(car);
		//������� ������ ������
		fine = this.fineCalculation(car.getSpeed());
		
		//������� ����� � ������ 
		System.out.println("����� �� ������: " + fare + " ���. " +
							(fine != 0.0 ? "����� ������: " + fine + " ���. " : "") + 
							"����� � ������: " + (fare + fine) + " ���.");
	}
	
}
