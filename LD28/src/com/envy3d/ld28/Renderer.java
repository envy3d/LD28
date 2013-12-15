/**
 * @author envy3d
 */

package com.envy3d.ld28;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.envy3d.ld28.unit.Unit;

public class Renderer {
	private int[] renderLayers = {0};
	private OrthographicCamera orthoCam;
	private SpriteBatch spriteBatch;
	private OrthogonalTiledMapRenderer tileRenderer;
	
	public Renderer(TiledMap tiledMap) {
		tileRenderer = new OrthogonalTiledMapRenderer(tiledMap, 0.25f, spriteBatch);
		orthoCam = new OrthographicCamera(10, 10);
	}
	
	public void render(float delta) {
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		spriteBatch.setProjectionMatrix(orthoCam.combined);
		tileRenderer.setView(orthoCam);
		
		tileRenderer.render(renderLayers);
		
		spriteBatch.begin();
		// Render sprites
		for (Unit unit : PlayData.units) {
			spriteBatch.draw(unit.render(delta), unit.x, unit.y);
		}
		
		spriteBatch.end();
	}
}
