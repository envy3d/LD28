/**
 * @author envy3d
 */

package com.envy3d.ld28.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.envy3d.ld28.GameData;

public class LoseScreen implements Screen, InputProcessor {
	
	public Texture img;
	
	public LoseScreen() {
		img = GameData.assetManager.get("loseScreen.png", Texture.class);
	}
	
	@Override
	public void render(float delta) {
		GameData.camera.position.x = Gdx.graphics.getWidth() / 2;
		GameData.camera.position.y = Gdx.graphics.getHeight() / 2;
		GameData.camera.update();
		GameData.spriteBatch.begin();
		GameData.spriteBatch.draw(img, 0, 0);
		GameData.spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Input.Keys.ENTER) {
			MainMenuScreen screen = new MainMenuScreen();
			Gdx.input.setInputProcessor(screen);
			GameData.game.setScreen(screen);
			return true;
		}
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
