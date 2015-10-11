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
    protected Enemy enemyInThisRoom;
    protected Items itemsInThisRoom;
    protected int coinsInRoom;
    
    /**getEnemyInThisRoom()
     * denne metode returnerer en Enemy som er bestemt af konstruktoren.
     * @return Enemy
     */
    public Enemy getEnemyInThisRoom() {
        return enemyInThisRoom;
    }
    /**getItemsInThisRoom()
     * denne metode returnerer en Item som er bestemt af konstruktoren.
     * @return Room
     */
    public Items getItemsInThisRoom(){
    	return itemsInThisRoom;
    }
    /**getCoinsInThisRoom()
     * denne metode returnerer en int som er bestemt af konstruktoren.
     * @return int
     */
    public int getCoinsInThisRoom(){
    	return coinsInRoom;
    }
    /**removeCoins()
     * når denne metode kaldes sættes coins til 0. kan kaldes for hvert
     * Room objekt hvor der er items og coins i sig.
     */
    public void removeCoins(){
    	coinsInRoom = 0;
    }
    /**setEnemy(Enemy e)
     * denne metode kaldes for at sende et Enemy objekt "ind i" et Room objeckt
     * @param e er et Enemy objekt
     */
    public void setEnemy(Enemy e){
    	this.enemyInThisRoom=e;
    }
    /**setItems(Items i)
     * denne metode kaldes for at sende et Item objekt "ind i" et Room objeckt
     * @param i er et Items objekt
     */
    public void setItems(Items i){
    	this.itemsInThisRoom=i;
    }
    /**setDescription(String description)
     * denne metode kaldes for at sette en String beskrivelse for et Room objeckt
     * @param description er en String
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**setCoins(int coinsInRoom)
     * denne metode bruges til at sætte en int value 
     * for hvor mange coins der skal være i et room objekt
     * @param coinsInRoom er en integer
     */
    public void setCoins(int coinsInRoom) {
        this.coinsInRoom = coinsInRoom;
    }
    /** getFullDescription
     * Denne metode returnere en description kombination af information 
     * om de givene argumenter fra constructor'en (String)
     * @param item er argument input af Item objekt 
     * @param enemy er argument input af Enemy objekt 
     * @return String
     */
    public String getFullDescription(Items item, Enemy enemy) { 
        if ((item == null) && (enemy == null)) {
            return "There seems to be no items in here! " + "and " + coinsInRoom 
            		+ " coins." + description + " The room is clear! no enemies!";
        }
        if ((item != null) && (enemy == null)) {
            return "I see a " + item.getName() + " on the ground." + "and " 
        + coinsInRoom + " coins.\n" + description + " but there is no enemies here!";
        }
        if((item == null) && (enemy != null)){
        	return "I see no items on the ground, "  + "and " + coinsInRoom 
        			+ " coins.\n"+ description + ". here seems to be a(n) " 
        			+ enemy.getName();
        }//ellers returner den info for room med både enemy og items.
        return "I see a " + item.getName() + " on the ground. " + "and " 
        + coinsInRoom + " coins.\n" + description +" but here seems to be a(n) " 
        + enemy.getName();
    }

    //room navigation
    private Room exitNorth;
    private Room exitSouth;
    private Room exitEast;
    private Room exitWest;
    /**getExitNorth()
     * bruges til at returnere et Room objekt fra variablen exitNorth
     * @return exitNorth
     */
    public Room getExitNorth() {
        return exitNorth;
    }
    /**getExitSouth()
     * bruges til at returnere et Room objekt fra variablen exitSouth
     * @return Room
     */
    public Room getExitSouth() {
        return exitSouth;
    }
    /**getExitEast()
     * bruges til at returnere et Room objekt fra variablen exitEast
     * @return Room
     */
    public Room getExitEast() {
        return exitEast;
    }
    /**getExitWest()
     * bruges til at returnere et Room objekt fra variablen exitWest
     * @return Room
     */
    public Room getExitWest() {
        return exitWest;
    }
    /**setExitNorth(Room exitNorth)
     * Denne metode bruge til at sætte variablen exitNorth til et bestem room objekt
     * @param exitNorth er et room
     */
    public void setExitNorth(Room exitNorth) {
        this.exitNorth = exitNorth;
    }
    /**setExitSouth(Room exitSouth)
     * Denne metode bruge til at sætte variablen exitSouth til et bestem room objekt
     * @param exitSouth er et room
     */
    public void setExitSouth(Room exitSouth) {
        this.exitSouth = exitSouth;
    }
    /**setExitEast(Room exitEast)
     * Denne metode bruge til at sætte variablen exitEast til et bestem room objekt
     * @param exitEast er et room
     */
    public void setExitEast(Room exitEast) {
        this.exitEast = exitEast;
    }
    /**setExitWest(Room exitWest)
     * Denne metode bruge til at sætte variablen exitWest til et bestem room objekt
     * @param exitWest er et room
     */
    public void setExitWest(Room exitWest) {
        this.exitWest = exitWest;
    }
    /**unlock()
     * fortæller at der er låst.
     * @return boolean altid false.
     */
    public boolean unlock(){
    	return false;
    }

}
