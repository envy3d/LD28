/**
 * @author envy3d
 */

package com.envy3d.ld28.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.envy3d.ld28.AnimationHolder;
import com.envy3d.ld28.GameData;
import com.envy3d.ld28.GameMaster;
import com.envy3d.ld28.PlayData;
import com.envy3d.ld28.Renderer;
import com.envy3d.ld28.input.PlayerInput;
import com.envy3d.ld28.map.Map;
import com.envy3d.ld28.map.MapBuilder;
import com.envy3d.ld28.map.TiledMapDataPrepper;
import com.envy3d.ld28.unit.Unit;

public class LoadingScreen implements Screen {
	private AssetManager assets;
	private GameMaster gameMaster;
	private Renderer renderer;
	
	private String mapName = "testMap2.tmx";
	
	public LoadingScreen() {
		assets = GameData.assetManager;
	}

	@Override
	public void render(float delta) {
		if (assets.update()) {
			AnimationHolder.animations = new ArrayMap<String, Animation>();
			AnimationHolder.build(new String[] { "knightIdleLarge.png", "knightRunLarge.png", "knightAttackLarge.png",
												 "goblinIdle.png", "goblinRun.png", "goblinAttack.png", "grass.png" });
			
			TiledMap tiledMap = assets.get(mapName, TiledMap.class);
			MapBuilder mapBuilder = new MapBuilder();
			TiledMapDataPrepper.readTileProperties(tiledMap, mapBuilder);
			PlayData.map = new Map(mapBuilder.getMap(), 48, 48);
			
			gameMaster = new GameMaster();
			renderer = new Renderer(tiledMap);
			Gdx.input.setInputProcessor(new PlayerInput(gameMaster));
			
			for (Unit u : PlayData.units) {
				u.setPixelPosition(PlayData.map.getTileWidth(), PlayData.map.getTileHeight());
			}
			PlayData.castle.setPixelPosition(PlayData.map.getTileWidth(), PlayData.map.getTileHeight());
			PlayData.player.setPixelPosition(PlayData.map.getTileWidth(), PlayData.map.getTileHeight());
			
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
		assets.load("knightIdleLarge.png", Texture.class);
		assets.load("knightRunLarge.png", Texture.class);
		assets.load("knightAttackLarge.png", Texture.class);
		assets.load("goblinIdle.png", Texture.class);
		assets.load("goblinRun.png", Texture.class);
		assets.load("goblinAttack.png", Texture.class);
		assets.load("grass.png", Texture.class);
		PlayData.units = new Array<Unit>(true, 10, Unit.class);
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
