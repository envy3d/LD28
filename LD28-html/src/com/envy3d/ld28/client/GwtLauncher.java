package com.envy3d.ld28.client;

import com.envy3d.ld28.LD28Game;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class GwtLauncher extends GwtApplication {
	@Override
	public GwtApplicationConfiguration getConfig () {
		GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(480, 384);
		return cfg;
	}

	@Override
	public ApplicationListener getApplicationListener () {
		return new LD28Game();
	}
}