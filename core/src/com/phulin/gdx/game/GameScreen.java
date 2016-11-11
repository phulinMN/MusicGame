package com.phulin.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private MusicGame musicGame;
	private Texture tapImg;
	private WorldRenderer worldRenderer;
	private Tabplay tabplay;
	private int x;
	private Score score;
	private BitmapFont font;
	private boolean [] press = new boolean[5];
	
	public GameScreen(MusicGame musicGame){
		this.musicGame = musicGame;
		tapImg = new Texture("tapb.png");
		worldRenderer = new WorldRenderer(musicGame);
		tabplay = new Tabplay(musicGame);
		score = tabplay.getScore();
		font = new BitmapFont();
	}

	public void ControlKey(float delta){
    		if(Gdx.input.isKeyJustPressed(Keys.D)){
    			tabplay.D_ISPRESS = true;			
    		}
    		if(!Gdx.input.isKeyJustPressed(Keys.D)){
    			tabplay.D_ISPRESS = false;
    		}
    		if(Gdx.input.isKeyJustPressed(Keys.F)){
    			tabplay.F_ISPRESS = true;
    		}
    		if(!Gdx.input.isKeyJustPressed(Keys.F)){
    			tabplay.F_ISPRESS = false;
    		}
    		if(Gdx.input.isKeyJustPressed(Keys.SPACE)){
    			tabplay.SPACE_ISPRESS = true;
    		}
    		if(!Gdx.input.isKeyJustPressed(Keys.SPACE)){
    			tabplay.SPACE_ISPRESS = false;
    		}
    		if(Gdx.input.isKeyJustPressed(Keys.J)){
    			tabplay.J_ISPRESS = true;
    		}
    		if(!Gdx.input.isKeyJustPressed(Keys.J)){
    			tabplay.J_ISPRESS = false;
    		}
    		if(Gdx.input.isKeyJustPressed(Keys.K)){
    			tabplay.K_ISPRESS = true;
    		}
    		if(!Gdx.input.isKeyJustPressed(Keys.K)){
    			tabplay.K_ISPRESS = false;
    		}
	}
		
	@Override
    public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		SpriteBatch batch = musicGame.batch;
		worldRenderer.render(delta);
        batch.begin();
        for(int i = 0; i < 5; i++){
        	x = (i*120);
        	batch.draw(tapImg,x,40);
        }
        font.draw(batch, "Perfect  " + score.p, 700, 500);
        font.draw(batch, "Miss " + score.m, 700, 600);
        batch.end();
        tabplay.render(delta);
        ControlKey(delta);
    }

}
