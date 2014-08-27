package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class WalkFace extends DisplayObject {
	float maxSpd = 8;
	float runAcc = 1f;
	float gravity = 0.65f;
	public WalkFace(){
		this(1);
	}
	
	public WalkFace(int move){
		super(new Vector2(40,40), new Texture("alt/walkface.png"));
		this.pos = Spawner.getSpawnPos();
		this.spd.x = move;
	}
	
	public void respawn(){
		this.pos.set(Spawner.getSpawnPos());
		this.spd.x*=1.1;
	}
	
	@Override
	public void move(){
		this.spd.y -= gravity;

		//collision
		Vector2 origNextPos = this.pos.cpy().add(this.spd);
		Vector2 nextPlayerPos = origNextPos.cpy();
		for(Wall w:GameState.current.walls){
			nextPlayerPos = this.adjustMoveCollision(w, nextPlayerPos);
		}
		
		Vector2 adjustment = nextPlayerPos.cpy().sub(origNextPos);
		if((adjustment.y < 0 && this.spd.y > 0)||(adjustment.y > 0 && this.spd.y < 0)){
			this.spd.y=0;
		}
		if((adjustment.x < 0 && this.spd.x > 0)||(adjustment.x > 0 && this.spd.x < 0)){
			this.spd.x*=-1;
			if(this.pos.y < 0){
				this.respawn();
				return;
			}
		}
		
		this.pos.set(nextPlayerPos);
    }
}
