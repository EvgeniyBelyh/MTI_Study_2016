package ru.edu.mti.homeworks.homework4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * �������� ���������� ����� � ������� ����������� ���������
 * @author ����� �������
 *
 */
public class Phonebook {
	
	private List<Contact> contactsInList = new ArrayList<Contact>(); //�������� � ��������� List
	private TreeSet<Contact> contactsInSet;  //�������� � ��������� Set
	private Map<String, Contact> contactsInMap = new HashMap<String, Contact>(); //�������� � ����� ������� Map	
	private Contact[] contactsArray; //������ ���������
	private String[] contactNames; //������ � ������� ��������� ��� ������ ����� �������� � �������� �������
	
	//����������� �� ���������
	public Phonebook () {
		
	}
	
	/**
	 * �����������
	 * @param contactCount - ���������� ������������ ��������� ���������
	 */
	public Phonebook (int contactCount) {
		this.fillCollections(contactCount);
		
	}
	
	//������� � �������
	public List<Contact> getContactsInList() {
		return contactsInList;
	}

	public void setContactsInList(List<Contact> contactsInList) {
		this.contactsInList = contactsInList;
	}

	public Set<Contact> getContactsInSet() {
		return contactsInSet;
	}

	public void setContactsInSet(TreeSet<Contact> contactsInSet) {
		this.contactsInSet = contactsInSet;
	}

	public Contact[] getContactsArray() {
		return contactsArray;
	}

	public void setContactsArray(Contact[] contactsArray) {
		this.contactsArray = contactsArray;
	}

	public Map<String, Contact> getContactsInMap() {
		return contactsInMap;
	}

	public void setContactsInMap(Map<String, Contact> contactsInMap) {
		this.contactsInMap = contactsInMap;
	}

	/**
	 * ��������� ��������� ����������� ���������� ��� ���������� ������
	 */
	private void fillCollections(int contactCount) {
		Contact contact;
		List<Contact> list;
		this.contactNames = new String[contactCount];
		
		System.out.println("���������� ��������� ��������");
		for(int i = 0; i < contactCount; i ++) {
			
			//���������� ��������� �������
			contact = Contact.generateVariantContact();
			//��������� ��� � ���������
			this.contactsInList.add(contact);
			this.contactNames[i] = contact.getName();
		}
		System.out.println("�������������! �������� �������� ��������� ��������");
		
		//����� �� ���� ��������� ��������� � ��������� ������ ��������� ���������
		for(Contact contact2 : this.contactsInList) {
			contact2.setRelatedContacts(this.contactsInList);			
		}
		
		System.out.println("������������ ��������� ��������");
		
		//������� ��������� ��������� � ������ ����������� ���������
		this.contactsInSet = new TreeSet<Contact>(new Comparator<Contact>(){
			public int compare(Contact contact1, Contact contact2) {
				return contact1.getName().compareTo(contact2.getName());
			}
		});
		
		//��������� ��������� ����������
		this.contactsInSet.addAll(this.contactsInList);
		
		for(Contact contact3 : this.contactsInSet) {		
			//��������� ����� �������� ������� ���������������� ����������
			this.contactsInMap.put(contact3.getName(), contact3);
		}
		
		//������� ������ ������� �������
		contactsArray = new Contact[contactsInList.size()];
		//��������� ������
		this.contactsInList.toArray(contactsArray);
		
		System.out.println("��������� ���������� ��� ���������");
	}
	
	/**
	 * � �������� ������� ������� ������
	 * @return  ���������� ���������� ���������� � ����� ��������
	 */
	public String reverseSearchInList() {
		
		Contact searchContact; //������� �������
		String maxPhone = ""; //����� ������������� ����� ��������
		long maxCount = 0; //���������� ����������
		long counter = 0; //�������
		
		//���� �� ���� ��������� � �������� �������
		for(int i = this.contactsInList.size() - 1; i >= 0; i--) {
			//���������� ������� �������
			searchContact = contactsInList.get(i);
			//�������� �������
			counter = 0;
			
			//�������� ������ ��������� ��������� ������� �������� � �������� �������
			for(int ii = this.contactsInList.size() - 1; ii >= 0; ii--) {
				//���� ������� ������� ����������� � ������� ��������� ���������, ��
				if(contactsInList.get(ii).getRelatedContacts().contains(searchContact)) {
					//����������� �������
					counter++;
				}
				
				//���� ������� ������ ������������� ���������� ����������, ����������� ����� ��������
				if(counter > maxCount) {
					maxCount = counter;
					maxPhone = searchContact.getPhone();
				}
			}
						
		}
		
		return ("������� " + maxPhone + " ����������� " + maxCount + " ���(�)");
	}
	
