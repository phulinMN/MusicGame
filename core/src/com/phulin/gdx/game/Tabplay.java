package com.phulin.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tabplay {
	private MusicGame musicGame;
	private Texture tabplayImg;
	private String [] Bar = new String[] {
			"*-***",
			"-****",
			"**-**",
			"***-*",
			"****-",
			"*-***",
			"*****",
			"*****",
			"-***-",
			"*-***",
			"-****",
			"**-**",
			"***-*",
			"****-",
			"*-***",
			"*****",
			"*****",
			"-***-",
			"*-***",
			"-****",
			"**-**",
			"***-*",
			"****-",
			"*-***",
			"*****",
			"*****",
			"-***-",
			"*-***",
			"-****",
			"**-**",
			"***-*",
			"****-",
			"*-***",
			"*****",
			"*****",
			"-***-",
			"-**-*"};
	//private String [] Bar = new String[] { "-****" };
	public int x = 0;
	public int y;
	private int k = 0;
	static int SPEED = 2;
	boolean D_ISPRESS = false;
	boolean F_ISPRESS = false;
	boolean SPACE_ISPRESS = false;
	boolean J_ISPRESS = false;
	boolean K_ISPRESS = false;
	private boolean isClick = true;;
	
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
    
    //public boolean checkKey = false;
    
    
    public void checkTap(int r, int c){
    		if(D_ISPRESS && x == 0 && y<=80 && y>=40){
    			System.out.println("OK D");
    		}
    		else if(D_ISPRESS){
    			//System.out.println("MISS D");
    		}
    		if(F_ISPRESS && x == 120 && y<=80 && y>=40){
    			System.out.println("OK F");
    		}
    		else if(F_ISPRESS){
    			//System.out.println("MISS F");
    		}
    		if(SPACE_ISPRESS && x == 240 && y<=80 && y>=40){
    			System.out.println("OK SPACE");
    		}
    		else if(SPACE_ISPRESS){
    			//System.out.println("MISS SPACE");
    		}
    		if(J_ISPRESS && x == 360 && y<=80 && y>=40){
    			System.out.println("OK J");
    		}
    		else if(J_ISPRESS){
    			//System.out.println("MISS J");
    		}
    		if(K_ISPRESS && x == 480 && y<=80 && y>=40){
    			System.out.println("OK K");
    		}
    		else if(K_ISPRESS){
    			//System.out.println("MISS K");
    		}
    	
    }
	
	public void render(float delta){
		SpriteBatch batch = musicGame.batch;
        batch.begin();
    	for(int r = 0; r < Bar.length ; r++){
    		for(int c = 0; c < 5; c++){
    			x = (c*120);
    			y = 760 + r*40 - k*SPEED;
    			if(hasBarAt(r,c)){
    				batch.draw(tabplayImg, x, y);
    			}
    			checkTap(r,c);
//    			System.out.println(x);
//    			System.out.println(y);
    		}
    	}
    	update(delta);
        batch.end();
    }	
	

}
