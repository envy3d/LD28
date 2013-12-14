/**
 * @author envy3d
 */

package com.envy3d.ld28.map;

public abstract class Tile {
	public int x, y;
	
	public abstract void onTile();
	public abstract void enteringTile();
}
