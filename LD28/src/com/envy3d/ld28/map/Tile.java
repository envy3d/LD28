/**
 * @author envy3d
 */

package com.envy3d.ld28.map;

import com.badlogic.gdx.utils.ArrayMap;

public abstract class Tile {
	protected int x, y;
	public ArrayMap<String, ? extends Number> stats;
	
	public abstract void onTile();
	public abstract void enteringTile();
	public void onSpawn() {}
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
