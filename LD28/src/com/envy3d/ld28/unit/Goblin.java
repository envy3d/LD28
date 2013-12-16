/**
 * @author envy3d
 */

package com.envy3d.ld28.unit;

import com.envy3d.ld28.AnimationHolder;

public class Goblin extends Ambulator {

	public Goblin(int tileX, int tileY) {
		super(tileX, tileY);
		idling = AnimationHolder.animations.get("goblinIdle.png");
		moving = AnimationHolder.animations.get("goblinRun.png");
		attacking = AnimationHolder.animations.get("goblinAttack.png");
		currentAnim = idling;
	}

	@Override
	public void onAnimationFinished() {
	}

}
