package com.mapuainvaders.game;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode(1280, 720);
		config.setResizable(false);
		config.setTitle("Mapua Invaders");
		config.setWindowIcon(Files.FileType.Internal,"Icon/Mapua_Invaders.png");
		config.useVsync(true);
		new Lwjgl3Application(new MapuaInvaders(), config);
	}
}