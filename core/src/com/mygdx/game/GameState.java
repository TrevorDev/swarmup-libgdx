package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;


public class GameState {
	static Stage stage;
	static SpriteBatch batch;
	static Input input = new Input();
	static ArrayList<Character> characters = new ArrayList<Character>();
	static FPSLogger fpsLogger = new FPSLogger();
	public static void init(){
		batch = new SpriteBatch();
		stage = new Stage(new StretchViewport(960, 540));
		stage.getCamera().position.x=0;
		stage.getCamera().position.y=0;
		stage.getCamera().update();
		for(int i=0;i<100;i++){
			Character c = new Character();
			c.pos.x = i*50;
			c.pos.y = 0;
			characters.add(c);
		}
	}
	
	public static void render(){
		//stage.getCamera().position.x++;
		//stage.getCamera().update();
		batch.setProjectionMatrix(stage.getCamera().combined);
		//Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//s.draw(batch);
		batch.begin();
		for(int i = 0;i<characters.size();i++){
			Character c = characters.get(i);
			Vector2 lt = getLastTouch();
			float dist = c.pos.dst(lt);
			if(dist<50){
				c.spd.scl(0.9f);
			}
			c.spd.x-=dist*(c.pos.x - lt.x)*0.00001f;
			c.spd.y-=dist*(c.pos.y - lt.y)*0.00001f;
			
			for(int j = 0;j<characters.size();j++){
				if(i!=j){
					Character c2 = characters.get(j);
					float collideDist = c.pos.dst(c2.pos);
					if(collideDist < (c.size/2) + (c2.size/2)){
						c.spd.x -= (c2.pos.x - c.pos.x)/collideDist;
						c.spd.y -= (c2.pos.y - c.pos.y)/collideDist;
					}
				}
			}
			
			c.move();
			//c.pos.x=lt.x;
			//c.pos.y=lt.y;
			//System.out.println(c.pos.x+"   "+i);
			c.draw(batch);
			//batch.draw(c.sprite, c.pos.x, c.pos.y);
			//Character x = (new Character());
			//batch.draw(x.sprite,0,0);
		}
		batch.end();
		fpsLogger.log();
	}
	
	public static Vector2 getLastTouch(){
		float x,y;
		//map touch to screen
		x=input.x*(stage.getViewport().getWorldWidth()/Gdx.graphics.getWidth())-(stage.getViewport().getWorldWidth()/2);
		y=(-input.y)*(stage.getViewport().getWorldHeight()/Gdx.graphics.getHeight())+(stage.getViewport().getWorldHeight()/2);
		
		//map touch to camera coord
		x+=stage.getCamera().position.x;
		y+=stage.getCamera().position.y;
		//System.out.println(x+"  "+ y);
		return new Vector2(x, y);	
	}
}
