/**
 * @author envy3d
 */

package com.envy3d.ld28;

import com.badlogic.gdx.math.Vector2;
import com.envy3d.ld28.input.InputReceiver;
import com.envy3d.ld28.unit.Goblin;
import com.envy3d.ld28.unit.Unit;

public class Ai {
	
	private InputReceiver receiver;
	
	public Ai(InputReceiver receiver) {
		this.receiver = receiver;
	}

	public void update() {
		//for (Unit u : PlayData.units) {
		Unit u;
		for (int i = 0; i < PlayData.units.items.length; i++) {
			u = PlayData.units.items[i];
			if (u instanceof Goblin) {
				if ((u.x + 1 == PlayData.castle.x && u.y == PlayData.castle.y) || (u.x + 1 == PlayData.player.x && u.y == PlayData.player.y)) {
					receiver.selectLocation(u.tileX + 1, u.tileY, u);
				}
				else if ((u.x - 1 == PlayData.castle.x && u.y == PlayData.castle.y) || (u.x - 1 == PlayData.player.x && u.y == PlayData.player.y)) {
					receiver.selectLocation(u.tileX - 1, u.tileY, u);
				}
				else if ((u.x == PlayData.castle.x && u.y + 1 == PlayData.castle.y) || (u.x == PlayData.player.x && u.y + 1 == PlayData.player.y)) {
					receiver.selectLocation(u.tileX, u.tileY + 1, u);
				}
				else if ((u.x == PlayData.castle.x && u.y - 1 == PlayData.castle.y) || (u.x == PlayData.player.x && u.y - 1 == PlayData.player.y)) {
					receiver.selectLocation(u.tileX, u.tileY - 1, u);
				}
				else {
					//find direction of player
					int x = PlayData.player.tileX - u.tileX;
					int y = PlayData.player.tileY - u.tileY;
					
					int cx = PlayData.castle.tileX - u.tileX;
					int cy = PlayData.castle.tileY - u.tileY;
					
					if (((cx*cx) + (cy*cy)) < ((x*x) + (y*y))) {
						x = cx;
						y = cy;
					}
					
					Vector2 vec = new Vector2(x, y);
					vec.nor();
					if (Math.abs(vec.x) > Math.abs(vec.y)) {
						if (vec.x > 0)
							receiver.selectLocation(u.tileX + 1, u.tileY, u);
						else
							receiver.selectLocation(u.tileX - 1, u.tileY, u);
					}
					if (vec.y > 0)
						receiver.selectLocation(u.tileX, u.tileY + 1, u);
					else
						receiver.selectLocation(u.tileX, u.tileY - 1, u);
				}
			}
			u = null;
		}
	}
}
