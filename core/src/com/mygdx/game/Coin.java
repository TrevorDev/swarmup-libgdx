package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Coin extends DisplayObject {

	public Coin() {
		super(new Vector2(30,30), new Texture("coin.png"));
	}

}
