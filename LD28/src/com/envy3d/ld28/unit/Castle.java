/**
 * @author envy3d
 */

package com.envy3d.ld28.unit;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.envy3d.ld28.PlayData;


public class Castle extends Unit {

	public Castle(int tileX, int tileY) {
		super(tileX, tileY);
	}

	@Override
	public void attack(int tileX, int tileY) {
	}

	@Override
	public void move(int tileX, int tileY) {
	}

	@Override
	public void die() {
		PlayData.castleAlive = false;
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
