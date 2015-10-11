package moriamines;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnemyTest {
		
	Enemy testEnemy;
	String name;
	@Before
	public void setUp() throws Exception {
		name="enemy";
		testEnemy = new Enemy(name, 10, 5);
	}

	@After
	public void tearDown() throws Exception {
		testEnemy = null;
	}

	@Test
	public void testGetName() {
		assertEquals(name, testEnemy.getName());
	}

	@Test
	public void testEnemy() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNull() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrc() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMutantRat() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGhost() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBoss() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnterAttack() {
		fail("Not yet implemented");
	}

	@Test
	public void testBeAttacked() {
		fail("Not yet implemented");
	}
	
	/*
	@Test
	public static void test1(){
		Enemy e = Enemy.getOrc();
		org.junit.Assert.assertTrue((e.hitPoints == 10));
	}
	*/

}
