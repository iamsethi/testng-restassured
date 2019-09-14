package com.api.rough;


/*compiler adds super(); as the first statement inside constructor, 
if call to another constructor using this(...) or super(...) is not available. 
Compiler adds super(); as the first line in OTG's constructor: OTG(int capacity, 
String type) { super(); } but PenDrive class doesn't have a no-arg constructor and
that is why OTG's constructor gives compilation error. 
*/

class PenDrive {
	int capacity;

	PenDrive(int capacity) {
		this.capacity = capacity;
	}
}

class OTG extends PenDrive {
	String type;

	OTG(int capacity, String type) {
		super(capacity);
		this.type = type;
	}
}

public class Question26 {
	public static void main(String[] args) {
		OTG obj = new OTG(64, "TYPE-C");
		System.out.println(obj.capacity + ":" + obj.type);
	}
}