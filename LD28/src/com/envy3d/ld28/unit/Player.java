/**
 * @author envy3d
 */

package com.envy3d.ld28.unit;

import com.envy3d.ld28.AnimationHolder;
import com.envy3d.ld28.PlayData;

public class Player extends Ambulator {
	
	public Player(int tileX, int tileY) {
		super(tileX, tileY);
		animTime = 0;
		idling = AnimationHolder.animations.get("knightIdleLarge.png");
		moving = AnimationHolder.animations.get("knightRunLarge.png");
		attacking = AnimationHolder.animations.get("knightAttackLarge.png");
		currentAnim = idling;
		
		attack = 3;
		defense = 3;
		move = 2;
		ranged = false;
	}
	
	@Override
	public void die() {
		super.die();
		PlayData.playerAlive = false;
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
