package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;

public class Swarmup extends ApplicationAdapter {
	@Override
	public void create () {
		BoomBox.init();
		GameState.newGameState();
	}

	@Override
	public void render () {
		GameState.current.render();
	}
}
