/**
 * @author envy3d
 */

package com.envy3d.ld28.unit;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Unit {
	public int x, y;
	public int hp;
	public int unitID;
	public String name;
	
	protected int animTime;
	protected Animation currentAnim;
	
	public int attack, defense, move;
	public boolean ranged;
	
	public abstract void attack();
	
	public abstract void defend();
	
	public abstract void update(float delta);
	
	public abstract void onAnimationFinished();
	
	public TextureRegion render(float delta) {
		animTime += delta;
		if (animTime > currentAnim.animationDuration) {
			animTime -= currentAnim.animationDuration;
			onAnimationFinished();
		}
		return currentAnim.getKeyFrame(animTime);
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void die() {
		
	}
	
}
