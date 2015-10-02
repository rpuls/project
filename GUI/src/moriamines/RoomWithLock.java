
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
	static Items items = null;
	static Enemy enemy = null;

    public RoomWithLock() {
        super("There seems to be a heavy door in the north direction in this room.", items, enemy);
    }
    
    
}
