/**
 * @author envy3d
 */

package com.envy3d.ld28.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.envy3d.ld28.PlayData;
import com.envy3d.ld28.unit.Player;

public class PlayerInput implements InputProcessor {
	
	private InputReceiver receiver;
	
	public PlayerInput(InputReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public boolean keyDown(int keycode) {
		if(PlayData.isPlayerTurn) {
			if (keycode == Input.Keys.LEFT) {
				 if (receiver.selectLocation(PlayData.player.tileX - 1, PlayData.player.tileY, PlayData.player)) {
					PlayData.isPlayerTurn = false;
					PlayData.isAiTurn = true;
				}
				return true;
			}
			else if (keycode == Input.Keys.RIGHT) {
				if (receiver.selectLocation(PlayData.player.tileX + 1, PlayData.player.tileY, PlayData.player)) {
					PlayData.isPlayerTurn = false;
					PlayData.isAiTurn = true;
				}
				return true;
			}
			else if (keycode == Input.Keys.UP) {
				if (receiver.selectLocation(PlayData.player.tileX, PlayData.player.tileY + 1, PlayData.player)) {
					PlayData.isPlayerTurn = false;
					PlayData.isAiTurn = true;
				}
				return true;
			}
			else if (keycode == Input.Keys.DOWN) {
				if (receiver.selectLocation(PlayData.player.tileX, PlayData.player.tileY - 1, PlayData.player)) {
					PlayData.isPlayerTurn = false;
					PlayData.isAiTurn = true;
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	
}
