/**
 * @author envy3d
 */

package com.envy3d.ld28.map;

public class Map {
	private int width;
	private int height;
	private Tile[][] tiles;
	
	public Map() {
		
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) {
			return null;
		}
		return tiles[y][x];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() { 
		return height;
	}
}
