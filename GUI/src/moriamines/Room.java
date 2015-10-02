package moriamines;

import java.util.ArrayList;

public class Room {

    public Room(String roomInfo, Items i, Enemy e) { //room constructor med 3 id's string roominfo, og arraylist roomitems
        this.description = roomInfo;
        this.enemyInThisRoom = e;
        this.itemsInThisRoom = i;

    }

    //int id;
    protected String description = "";
    protected ArrayList<String> items = new ArrayList<>();
    protected Enemy enemyInThisRoom;
    protected Items itemsInThisRoom;
    //public String[] roomItems; not used
    
    
    public ArrayList<String> getItems() {
		return items;
	}
    

    public Enemy getEnemyInThisRoom() {
        return enemyInThisRoom;
    }
    public Items getItemsInThisRoom(){
    	return itemsInThisRoom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Denne metode returnere Description (i dette tilfælde description af current room)
     * room har to identifier, String description, og string[] liste. hvis item listen er tom returnere den "There seems...." + description.
     * hvis item liste identifieren !ikke er tom
     * @return 
     */
    public String getFullDescription(Items item, Enemy enemy) {  
        if ((item == null) && (enemy == null)) {
            return "There seems to be no items in here! " + description + " The room is clear! no enemies!";
        }
        if (item != null && (enemy == null)) {
            return "I see a " + item.getName() + " on the ground.\n" + description + " but there is no enemies here!";
        }
        if((item == null) && (enemy != null)){
        	return "I see no items on the ground.\n" + description + " but here seems to be a(n) " + enemy.getName();
        }
        return "";
    }

    //room navigation
    private Room exitNorth;
    private Room exitSouth;
    private Room exitEast;
    private Room exitWest;

    public Room getExitNorth() {
        return exitNorth;
    }

    public Room getExitSouth() {
        return exitSouth;
    }

    public Room getExitEast() {
        return exitEast;
    }

    public Room getExitWest() {
        return exitWest;
    }

    public void setExitNorth(Room exitNorth) {
        this.exitNorth = exitNorth;
    }

    public void setExitSouth(Room exitSouth) {
        this.exitSouth = exitSouth;
    }

    public void setExitEast(Room exitEast) {
        this.exitEast = exitEast;
    }

    public void setExitWest(Room exitWest) {
        this.exitWest = exitWest;
    }

}
