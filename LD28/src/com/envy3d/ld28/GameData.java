/**
 * @author envy3d
 */

package com.envy3d.ld28;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameData {
	private GameData(){}
	
	public static SpriteBatch spriteBatch;
	public static AssetManager assetManager;
	public static Game game;
	public static GameCamera camera;
	
	public static boolean playAnimations = false;
	
}
