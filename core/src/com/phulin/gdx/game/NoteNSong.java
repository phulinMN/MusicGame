package com.phulin.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class NoteNSong {
	private MusicGame musicGame;
	int i = 0;
	public String [] NOTE = new String[] {
			"****-",
			"*****",
			"-****",
			"*****",
			"**-**",
			"*****",
			"****-",
			"*****",
			"*-***",
			"*****",
			"-****",
			"*****",
			"**-**",
			"*****",
			"****-",
			"*****",
			"**-**",
			"-****",
			"*-***",
			"*-***",
			"****-",
			"***-*",
			"-****",
			"****-",
			"*-***",
			"**-**",
			"****-",
			"**-**",
			"-****",
			"*-***",
			"***-*",
			"****-",
			"****-",
			"**-**",
			"-****"
			};
	
	Music music = Gdx.audio.newMusic(Gdx.files.internal("Canon.mp3"));
	
	public void update(float delta){
		i++;
		if(i>=400){
			music.play();
		}
	}
	public boolean hasBarAt(int r, int c) {
        return NOTE[r].charAt(c) == '-';
    }
 
    public boolean hasDotAt(int r, int c) {
        return NOTE[r].charAt(c) == '*';
    }
	public NoteNSong(MusicGame musicGame){
		
	}
	
}
