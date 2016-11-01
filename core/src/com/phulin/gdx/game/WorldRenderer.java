package com.phulin.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	private MusicGame musicGame;
	private Texture bgImg;
	private Texture bgScoreImg;
	private int x;
	
	public WorldRenderer(MusicGame musicGame){
		this.musicGame = musicGame;
		bgImg = new Texture("bgblack.png");
		bgScoreImg = new Texture("bgRH.png");
	}
	
	public void render(float delta) {
		SpriteBatch batch = musicGame.batch;
		x = 0;
        batch.begin();
        for(int i = 0; i < 5; i++){
        	x = (i*120);
        	batch.draw(bgImg,x,0);
        }
        batch.draw(bgScoreImg,600,0);
        batch.end();
    }
}
