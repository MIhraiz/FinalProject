package domain;

import java.util.ArrayList;

public abstract class Search {

	public Search() {
		super();
	}
	
	public static ArrayList<Person> search(ArrayList<Person> students, ArrayList<Person> employees, String name) {
		
		ArrayList<Person> persons = new ArrayList<Person>();
		
		for(int i = 0; i< students.size(); i++) {
			if(students.get(i).getName().contains(name)) {
				persons.add(students.get(i));
			}
		}
		
		for(int i = 0; i < employees.size();i++) {
			if(employees.get(i).getName().contains(name)) {
				persons.add(employees.get(i));
			}
		}
		
		return persons;
		
	}
	
	public static ArrayList<Person> search(ArrayList<Person> persons, String name) {
		
		ArrayList<Person> subPersons = new ArrayList<Person>();
		
		for(int i = 0; i< persons.size(); i++) {
			if(persons.get(i).getName().contains(name)) {
				subPersons.add(persons.get(i));
			}
		}
		
		return subPersons;
		
	}
	
	public static int search(ArrayList<Person> persons, Person p) {
		
		for(int index =0; index < persons.size(); index++) {
			if(p.equals(persons.get(index))) {
				return index;
			}
		}
		
		return -1;
		
		
	}


	
}
	
