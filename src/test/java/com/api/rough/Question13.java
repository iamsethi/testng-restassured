package com.api.rough;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Question13 {
	public static void main(String[] args) {
		String str = "java";
		StringBuilder sb = new StringBuilder("java");

		System.out.println(str.equals(sb) + ":" + sb.equals(str));
		System.out.println(str.equals(sb.toString()));

		Period period = Period.of(0, 0, 0);
		System.out.println(period);

		short[] arg = new short[] { 50, 50 };
		arg[0] = 5;
		arg[1] = 10;
		System.out.println("[" + arg[0] + ", " + arg[1] + "]");

		String swift_code = "ICICINBBRT4";// ICIC: First 4 letters for bank code
											// IN: Next 2 letters for Country code
		System.out.println(swift_code.substring(4, 6)); // Print Country code

		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(2));
		list.add(new Integer(1));
		list.add(new Integer(0));
		list.remove(list.indexOf(0));
		System.out.println(list);

		//
		String fruit = "mango";
		switch (fruit) {
		case "Apple":
			System.out.println("APPLE");
		case "Mango":
			System.out.println("MANGO");
		default:
			System.out.println("ANY FRUIT WILL DO");
		case "Banana":
			System.out.println("BANANA");
			break;

		}

		// Trick start from default

		switch ("banana") {
		default:
			System.out.println("ANY FRUIT WILL DO");
		case "Apple":
			System.out.println("APPLE");
		case "Mango":
			System.out.println("MANGO");
		case "Banana":
			System.out.println("BANANA");
			break;
		}

		// Trick list is not key value but we are specifying the index here and
		// lsr.remove will take the index and not the value
		List<Character> lsr = new ArrayList<>();
		lsr.add(0, 'V');
		lsr.add('T');
		lsr.add(1, 'E');
		lsr.add(3, 'O');

		System.out.println(lsr);
		if (lsr.contains('O')) {
			// lsr.remove('O');
		}

		for (char ch : lsr) {
			System.out.print(ch);
		}

		int i = '5';
		m(i);
		m('5');

		// Trick
		/*
		 * new StringBuilder(100);` creates a StringBuilder instance, whose internal
		 * char array's length is 100 but length() method of StringBuilder object
		 * returns the number of characters stored in the internal array and in this
		 * case it is 0. So, `sb.length()` returns 0 as there are no characters inside
		 * the StringBuilder object.
		 */
		StringBuilder sbdr = new StringBuilder(100);
		System.out.println(sbdr.length() + ":" + sbdr.toString().length());

		String s = new String("Hello");
		List<String> lst = new ArrayList<>();
		lst.add(s);
		lst.add(new String("Hello"));
		lst.add(s);
		s.replace("l", "L");

		System.out.println(lst);

		// Trick - byte range is -128 to 127
		byte var = 100;
		switch (var) {
		case 100:
			System.out.println("var is 100");
			break;
		case 127:
			System.out.println("var is 200");
			break;
		/*
		 * case 128: System.out.println("var is 200"); break;
		 */
		default:
			System.out.println("In default");
		}

		// Trick - september doesn't have 31
		// LocalDate date = LocalDate.of(2020, 9, 31);
		LocalDate date = LocalDate.of(2020, 9, 30);
		System.out.println(date);

		// Trick - infinite loop
		int x = 1;
		/*
		 * while (checkAndIncrement(x)) { System.out.println(x); }
		 */

		// Trick - local var model is not initialized
		double price = 90000;
		String model;
		// System.out.println(model);

		// Trick - Array size cannot be specified at the time of declaration, so short
		// [2] arr; gives compilation error.
		// short arr [] = new short[2]; - correct
		// short [] arr = new short[]{100, 100}; - correct
		// short arr [] refers to a short array object of 0 size. so arr[0] = 5; and
		// arr[1] = 10; will throw ArrayIndexOutOfBoundsException at runtime.
		short[] arr;
		arr = new short[2];
		arr[0] = 5;
		arr[1] = 10;
		System.out.println("[" + arr[0] + ", " + arr[1] + "]");

		// Trick - gives compilation error as 1st dimension is not specified
		// new int[][8];
		int[][] two_dim = new int[8][]; // this is correct

		// append' method is overloaded in StringBuilder class: append(String),
		// append(StringBuffer) and append(char[]) etc.
		// In this case compiler gets confused as to which method `append(null)` can be
		// tagged
		StringBuilder sbnew = new StringBuilder();
		// System.out.println(sbnew.append(null).length());

		// If you want to remove the items from ArrayList, while using Iterator or
		// ListIterator,
		// then use Iterator.remove() or ListIterator.remove() method and NOT
		// List.remove(...) method
		List<String> dryFruits = new ArrayList<>();
		dryFruits.add("Walnut");
		dryFruits.add("Apricot");
		dryFruits.add("Almond");
		dryFruits.add("Date");

		Iterator<String> iterator = dryFruits.iterator();
		while (iterator.hasNext()) {
			String dryFruit = iterator.next();
			if (dryFruit.startsWith("A")) {
				iterator.remove();
				// dryFruits.remove(dryFruit); //List.remove(...) method will throw concurrent
				// modification exception
			}
		}

		System.out.println(dryFruits);

		StringBuilder sbvar = new StringBuilder("Java");
		String s1 = sbvar.toString();
		String s2 = sbvar.toString();
		System.out.println(s1 == s2);

		String[] arry = { "A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab" };
		Predicate<String> p = ss -> ss.toUpperCase().substring(0, 1).equals("A");
		processStringArray(arry, p);

		// Trick - if you store 1, it will store ASCII character of given number which
		// is start of heading which is not printable.
		// So it will not print anything on the console
		// If we store 65, then it'll treat it as A char vars = 65 ;
		// System.out.println(vars); will print A
		char vars = 1;
		switch (vars) {
		case 1:
			System.out.println("Lucky no. 7");
			break;
		default:
			System.out.println("DEFAULT");
		}

		LocalTime time = LocalTime.of(16, 40);
		String amPm = time.getHour() >= 12 ? (time.getHour() == 12) ? "PM" : "AM" : "Time is less than 12 hours";
		System.out.println(amPm);

		String str1 = new String("Core");
		String str2 = new String("CoRe");
		System.out.println(str1 = str2);

		/*
		 * Trick - Array elements are initialized to their default values. arr is
		 * referring to an array of Double type, which is reference type and hence both
		 * the array elements are initialized to null.
		 */
		Double[] arra = new Double[2];
		// System.out.println(arra[0] + arra[1]); null pointer exception

		List<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.parse("2018-07-11"));
		dates.add(LocalDate.parse("1919-02-25"));
		dates.add(LocalDate.of(2020, 4, 8));
		dates.add(LocalDate.of(1980, Month.DECEMBER, 31));

		dates.removeIf(y -> y.getYear() < 2000);

		System.out.println(dates);

		LocalDate datess = LocalDate.parse("1947-08-14");
		LocalTime times = LocalTime.MAX;
		System.out.println(datess.atTime(times));

		LocalDate newYear = LocalDate.of(2018, 1, 1);
		LocalDate christmas = LocalDate.of(2018, 12, 25);
		boolean flag1 = newYear.isAfter(christmas);
		boolean flag2 = newYear.isBefore(christmas);
		System.out.println(flag1 + ":" + flag2);

		int ii = '5';
		m(ii); // ii value is 53 if we print it
		// '1' = 49
		// '2' = 50
		m('5');

		do {
			System.out.println(100);
		} while (false);
		System.out.println("Bye");

		System.out.println(new String("Java"));
		System.out.println(new StringBuilder("Java"));

		// double [] ara = new int[2]; //cannot convert from int to double

		LocalDateTime obj = LocalDateTime.now();
		System.out.println(obj.getSecond());

		String[] fruits = { "mango", "banana", "mango", "orange" };
		for (String fruite : fruits) {
			System.out.print(fruite + " ");
			if (fruite.equals("mango")) {
				continue;
			}
			System.out.println("salad!");
			break;
		}

		List<Integer> listi = new ArrayList<Integer>();
		listi.add(new Integer(2));
		listi.add(new Integer(1));
		listi.add(new Integer(0));

		listi.remove(listi.indexOf(0));

		System.out.println(listi);

		String[] aray = { "*", "**", "***", "****", "*****" };
		Predicate<String> pr1 = srt -> srt.length() < 4;
		prints(aray, pr1);

	}

	public static void prints(String[] arr, Predicate<String> predicate) {
		for (String str : arr) {
			if (predicate.test(str)) {
				System.out.println(str);
			}
		}
	}

	private static void m(int x) {

		System.out.println("int version");
	}

	private static void m(char x) {
		System.out.println("char version");
	}

	private static void processStringArray(String[] arr, Predicate<String> predicate) {
		for (String str : arr) {
			if (predicate.test(str)) {
				System.out.println(str);
			}
		}
	}

	private static boolean checkAndIncrement(int x) {
		if (x < 5) {
			x++;
			return true;
		} else {
			return false;
		}
	}
}