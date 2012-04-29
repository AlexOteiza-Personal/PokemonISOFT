package sounds;

import graphics.Settings;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import utils.AudioUtils;

public class Sound {
	private Clip clip;
	public Sound(String dir) {
		try {
			this.clip = AudioUtils.getAudioWdir(dir);
		} catch (LineUnavailableException e) {}
	}
	public void play(){
		clip.setMicrosecondPosition(0);
		if(Settings.getSound()==false)
			return;
		clip.start();
	}
}
