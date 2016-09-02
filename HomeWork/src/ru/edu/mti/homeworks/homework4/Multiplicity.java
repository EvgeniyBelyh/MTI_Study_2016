package ru.edu.mti.homeworks.homework4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Класс операций с множествами
 * @author Белых Евгений
 *
 */
public class Multiplicity {
	
	/**
	 * Объединение двух множеств
	 * @param set1 - множество 1
	 * @param set2 - множество 2
	 * @return - объединенное множество
	 */
	public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
		//создаем объект пустого множества
		Set<Integer> unionSet = new HashSet<>();
		//добавляем в объединенное множество множество 1
		unionSet.addAll(set1);
		//добавляем в объединенное множество множество 2
		unionSet.addAll(set2);
		//возвращаем объединенное множество
		return unionSet;
	}
	
	/**
	 * Пересечение двух множеств
	 * @param set1 - множество 1
	 * @param set2 - множество 2
	 * @return - множество пересечение множеств 1 и 2
	 * 	 
	 */
	public static Set<Integer> intersect(Set<Integer> set1, Set<Integer> set2) {
		//создаем объект пустого множества
		Set<Integer> intersectSet = new HashSet<>();
		//идем по элементам множества 1
		for (Iterator<Integer> iterator = set1.iterator(); iterator.hasNext();) {
			Integer number = (Integer) iterator.next();
			//если элемент множества 1 есть во множестве 2,
			if(set2.contains(number)) {
				//то добавляем элемент в возвращаемое множество
				intersectSet.add(number);
			}
		}
		
		//возвращаем полученное множество
		return intersectSet;
	}
}
