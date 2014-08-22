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
    	Texture t = new Texture("char1.png");
        sprite = new Sprite(t);
        sprite.setSize(size, size);
    }
    
    public void move(){
    	if(spd.len()>maxSpd){
    		spd.limit(maxSpd);
    	}
    	pos.add(spd);
    }
    
    public void draw(Batch b){
    	this.sprite.setPosition(pos.x, pos.y);
    	this.sprite.draw(b);
    }
}
