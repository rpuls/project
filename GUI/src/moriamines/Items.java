package moriamines;

public class Items {

    private String name = "";
    private boolean heal = false;
    private boolean equipped = false;
    private boolean unlocker = false;
    private boolean chest = false;
    private int damage = 0;
    private int maxHp = 0;
    
    public String getName() {
        return name;
    }

    public Items (String n, boolean h, boolean eq, boolean ul, boolean tc, int dmg, int mh) {
        name = n;
        heal = h;
        equipped = eq;
        unlocker = ul;
        chest = tc;
        damage = dmg;
        maxHp = mh;
        
    }
    public Items getNull(){
        return (Items)null;
    }
    public Items getSword() {
        return new Items("Rusty Sword", false, false, false, false, 10, 0);
    }

    public Items getArmor() {
        return new Items("Body plate", false, false, false, false, 0, 100);
    }

    public Items getPotion() {
        return new Items("Helth resetting potion!", true, false, false, false, 0, 0);
    }

    public Items getKey() {
        return new Items("Mysterious metal piece!", false, false, true, false, 0, 0);
    } 
    public Items getChest() {
        return new Items("THE TREASURE!", false, false, true, true, 0, 0);
    }
}
