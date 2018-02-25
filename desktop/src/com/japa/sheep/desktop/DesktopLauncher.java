package com.japa.sheep.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.japa.sheep.SheepGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "SheepGame";
		config.width = 800;
		config.height = 400;
		System.out.println("GAAAH");
		new LwjglApplication(new SheepGame(), config);
	}
}
