package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class FlyFace extends DisplayObject {

	float acc = 0.01f;
	public FlyFace() {
		super(new Vector2(50, 50), new Texture("alt/flyface.png"));
		this.pos = Spawner.getSpawnPos();
	}
	
	@Override
	public void move(){
		this.spd.set(GameState.current.player.pos.cpy().sub(this.pos));
		float dist = this.spd.len();
		this.spd.nor().scl(dist*acc);
		this.pos.add(this.spd);
	}
}
