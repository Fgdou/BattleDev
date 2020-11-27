package com.isograd.exercise2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exo4Test {
	@Test
	void parseInt(){
		assertEquals(10, Exo4.parseInt("10", 0, 2));
		assertEquals(1, Exo4.parseInt("10", 0, 1));
		assertEquals(0, Exo4.parseInt("10", 1, 2));
		assertEquals(102, Exo4.parseInt("10200", 0, 3));
	}
}