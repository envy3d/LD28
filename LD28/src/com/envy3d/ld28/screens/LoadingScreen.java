/**
 * @author envy3d
 */

package com.envy3d.ld28.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.envy3d.ld28.GameData;
import com.envy3d.ld28.GameMaster;
import com.envy3d.ld28.PlayData;
import com.envy3d.ld28.Renderer;
import com.envy3d.ld28.map.Map;
import com.envy3d.ld28.map.MapBuilder;
import com.envy3d.ld28.map.TiledMapDataPrepper;

public class LoadingScreen implements Screen {
	private AssetManager assets;
	private GameMaster gameMaster;
	private Renderer renderer;
	
	private String mapName = "testMap.tmx";
	
	public LoadingScreen() {
		assets = GameData.assetManager;
	}

	@Override
	public void render(float delta) {
		if (assets.update()) {
			TiledMap tiledMap = assets.get(mapName, TiledMap.class);
			MapBuilder mapBuilder = new MapBuilder();
			TiledMapDataPrepper.readTileProperties(tiledMap, mapBuilder);
			PlayData.map = new Map(mapBuilder.getMap(), 48, 48);
			gameMaster = new GameMaster();
			renderer = new Renderer(tiledMap);
			GameData.game.setScreen(new GameScreen(gameMaster, renderer));
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		assets.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
		assets.load(mapName, TiledMap.class);
		assets.load("knightIdle.png", Texture.class);
		assets.load("knightRun.png", Texture.class);
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

}
