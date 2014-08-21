package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Character{
	Sprite sprite;
	public int x,y;
    public Character() {
    	x = 0;
    	y = 0;
        sprite = new Sprite(new Texture("badlogic.jpg"));
    }
    
    public void draw(Batch b){
    	b.draw(this.sprite ,GameState.input.x*(960.0f/Gdx.graphics.getWidth()), (-GameState.input.y)*(540.0f/Gdx.graphics.getHeight())+(540/2));
    }
}
