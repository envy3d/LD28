/**
 * @author envy3d
 */

package com.envy3d.ld28.unit;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Unit {
	
	public int tileX, tileY;
	public int x, y;
	public int hp;
	public int unitID;
	public String name;
	
	protected int animTime;
	public Animation currentAnim;
	
	public Unit(int tileX, int tileY) {
		this.tileX = tileX;
		this.tileY = tileY;
	}
	
	public void setPixelPosition(int pixelsPerTileX, int pixelsPerTileY) {
		x = tileX * pixelsPerTileX;
		y = tileY * pixelsPerTileY;
	}
	
	public abstract void attack(int tileX, int tileY);
	
	public abstract void conquer(int tileX, int tileY);
	
	public abstract void defend();
	
	public abstract void move(int tileX, int tileY);
	
	public abstract void die();
	
	public void update(float delta) {
		
	}
	
	public abstract void onAnimationFinished();
	
	public TextureRegion render(float delta) {
		/*animTime += delta;
		if (animTime > currentAnim.animationDuration) {
			animTime -= currentAnim.animationDuration;
			onAnimationFinished();
		}*/
		return currentAnim.getKeyFrame(animTime);
	}
	
}
