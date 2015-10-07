package moriamines;
import org.junit.Test;
import org.junit.Assert.*;

public class Enemy {

    private String name = "";
    private int hitPoints = 0;
    private int damage = 0;
    
	
    public String getName() {
        return name;
    }

    public Enemy(String n, int hp, int dmg) {
        name = n;
        hitPoints = hp;
        damage = dmg;
    }
    
    
//TYPE    
    public static Enemy getNull(){
        return (Enemy)null;
    }
    public static Enemy getOrc() {
        return new Enemy("Orc", 10, 1);
    }

    public static Enemy getMutantRat() {
        return new Enemy("Mutant Rat", 25, 5);
    }

    public static Enemy getGhost() {
        return new Enemy("Ghost", 50, 6);
    }

    public static Enemy getBoss() {
        return new Enemy("Boss Deamon", 320, 14);
    }
    
//COMBAT
    public String enterAttack(Player p){
    	p.beAttacked(damage);
    	return "\nEnemy is attacking you!";
    }
    
    public String beAttacked(Player p, int hit){
        if(hitPoints <=0){
            return "The " + name + " is allready dead!";
        }
        hitPoints -= hit;
        if(hitPoints<=0){
            hitPoints = 0;
            p.removeMe();
            return "The " + name + " just got KILLED!"; //false hvis den er død.
        }else{
            p.beAttacked(damage);
            return "Enemy's remaning hitpoints: " + hitPoints;
        }
    }  
	@Test
	public static void test1(){
		Enemy e = Enemy.getOrc();
		org.junit.Assert.assertTrue((e.hitPoints == 10));
	}
}
