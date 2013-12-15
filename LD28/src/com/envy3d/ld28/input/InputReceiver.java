/**
 * @author envy3d
 */

package com.envy3d.ld28.input;

import com.badlogic.gdx.utils.Array;
import com.envy3d.ld28.map.Tile;

public interface InputReceiver {
	
	public Tile queryTile(int x, int y);
	public Array<Tile> queryNeighbors(int x, int y, int unitID);
	public boolean selectLocation(int x, int y, int unitID);
	
}
