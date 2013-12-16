/**
 * @author envy3d
 */

package com.envy3d.ld28;

import com.badlogic.gdx.utils.Array;
import com.envy3d.ld28.input.InputReceiver;
import com.envy3d.ld28.map.Map;
import com.envy3d.ld28.map.Tile;
import com.envy3d.ld28.unit.Castle;
import com.envy3d.ld28.unit.Goblin;
import com.envy3d.ld28.unit.Hovel;
import com.envy3d.ld28.unit.Player;
import com.envy3d.ld28.unit.Unit;

public class GameMaster implements InputReceiver {
	private final int HOURS_IN_DAY = 24;
	private final int DAYS_TO_SURVIVE = 21; // ???
	
	private Map map;
	
	public GameMaster() {
		map = PlayData.map;
	}
	
	public void update(float delta) {
		if (!PlayData.isAiTurn && !PlayData.isPlayerTurn) {
			PlayData.currentHour += 1;
			if (PlayData.currentHour == 24) {
				PlayData.currentHour = 0;
				PlayData.currentDay += 1;
				for (Unit u : PlayData.units) {
					if (u instanceof Hovel) {
						PlayData.units.add(new Goblin(u.tileX, u.tileY));
						PlayData.units.peek().setPixelPosition(PlayData.map.getTileWidth(), PlayData.map.getTileHeight());
						PlayData.units.peek().hp = 2 + (PlayData.currentDay/3);
					}
				}
			}
			PlayData.isPlayerTurn = true;
		}
		else if (PlayData.isAiTurn) {
			// run AI
			PlayData.isAiTurn = false;
		}
		
		for (Unit u : PlayData.units) {
			u.update(delta);
		}
		PlayData.player.update(delta);
	}

	@Override
	public Array<Tile> queryNeighbors(int x, int y, int unitID) {
		
		return null;
	}

	@Override
	public boolean selectLocation(int x, int y, Unit unit) {
		Unit unitInDestTile = null;
		for (Unit u : PlayData.units) {
			if (u.tileX == x && u.tileY == y) {
				unitInDestTile = u;
			}
		}
		if (PlayData.player.tileX == x && PlayData.player.tileY == y) {
			unitInDestTile = PlayData.player;
		}
		if (unitInDestTile != null) {
			if (unit instanceof Goblin) {
				if (unitInDestTile instanceof Goblin) {
					return false;
				}
				else {
					unit.attack(x, y);
					unitInDestTile.defend();
					return true;
				}
			}
			else if (unit instanceof Player) {
				if (unitInDestTile instanceof Castle) {
					return false;
				}
				else if(unitInDestTile instanceof Hovel) {
					unit.attack(x, y);
					return true;
				}
				else if (unitInDestTile instanceof Goblin) {
					unit.attack(x, y);
					unitInDestTile.defend();
					return true;
				}
			}
		}
		else {
			if (PlayData.map.getTile(x, y).moveCost > 1) {
				return false;
			}
			else {
				unit.move(x, y);
				return true;
			}
		}
		return false;
	}

	@Override
	public Tile queryTile(int x, int y) {
		return map.getTile(x, y);
	}

}
