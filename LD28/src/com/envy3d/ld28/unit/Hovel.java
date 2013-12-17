/**
 * @author envy3d
 */

package com.envy3d.ld28.unit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.envy3d.ld28.AnimationHolder;
import com.envy3d.ld28.GameData;


public class Hovel extends Unit {
	public boolean alive = true;

	public Hovel(int tileX, int tileY) {
		super(tileX, tileY);
		hp = 10;
	}

	@Override
	public void attack(int tileX, int tileY) {
	}

	@Override
	public void move(int tileX, int tileY) {
	}

	@Override
	public void die() {
		alive = false;
		int a = x;
		int b = y;
		currentAnim = AnimationHolder.animations.get("grass.png");
	}
	
	@Override
	public void defend() {
	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void onAnimationFinished() {
	}
	
	@Override
	public TextureRegion render(float delta) {
		return null;
	}

	@Override
	public void conquer(int tileX, int tileY) {
	}
}
