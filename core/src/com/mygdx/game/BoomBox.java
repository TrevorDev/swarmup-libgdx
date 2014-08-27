package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class BoomBox {
	static Sound jump;
	static Sound hit;
	static Sound explode;
	static Sound stomp;
	static void init(){
		jump =  Gdx.audio.newSound(Gdx.files.internal("sound/jump2.wav"));
		jump.play();
		hit =  Gdx.audio.newSound(Gdx.files.internal("sound/hit.wav"));
		hit.play();
		explode =  Gdx.audio.newSound(Gdx.files.internal("sound/explode.wav"));
		explode.play();
		stomp =  Gdx.audio.newSound(Gdx.files.internal("sound/stomp.wav"));
		stomp.play();
	}
}
