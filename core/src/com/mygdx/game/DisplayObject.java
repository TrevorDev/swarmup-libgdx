package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import physics.Rectangle;

public class DisplayObject extends Rectangle {
	public Vector2 spd = new Vector2(0,0);
	public Sprite sprite;
	
	public DisplayObject(Vector2 dim, Texture t){
		sprite = new Sprite(t);
		this.dim.set(dim);
	}
	
	
	public void move(){
    	this.pos.add(spd);
    }
    
    public void draw(Batch b){
    	this.sprite.setPosition(pos.x, pos.y);
    	this.sprite.setSize(dim.x, dim.y);
    	this.sprite.draw(b);
    	//b.draw(sprite, pos.x, pos.y, 0, 0, dim.x, dim.y, 1, 1, 0);
    }
}
