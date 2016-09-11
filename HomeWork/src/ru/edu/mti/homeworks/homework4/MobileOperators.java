package ru.edu.mti.homeworks.homework4;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public enum MobileOperators { 
	MTS(asList(911, 917, 987)), 
	Beeline(asList(903, 905, 906, 900)), 
	MegaFon(asList(927, 929)), 
	Tele2(asList(900, 902)); 

	List<String> phoneRange; 

	MobileOperators(List<String> range){ 
		this.phoneRange = range; 
	} 

	public String randomPhone(){ 
		return phoneRange.get((int) (Math.round(Math.random() * (phoneRange.size() - 1)))); 
	} 

	public static List<String> asList(int... phones){ 
		List<String> result = new ArrayList<String>(phones.length); 
		for(int phone : phones){ 
			result.add(Integer.toString(phone)); 
		} 
		return result; 
	} 
} 

=======
public enum MobileOperators {
	MTS, Beeline, MegaFon, Tele2;
}
>>>>>>> refs/remotes/origin/master
