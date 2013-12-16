/**
 * @author envy3d
 */

package com.envy3d.ld28.map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class TiledMapDataPrepper {
	
	/**
	 * Puts tmx map data into the provided MapBuilder.
	 * @param tiledMap
	 * @param mapBuilder
	 */
	public static void readTileProperties(TiledMap tiledMap, MapBuilder mapBuilder) {
		TiledMapTileLayer tiles = (TiledMapTileLayer)tiledMap.getLayers().get(0);
		mapBuilder.setDimensions(tiles.getWidth(), tiles.getHeight());
		
		for (int i = 0, m = tiles.getHeight(); i < m; i++) {
			for (int j = 0, n = tiles.getWidth(); j < n; j++) {
				String a = tiles.getCell(j, i).getTile().getProperties().get("type", String.class);
				mapBuilder.setTile(j, i, tiles.getCell(j, i).getTile().getProperties().get("type", String.class));
			}
		}
	}
	
}