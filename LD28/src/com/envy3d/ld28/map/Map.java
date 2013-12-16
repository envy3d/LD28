/**
 * @author envy3d
 */

package com.envy3d.ld28.map;

public class Map {
	private int width;
	private int height;
	private int tileWidth;
	private int tileHeight;
	private Tile[][] tiles;
	
	public Map(Tile[][] tiles, int tileWidth, int tileHeight) {
		this.tiles = tiles;
		this.width = tiles[0].length;
		this.height = tiles.length;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		
	}
	
	public Map(int width, int height, int tileWidth, int tileHeight) {
		this.width = width;
		this.height = height;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
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
	
	public int getTileWidth() {
		return tileWidth;
	}
	
	public int getTileHeight() {
		return tileHeight;
	}
}
