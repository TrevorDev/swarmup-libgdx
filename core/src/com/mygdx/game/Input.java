package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;

	public class Input implements InputProcessor {
	    
	    private String message = "No gesture performed yet";
	    public float x, y;
	    public boolean left = false;
	    public boolean right = false;
	    public int leftP = 0;
	    public int rightP = 0;
	    public Input(){
	    	x=0;
	    	y=0;
	    	InputMultiplexer im = new InputMultiplexer();
	        im.addProcessor(this);
	        Gdx.input.setInputProcessor(im);
	    }
	    
	    @Override
	    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	    	GameState.menu = null;
	    	this.x = screenX;
	    	this.y = screenY;
	        message = "TOUCH STARTED    " + pointer+"  "+x+"  "+Gdx.graphics.getWidth()/2;
	        
	        if(x > Gdx.graphics.getWidth()/2){
	        	right = true;
	        	rightP = pointer;
	        }
	        if(x < Gdx.graphics.getWidth()/2){
	        	left = true;
	        	leftP = pointer;
	        }
	        
	        Gdx.app.log("INFO", message);
	        return true;
	    }

	    @Override
	    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	        message = "TOUCH ENDED  "+pointer;
	        if(rightP == pointer){
	        	right = false;
	        }
	        if(leftP == pointer){
	        	left = false;
	        }
	        Gdx.app.log("INFO", message);
	        return false;
	    }
	    
	    

	    @Override
	    public boolean keyDown(int keycode) {
	        message = "Key Down";
	        Gdx.app.log("INFO", message);
	        return true;
	    }

	    @Override
	    public boolean keyUp(int keycode) {
	        message = "Key up";
	        Gdx.app.log("INFO", message);
	        return true;
	    }

	    @Override
	    public boolean keyTyped(char character) {
	        message = "Key typed";
	        Gdx.app.log("INFO", message);
	        return true;
	    }

	    

	    @Override
	    public boolean touchDragged(int screenX, int screenY, int pointer) {
	        message = "Touch Dragged";
	        Gdx.app.log("INFO", message);
	        return false;
	    }

	    @Override
	    public boolean mouseMoved(int screenX, int screenY) {
	        message = "Mouse moved";
	        Gdx.app.log("INFO", message);
	        return false;
	    }

	    @Override
	    public boolean scrolled(int amount) {
	        message = "Scrolled";
	        Gdx.app.log("INFO", message);
	        return false;
	    }

	}

