/**
 * @author envy3d
 */

package com.envy3d.ld28;

import com.badlogic.gdx.utils.Array;
import com.envy3d.ld28.input.InputReceiver;
import com.envy3d.ld28.map.Map;
import com.envy3d.ld28.map.Tile;

public class GameMaster implements InputReceiver {
	private final int HOURS_IN_DAY = 24;
	private final int DAYS_TO_SURVIVE = 21; // ???
	
	private Map map;
	
	public GameMaster() {
		map = PlayData.map;
	}
	
	public void update(float delta) {
		
	}

	@Override
	public Array<Tile> queryNeighbors(int x, int y, int unitID) {
		
		return null;
	}

	@Override
	public boolean selectLocation(int x, int y, int unitID) {
		
		return false;
	}

	@Override
	public Tile queryTile(int x, int y) {
		return map.getTile(x, y);
	}

}
