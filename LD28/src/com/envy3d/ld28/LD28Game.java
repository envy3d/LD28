package com.envy3d.ld28;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.envy3d.ld28.screens.LoadingScreen;

public class LD28Game extends Game {//implements ApplicationListener {
	private OrthographicCamera camera;
	
	@Override
	public void create() {		
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		GameData.spriteBatch = new SpriteBatch();
		GameData.assetManager = new AssetManager();
		GameData.game = this;
		setScreen(new LoadingScreen());
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
