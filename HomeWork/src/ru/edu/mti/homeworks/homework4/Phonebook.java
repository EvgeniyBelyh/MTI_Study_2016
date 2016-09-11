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
 * Тестовая телефонная книга с разными коллекциями контактов
 * @author Белых Евгений
 *
 */
public class Phonebook {
	
	private List<Contact> contactsInList = new ArrayList<Contact>(); //контакты в коллекции List
	private TreeSet<Contact> contactsInSet;  //контакты в множестве Set
	private Map<String, Contact> contactsInMap = new HashMap<String, Contact>(); //контакты в карте записей Map	
	private Contact[] contactsArray; //массив контактов
	private String[] contactNames; //массив с именами контактов для обхода карты значений в обратном порядке
	
	//конструктор по умолчанию
	public Phonebook () {
		
	}
	
	/**
	 * Конструктор
	 * @param contactCount - количество генерируемых случайных контактов
	 */
	public Phonebook (int contactCount) {
		this.fillCollections(contactCount);
		
	}
	
	//геттеры и сеттеры
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
	 * Заполняет коллекции одинаковыми контактами для проведения тестов
	 */
	private void fillCollections(int contactCount) {
		Contact contact;
		List<Contact> list;
		this.contactNames = new String[contactCount];
		
		System.out.println("Генерируем случайные контакты");
		for(int i = 0; i < contactCount; i ++) {
			
			//генерируем случайный контакт
			contact = Contact.generateVariantContact();
			//добавляем его в коллекцию
			this.contactsInList.add(contact);
			this.contactNames[i] = contact.getName();
		}
		System.out.println("Сгенерировали! Начинаем собирать связанные контакты");
		
		//бежим по всем созданным контактам и заполняем списки связанных контактов
		for(Contact contact2 : this.contactsInList) {
			contact2.setRelatedContacts(this.contactsInList);			
		}
		
		System.out.println("Распределили связанные контакты");
		
		//создаем множество элементов с прямой сортировкой элементов
		this.contactsInSet = new TreeSet<Contact>(new Comparator<Contact>(){
			public int compare(Contact contact1, Contact contact2) {
				return contact1.getName().compareTo(contact2.getName());
			}
		});
		
		//заполняем множество контактами
		this.contactsInSet.addAll(this.contactsInList);
		
		for(Contact contact3 : this.contactsInSet) {		
			//заполняем карту значений заранее отсортированными значениями
			this.contactsInMap.put(contact3.getName(), contact3);
		}
		
		//создаем массив нужного размера
		contactsArray = new Contact[contactsInList.size()];
		//заполняем массив
		this.contactsInList.toArray(contactsArray);
		
		System.out.println("Заполнили контактами все коллекции");
	}
	
	/**
	 * в обратном порядке обходит список
	 * @return  возвращает количество повторений и номер телефона
	 */
	public String reverseSearchInList() {
		
		Contact searchContact; //искомый контакт
		String maxPhone = ""; //часто встречающийся номер телефона
		long maxCount = 0; //количество повторений
		long counter = 0; //счетчик
		
		//идем по всем контактам в обратном порядке
		for(int i = this.contactsInList.size() - 1; i >= 0; i--) {
			//определяем искомый контакт
			searchContact = contactsInList.get(i);
			//обнуляем счетчик
			counter = 0;
			
			//выбираем списки связанных контактов каждого контакта в обратном порядке
			for(int ii = this.contactsInList.size() - 1; ii >= 0; ii--) {
				//если искомый контакт встречается в списках связанных контактов, то
				if(contactsInList.get(ii).getRelatedContacts().contains(searchContact)) {
					//увеличиваем счетчик
					counter++;
				}
				
				//если счетчик больше максимального количества повторений, присваиваем новые значения
				if(counter > maxCount) {
					maxCount = counter;
					maxPhone = searchContact.getPhone();
				}
			}
						
		}
		
		return ("Телефон " + maxPhone + " встречается " + maxCount + " раз(а)");
	}
	
