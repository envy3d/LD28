/**
 * @author envy3d
 */

package com.envy3d.ld28.map;

import com.badlogic.gdx.Gdx;
import com.envy3d.ld28.PlayData;
import com.envy3d.ld28.unit.*;

public class MapBuilder {
	private int height;
	private int width;
	private Tile[][] map;
	
	public MapBuilder() {
		
	}
	
	public MapBuilder(int mapWidth, int mapHeight) {
		setDimensions(mapWidth, mapHeight);
	}
	
	public void setDimensions(int width, int height) {
		this.width = width;
		this.height = height;
		
		map = new Tile[height][];
		
		for (int i = 0; i < height; ++i) {
			map[i] = new Tile[width];
		}
	}
	
	public boolean setTile(int x, int y, String tileType) {
		if (x < 0 || x >= this.width || y < 0 || y >= this.height) {
			Gdx.app.error("That tile location is invalid", null);
			return false;
		}
		switch (tileType) {
			case "grass":
				map[y][x] = new GrassTile(x, y);
				return true;
			case "forest":
				map[y][x] = new ForestTile(x, y);
				return true;
			case "mountain":
				map[y][x] = new MountainTile(x, y);
				return true;
			case "castle":
				map[y][x] = new CastleTile(x, y);
				PlayData.castle = new Castle(x, y);
				PlayData.player = new Player(x, y - 1);
				return true;
			case "hovel":
				map[y][x] = new HovelTile(x, y);
				PlayData.units.add(new Hovel(x, y));
				return true;
				
			default:
				Gdx.app.error("That tile type does not exist", null);
				return false;
		}
	}
	
	/**
	 * The map is not guaranteed to be filled.
	 */
	public Tile[][] getMap() {
		return map;
	}
}
