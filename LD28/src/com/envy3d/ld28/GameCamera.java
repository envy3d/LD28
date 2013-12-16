/**
 * @author envy3d
 */

package com.envy3d.ld28;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class GameCamera extends OrthographicCamera {
	
	public boolean stayInCameraBounds;
	public int leftBound, rightBound, bottomBound, topBound;
	public Vector3 realPosition;
	
	public GameCamera(int screenWidth, int screenHeight) {
		super(screenWidth, screenHeight);
		stayInCameraBounds = true;
		realPosition = position.cpy();
	}
	
	public void update(float delta) {
		position.x = (int)realPosition.x;
		position.y = (int)realPosition.y;
		this.update();
	}
	
	public void stayInBounds() {
		if (realPosition.x - (viewportWidth * 0.5f) < 0) {
			realPosition.x = (viewportWidth * 0.5f);
		}
		else if (realPosition.x + (viewportWidth * 0.5f) > rightBound) {
			realPosition.x = rightBound - (viewportWidth * 0.5f);
		}
		if (realPosition.y - (viewportHeight * 0.5f) < 0) {
			realPosition.y = (viewportHeight * 0.5f);
		}
		else if (realPosition.y + (viewportHeight * 0.5f) > topBound) {
			realPosition.y = topBound - (viewportHeight * 0.5f);
		}
	}
	
	public void setCameraBounds(int leftEdge, int rightEdge, int bottomEdge, int topEdge) {
		this.leftBound = leftEdge;
		this.rightBound = rightEdge;
		this.bottomBound = bottomEdge;
		this.topBound = topEdge;
	}
}
