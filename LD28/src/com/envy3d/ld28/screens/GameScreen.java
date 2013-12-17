/**
 * @author envy3d
 */

package com.envy3d.ld28.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.envy3d.ld28.GameData;
import com.envy3d.ld28.GameMaster;
import com.envy3d.ld28.PlayData;
import com.envy3d.ld28.Renderer;

public class GameScreen implements Screen {
	public GameMaster gameMaster;
	public Renderer renderer;
	
	public GameScreen(GameMaster gameMaster, Renderer renderer) {
		this.gameMaster = gameMaster;
		this.renderer = renderer;
	}

	@Override
	public void render(float delta) {
		if (PlayData.castleAlive == false || PlayData.playerAlive == false) {
			// switch to lose screen
		}
		gameMaster.update(delta);
		
		// if player makes an action, calculations are performed.
		// render
		
		renderer.render(delta);
		
		if (PlayData.castleAlive == false || PlayData.castleAlive == false) {
			LoseScreen screen = new LoseScreen();
			Gdx.input.setInputProcessor(screen);
			GameData.game.setScreen(screen);
		}
		else if (PlayData.currentDay == 8) {
			WinScreen screen = new WinScreen();
			Gdx.input.setInputProcessor(screen);
			GameData.game.setScreen(screen);
		}
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
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

}
