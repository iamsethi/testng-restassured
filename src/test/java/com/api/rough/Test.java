package com.api.rough;

public class Test {
	public static int x = 100;
	public int y = 200;

	public String toString() {
		return y + ":" + x;
	}

/*	public static void main(String[] args) {
		Test t1 = new Test();
		t1.y = 300; // 300 100
		System.out.println(t1);
		Test t2 = new Test();
		t2.x = 300;
		System.out.println(t2); // 200 300
	}
*/
/*	public static void main(String[] args) {
		String color = "Green";
		switch (color) {
		case "Red":
			System.out.println("Red");
		case "Blue":
			System.out.println("Blue");
			break;
		case "Green":
			System.out.println("Green");

		default:
			System.out.println("Default");
		}

	}
*/
/*	public static void sum(Integer x, Integer y) {
		System.out.println("Integer sum is:" + (x + y));
	}

	public static void sum(double x, double y) {
		System.out.println("double sum is:" + (x + y));
	}

	public static void sum(float x, float y) {
		System.out.println("float sum is:" + (x + y));
	}
*/
	
	
	public static void sum(int x, long y) {
		System.out.println("int 2 is:" + (x * y));
	}
	
	public static void sum(int x, double y) {
		System.out.println("int 3 is:" + (x * y));
	}

	public static void main(String[] args) {
		/*byte a=127;float b=100;
		sum(a,b);*/
		//sum(10.0, 20.0);
	}

}