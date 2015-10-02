package moriamines;

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
    
    public Enemy getNull(){
        return (Enemy)null;
    }
    public Enemy getOrc() {
        return new Enemy("Orc", 10, 1);
    }

    public Enemy getMutantRat() {
        return new Enemy("Mutant Rat", 25, 5);
    }

    public Enemy getGhost() {
        return new Enemy("Ghost", 50, 6);
    }

    public Enemy getBoss() {
        return new Enemy("Boss Deamon", 200, 25);
    }
    
    //combat
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

}
