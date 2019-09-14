package com.api.rough;

//assume this is in some diiferent package
class A {
	public int i1 = 1;
	protected int i2 = 2;
}

// trick here is If you are accessing protected variables outside their package, then they cannot be accessed using object reference, they can only be accessed by the means of inheritance.
//Answer-  System.out.println(obj.i2); // Line 9 will give CTE
public class Question21 extends A {
	public void print() {
		A obj = new A();
		System.out.println(obj.i1); // Line 8
		System.out.println(obj.i2); // Line 9
		System.out.println(this.i2); // Line 10
		System.out.println(super.i2); // Line 11
	}

	public static void main(String[] args) {
		new Question21().print();
	}
}