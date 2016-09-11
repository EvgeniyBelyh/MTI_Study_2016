package ru.edu.mti.homeworks.homework4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * ����� �������� � �����������
 * @author ����� �������
 *
 */
public class Multiplicity {
	
	/**
	 * ����������� ���� ��������
	 * @param set1 - ��������� 1
	 * @param set2 - ��������� 2
	 * @return - ������������ ���������
	 */
	public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
		//������� ������ ������� ���������
		Set<Integer> unionSet = new HashSet<>();
		//��������� � ������������ ��������� ��������� 1
		unionSet.addAll(set1);
		//��������� � ������������ ��������� ��������� 2
		unionSet.addAll(set2);
		//���������� ������������ ���������
		return unionSet;
	}
	
	/**
	 * ����������� ���� ��������
	 * @param set1 - ��������� 1
	 * @param set2 - ��������� 2
	 * @return - ��������� ����������� �������� 1 � 2
	 * 	 
	 */
	public static Set<Integer> intersect(Set<Integer> set1, Set<Integer> set2) {
		//������� ������ ������� ���������
		Set<Integer> intersectSet = new HashSet<>();
		//���� �� ��������� ��������� 1
		for (Iterator<Integer> iterator = set1.iterator(); iterator.hasNext();) {
			Integer number = (Integer) iterator.next();
			//���� ������� ��������� 1 ���� �� ��������� 2,
			if(set2.contains(number)) {
				//�� ��������� ������� � ������������ ���������
				intersectSet.add(number);
			}
		}
		
		//���������� ���������� ���������
		return intersectSet;
	}
}
