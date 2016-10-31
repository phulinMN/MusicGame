package com.phulin.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tabplay {
	private MusicGame musicGame;
	private Texture tabplayImg;
	private String [] Bar = new String[] {
			"-----", "-***-", "*-*-*", "****-", "***-*"};
	private int x = 0;
	private int y;
	
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
	
	public void render(float delta) {
		SpriteBatch batch = musicGame.batch;
        batch.begin();
//        for(int k=0; k<8;k++){
    		for(int r = 0; r < 5; r++){
    			for(int c = 0; c < 5; c++){
    				x = (c*120);
    				y = 880 - (r*40);
    				if(hasBarAt(r,c)){
    					batch.draw(tabplayImg, x, y);
    				}
    			}		
    		}
//    	}
        batch.end();
    }	

}
