package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Wall extends DisplayObject {
	public Sprite side;
	public Wall(float x, float y, float dimX, float dimY){
		super(new Vector2(dimX, dimY), new Texture("alt/grass.png"));
		side = new Sprite(new Texture("alt/side.png"));
		this.side.flip(true, false);
		this.pos.set(x, y);
	}
	
	public void draw(Batch b){
    	float wid = dim.x / 10;
    	for(int i = 0;i<10;i++){
    		if(i==0 || i==9){
    			this.side.setPosition(pos.x+(i*wid), pos.y);
        		this.side.setSize(wid, dim.y);
        		this.side.flip(true, false);
            	this.side.draw(b);
    		}else{
    			this.sprite.setPosition(pos.x+(i*wid), pos.y);
        		this.sprite.setSize(wid, dim.y);
            	this.sprite.draw(b);
    		}
    	}
    	
    	//b.draw(sprite, pos.x, pos.y, 0, 0, dim.x, dim.y, 1, 1, 0);
    }
}
