package com.phulin.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tabplay {
	private MusicGame musicGame;
	private Texture tabplayImg;
	private Texture touchImg;
	private NoteNSong noteNSong;
	public int x = 0;
	public int y;
	private int k = 0;
	static int SPEED = 2;
	boolean D_ISPRESS = false;
	boolean F_ISPRESS = false;
	boolean SPACE_ISPRESS = false;
	boolean J_ISPRESS = false;
	boolean K_ISPRESS = false;
	private boolean [] check = new boolean[5];
	private boolean press = false;
	public Score score;
	int D_point;
	
	
	public Tabplay(MusicGame musicGame){
		this.musicGame = musicGame;
		tabplayImg = new Texture("tapb.png");
		touchImg = new Texture("tapspace.png");
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
    
    public void isCheck(int r, int c){
   		if(hasBarAt(r,c)){
   			D_point++;
   			System.out.println("OK");
   		}
   		else{
   			score.m++;
   			System.out.println("Miss");
   		}
  	}
    
    public void checkTap(int r, int c){
    	if(D_ISPRESS && x == 0 && y<=80 && y>=40){
    		check[0] = true;
    		press = false;
    		isCheck(r,c);
    	}
    	else if(D_ISPRESS){
    		check[0] = false;
    		press = true;
    		if ( D_point > 0) {
    			score.p++;
    			D_point = 0;
    		}
    	}
    	if(F_ISPRESS && x == 120 && y<=80 && y>=40){
    		check[1] = true;
    		press = false;
    		isCheck(r,c);
    	}
    	else if(F_ISPRESS){
    		check[1] = false;
    		press = true;
    	}
    	if(SPACE_ISPRESS && x == 240 && y<=80 && y>=40){
    		check[2] = true;
    		press = false;
    		isCheck(r,c);
    	}
    	else if(SPACE_ISPRESS){
    		check[2] = false;
    		press = true;
    	}
    	if(J_ISPRESS && x == 360 && y<=80 && y>=40){
    		check[3] = true;
    		press = false;
    		isCheck(r,c);
    	}
    	else if(J_ISPRESS){
    		check[3] = false;
    		press = true;
    	}
    	if(K_ISPRESS && x == 480 && y<=80 && y>=40){
    		check[4] = true;
    		press = false;
    		isCheck(r,c);
    	}
    	else if(K_ISPRESS){
    		check[4] = false;
    		press = true;
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
    			if(check[c]){
    				batch.draw(touchImg, x, 40);
    			}
    		}
    	}
    	update(delta);
        batch.end();
    }	
}
