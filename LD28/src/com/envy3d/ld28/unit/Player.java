/**
 * @author envy3d
 */

package com.envy3d.ld28.unit;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.envy3d.ld28.AnimationHolder;

public class Player extends Unit {
	public Animation idling;
	public Animation moving;
	public Animation attacking;
	
	public Player(AssetManager assets) {
		animTime = 0;
		idling = AnimationHolder.animations.get("knightIdle");
		moving = AnimationHolder.animations.get("knightRun");
		currentAnim = idling;
	}

	@Override
	public void attack() {
		
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
}
