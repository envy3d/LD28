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
		orthoCam = GameData.camera;
		//orthoCam.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() /2, orthoCam.position.z);
		orthoCam.setCameraBounds(0, PlayData.map.getTileWidth() * PlayData.map.getWidth(),
								 0, PlayData.map.getTileHeight() * PlayData.map.getHeight());
		spriteBatch = GameData.spriteBatch;
		tileRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1, spriteBatch);
	}
	
	public void render(float delta) {
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		spriteBatch.setProjectionMatrix(orthoCam.combined);
		orthoCam.realPosition.set(PlayData.player.tileX * PlayData.map.getTileWidth(), (PlayData.player.tileY * PlayData.map.getTileHeight()), orthoCam.position.z);
		orthoCam.stayInBounds();
		orthoCam.update(delta);
		tileRenderer.setView(orthoCam);
		
		tileRenderer.render(renderLayers);
		
		spriteBatch.begin();
		// Render sprites
		for (Unit unit : PlayData.units) {
			if (unit.currentAnim != null) {
				spriteBatch.draw(unit.render(delta), unit.x, unit.y);
			}
		}
		spriteBatch.draw(PlayData.player.render(delta), PlayData.player.x, PlayData.player.y);
		spriteBatch.end();
	}
}
