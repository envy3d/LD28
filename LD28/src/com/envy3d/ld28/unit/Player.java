/**
 * @author envy3d
 */

package com.envy3d.ld28.unit;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.envy3d.ld28.AnimationHolder;
import com.envy3d.ld28.PlayData;

public class Player extends Ambulator {
	public Animation idling;
	public Animation moving;
	public Animation attacking;
	
	public Player(AssetManager assets) {
		animTime = 0;
		idling = AnimationHolder.animations.get("knightIdle");
		moving = AnimationHolder.animations.get("knightRun");
		currentAnim = idling;
		
		attack = 3;
		defense = 3;
		move = 2;
		ranged = false;
	}

	@Override
	public void attack(int tileX, int tileY) {
		
	}
	
	@Override
	public void move(int tileX, int tileY) {
		
	}

	@Override
	public void defend() {
		
	}
	
	@Override
	public void die() {
		PlayData.playerAlive = false;
	}

	@Override
	public void update(float delta) {
		
	}

	@Override
	public void onAnimationFinished() {
	}
	
	public void setStats(int attack, int defense, int move, boolean ranged) {
		this.attack = attack;
		this.defense = defense;
		this.move = move;
		this.ranged = ranged;
	}
}
