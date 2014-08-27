package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Text {
	public BitmapFont font;
	String pre;
	String post;
	Vector2 pos = new Vector2();
	public Text(String pre, String post){
		this.pre = pre;
		this.post = post;
		Texture fontTexture = new Texture(Gdx.files.internal("font/federal_0.png"));
		font = new BitmapFont(Gdx.files.internal("font/federal.fnt"), new TextureRegion(fontTexture), false);
		font.setColor(0, 0, 0, 1);
	}
	
	public void update(String post){
		this.post = post;
	}
	
	public void draw(Batch batch){
		font.draw(batch, pre+post, pos.x, pos.y);
	}
}
