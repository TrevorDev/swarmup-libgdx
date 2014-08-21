package com.mygdx.game;

import java.util.ArrayList;


public class GameState {
	static Input input = new Input();
	static ArrayList<Character> characters = new ArrayList<Character>();
	public static void init(){
		characters.add(new Character());
	}
}
