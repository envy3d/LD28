/**
 * @author envy3d
 */

package com.envy3d.ld28.map;

public abstract class Tile {
	public int x, y;
	public int moveCost;
	public float attackMod = 1;
	public float defendMod = 1;
	
	
	public abstract void onTile();
	public abstract void enteringTile();
	public void onSpawn() {}
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
