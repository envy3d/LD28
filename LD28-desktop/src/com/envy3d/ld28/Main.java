package com.envy3d.ld28;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "LD28";
		cfg.useGL20 = true;
		cfg.width = 480;
		cfg.height = 384;
		
		new LwjglApplication(new LD28Game(), cfg);
	}
}
