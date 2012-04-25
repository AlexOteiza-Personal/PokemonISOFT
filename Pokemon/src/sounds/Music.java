package sounds;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import utils.AudioUtils;

/*
 * Enumeracion de music conteniendo cada una de las musicas
 * y ademas los puntos en los que la musica va a estar haciendo loop.
 */

public enum Music{
	ROUTE_3(0,"/sounds/route3.wav"),
	WILD_BATTLE(397155,"/sounds/wild_battle.wav");
	private Clip clip;
	/*
	 * La clase Clip usa unas unidades para el sonido llamadas 'Frames' , 
	 * desconocidas por el programador , esta clase usa los milisegundos 
	 * milisegundos pasados al constructor y los convierte para usarlos con el clip
	 */
	Music(int msloopStart,String dir){
		try {
			clip = AudioUtils.getAudioWdir(dir);
		} catch (LineUnavailableException e) {
			System.err.println("Line unavailable");
		}
		int loopStart=0;
		// Solo realizamos la operacion si es mayor que 0
		if(msloopStart>0)
		{
			// Obtenemos cuantos frames son un milisegundo
			double framePerMs = (double)(clip.getFrameLength())/(double)(clip.getMicrosecondLength()/100);
			// Obtenemos el Frame correspondiente a los milisegundos introducidos
			loopStart = (int)(framePerMs*msloopStart);
		}
		clip.setLoopPoints(loopStart, -1);
	}
	public void loop()
	{
		clip.loop(-1);
	}
	public void stop()
	{
		clip.stop();
	}
}
