package moriamines;

import java.util.ArrayList;

public class Player {

    Player(Room start) {
        position = start;
        inventory = new ArrayList<Items>();
        e = position.getEnemyInThisRoom(); //mangler is dead check
        i = position.getItemsInThisRoom();
    }

    private int level = 1;
    private int hitPoints = 30;
    private int damage = 2;
    private ArrayList<Items> inventory;
    public Room position;
    private Room lastRoom;
    private Enemy e;
    private Items i;

    /**
     * itemsToArray Denne metode løber et stringArray igennem med et for loop,
     * og tilføjer hver string til et nyt ArrayList @param itemsToArray
     *
     * @return
     */
    
    
    private ArrayList<String> itemsToArray() {
        ArrayList<String> itemsToPick = new ArrayList<>();
        for (int i = 0; i < position.getItems().size(); i++) {
            itemsToPick.add(position.getItems().get(i));
        }
        return itemsToPick;

    }

    public String getInventory() {//converteringsfejl
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
            return "You picked up the following: " + i.getName();
        } else {
            return "Nothing to pickup";
        }
    }
    

    public void beAttacked(int hit) {
        hitPoints -= hit;
        if (hitPoints <= 0) {
            hitPoints = 0;
        }
    }

    public String attack() {
        if (e != null) {
            String r = e.beAttacked(this, damage);
            if (hitPoints <= 0) {
                MoriaMines.gameOver = true;
                return "GAME OVER YOU DIED!";
            } else {
                return r + ".\nyou took some damage. Your current HP is now: " + hitPoints;
            }
        } else {
            return "no enemy!";
        }
    }

    void enterRoom(Room newRoom) {
        lastRoom = position;
        position = newRoom;
        e = position.getEnemyInThisRoom();
        i = position.getItemsInThisRoom();
        //return position.enterRoom();
    }

    String goNorth() {
        Room newRoom = position.getExitNorth();
        if (newRoom == null) {
            return "There is no path leading north";
        }
        if (e != null) {
            return "You need to kill the blocking enemy to move on!";
        }
        enterRoom(newRoom);
        return newRoom.getFullDescription(newRoom.getItemsInThisRoom(),newRoom.getEnemyInThisRoom() );
    }

    String goSouth() {
        Room newRoom = position.getExitSouth();
        if (newRoom == null) {
            return "There is no path leading south";
        }
        if (e != null) {
            return "You need to kill the blocking enemy to move on!";
        }
        enterRoom(newRoom);
        return newRoom.getFullDescription(newRoom.getItemsInThisRoom(),newRoom.getEnemyInThisRoom());
    }

    String goEast() {
        Room newRoom = position.getExitEast();
        if (newRoom == null) {
            return "There is no path leading east";
        }
        if (e != null) {
            return "You need to kill the blocking enemy to move on!";
        }
        enterRoom(newRoom);
        return newRoom.getFullDescription(newRoom.getItemsInThisRoom(),newRoom.getEnemyInThisRoom());
    }

    String goWest() {
        Room newRoom = position.getExitWest();
        if (newRoom == null) {
            return "There is no path leading west";
        }
        if (e != null) {
            return "You need to kill the blocking enemy to move on!";
        }
        enterRoom(newRoom);
        return newRoom.getFullDescription(newRoom.getItemsInThisRoom(),newRoom.getEnemyInThisRoom());
    }

    public String help() {
        return "help �? prints this message\n"
                + "east, west, north, south, back, inventory, pick items �? attempt to move player to new room";
    }

	public void removeMe() {
		e=null;
		
	}

}
