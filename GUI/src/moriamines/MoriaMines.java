package moriamines;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoriaMines {
    public static boolean gameOver = false;

    public static void main(String[] args) throws IOException {
        String command, res;
        BuildMap map =new BuildMap();
        Player playerObject1 =  map.playerObject1;

        while (!gameOver) {
            System.out.print("Command: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            command = in.readLine();
            res = doCommand(playerObject1, command);
            System.out.println(res);
        }
        System.out.println("Game ended");
    }

    private static String doCommand(Player playerObject1, String command) {
        String[] parts = command.split(" ");
        if (parts[0].length() == 0) {
            return "Nothing typed!";
        } else {

            if (parts[0].equalsIgnoreCase("back")) {
                return "Will go back!";
            }
            if (parts[0].equalsIgnoreCase("help")) {
                return playerObject1.help();
            }
            if (parts[0].equalsIgnoreCase("inventory")) {
                return playerObject1.getInventory();
            }
            if (parts[0].equalsIgnoreCase("north")) {
                return playerObject1.goNorth();
            }
            if (parts[0].equalsIgnoreCase("south")) {
                return playerObject1.goSouth();
            }
            if (parts[0].equalsIgnoreCase("east")) {
                return playerObject1.goEast();
            }
            if (parts[0].equalsIgnoreCase("west")) {
                return playerObject1.goWest();
            }
            if (parts[0].equalsIgnoreCase("attack")) {
                
                return playerObject1.attack();
            }
            if (parts[0].equalsIgnoreCase("pickitems")) {
                
                return playerObject1.pickUp();
            }
        }
        return "Not a valid command: " + command;
    }

}
