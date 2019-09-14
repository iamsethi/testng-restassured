package com.api.rough;

import java.util.ArrayList;
import java.util.List;


//Trick -  if you are using custom objects in List.Make sure you have overridden hashcode and equals method. –
//remove will return false here
class Students {
	private String name;
	private int age;

	Students(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Student[" + name + ", " + age + "]";
	}
}

public class Question34 {
	public static void main(String[] args) {
		List<Students> students = new ArrayList<>();
		students.add(new Students("James", 25));
		students.add(new Students("James", 27));
		students.add(new Students("James", 25));
		students.add(new Students("James", 25));

		students.remove(new Students("James", 25));

		for (Students stud : students) {
			System.out.println(stud);
		}
	}
}