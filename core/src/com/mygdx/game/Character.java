package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Character{
	Sprite sprite;
	float maxSpd = 10;
	float size = 20;
	Vector2 spd = new Vector2(0,0);
	Vector2 pos = new Vector2(0,0);
	
    public Character() {
    	Texture t = new Texture("swarm.png");
        sprite = new Sprite(t);
        sprite.setSize(size, size);
    }
    
    public void move(){
    	Vector2 lt = GameState.getLastTouch();
		float dist = this.pos.dst(lt);
		if(dist<50){
			this.spd.scl(0.9f);
		}
		this.spd.x-=dist*(this.pos.x - lt.x)*0.00001f;
		this.spd.y-=dist*(this.pos.y - lt.y)*0.00001f;
		
		for(Character c2 : GameState.current.characters){
			if(!c2.equals(this)){
				float collideDist = this.pos.dst(c2.pos);
				if(collideDist < (this.size/2) + (c2.size/2)){
					this.spd.x -= (c2.pos.x - this.pos.x)/collideDist;
					this.spd.y -= (c2.pos.y - this.pos.y)/collideDist;
				}
			}
		}
    	
    	if(spd.len()>maxSpd){
    		spd.limit(maxSpd);
    	}
    	pos.add(spd);
    }
    
    public void draw(Batch b){
    	this.sprite.setPosition(pos.x, pos.y);
    	//this.sprite.draw(b);
    }
}
