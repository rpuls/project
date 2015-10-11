package moriamines;

import java.util.ArrayList;

public class Player {
	
    protected int level = 1;
    protected int hitPointsMax = 30;
    protected int hitPointsCurrent = 30;
    protected int damage = 2;
    protected int collectedCoins = 25;
    protected ArrayList<Items> inventory;
    public Room currentRoom;
    private Room lastRoom;
    private Enemy e;
    private Items i;
    private int c;

    Player(Room start) {
    	System.out.println("Welcome to Moriamines!\nThis is a jurney into a spooky old abandoned building.\nThe main goal is to find the treasure chest, by explorering the building\nPLAYER: Hello! My name is Carsten, i will be your marionette doll\nthrough the adventure. Type your first command \"help\" to start the game.");
        currentRoom = start;
        inventory = new ArrayList<Items>();
        inventory.add(Items.getPotion());
        inventory.add(Items.getShortSword());
        e = currentRoom.getEnemyInThisRoom();
        i = currentRoom.getItemsInThisRoom();
        c = currentRoom.getCoinsInThisRoom();
    }




//INVENTORY
    public String getInventory() {
    	String totalInv="";
    	for (int i = 0; i < inventory.size(); i++) {
    		totalInv+=(inventory.get(i).getName()+" ");
		}
        return "you are currently carring; " + totalInv;
    }

    public String pickUp() {
        if (e != null) {
            return "The Enemy is guarding the items! try \"attack\"";
        }
        if (i != null) {
            inventory.add(i);
            currentRoom.setItems(null);
            collectedCoins = collectedCoins + c;
            currentRoom.removeCoins();
            if(i.getName()=="THE TREASURE!"){
            	MoriaMines.gameOver=true;
            	return "\n\n\n\n\n\n\n\n\n\n\nYou have won the game\nReached level: " + level + "\nCollected coins: " + collectedCoins;
            }
            return "You picked up the following: " + i.getName() + " and: " + c + " coins";
        } else {
            return "Nothing to pickup";
        }
    }
//USEABLE ITEMS USEAGE
    public String usePotion(){
    	Items i=containsA("Health resetting potion!");
    	if(i!=null){
    		inventory.remove(i);
    		hitPointsCurrent = hitPointsMax;
    		return "your health is now: " + hitPointsCurrent +" ("+hitPointsCurrent+"/"+hitPointsMax+")";
    	}
    	return "You have no potions!";
    }
    
    public String useArmor(){
    	Items i=containsA("Body plate");
    	if(i!=null){
    		inventory.remove(i);
    		hitPointsMax = hitPointsMax + 20;
    		return "your Maximum health is now: " + hitPointsMax +" ("+hitPointsCurrent+"/"+hitPointsMax+")";
    	}
    	return "You have no Armor";
    }
    
    public String useWeapon(){
    	Items i=containsA("Bastard Sword!");
    	if(i!=null){
    		inventory.remove(i);
    		damage = damage + 5;
    		return "your damage is now: " + damage;
    	}
    	return "no weapon to eqquip!";
    }
    
    public String useKey(){
    	Items i=containsA("Mysterious metal piece!");
    	if(i==null){
    		return "You dont have the Key!";
    	}
		if(currentRoom.unlock()){
    		inventory.remove(i);
    		return "The door have been unlocked";
		}
		return "There are no locked doors in here";
	
    }
    
    /**containsA
     * denne metode tjekker arraylisten "inventory" igennem for items objector der 
     * indeholder en bestemt string @param s (.getName) hvis string findes returneres items Objectet som string name tilhøre
     * hvis den ikke findes returneres null.
     * @param s
     * @return
     */
    public Items containsA(String s){
    	for (int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getName().equalsIgnoreCase(s)){
				return inventory.get(i);
			}
		}
    	return null;
    }
    
//COMBAT
    public void beAttacked(int hit) {
        hitPointsCurrent -= hit;
        if (hitPointsCurrent <= 0) {
            hitPointsCurrent = 0;
        }
    }

    public String attack() {
        if (e != null) {
            String r = e.beAttacked(this, damage);
            if (hitPointsCurrent <= 0) {
                MoriaMines.gameOver = true;
                return "GAME OVER YOU DIED!";
            } else {
                return r + ".\nyou took some damage. Your current HP is now: " + hitPointsCurrent;
            }
        } else {
            return "no enemy!";
        }
    }
//REMOVE ENEMY FROM ROOM AND PLAYER LEVELS UP
	public void removeMe() {
		e=null;
		currentRoom.setEnemy(null);
		if(level<10){
			level = level + 1;
			damage = damage + 1;
			if(hitPointsCurrent == hitPointsMax){
				hitPointsMax = hitPointsMax + 5;
				hitPointsCurrent = hitPointsMax;
			}else{
				hitPointsMax = hitPointsMax + 5;
			}
		}	
	}
//MOVE PLAYER
    private String enterRoom(Room newRoom) {
        lastRoom = currentRoom;
        currentRoom = newRoom;
        e = currentRoom.getEnemyInThisRoom();
        i = currentRoom.getItemsInThisRoom();
        c = currentRoom.getCoinsInThisRoom();
        String R = newRoom.getFullDescription(newRoom.getItemsInThisRoom(),newRoom.getEnemyInThisRoom());if (e != null) {
            String r = e.enterAttack(this);
            if (hitPointsCurrent <= 0) {
                MoriaMines.gameOver = true;
                R += "GAME OVER YOU DIED!";
            } else {
            	R += r + " Your current HP is now: " + hitPointsCurrent; 
            }
        } 
        return R;
    }

    String goNorth() {
        Room newRoom = currentRoom.getExitNorth();
        if (newRoom == null) {
            return "There is no path leading north";
        }
        if (e != null) {
            return "You need to kill the blocking enemy to move on!";
        }
        return enterRoom(newRoom);
    }

    String goSouth() {
        Room newRoom = currentRoom.getExitSouth();
        if (newRoom == null) {
            return "There is no path leading south";
        }
        if (e != null) {
            return "You need to kill the blocking enemy to move on!";
        }
        return enterRoom(newRoom);
    }

    String goEast() {
        Room newRoom = currentRoom.getExitEast();
        if (newRoom == null) {
            return "There is no path leading east";
        }
        if (e != null) {
            return "You need to kill the blocking enemy to move on!";
        }
        return enterRoom(newRoom);
    }
    String goWest() {
        Room newRoom = currentRoom.getExitWest();
        if (newRoom == null) {
            return "There is no path leading west";
        }
        if (e != null) {
            return "You need to kill the blocking enemy to move on!";
        }
        return enterRoom(newRoom);
    }
    String back() {
        Room newRoom = lastRoom;
        if (newRoom == null) {
            return "There is no way back";
        }
        if (e != null) {
            return "You need to kill the blocking enemy to move on!";
        }
        return enterRoom(newRoom);
    }
    
//other actions

    public String help() {
        return "To move Carsten use following commands: east, west, north, south or back.\nTo Check player info use command: player or inventory.\nAction commands are following: attack, heal, pickitems and use.\nSystem restart and quit.";
    }
    public String player(){
    	return "Current level: " + level + " -- HP/HPMAX: " + hitPointsCurrent + "/" + hitPointsMax + " -- Damage: " + damage + " -- Coins collected: " + collectedCoins;
    }



}
