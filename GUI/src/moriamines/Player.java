package moriamines;

import java.util.ArrayList;

public class Player {

    Player(Room start) {
        position = start;
        inventory = new ArrayList<>();
        inventory.add("tool");
        e = position.getEnemyInThisRoom();
    }

    private int hitPoints = 500;
    private int damage = 10;
    private ArrayList<String> inventory;
    private Room position;
    private Room lastRoom;
    private Enemy e;

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

    public String getInventory() {
        return "you are currently carring; " + inventory.toString();
    }

    public String pickUp() {
        ArrayList<String> newItems = itemsToArray();
        if (e != null) {
            return "The Enemy is guarding the items! try \"attack\"";
        }
        if (newItems != null) {
            inventory.addAll(newItems);
            return "You picked up the following: " + newItems.toString();
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
                return r;
            }
        } else {
            return "no enemy!";
        }
    }

    void enterRoom(Room newRoom) {
        lastRoom = position;
        position = newRoom;
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
        return newRoom.getFullDescription();
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
        return newRoom.getFullDescription();
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
        return newRoom.getFullDescription();
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
        return newRoom.getFullDescription();
    }

    public String help() {
        return "help �? prints this message\n"
                + "east, west, north, south, back, inventory, pick items �? attempt to move player to new room";
    }

}
