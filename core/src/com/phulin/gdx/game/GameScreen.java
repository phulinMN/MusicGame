package com.phulin.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private MusicGame musicGame;
	private Texture tapImg;
	private WorldRenderer worldRenderer;
	private Tabplay tabplay;
	private int x;
	private int y;
	private boolean isClick = true;
	
	public GameScreen(MusicGame musicGame){
		this.musicGame = musicGame;
		tapImg = new Texture("tapb.png");
		worldRenderer = new WorldRenderer(musicGame);
		tabplay = new Tabplay(musicGame);
	}
	
	public void ControlKey(float delta){
		if(Gdx.input.isKeyPressed(Keys.D) && !isClick){
			isClick = true;
			System.out.println("D");
		}
		if(Gdx.input.isKeyPressed(Keys.D) && isClick){
			isClick = false;
		}
		if(Gdx.input.isKeyPressed(Keys.F) && !isClick){
			System.out.println("F");
		}
		if(Gdx.input.isKeyPressed(Keys.F) && isClick){
			isClick = false;
		}
		if(Gdx.input.isKeyPressed(Keys.SPACE) && !isClick){
			System.out.println("SPACE");
		}
		if(Gdx.input.isKeyPressed(Keys.SPACE) && isClick){
			isClick = false;
		}
		if(Gdx.input.isKeyPressed(Keys.J) && !isClick){
			System.out.println("J");
		}
		if(Gdx.input.isKeyPressed(Keys.J) && isClick){
			isClick = false;
		}
		if(Gdx.input.isKeyPressed(Keys.K) && !isClick){
			System.out.println("K");
		}
		if(Gdx.input.isKeyPressed(Keys.K) && isClick){
			isClick = false;
		}
	}
		
	@Override
    public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		SpriteBatch batch = musicGame.batch;
		worldRenderer.render(delta);
		x = 0;
        y = 50;
        batch.begin();
        for(int i = 0; i < 5; i++){
        	x = (i*120);
        	batch.draw(tapImg,x,y);
        }
        batch.end();
        tabplay.render(delta);
        ControlKey(delta);
    }

}
