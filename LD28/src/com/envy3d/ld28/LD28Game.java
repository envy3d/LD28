package com.envy3d.ld28;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.envy3d.ld28.screens.LoadingScreen;
import com.envy3d.ld28.screens.MainMenuScreen;

public class LD28Game extends Game {//implements ApplicationListener {
	
	@Override
	public void create() {		
		GameData.spriteBatch = new SpriteBatch();
		GameData.assetManager = new AssetManager();
		GameData.game = this;
		GameData.camera = new GameCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		MainMenuScreen screen = new MainMenuScreen();
		Gdx.input.setInputProcessor(screen);
		setScreen(screen);
	}

	@Override
	public void dispose() {
		GameData.spriteBatch.dispose();
		GameData.assetManager.dispose();
	}

	@Override
	public void resize(int width, int height) {
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

}
