package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Background {
	public Sprite sprite;
	public Background(){
		sprite = new Sprite(new Texture("alt/bg1.png"));
		sprite.setPosition(-GameState.current.stage.getViewport().getWorldWidth()/2, -GameState.current.stage.getViewport().getWorldHeight()/2);
		sprite.setSize(GameState.current.stage.getViewport().getWorldWidth(), GameState.current.stage.getViewport().getWorldHeight());
	}
	
	public void draw(Batch b){
		try{
    	this.sprite.draw(b);
		}catch(Exception e){
			
		}
    }
}
