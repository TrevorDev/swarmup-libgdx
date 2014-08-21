package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Swarmup extends ApplicationAdapter {
	private Stage stage;
	
	SpriteBatch batch;
	Texture img;
	Sprite s;
	@Override
	public void create () {
		stage = new Stage(new StretchViewport(960, 540));
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		s= new Sprite(new Texture("badlogic.jpg"));
		GameState.init();
	}

	@Override
	public void render () {
		//stage.getCamera().position.x++;
		//stage.getCamera().update();
		batch.setProjectionMatrix(stage.getCamera().combined);
		//Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//s.draw(batch);
		batch.begin();
		for(Character c : GameState.characters){
			c.draw(batch);
			//batch.draw(c.sprite ,GameState.input.x*(960.0f/Gdx.graphics.getWidth()), (-GameState.input.y)*(540.0f/Gdx.graphics.getHeight())+(540/2));
		}
		
		batch.end();
	}
}
