package com.phulin.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class NoteNSong {
	private MusicGame musicGame;
	public String [] NOTE = new String[] {
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
	
	public boolean hasBarAt(int r, int c) {
        return NOTE[r].charAt(c) == '-';
    }
 
    public boolean hasDotAt(int r, int c) {
        return NOTE[r].charAt(c) == '*';
    }
	public NoteNSong(MusicGame musicGame){
		Music music = Gdx.audio.newMusic(Gdx.files.internal("twinkle.mp3"));
		music.play();
	}
}
