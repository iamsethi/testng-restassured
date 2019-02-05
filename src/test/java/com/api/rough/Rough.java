package com.api.rough;

import org.testng.annotations.Test;

public class Rough {

	@Test(groups = { "cars", "bikes" })
	public void b() {
		System.out.println("cars and bikes ");
	}

	@Test(groups = { "cars" })
	public void a() {
		System.out.println("cars ");
	}

	@Test(groups = { "bikes" })
	public void c() {
		System.out.println("bikes ");
	}
}
