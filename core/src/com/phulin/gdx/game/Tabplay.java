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
	private boolean isClick = true;
	private boolean [] check = new boolean[5];
	
	
	public Tabplay(MusicGame musicGame){
		this.musicGame = musicGame;
		tabplayImg = new Texture("tapb.png");
		touchImg = new Texture("tapspace.png");
		noteNSong = new NoteNSong(musicGame);
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
    }
    
    public void checkTap(int r, int c){
    	if(D_ISPRESS && x == 0 && y<=80 && y>=40){
    		System.out.println("OK D");
    		check[0] = true;
    	}
    	else if(D_ISPRESS){
    		check[0] = false;
    		//System.out.println("MISS D");
    	}
    	if(F_ISPRESS && x == 120 && y<=80 && y>=40){
    		System.out.println("OK F");
    		check[1] = true;
    	}
    	else if(F_ISPRESS){
    		//System.out.println("MISS F");
    		check[1] = false;
    	}
    	if(SPACE_ISPRESS && x == 240 && y<=80 && y>=40){
    		System.out.println("OK SPACE");
    		check[2] = true;
    	}
    	else if(SPACE_ISPRESS){
    		//System.out.println("MISS SPACE");
    		check[2] = false;
    	}
    	if(J_ISPRESS && x == 360 && y<=80 && y>=40){
    		System.out.println("OK J");
    		check[3] = true;
    	}
    	else if(J_ISPRESS){
    		//System.out.println("MISS J");
    		check[3] = false;
    	}
    	if(K_ISPRESS && x == 480 && y<=80 && y>=40){
    		System.out.println("OK K");
    		check[4] = true;
    	}
    	else if(K_ISPRESS){
    		//System.out.println("MISS K");
    		check[4] = false;
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
//    			if(D_ISPRESS){
//    	    		batch.draw(touchImg, 0, 40);
//    	    	}
//    			else if(F_ISPRESS){
//    	    		batch.draw(touchImg, 120, 40);
//    	    	}
//    			else if(SPACE_ISPRESS){
//    	    		batch.draw(touchImg, 240, 40);
//    	    	}
//    			else if(J_ISPRESS){
//    	    		batch.draw(touchImg, 360, 40);
//    	    	}
//    			else if(K_ISPRESS){
//    	    		batch.draw(touchImg, 480, 40);
//    	    	}
    		}
    	}
    	update(delta);
        batch.end();
    }	
	

}
