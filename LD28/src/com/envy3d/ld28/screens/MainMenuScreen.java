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

public class MainMenuScreen implements Screen, InputProcessor {

	public Texture img;
	
	public MainMenuScreen() {
		GameData.assetManager.load("MainMenu.png", Texture.class);
		GameData.assetManager.finishLoading();
		img = GameData.assetManager.get("MainMenu.png");
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Input.Keys.ENTER) {
			GameData.game.setScreen(new LoadingScreen());
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
