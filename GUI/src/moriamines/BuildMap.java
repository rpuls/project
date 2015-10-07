package moriamines;

public class BuildMap {
	Items items = new Items("", false, false, false, false, 0, 0);
//HARDCODED MAP	
    Room room20 = new Room("Entrance room", items.getNull(), Enemy.getNull(), 0);
    Room room1 = new Room("The walls looks sticky and wet", items.getArmor(), Enemy.getGhost(), 138);
    Room room2 = new Room("I can hear the wind through an open window\nBut wait... There is no windows in this room", items.getPotion(), Enemy.getGhost(), 0);
    Room room3 = new RoomWithLock(items.getNull(), Enemy.getNull(), 0);
    Room room4 = new Room("Thanks god, there is a torch in this room", items.getPotion(), Enemy.getGhost(), 77);
    Room room5 = new Room("The floor is vibrating in this room", items.getNull(), Enemy.getMutantRat(), 0);
    Room room6 = new Room("There is a box on the floor", items.getPotion(), Enemy.getNull(), 1);
    Room room7 = new Room("There is blood on the floor", items.getNull(), Enemy.getGhost(), 0);
    Room room8 = new Room("The room is full of torture machines", items.getSword(), Enemy.getGhost(), 113);
    Room room9 = new Room("The room has nice decor", items.getNull(), Enemy.getMutantRat(), 0);
    Room room10 = new Room("Empty and big room", items.getNull(), Enemy.getOrc(), 0);
    Room room11 = new Room("This is no ordinary room, more like a hallway", items.getPotion(), Enemy.getMutantRat(), 42);
    Room room12 = new Room("The room is nice and clean", items.getNull(), Enemy.getOrc(), 0);
    Room room13 = new Room("This room smells like rotten trash.... OHHHHH an", items.getPotion(), Enemy.getMutantRat(), 21);
    Room room14 = new Room("This room look familiar, have i been here before?", items.getPotion(), Enemy.getOrc(), 0);
    Room room15 = new Room("Bricks has fallen from the roof in this room", items.getNull(), Enemy.getOrc(), 0);
    Room room16 = new Room("The only light in this room is from the entrance door", items.getNull(), Enemy.getOrc(), 0);
    Room room17 = new Room("The room is tiny and dark", items.getNull(), Enemy.getMutantRat(), 0);
    Room room18 = new Room("Something smells rotten in here.", items.getSword(), Enemy.getMutantRat(), 0);
    Room room19 = new Room("The room is very cold, and very large", items.getKey(), Enemy.getMutantRat(), 33);
    Room room21 = new Room("Ohhh! Shit! What is this beast??? ... \ncreature: I'M THE TREASURE GUARD.", items.getChest(), Enemy.getBoss(), 0);
    Player playerObject1 = new Player(this.room20);
    
    public BuildMap() {
        //room 1
        room1.setExitSouth(room5);
        //room 2
        room2.setExitSouth(room6);
        //room 3
        room3.setExitEast(room4);
        room3.setExitNorth(room21);
        //room 4
        room4.setExitSouth(room9);
        room4.setExitEast(room5);
        room4.setExitWest(room3);
        //room 5
        room5.setExitNorth(room1);
        room5.setExitEast(room6);
        room5.setExitWest(room4);
        //room 6
        room6.setExitNorth(room2);
        room6.setExitEast(room7);
        room6.setExitWest(room5);
        //room 7
        room7.setExitEast(room8);
        room7.setExitWest(room6);
        //room 8
        room8.setExitWest(room7);
        //room 9
        room9.setExitNorth(room4);
        room9.setExitSouth(room14);
        room9.setExitEast(room10);
        //room 10
        room10.setExitSouth(room15);
        room10.setExitEast(room11);
        room10.setExitWest(room9);
        //room 11
        room11.setExitEast(room12);
        room11.setExitWest(room10);
        //room 12
        room12.setExitSouth(room17);
        room12.setExitEast(room13);
        room12.setExitWest(room11);
        //room 13
        room13.setExitWest(room12);
        //room 14
        room14.setExitNorth(room9);
        room14.setExitSouth(room19);
        room14.setExitEast(room15);
        //room 15
        room15.setExitNorth(room10);
        room15.setExitEast(room16);
        room15.setExitWest(room14);
        //room 16
        room16.setExitSouth(room20);
        room16.setExitWest(room15);
        //room 17
        room17.setExitNorth(room12);
        room17.setExitEast(room18);
        room17.setExitWest(room16);
        //room 18
        room18.setExitWest(room17);
        //room 19
        room19.setExitNorth(room14);
        //room 20
        room20.setExitNorth(room16);
    }
}
