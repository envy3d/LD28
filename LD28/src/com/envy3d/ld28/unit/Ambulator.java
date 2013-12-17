/**
 * @author envy3d
 */

package com.envy3d.ld28.unit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.envy3d.ld28.PlayData;

public class Ambulator extends Unit {

	public final float ACTION_TIMER_TARGET = 0.5f;
	
	public int attack, defense, move;
	public boolean ranged;
	public boolean isMoving, isAttacking, isConquering, isDefending, isDieing;
	public float actionTimer = 0;
	public Vector2 pixelDestination;
	
	public Animation idling;
	public Animation moving;
	public Animation attacking;
	
	public Ambulator(int tileX, int tileY) {
		super(tileX, tileY);
		pixelDestination = new Vector2();
	}
	
	public void attack(int tileX, int tileY) {
		isAttacking = true;
		actionTimer = 0;
		pixelDestination.set(tileX * PlayData.map.getTileWidth(), tileY * PlayData.map.getTileHeight());
	}
	
	@Override
	public void conquer(int tileX, int tileY) {
		this.tileX = tileX;
		this.tileY = tileY;
		isConquering = true;
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
		currentAnim = moving;
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
			if (actionTimer == 0) {
				currentAnim = attacking;
				x = (int) ((x + pixelDestination.x) / 2);
				y = (int) ((y + pixelDestination.y) / 2);
			}
			else if (actionTimer < ACTION_TIMER_TARGET) {
				
			}
			else {
				actionTimer = 0;
				currentAnim = idling;
				isAttacking = false;
				x = tileX * PlayData.map.getTileWidth();
				y = tileY * PlayData.map.getTileHeight();
			}
		}
		else if (isConquering) {
			if (actionTimer == 0) {
				currentAnim = attacking;
				x = (int) ((x + pixelDestination.x) / 2);
				y = (int) ((y + pixelDestination.y) / 2);
			}
			else if (actionTimer < ACTION_TIMER_TARGET) {
				
			}
			else {
				actionTimer = 0;
				currentAnim = idling;
				isConquering = false;
				x = (int) pixelDestination.x;
				y = (int) pixelDestination.y;
			}
		}
		else if (isMoving) {
			if (actionTimer == 0) {
				currentAnim = moving;
				x = (int) ((x + pixelDestination.x) / 2);
				y = (int) ((y + pixelDestination.y) / 2);
			}
			else if (actionTimer < ACTION_TIMER_TARGET) {
				
			}
			else {
				actionTimer = 0;
				currentAnim = idling;
				isMoving = false;
				x = (int) pixelDestination.x;
				y = (int) pixelDestination.y;
			}
		}
		else if (isDefending) {
			if (actionTimer == 0) {
			}

			else if (actionTimer > ACTION_TIMER_TARGET / 2 && actionTimer < ACTION_TIMER_TARGET) {
				currentAnim = attacking;
			}
			else {
				actionTimer = 0;
				currentAnim = idling;
				isDefending = false;
			}
		}
		else if (isDieing) {
			
		}
		else { // is idling
			
		}
		actionTimer += delta;
	}
}
