package com.mygdx.game;

import javafx.util.Pair;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

	public class Input implements GestureListener, InputProcessor {
	    
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
	        GestureDetector gd = new GestureDetector(this);
	        im.addProcessor(gd);
	        im.addProcessor(this);
	        Gdx.input.setInputProcessor(im);
	    }
	    
	    /*public Vector2 getLastTouch(){
	    	return new Vector2(x*(960.0f/Gdx.graphics.getWidth()))
	    }*/
	    
	    @Override
	    public boolean touchDown(float x, float y, int pointer, int button) {
	    	this.x = x;
	    	this.y = y;
	        message = "Touch down!";
	        
	        
	        if(rightP == pointer && x > Gdx.graphics.getWidth()/2){
	        	right = true;
	        	rightP = pointer;
	        }
	        if(leftP == pointer && x < Gdx.graphics.getWidth()/2){
	        	left = true;
	        	leftP = pointer;
	        }
	        
	        Gdx.app.log("INFO", message);
	        return true;
	    }

	    @Override
	    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	        message = "TOUCH ENDED"+screenX+" "+screenY+" "+Gdx.graphics.getWidth();
	        if(rightP == pointer && screenX > Gdx.graphics.getWidth()/2){
	        	right = false;
	        }
	        if(leftP == pointer && screenX < Gdx.graphics.getWidth()/2){
	        	left = false;
	        }
	        Gdx.app.log("INFO", message);
	        return false;
	    }
	    
	    @Override
	    public boolean tap(float x, float y, int count, int button) {
	        message = "Tap performed, finger" + Integer.toString(button);
	        Gdx.app.log("INFO", message);
	        return false;
	    }

	    @Override
	    public boolean longPress(float x, float y) {
	        message = "Long press performed";
	        Gdx.app.log("INFO", message);
	        return true;
	    }

	    @Override
	    public boolean fling(float velocityX, float velocityY, int button) {
	        message = "Fling performed, velocity:" + Float.toString(velocityX) +
	                "," + Float.toString(velocityY);
	        Gdx.app.log("INFO", message);
	        return true;
	    }

	    @Override
	    public boolean pan(float x, float y, float deltaX, float deltaY) {
	        message = "Pan performed, delta:" + Float.toString(deltaX) +
	                "," + Float.toString(deltaY);
	        Gdx.app.log("INFO", message);
	        return true;
	    }

	    @Override
	    public boolean zoom(float initialDistance, float distance) {
	        message = "Zoom performed, initial Distance:" + Float.toString(initialDistance) +
	                " Distance: " + Float.toString(distance);
	        Gdx.app.log("INFO", message);
	        return true;
	    }

	    @Override
	    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
	            Vector2 pointer1, Vector2 pointer2) {
	        message = "Pinch performed";
	        Gdx.app.log("INFO", message);

	        return true;
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
	    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	    	
	        message = "TOUCH STARTED "+screenX+" "+screenY;
	        Gdx.app.log("INFO", message);

	        return false;
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

		@Override
		public boolean panStop(float x, float y, int pointer, int button) {
			// TODO Auto-generated method stub
			return false;
		}

	}

