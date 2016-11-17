package com.phulin.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tabplay {
	private MusicGame musicGame;
	private Texture tabplayImg;
	private NoteNSong noteNSong;
	public int x = 0;
	public int y;
	private int k = 0;
	static int SPEED = 2;
	int D = 0;
	int F = 1;
	int S = 2;
	int J = 3;
	int K = 4;
	boolean [] Key = new boolean [5];
	boolean [] check = new boolean[5];
	public Score score;
	int [] point = new int [5];
	int [] miss = new int [5];
	
	public Tabplay (MusicGame musicGame) {
		this.musicGame = musicGame;
		tabplayImg = new Texture("tapb.png");
		noteNSong = new NoteNSong(musicGame);
		score = new Score(musicGame);
	}
	
	Score getScore() {
		return score;
	}
	
	NoteNSong getNote(){
		return noteNSong;
	}
	
	public boolean hasBarAt(int r, int c) {
        return noteNSong.NOTE[r].charAt(c) == '-';
    }
 
    public boolean hasDotAt(int r, int c) {
        return noteNSong.NOTE[r].charAt(c) == '*';
    }
    
    public void update(float delta){
    	k++;
    	score.isMiss();
    	score.isPerfect();
    }
    
    public void isCheck(int botton,int r, int c){
 		if(hasBarAt(r,c)){
 			point[botton]++;
   			System.out.println("OK");
   		}
   		else{
   			miss[botton]++;
   			System.out.println("Miss");
   		}
  	}
    
    public void checkTap(int r, int c){
    	for(int i = 0; i < Key.length; i++){
    		if(Key[i] && x == i*120 && y >= 40 && y <= 80){
    			check[i] = true;
    			isCheck(i,r,c);
    		}
    		else if (!Key[i]){
    			check[i] = false;
    			if(point[i] > 0){
    				score.p++;
    				point[i] = 0;
    			}
    			if(miss[i] > 0){
    				score.m++;
    				miss[i] = 0;
    			}
    		}
      	}
    }
	
	public void render(float delta){
		SpriteBatch batch = musicGame.batch;
        batch.begin();
    	for(int r = 0; r < noteNSong.NOTE.length ; r++){
    		for(int c = 0; c < 5; c++){
    			x = (c*120);
    			y = 760 + r*40 - k*SPEED;
    			if(hasBarAt(r,c)){
    				batch.draw(tabplayImg, x, y);
    			}
    			checkTap(r,c);
    		}
    	}
    	update(delta);
        batch.end();
    }	
}
