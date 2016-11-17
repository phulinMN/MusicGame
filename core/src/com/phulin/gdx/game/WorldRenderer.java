package com.phulin.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	private MusicGame musicGame;
	private Texture bgImg;
	private Texture bgScoreImg;
	private Texture tapImg;
	private Tabplay tabplay;
	private Texture touchImg;
	private BitmapFont font;
	private int x;
	private Score score;
	
	public WorldRenderer(MusicGame musicGame, Tabplay tabplay){
		this.musicGame = musicGame;
		bgImg = new Texture("bgblack.png");
		bgScoreImg = new Texture("bgRH.png");
		tapImg = new Texture("tapb.png");
		touchImg = new Texture("tapspace.png");
		font = new BitmapFont();
		this.tabplay = tabplay;
		score = tabplay.getScore();
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
        
        for(int i = 0; i < 5; i++){
        	x = (i*120);
        	if(tabplay.check[i]){
				batch.draw(touchImg, x, 40);
			}
        	else {
        		batch.draw(tapImg,x,40);
        	}
        }
        font.draw(batch, "Perfect  " + score.p, 700, 500);
        font.draw(batch, "Miss " + score.m, 700, 600);
        
        batch.end();
    }
}
