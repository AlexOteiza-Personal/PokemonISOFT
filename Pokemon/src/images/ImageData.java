package images;


import java.io.IOException;
import java.util.Arrays;

import pokemon.PokemonStats;
import pokemon.Type;
import pokemon.attacks.LearnAttackList;


public class ImageData {
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
	
	private StatusImage imgStatus;
	private BattleImage imgFront;
	private BattleImage imgBack;
	
	
	
	private ImageData(String imgStatusFilename,String imgFrontFilename, String imgBackFilename) {
		try{
		this.imgFront = new BattleImage(imgFrontFilename);
		this.imgBack = new BattleImage(imgBackFilename);
		}
		catch(Exception ex)
		{
			System.exit(2);
		}
	}
	public StatusImage getImgStatus()
	{
		return imgStatus;
	}
	public BattleImage getImgFront() {
		return imgFront;
	}
	public BattleImage getImgBack() {
		return imgBack;
	}
	public static ImageData getInstance(int imageData) {
		ImageData img = null;
		String imgDir = "/images/pokemon/";
		switch(imageData){
		case BULBASAUR:img=new ImageData(null,imgDir+"front/001.png",imgDir+"back/001.png");	break;
		case EKANS:	   img=new ImageData(null,imgDir+"front/002.png",imgDir+"back/002.png");	break;
		case DIGLETT:  img=new ImageData(null,imgDir+"front/003.png",imgDir+"back/003.png");	break;
		case RATTATA:  img=new ImageData(null,imgDir+"front/004.png",imgDir+"back/004.png");	break;
		case WEEDLE:   img=new ImageData(null,imgDir+"front/005.png",imgDir+"back/005.png");	break;
		case ABRA:	img=new ImageData(null,imgDir+"front/006.png",imgDir+"back/006.png");		break;
		case DODRIO:img=new ImageData(null,imgDir+"front/007.png",imgDir+"back/007.png");	break;
		case PIDGEY:img=new ImageData(null,imgDir+"front/008.png",imgDir+"back/008.png");	break;
		case ARCANINE:img=new ImageData(null,imgDir+"front/009.png",imgDir+"back/009.png");	break;
		case MEW:img=new ImageData(null,imgDir+"front/010.png",imgDir+"back/010.png");		break;
		default:break;
		}
		return img;
	}
}
