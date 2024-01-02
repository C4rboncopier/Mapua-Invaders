package com.mapuainvaders.game;

import com.badlogic.gdx.Game;
import com.mapuainvaders.game.screens.Splash;

public class MapuaInvaders extends Game {
	
	@Override
	public void create () {
		setScreen(new Splash(this));
	}

	@Override
	public void dispose () {
		super.dispose();
	}
	
	@Override
	public void render () {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}