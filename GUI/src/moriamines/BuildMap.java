package moriamines;

public class BuildMap {
    Room room20 = new Room("a", new String[]{"weapon", "key", "potion"}, Enemy.getOrc());
    Player playerObject1 = new Player(this.room20);
    Room room1 = new Room("a", new String[]{"weapon", "key", "potion"}, Enemy.getOrc());
    Room room2 = new Room("a", new String[]{"weapon"}, Enemy.getOrc());
    Room room3 = new Room("a", new String[]{"weapon"}, Enemy.getOrc());
    RoomWithLock roomWithLock = new RoomWithLock();
    Room room4 = new Room("a", new String[]{"weapon"}, Enemy.getOrc());
    Room room5 = new Room("a", new String[]{"weapon"}, Enemy.getOrc());
    Room room6 = new Room("a", new String[]{"weapon"}, Enemy.getOrc());
    Room room7 = new Room("a", new String[]{"weapon"}, Enemy.getOrc());
    Room room8 = new Room("a", new String[]{"weapon"}, Enemy.getOrc());
    Room room9 = new Room("a", new String[]{"weapon"}, Enemy.getOrc());
    Room room10 = new Room("a", new String[]{"weapon", "key"}, Enemy.getOrc());
    Room room11 = new Room("a", new String[]{"weapon", "key"}, Enemy.getOrc());
    Room room12 = new Room("a", new String[]{"weapon", "key"}, Enemy.getOrc());
    Room room13 = new Room("This room smells like rotten trash.... OHHHHH an", new String[]{"weapon", "key"}, Enemy.getOrc());
    Room room14 = new Room("a", new String[]{"weapon", "key"}, Enemy.getOrc());
    Room room15 = new Room("a", new String[]{"weapon", "key"}, Enemy.getOrc());
    Room room16 = new Room("a", new String[]{}, Enemy.getOrc());
    Room room17 = new Room("a", new String[]{"weapon", "key", "potion"}, Enemy.getOrc());
    Room room18 = new Room("a", new String[]{"weapon", "key", "potion"}, Enemy.getOrc());
    Room room19 = new Room("a", new String[]{"weapon", "key", "potion"}, Enemy.getOrc());
    Room room21 = new Room("Ohhh! Shit! What is this beast??? ... \ncreature: I'M THE TREASURE GUARD.", new String[]{"treasure chest"}, Enemy.getBoss());
    
    public BuildMap() {
        //room 1
        room1.setExitSouth(room5);
        //room 2
        room2.setExitSouth(room6);
        //room 3
        room3.setExitEast(room4);
        room3.setExitNorth(roomWithLock);
        //RoomWithLock
        roomWithLock.setExitNorth(room21);
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
        room16.setExitEast(room17);
        room16.setExitWest(room16);
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

        test();
    }

    public Room[] putRooms() {
        Room[] arrayRooms;
        arrayRooms = new Room[20];
        arrayRooms[0] = room1;
        arrayRooms[1] = room2;
        arrayRooms[2] = room3;
        arrayRooms[3] = room4;
        arrayRooms[4] = room5;
        arrayRooms[5] = room6;
        arrayRooms[6] = room7;
        arrayRooms[7] = room8;
        arrayRooms[8] = room9;
        arrayRooms[9] = room10;
        arrayRooms[10] = room11;
        arrayRooms[11] = room12;
        arrayRooms[12] = room13;
        arrayRooms[13] = room14;
        arrayRooms[14] = room15;
        arrayRooms[15] = room16;
        arrayRooms[16] = room17;
        arrayRooms[17] = room18;
        arrayRooms[18] = room19;
        arrayRooms[19] = room20;
        return arrayRooms;
    }

    public void test() {
        Room currentRoom = room20;
        System.out.println(currentRoom.getFullDescription());
        currentRoom = room16;
        System.out.println(currentRoom.getFullDescription());
        currentRoom = room15;
        System.out.println(currentRoom.getFullDescription());
        currentRoom = room14;
        System.out.println(currentRoom.getFullDescription());
        currentRoom = room19;
        System.out.println(currentRoom.getFullDescription());
        currentRoom = room14;
        System.out.println(currentRoom.getFullDescription());
        currentRoom = room9;
        System.out.println(currentRoom.getFullDescription());
        currentRoom = room10;
        System.out.println(currentRoom.getFullDescription());
        currentRoom = room11;
        System.out.println(currentRoom.getFullDescription());
        currentRoom = room12;
        System.out.println(currentRoom.getFullDescription());
        currentRoom = room13;
        System.out.println(currentRoom.getFullDescription());
    }

}
