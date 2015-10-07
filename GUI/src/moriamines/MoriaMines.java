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
//ENGINE
        while (!gameOver) {
            System.out.print("Command: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            command = in.readLine();
            res = doCommand(playerObject1, command);
            System.out.println(res);
        }
        System.out.println("Game ended");
    }
//COMMANDS (FROM PLAYER)
    private static String doCommand(Player playerObject1, String command) throws IOException {
        String[] parts = command.split(" ");
        if (parts[0].length() == 0) {
            return "Nothing typed!";
        } else {

            if (parts[0].equalsIgnoreCase("back")) {
                return playerObject1.back();
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
            if (parts[0].equalsIgnoreCase("player")) {
                
                return playerObject1.player();
            }
            if (parts[0].equalsIgnoreCase("heal")) {
                
                return playerObject1.usePotion();
            }
            if (parts[0].equalsIgnoreCase("usearmor")) {
                
                return playerObject1.useArmor();
            }
            if (parts[0].equalsIgnoreCase("useweapon")) {
                
                return playerObject1.useWeapon();
            }
            if (parts[0].equalsIgnoreCase("usekey")) {
                
                return playerObject1.useKey();
            }
            if (parts[0].equalsIgnoreCase("restart")) {
                
                main(new String[]{""});
            }
            if (parts[0].equalsIgnoreCase("quit")) {
                
                gameOver = true;
            }
            /*
            if (parts[0].equalsIgnoreCase("use")) {
                
                return playerObject1.use();
            }*/
            
        }
        return "Not a valid command: " + command;
    }

}
