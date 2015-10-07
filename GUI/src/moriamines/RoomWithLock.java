
 /** To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moriamines;

/**
 *
 * @author Puls
 */
public class RoomWithLock extends Room {

	private boolean isLocked = true;

    public RoomWithLock(Items i, Enemy e, int coins) {
        super("\nBut there is a heavy door in the north direction in this room.\n", i, e , coins);
    }
    
    @Override
    public boolean unlock(){
    	if(isLocked){
    		isLocked = false;
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Room getExitNorth() {
    	if(isLocked){
    		System.out.println("The door is locked!");
    		return null;
    	}
        return super.getExitNorth();
        
    }
    
    
}
