package sounds;

import graphics.Settings;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import utils.AudioUtils;

public class SoundData {
	public static final int BULBASAUR = 1;
	public static final int EKANS = 2;
	public static final int DIGLETT = 3;
	public static final int RATTATA = 4;
	public static final int WEEDLE = 5;
	public static final int ABRA = 6;
	public static final int DODRIO = 7;
	public static final int PIDGEY = 8;
	public static final int ARCANINE = 9;
	public static final int MEW = 10;
	
	private Clip clip;
	
	private SoundData(String dir) {
		try {
			this.clip = AudioUtils.getAudioWdir(dir);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
	}
	public void play(){
		clip.setMicrosecondPosition(0);
		if(Settings.getSound()==false)
			return;
		clip.start();
	}
	
	public static SoundData getInstance(int soundData) {
		SoundData snd = null;
		String sndDir = "/sounds/pokemon/";
		switch(soundData){
		case BULBASAUR:snd=new SoundData(sndDir+"001.au");	break;
		case EKANS:	   snd=new SoundData(sndDir+"");	break;
		case DIGLETT:  snd=new SoundData(sndDir+"");	break;
		case RATTATA:  snd=new SoundData(sndDir+"");	break;
		case WEEDLE:   snd=new SoundData(sndDir+"");	break;
		case ABRA:	snd=new SoundData(sndDir+"");		break;
		case DODRIO:snd=new SoundData(sndDir+"");	break;
		case PIDGEY:snd=new SoundData(sndDir+"");	break;
		case ARCANINE:snd=new SoundData(sndDir+"");	break;
		case MEW:snd=new SoundData(sndDir+"");		break;
		default:break;
		}
		return snd;
	}
}
