package com.phulin.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Score {
	public int p = 0;
	public int m = 0;
	private MusicGame musicGame;
	
	public void isPerfect(){
		System.out.println("Perfect " + p);
	}
	
	public void isMiss(){
		System.out.println("Miss " + m);
	}
	
	public Score(MusicGame musicGame){
		this.musicGame = musicGame;
	}
	
	public void render(float delta){
		SpriteBatch batch = musicGame.batch;
        batch.begin();
        
        batch.end();
	}
}
