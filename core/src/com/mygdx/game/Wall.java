package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Wall extends DisplayObject {
	public Wall(float x, float y, float dimX, float dimY){
		super(new Vector2(dimX, dimY), new Texture("alt/wall.png"));
		this.pos.set(x, y);
	}
	
	public void draw(Batch b){
    	this.sprite.setPosition(pos.x, pos.y);
    	this.sprite.setSize(dim.x, dim.y);
    	this.sprite.draw(b);
    	//b.draw(sprite, pos.x, pos.y, 0, 0, dim.x, dim.y, 1, 1, 0);
    }
}
