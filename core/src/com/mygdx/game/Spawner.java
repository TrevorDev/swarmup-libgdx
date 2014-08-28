package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Spawner {
	static Vector2 getSpawnPos(){
		return new Vector2(0,9*(GameState.current.stage.getViewport().getWorldHeight()/2)/11);
	}
}
