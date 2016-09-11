package ru.edu.mti.homeworks.homework4;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс контакта телефонного справочника
 * @author Белых Евгений
 *
 */
public class Contact {
	
	private String name; //ФИО
	private String phone; //номер телефона
	private boolean mobile; //true - если телефон сотовый, иначе городской
	private MobileOperators operator; //оператор сотовой связи
	private List<Contact> relatedContacts; //список связанных контактов
	private static final int RELATED_CONTACT_POOL_SIZE = 10; //количество связанных контактов
	
	//конструкторы
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
	
	//геттеры и сеттеры
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
		//создаем список связанных контактов заданного размера
		this.relatedContacts = new ArrayList<Contact>(Contact.RELATED_CONTACT_POOL_SIZE); 

		//собираем 10 контактов
		for(int i = 0; i < Contact.RELATED_CONTACT_POOL_SIZE; i++) {
			//добавляем случайный контакт
			this.relatedContacts.add(relatedContacts.get((int) (Math.round(Math.random() * (relatedContacts.size() - 1)))));
		}
	}

	
	/**
	 * генерирует случайный контакт с 10 случайными контактами в списке связанных контактов
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
	 * генерирует случайный номер телефона
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
	 * форматируем вывод контакта в консоль
	 */
	public String toString() {
		return "Contact " + name + ", phone " + phone;
	}
	
}
