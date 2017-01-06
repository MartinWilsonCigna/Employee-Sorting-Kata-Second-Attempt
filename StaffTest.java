package EmployeeSort2;

import static org.junit.Assert.*;

import org.junit.Test;

public class StaffTest {

	@Test
	public void testContainsBigBoss() {
		String testInput = "2"
				+ "\n"
				+ "BigBoss"
				+ "\n"
				+ "Boss"
				+ "\n"
				+ "BigBoss Boss";
		
		Staff staff = new Staff(testInput);
		
		assertTrue("Staff should contain BigBoss, but doesn't", staff.contains("BigBoss"));
	}

	@Test
	public void testContainsBoss() {
		String testInput = "2"
				+ "\n"
				+ "BigBoss"
				+ "\n"
				+ "Boss"
				+ "\n"
				+ "BigBoss Boss";
		
		Staff staff = new Staff(testInput);
		
		assertTrue("Staff should contain Boss, but doesn't", staff.contains("Boss"));
	}

	@Test
	public void testDoesNotContainHugh() {
		String testInput = "2"
				+ "\n"
				+ "BigBoss"
				+ "\n"
				+ "Boss"
				+ "\n"
				+ "BigBoss Boss";
		
		Staff staff = new Staff(testInput);
		
		assertTrue("Staff shouldn't think it contains Hugh, but does", !staff.contains("Hugh"));
	}

	@Test
	public void testFindSubordinates() {
		String testInput = "2"
				+ "\n"
				+ "BigBoss"
				+ "\n"
				+ "Boss"
				+ "\n"
				+ "BigBoss Boss";
		
		Staff staff = new Staff(testInput);
		
		assertEquals("Boss", staff.findSubordinates("BigBoss"));
	}

	@Test
	public void testFindSubordinatesWithTwoSubordinates() {
		String testInput = "2"
				+ "\n"
				+ "BigBoss"
				+ "\n"
				+ "Boss"
				+ "\n"
				+ "BigBoss Boss"
				+ "\n"
				+ "BigBoss Honcho";
		
		Staff staff = new Staff(testInput);
		
		assertEquals("Boss Honcho", staff.findSubordinates("BigBoss"));
	}

	@Test
	public void testFindSubordinatesFromMany() {
		String testInput = "2"
				+ "\n"
				+ "BigBoss"
				+ "\n"
				+ "Boss"
				+ "\n"
				+ "BigBoss Boss"
				+ "\n"
				+ "Jim Steve"
				+ "\n"
				+ "Mike Jim"
				+ "\n"
				+ "Boss Mike"
				+ "\n"
				+ "Mike Ross"
				+ "\n"
				+ "Ross Elen"
				+ "\n"
				+ "Ross Karen"
				+ "\n"
				+ "Susan Selma"
				+ "\n"
				+ "Susan Godfrey"
				+ "\n"
				+ "Jim Susan";
		
		Staff staff = new Staff(testInput);
		
		assertEquals("Steve Susan", staff.findSubordinates("Jim"));
	}
	
	@Test
	public void testGetRoot() {
		String testInput = "2"
				+ "\n"
				+ "BigBoss"
				+ "\n"
				+ "Boss"
				+ "\n"
				+ "BigBoss Boss"
				+ "\n"
				+ "Jim Steve"
				+ "\n"
				+ "Mike Jim"
				+ "\n"
				+ "Boss Mike"
				+ "\n"
				+ "Mike Ross"
				+ "\n"
				+ "Ross Elen"
				+ "\n"
				+ "Ross Karen"
				+ "\n"
				+ "Susan Selma"
				+ "\n"
				+ "Susan Godfrey"
				+ "\n"
				+ "Jim Susan";
		
		Staff staff = new Staff(testInput);
		
		assertEquals("BigBoss", staff.getRoot().getName());
	}
	
	@Test
	public void testGetRootWhenNotFirst() {
		String testInput = "2"
				+ "\n"
				+ "LittleBigBoss"
				+ "\n"
				+ "Boss"
				+ "\n"
				+ "Jim Steve"
				+ "\n"
				+ "Mike Jim"
				+ "\n"
				+ "Boss Mike"
				+ "\n"
				+ "Mike Ross"
				+ "\n"
				+ "Ross Elen"
				+ "\n"
				+ "Ross Karen"
				+ "\n"
				+ "Susan Selma"
				+ "\n"
				+ "Susan Godfrey"
				+ "\n"
				+ "BigBoss Boss"
				+ "\n"
				+ "Godfrey LittleBigBoss"
				+ "\n"
				+ "Jim Susan";
		
		Staff staff = new Staff(testInput);
		
		assertEquals("BigBoss", staff.getRoot().getName());
	}
	
	@Test
	public void testFindLowestEmployee() {
		String testInput = "2"
				+ "\n"
				+ "BigBoss"
				+ "\n"
				+ "Boss"
				+ "\n"
				+ "BigBoss Boss"
				+ "\n"
				+ "BigBoss Honcho"
				+ "\n"
				+ "Boss MiniBoss"
				+ "\n"
				+ "Boss TinyBoss";
		
		Staff staff = new Staff(testInput);
		
		assertEquals("MiniBoss", staff.findLowestEmployee().getName());
	}
	
	@Test
	public void testFindLowestManagerFromMany() {
		String testInput = "2"
				+ "\n"
				+ "1BigBoss"
				+ "\n"
				+ "2Boss"
				+ "\n"
				+ "1BigBoss 2Boss"
				+ "\n"
				+ "1BigBoss 2Honcho"
				+ "\n"
				+ "2Boss 3MiniBoss"
				+ "\n"
				+ "2Boss 3TinyBoss"
				+ "\n"
				+ "2Honcho 3Honchette"
				+ "\n"
				+ "2Honcho 3Honcherina"
				+ "\n"
				+ "3Honchette 4BabyHoncho"
				+ "\n"
				+ "3Honchette 4DemiHoncho"
				+ "\n"
				+ "3MiniBoss 4EenieBoss"
				+ "\n"
				+ "3MiniBoss 4MeanieBoss"
				+ "\n"
				+ "4EenieBoss 5WeenieBoss"
				+ "\n"
				+ "4EenieBoss 5BeanieBoss";
		
		Staff staff = new Staff(testInput);
		
		assertEquals("4EenieBoss", staff.findLowestManager().getName());
	}

}
