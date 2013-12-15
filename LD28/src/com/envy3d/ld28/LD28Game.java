package com.envy3d.ld28;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.envy3d.ld28.screens.LoadingScreen;

public class LD28Game extends Game {//implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch spriteBatch;
	
	@Override
	public void create() {		
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		spriteBatch = new SpriteBatch();
		GameData.spriteBatch = spriteBatch;
		setScreen(new LoadingScreen());
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
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
