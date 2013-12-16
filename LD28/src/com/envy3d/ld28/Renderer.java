/**
 * @author envy3d
 */

package com.envy3d.ld28;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.envy3d.ld28.unit.Unit;

public class Renderer {
	private int[] renderLayers = {0};
	private GameCamera orthoCam;
	private SpriteBatch spriteBatch;
	private OrthogonalTiledMapRenderer tileRenderer;
	
	public Renderer(TiledMap tiledMap) {
		orthoCam = new GameCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		orthoCam.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() /2, orthoCam.position.z);
		orthoCam.setCameraBounds(0, PlayData.map.getTileWidth() * PlayData.map.getWidth(),
								 0, PlayData.map.getTileHeight() * PlayData.map.getHeight());
		spriteBatch = GameData.spriteBatch;
		tileRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1, spriteBatch);
	}
	
	public void render(float delta) {
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		spriteBatch.setProjectionMatrix(orthoCam.combined);
		orthoCam.update();
		tileRenderer.setView(orthoCam);
		
		tileRenderer.render(renderLayers);
		
		spriteBatch.begin();
		// Render sprites
		/*
		for (Unit unit : PlayData.units) {
			spriteBatch.draw(unit.render(delta), unit.x, unit.y);
		}
		*/
		spriteBatch.end();
	}
}
