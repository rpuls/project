package moriamines;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	Enemy testEnemy = new Enemy("",0,0);
	Items testItem = new Items("",false,false,false,false,0,0);
	int hit = 500;
	Room testRoom = new Room("",testItem,testEnemy,0);
	Player testPlayer;
	
	@Before
	public void setUp() throws Exception {
		testPlayer = new Player(testRoom);
	}

	@After
	public void tearDown() throws Exception {
		testPlayer = null;
	}

	@Test
	public void testUsePotion() {
		testPlayer.beAttacked(30);
		assertTrue(testPlayer.hitPointsCurrent == (testPlayer.hitPointsMax-30));
		testPlayer.usePotion();
		assertTrue(testPlayer.hitPointsCurrent == testPlayer.hitPointsMax);
	}

	@Test
	public void testBeAttacked() {
		testPlayer.beAttacked(1000);
		assertTrue(testPlayer.hitPointsCurrent == 0);
		testPlayer.beAttacked(2000);
		assertTrue(testPlayer.hitPointsCurrent == 0);
	}

	@Test
	public void useArmor() {
		final int startMaxHP = testPlayer.hitPointsMax;
		assertTrue(testPlayer.hitPointsMax == 30);
		testPlayer.inventory.add(Items.getArmor());
		testPlayer.useArmor();
		assertTrue(testPlayer.hitPointsMax == startMaxHP+20);
	}

}
