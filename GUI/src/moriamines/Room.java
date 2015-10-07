package moriamines;

import java.util.ArrayList;

public class Room {

	/**Room constructor
	 * Konstruerer et rum med følgende argumenter.
	 * @param roomInfo - som er en beskrivelse af rummet (String).
	 * @param i Items object fra klassen (Items).
	 * @param e Enemy object fra klassen (Enemy).
	 * @param coins (integer) variable som bestemmer om der er coins i rummer og hvor mange.
	 */
    public Room(String roomInfo, Items i, Enemy e, int coins) { //room constructor med 3 id's string roominfo, og arraylist roomitems
        this.description = roomInfo;
        this.enemyInThisRoom = e;
        this.itemsInThisRoom = i;
        this.coinsInRoom = coins;

    }
    protected String description = "";
    protected ArrayList<String> items = new ArrayList<>();
    protected Enemy enemyInThisRoom;
    protected Items itemsInThisRoom;
    protected int coinsInRoom;
    
    
    public ArrayList<String> getItems() {
		return items;
	}
    public Enemy getEnemyInThisRoom() {
        return enemyInThisRoom;
    }
    public Items getItemsInThisRoom(){
    	return itemsInThisRoom;
    }
    public int getCoinsInThisRoom(){
    	return coinsInRoom;
    }
    public void removeCoins(){
    	coinsInRoom = 0;
    }
    public void setEnemy(Enemy e){
    	this.enemyInThisRoom=e;
    }
    public void setItems(Items i){
    	this.itemsInThisRoom=i;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setCoins(int coinsInRoom) {
        this.coinsInRoom = coinsInRoom;
    }
    /** getFullDescription
     * Denne metode returnere en description kombination af information 
     * om de givene argumenter fra constructor'en (String)
     * @return 
     */
    public String getFullDescription(Items item, Enemy enemy) {  //, int coins, int coins
        if ((item == null) && (enemy == null)) {
            return "There seems to be no items in here! " + "and " + coinsInRoom + " coins." + description + " The room is clear! no enemies!";
        }
        if ((item != null) && (enemy == null)) {
            return "I see a " + item.getName() + " on the ground." + "and " + coinsInRoom + " coins.\n" + description + " but there is no enemies here!";
        }
        if((item == null) && (enemy != null)){
        	return "I see no items on the ground, "  + "and " + coinsInRoom + " coins.\n"+ description + ". here seems to be a(n) " + enemy.getName();
        }//ellers returner den info for room med både enemy og items.
        return "I see a " + item.getName() + " on the ground. " + "and " + coinsInRoom + " coins.\n" + description +" but here seems to be a(n) " + enemy.getName();
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
    public boolean unlock(){
    	return false;
    }

}
