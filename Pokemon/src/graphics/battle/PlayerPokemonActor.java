package graphics.battle;

import java.awt.image.BufferedImage;

import pokemon.Pokemon;

import utils.ImageUtils;

public class PlayerPokemonActor extends Actor{

	public PlayerPokemonActor(Pokemon pokemon, int x, int y,boolean front) {
		super(x, y, front ? pokemon.getImageData().getImgFront().getImage() : pokemon.getImageData().getImgBack().getImage());
	}
	
}
