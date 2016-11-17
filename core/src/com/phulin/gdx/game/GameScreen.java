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
	private WorldRenderer worldRenderer;
	private Tabplay tabplay;
	private int x;
	private boolean [] press = new boolean[5];
	
	public GameScreen(MusicGame musicGame){
		this.musicGame = musicGame;
		tabplay = new Tabplay(musicGame);
		worldRenderer = new WorldRenderer(musicGame,tabplay);
	}

	public void ControlKey(float delta){
    		if(Gdx.input.isKeyPressed(Keys.D)){
    			tabplay.Key[0] = true;			
    		}
    		if(!Gdx.input.isKeyPressed(Keys.D)){
    			tabplay.Key[0] = false;
    		}
    		if(Gdx.input.isKeyPressed(Keys.F)){
    			tabplay.Key[1] = true;
    		}
    		if(!Gdx.input.isKeyPressed(Keys.F)){
    			tabplay.Key[1] = false;
    		}
    		if(Gdx.input.isKeyPressed(Keys.SPACE)){
    			tabplay.Key[2] = true;
    		}
    		if(!Gdx.input.isKeyPressed(Keys.SPACE)){
    			tabplay.Key[2] = false;
    		}
    		if(Gdx.input.isKeyPressed(Keys.J)){
    			tabplay.Key[3] = true;
    		}
    		if(!Gdx.input.isKeyPressed(Keys.J)){
    			tabplay.Key[3] = false;
    		}
    		if(Gdx.input.isKeyPressed(Keys.K)){
    			tabplay.Key[4] = true;
    		}
    		if(!Gdx.input.isKeyPressed(Keys.K)){
    			tabplay.Key[4] = false;
    		}
	}
		
	@Override
    public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		SpriteBatch batch = musicGame.batch;
		worldRenderer.render(delta);
        tabplay.render(delta);
        ControlKey(delta);
    }

}
