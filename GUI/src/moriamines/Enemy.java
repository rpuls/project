package moriamines;

public class Enemy {

    private static String name = "";
    private int hitPoints = 0;
    private int damage = 0;
    
    public static String getName() {
        return name;
    }

    public Enemy(String n, int hp, int dmg) {
        name = n;
        hitPoints = hp;
        damage = dmg;
    }
    public static Enemy getNull(){
        return (Enemy)null;
    }
    public static Enemy getOrc() {
        return new Enemy("Orc", 50, 20);
    }

    public static Enemy getMutantRat() {
        return new Enemy("Mutant Rat", 10, 35);
    }

    public static Enemy getGhost() {
        return new Enemy("Ghost", 100, 5);
    }

    public static Enemy getBoss() {
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
            return "The " + name + " just got KILLED!"; //false hvis den er død.
        }else{
            p.beAttacked(damage);
            return "Remaning hitpoints: " + hitPoints;
        }
    }  

}
