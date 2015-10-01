package moriamines;

import java.util.ArrayList;

public class Room {

    public Room(String roomInfo, String[] roomItems, Enemy e) { //room constructor med 3 id's string roominfo, og arraylist roomitems
        this.description = roomInfo;
        putItems(roomItems);
        this.enemyInThisRoom = e;

    }

    //int id;
    protected String description = "";
    protected ArrayList<String> items = new ArrayList<>();
    protected Enemy enemyInThisRoom;
    //public String[] roomItems; not used
    
    
    public ArrayList<String> getItems() {
		return items;
	}
    

    public Enemy getEnemyInThisRoom() {
        return enemyInThisRoom;
    }

    private void putItems(String[] roomItems) { //smider items  i arraylisten "items"
        for (int i = 0; i < roomItems.length; i++) {
            if (roomItems.length != 0) {
                items.add(roomItems[i]);
            }
        }
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
    public String getFullDescription() {  
        if (items.isEmpty()) {
            return "There seems to be no items in here! " + description + " " + Enemy.getName();
        }
        if (!(items.isEmpty())) {
            String itemsInThisRoom = "";
            for (int i = 0; i < items.size(); i++) {
                itemsInThisRoom = itemsInThisRoom + " " + items.get(i);
            }
            return "I see following items on the ground in this room:" + itemsInThisRoom + ".\n" + description + " " + Enemy.getName();
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
