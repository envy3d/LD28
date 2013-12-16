/**
 * @author envy3d
 */

package com.envy3d.ld28.unit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.envy3d.ld28.PlayData;

public class Ambulator extends Unit {
	public final float ACTION_TIMER_TARGET = 0.5f;
	
	public int attack, defense, move;
	public boolean ranged;
	public boolean isMoving, isAttacking, isDefending, isDieing;
	public float actionTimer = 0;
	public Vector2 pixelDestination;
	
	public void attack(int tileX, int tileY) {
		isAttacking = true;
		actionTimer = 0;
		pixelDestination.set(tileX * PlayData.map.getTileWidth(), tileY * PlayData.map.getTileHeight());
	}
	
	public void defend() {
		isDefending = true;
		actionTimer = 0;
	}
	
	public void move(int tileX, int tileY) {
		isMoving = true;
		this.tileX = tileX;
		this.tileY = tileY;
		actionTimer = 0;
		pixelDestination.set(tileX * PlayData.map.getTileWidth(), tileY * PlayData.map.getTileHeight());
	}
	
	public void die() {
		isDieing = true;
		actionTimer = 0;
	}
	
	@Override
	public void onAnimationFinished() {
	}
	
	public void update(float delta) {
		if (isAttacking) {
			
		}
		else if (isMoving) {
			
		}
		else if (isDefending) {
			
		}
		else if (isDieing) {
			
		}
		else { // is idling
			
		}
	}
}
