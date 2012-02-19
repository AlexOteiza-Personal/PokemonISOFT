package pokemon.imagedata;

import java.io.IOException;

public class ImageData {
	private StatusImage imgStatus;
	private BattleImage imgFront;
	private BattleImage imgBack;
	public ImageData(String imgStatusFilename,String imgFrontFilename, String imgBackFilename) {
		try{
		this.imgFront = new BattleImage(imgFrontFilename);
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
}