	/**
	 * в обратном порядке обходит множество 
	 * @return возвращает количество повторений и номер телефона
	 */
	public String reverseSearchInSet() {
		
		Contact searchContact; //искомый контакт
		String maxPhone = ""; //часто встречающийся номер телефона
		long maxCount = 0; //количество повторений
		long counter = 0; //счетчик
		
		//берем обратное множество
		NavigableSet<Contact> desSet = contactsInSet.descendingSet();
		
		//идем по всем контактам
		for(Iterator<Contact> iterator = desSet.iterator(); iterator.hasNext();) {
			//определяем искомый контакт
			searchContact = (Contact) iterator.next();
			//обнуляем счетчик
			counter = 0;
			
			//выбираем списки связанных контактов каждого контакта в обратном порядке
			for(Iterator<Contact> iterator2 = desSet.iterator(); iterator2.hasNext();) {
				Contact contact = (Contact) iterator2.next();
				//если искомый контакт встречается в списках связанных контактов, то
				if(contact.getRelatedContacts().contains(searchContact)) {
					//увеличиваем счетчик
					counter++;
				}
				
				//если счетчик больше максимального количества повторений, присваиваем новые значения
				if(counter > maxCount) {
					maxCount = counter;
					maxPhone = searchContact.getPhone();
				}
			}
						
		}
		
		return ("Телефон " + maxPhone + " встречается " + maxCount + " раз(а)");
	}
	
	/**
	 * в обратном порядке обходит массив 
	 * @return возвращает количество повторений и номер телефона
	 */
	public String reverseSearchInArray() {
		Contact searchContact; //искомый контакт
		String maxPhone = ""; //часто встречающийся номер телефона
		long maxCount = 0; //количество повторений
		long counter = 0; //счетчик
		
		//идем по всем контактам в обратном порядке
		for(int i = this.contactsArray.length - 1; i >= 0; i--) {
			//определяем искомый контакт
			searchContact = contactsArray[i];
			//обнуляем счетчик
			counter = 0;
			
			//выбираем списки связанных контактов каждого контакта в обратном порядке
			for(int ii = this.contactsArray.length - 1; ii >= 0; ii--) {
				//если искомый контакт встречается в списках связанных контактов, то
				if(contactsArray[ii].getRelatedContacts().contains(searchContact)) {
					//увеличиваем счетчик
					counter++;
				}
				
				//если счетчик больше максимального количества повторений, присваиваем новые значения
				if(counter > maxCount) {
					maxCount = counter;
					maxPhone = searchContact.getPhone();
				}
			}
						
		}
		
		return ("Телефон " + maxPhone + " встречается " + maxCount + " раз(а)");
	}
	
	
	/**
	 * в обратном порядке обходит карту значений
	 * @return  возвращает количество повторений и номер телефона
	 */
	public String reverseSearchInMap() {
		
		Contact searchContact; //искомый контакт
		String maxPhone = ""; //часто встречающийся номер телефона
		long maxCount = 0; //количество повторений
		long counter = 0; //счетчик
		
		//идем по всем контактам в обратном порядке
		for(int i = this.contactNames.length - 1; i >= 0; i--) {
			//определяем искомый контакт
			searchContact = contactsInMap.get(contactNames[i]);
			
			//обнуляем счетчик
			counter = 0;
			
			//выбираем списки связанных контактов каждого контакта
			for(Map.Entry<String, Contact> entry2 : contactsInMap.entrySet()) {
				//если искомый контакт встречается в списках связанных контактов, то
				if(entry2.getValue().getRelatedContacts().contains(searchContact)) {
					//увеличиваем счетчик
					counter++;
				}
				
				//если счетчик больше максимального количества повторений, присваиваем новые значения
				if(counter > maxCount) {
					maxCount = counter;
					maxPhone = searchContact.getPhone();
				}
			}
						
		}
		
		return ("Телефон " + maxPhone + " встречается " + maxCount + " раз(а)");
	}
}