	/**
	 * � �������� ������� ������� ��������� 
	 * @return ���������� ���������� ���������� � ����� ��������
	 */
	public String reverseSearchInSet() {
		
		Contact searchContact; //������� �������
		String maxPhone = ""; //����� ������������� ����� ��������
		long maxCount = 0; //���������� ����������
		long counter = 0; //�������
		
		//����� �������� ���������
		NavigableSet<Contact> desSet = contactsInSet.descendingSet();
		
		//���� �� ���� ���������
		for(Iterator<Contact> iterator = desSet.iterator(); iterator.hasNext();) {
			//���������� ������� �������
			searchContact = (Contact) iterator.next();
			//�������� �������
			counter = 0;
			
			//�������� ������ ��������� ��������� ������� �������� � �������� �������
			for(Iterator<Contact> iterator2 = desSet.iterator(); iterator2.hasNext();) {
				Contact contact = (Contact) iterator2.next();
				//���� ������� ������� ����������� � ������� ��������� ���������, ��
				if(contact.getRelatedContacts().contains(searchContact)) {
					//����������� �������
					counter++;
				}
				
				//���� ������� ������ ������������� ���������� ����������, ����������� ����� ��������
				if(counter > maxCount) {
					maxCount = counter;
					maxPhone = searchContact.getPhone();
				}
			}
						
		}
		
		return ("������� " + maxPhone + " ����������� " + maxCount + " ���(�)");
	}
	
	/**
	 * � �������� ������� ������� ������ 
	 * @return ���������� ���������� ���������� � ����� ��������
	 */
	public String reverseSearchInArray() {
		Contact searchContact; //������� �������
		String maxPhone = ""; //����� ������������� ����� ��������
		long maxCount = 0; //���������� ����������
		long counter = 0; //�������
		
		//���� �� ���� ��������� � �������� �������
		for(int i = this.contactsArray.length - 1; i >= 0; i--) {
			//���������� ������� �������
			searchContact = contactsArray[i];
			//�������� �������
			counter = 0;
			
			//�������� ������ ��������� ��������� ������� �������� � �������� �������
			for(int ii = this.contactsArray.length - 1; ii >= 0; ii--) {
				//���� ������� ������� ����������� � ������� ��������� ���������, ��
				if(contactsArray[ii].getRelatedContacts().contains(searchContact)) {
					//����������� �������
					counter++;
				}
				
				//���� ������� ������ ������������� ���������� ����������, ����������� ����� ��������
				if(counter > maxCount) {
					maxCount = counter;
					maxPhone = searchContact.getPhone();
				}
			}
						
		}
		
		return ("������� " + maxPhone + " ����������� " + maxCount + " ���(�)");
	}
	
	
	/**
	 * � �������� ������� ������� ����� ��������
	 * @return  ���������� ���������� ���������� � ����� ��������
	 */
	public String reverseSearchInMap() {
		
		Contact searchContact; //������� �������
		String maxPhone = ""; //����� ������������� ����� ��������
		long maxCount = 0; //���������� ����������
		long counter = 0; //�������
		
		//���� �� ���� ��������� � �������� �������
		for(int i = this.contactNames.length - 1; i >= 0; i--) {
			//���������� ������� �������
			searchContact = contactsInMap.get(contactNames[i]);
			
			//�������� �������
			counter = 0;
			
			//�������� ������ ��������� ��������� ������� ��������
			for(Map.Entry<String, Contact> entry2 : contactsInMap.entrySet()) {
				//���� ������� ������� ����������� � ������� ��������� ���������, ��
				if(entry2.getValue().getRelatedContacts().contains(searchContact)) {
					//����������� �������
					counter++;
				}
				
				//���� ������� ������ ������������� ���������� ����������, ����������� ����� ��������
				if(counter > maxCount) {
					maxCount = counter;
					maxPhone = searchContact.getPhone();
				}
			}
						
		}
		
		return ("������� " + maxPhone + " ����������� " + maxCount + " ���(�)");
	}
}
