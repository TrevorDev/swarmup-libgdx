package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;


public class GameState {
	static Preferences state = Gdx.app.getPreferences("game");
	static GameState current;
	static Background menu;
	static boolean started = false;
	int highScore = 0;
	int score = 0;
	Stage stage;
	SpriteBatch batch;
	Input input = new Input();
	Player player = new Player();
	Background bg;
	ArrayList<Character> characters = new ArrayList<Character>();
	ArrayList<Wall> walls = new ArrayList<Wall>();
	ArrayList<DisplayObject> badGuys = new ArrayList<DisplayObject>();
	ArrayList<DisplayObject> coins = new ArrayList<DisplayObject>();
	Text scoreDisp = new Text("Score: ", "0");
	Text highScoreDisp = new Text("Record: ", "0");
	FPSLogger fpsLogger = new FPSLogger();
	public void init(){
		batch = new SpriteBatch();
		stage = new Stage(new StretchViewport(960, 540));
		stage.getCamera().position.x=0;
		stage.getCamera().position.y=0;
		stage.getCamera().update();
		float wallWid = 30;
		walls.add(new Wall(-stage.getViewport().getWorldWidth()/2,-stage.getViewport().getWorldHeight()/2,stage.getViewport().getWorldWidth(),wallWid));
		walls.add(new Wall(-stage.getViewport().getWorldWidth()/2,stage.getViewport().getWorldHeight()/2,stage.getViewport().getWorldWidth(),wallWid));
		
		walls.add(new Wall(-stage.getViewport().getWorldWidth()/2-wallWid,-stage.getViewport().getWorldHeight()/2,wallWid,stage.getViewport().getWorldHeight()));
		walls.add(new Wall(stage.getViewport().getWorldWidth()/2,-stage.getViewport().getWorldHeight()/2,wallWid,stage.getViewport().getWorldHeight()));
		
		walls.add(new Wall(-stage.getViewport().getWorldWidth()/4,-150,stage.getViewport().getWorldWidth()/2,wallWid));
		walls.add(new Wall(-stage.getViewport().getWorldWidth()/4+400,0,stage.getViewport().getWorldWidth()/2,wallWid));
		walls.add(new Wall(-stage.getViewport().getWorldWidth()/4-400,0,stage.getViewport().getWorldWidth()/2,wallWid));
		walls.add(new Wall(-stage.getViewport().getWorldWidth()/4,150,stage.getViewport().getWorldWidth()/2,wallWid));
		
		bg = new Background();
		if(!GameState.started){
			GameState.started = true;
			menu = new Background("main2.png");
		}
		//coins.add(new Coin());
		badGuys.add(new FlyFace());
		badGuys.add(new WalkFace());
		
		
		scoreDisp.pos.set(-stage.getViewport().getWorldWidth()/2+3, -stage.getViewport().getWorldHeight()/2+20);
		highScore = GameState.state.getInteger("highScore", 0);
		highScoreDisp.pos.set(-stage.getViewport().getWorldWidth()/2+400, -stage.getViewport().getWorldHeight()/2+20);
		highScoreDisp.update(highScore+"");
		
		for(int i=0;i<20;i++){
			Character c = new Character();
			c.pos.x = i*50;
			c.pos.y = 0;
			characters.add(c);
		}
	}
	
	public void render(){
		//stage.getCamera().position.x++;
		//stage.getCamera().update();
		batch.setProjectionMatrix(stage.getCamera().combined);
		//Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//s.draw(batch);
		
		if(menu != null){
			batch.begin();
			menu.draw(batch);
			batch.end();
			return;
		}
		
		batch.begin();
		bg.draw(batch);
		for(Character c : characters){
			c.move();
			c.draw(batch);
		}
		
		player.move();
		player.draw(batch);
		
		for(Wall w:walls){
			w.draw(batch);
		}
		
		for(DisplayObject w:coins){
			w.move();
			w.draw(batch);
		}
		
		for(DisplayObject w:badGuys){
			w.move();
			w.draw(batch);
		}
		scoreDisp.draw(batch);
		highScoreDisp.draw(batch);
		batch.end();
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		fpsLogger.log();
	}
	
	public static Vector2 getLastTouch(){
		float x,y;
		//map touch to screen
		x=current.input.x*(current.stage.getViewport().getWorldWidth()/Gdx.graphics.getWidth())-(current.stage.getViewport().getWorldWidth()/2);
		y=(-current.input.y)*(current.stage.getViewport().getWorldHeight()/Gdx.graphics.getHeight())+(current.stage.getViewport().getWorldHeight()/2);
		
		//map touch to camera coord
		x+=current.stage.getCamera().position.x;
		y+=current.stage.getCamera().position.y;
		//System.out.println(x+"  "+ y);
		return new Vector2(x, y);	
	}
	
	public static void newGameState(){
		current = new GameState();
		current.init();
	}
}
