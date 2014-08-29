package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player extends DisplayObject {
	float jumpHeight = 12;
	float maxSpd = 5;
	float runAcc = 1f;
	float gravity = 0.40f;
	int maxJumps = 1;
	int jumps = maxJumps;
	boolean grounded = false;
	public Player(){
		super(new Vector2(40,40), new Texture("alt/player.png"));
	}
	
	@Override
	public void move(){
		if(GameState.current.input.left){
			this.spd.x-=runAcc;
		}
		
		if(GameState.current.input.right){
			this.spd.x+=runAcc;
		}
		
		if(Math.abs(this.spd.x) > maxSpd){
			this.spd.x = (this.spd.x/Math.abs(this.spd.x))*maxSpd;
		}
		
		if(grounded && !GameState.current.input.right && !GameState.current.input.left){
			this.spd.x*=0.7;
			if(Math.abs(this.spd.x)<1){
				this.spd.x=0;
			}
		}
		
		if(GameState.current.input.right && GameState.current.input.left && jumps > 0){
			this.spd.y=jumpHeight;
			jumps--;
			BoomBox.jump.play();
			Gdx.app.log("JUMPED", "1");
		}
		this.spd.y -= gravity;

		//collision
		Vector2 origNextPos = this.pos.cpy().add(this.spd);
		Vector2 nextPlayerPos = origNextPos.cpy();
		ArrayList<DisplayObject> newGuys = new ArrayList<DisplayObject>();
		for(DisplayObject w:GameState.current.badGuys){
			if(w.getClass().equals(WalkFace.class))
			nextPlayerPos = this.adjustMoveCollision(w, nextPlayerPos);
			
			Vector2 adjustment = nextPlayerPos.cpy().sub(origNextPos);
			if((adjustment.y < 0 && this.spd.y > 0)||(adjustment.y > 0 && this.spd.y < 0)){
				if(adjustment.y > 0){
					BoomBox.stomp.play();
					this.spd.y=15;
					GameState.current.scoreDisp.update(++GameState.current.score + "");
					if(GameState.current.score > GameState.current.highScore){
						GameState.current.highScore = GameState.current.score;
						GameState.state.putInteger("highScore", GameState.current.highScore);
						GameState.state.flush();
						GameState.current.highScoreDisp.update(GameState.current.highScore+"");
					}
					WalkFace x = (WalkFace)w;
					x.respawn();
					if(w.spd.x>0){
						newGuys.add(new WalkFace(-1));
					}else{
						newGuys.add(new WalkFace(1));
					}
					
					break;
				}
			}
		}
		for(DisplayObject w:newGuys){
			GameState.current.badGuys.add(w);
		}
		
		
		
		
		//WALL COLLISION
		origNextPos = this.pos.cpy().add(this.spd);
		nextPlayerPos = origNextPos.cpy();
		for(Wall w:GameState.current.walls){
			nextPlayerPos = this.adjustMoveCollision(w, nextPlayerPos);
		}
		
		Vector2 adjustment = nextPlayerPos.cpy().sub(origNextPos);
		grounded=false;
		if((adjustment.y < 0 && this.spd.y > 0)||(adjustment.y > 0 && this.spd.y < 0)){
			if(adjustment.y > 0){
				grounded = true;
				jumps = maxJumps;
			}
			
			this.spd.y=0;
		}
		if((adjustment.x < 0 && this.spd.x > 0)||(adjustment.x > 0 && this.spd.x < 0)){
			this.spd.x=0;
		}
		
		this.pos.set(nextPlayerPos);
		
		
		for(DisplayObject w:GameState.current.coins){
			if(this.collidesWith(w)){
				GameState.current.scoreDisp.update((Integer.parseInt(GameState.current.scoreDisp.post)+1)+"");
			}
		}
		boolean dead = false;
		for(DisplayObject w:GameState.current.badGuys){
			if(this.collidesWith(w)){
				BoomBox.hit.play();
				dead = true;
			}
		}
		if(dead){
			GameState.current.restart();
			//GameState.newGameState();
		}
    }
}
