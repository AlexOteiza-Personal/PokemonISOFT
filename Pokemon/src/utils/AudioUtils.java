package utils;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioUtils {
	public static Clip getAudioWdir(String dir) throws LineUnavailableException
	{
		Clip clip = AudioSystem.getClip();
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(AudioUtils.class.getResource(dir));
			clip.open(ais);
		} catch (UnsupportedAudioFileException e) {
			System.err.println("Formato de Audio no soportado");
		} catch (IOException e) {
			System.err.println("Archivo "+ dir+"+ no encontrado");
		}
		return clip;
	}
}
