package com.api.rough;


//Trick - Parent can't be down graded to child
class AA {
	public void print() {
		System.out.println("A");
	}
}

class BB extends AA {
	public void print() {
		System.out.println("B");
	}

}

class Question35 {

	public static void main(String[] args) {
		AA obj1 = new AA();
		BB obj2 = (BB) obj1;
		obj2.print();
	}
}