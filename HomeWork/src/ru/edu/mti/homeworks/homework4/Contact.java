package ru.edu.mti.homeworks.homework4;

import java.util.ArrayList;
import java.util.List;

/**
 * ����� �������� ����������� �����������
 * @author ����� �������
 *
 */
public class Contact {
	
	private String name; //���
	private String phone; //����� ��������
	private boolean mobile; //true - ���� ������� �������, ����� ���������
	private MobileOperators operator; //�������� ������� �����
	private List<Contact> relatedContacts; //������ ��������� ���������
	
	//������������
	public Contact() {
		//generateVariantContact();
	}

	public Contact(String name, String phone, boolean mobile, MobileOperators operator, List<Contact> relatedContacts) {
		super();
		this.name = name;
		this.phone = phone;
		this.mobile = mobile;
		this.operator = operator;
		this.relatedContacts = relatedContacts;
	}
	
	//������� � �������
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isMobile() {
		return mobile;
	}

	public void setMobile(boolean mobile) {
		this.mobile = mobile;
	}

	public MobileOperators getOperator() {
		return operator;
	}

	public void setOperator(MobileOperators operator) {
		this.operator = operator;
	}

	public List<Contact> getRelatedContacts() {
		return relatedContacts;
	}

	public void setRelatedContacts(List<Contact> relatedContacts) {
		this.relatedContacts = relatedContacts;
	}
	
	/**
	 * ���������� ��������� ������� � 10 ���������� ���������� � ������ ��������� ���������
	 * @return
	 */
	public static Contact generateVariantContact() {
		
		Contact contact = new Contact();
		String phoneNumber = Contact.generateVariantPhone();
		contact.setPhone(phoneNumber);
		contact.setMobile(Math.random() < 0.5);
		contact.name = (phoneNumber + "_Belyh_Evgeniy");

		return contact;
	}
	
	/**
	 * ���������� ��������� ����� ��������
	 * @return
	 */
	private static String generateVariantPhone() {
		
		String phone = "";
		
		for(int i = 0; i < 7; i++) {
			phone = phone + Math.round(Math.random() * 9);
		}
		
		return phone;
	}
	
	/**
	 * ����������� ����� �������� � �������
	 */
	public String toString() {
		return "Contact " + name + ", phone " + phone;
	}
}
