/**
 * @author envy3d
 */

package com.envy3d.ld28;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;

public class AnimationHolder {
	public static ArrayMap<String, Animation> animations;
	
	public AnimationHolder(String[] spritesheetNames, AssetManager assets) {
		Texture tempTex;
		Array<TextureRegion> tempRegs = new Array<>(3);
		
		for (String name : spritesheetNames) {
			tempTex = assets.get(name, Texture.class);
			int texWidth = tempTex.getWidth();
			int texHeight = tempTex.getHeight();
			int numOfTextures = texWidth / texHeight;
			
			for (int i = 0; i < numOfTextures; ++i) {
				tempRegs.add(new TextureRegion(tempTex, i * texHeight, 0, texHeight, texHeight));
			}
			animations.put(name, new Animation(0.25f, tempRegs));
			tempRegs.clear();
		}
	}
}
