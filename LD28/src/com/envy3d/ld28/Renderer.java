/**
 * @author envy3d
 */

package com.envy3d.ld28;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;

public class Renderer {
	private int[] renderLayers = {0};
	private OrthographicCamera orthoCam;
	private SpriteBatch spriteBatch;
	private TiledMapRenderer tileRenderer;
	
	public void render(float delta) {
		spriteBatch.setProjectionMatrix(orthoCam.combined);
		tileRenderer.setView(orthoCam);
		
		tileRenderer.render(renderLayers);
		
		spriteBatch.begin();
		// Render sprites
		
		spriteBatch.end();
	}
}
