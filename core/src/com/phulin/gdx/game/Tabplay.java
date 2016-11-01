package com.phulin.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tabplay {
	private MusicGame musicGame;
	private Texture tabplayImg;
	private String [] Bar = new String[] {
			"-----", "-***-", "*-*-*", "****-", "***-*"};
	private int x = 0;
	private int y;
	private int k = 0;
	
	public Tabplay(MusicGame musicGame){
		this.musicGame = musicGame;
		tabplayImg = new Texture("tapb.png");
	}
	
	public boolean hasBarAt(int r, int c) {
        return Bar[r].charAt(c) == '-';
    }
 
    public boolean hasDotAt(int r, int c) {
        return Bar[r].charAt(c) == '*';
    }
    public void update(float delta){
    	k++;
    }
	
	public void render(float delta) {
		SpriteBatch batch = musicGame.batch;
        batch.begin();
    	for(int r = 0; r < 5; r++){
    		for(int c = 4; c >= 0; c--){
    			x = (c*120);
    			y = 760 - (r*40)-(k*5);
    			if(hasBarAt(r,c)){
    				batch.draw(tabplayImg, x, y);
    			}
    		}
    	}
    	update(delta);
        batch.end();
    }	
	

}
