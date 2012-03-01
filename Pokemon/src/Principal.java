import java.awt.*;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.Iterator;

import exceptions.ImageInvalidSizeException;
import fonts.BitmapFont;

import graphics.GameFrame;
import graphics.betatesting.PokemonStatusTest;
import pokemon.*;
import utils.ImageUtils;

public class Principal {

    /**
     * @param args
     * @throws IOException
     * @throws ImageInvalidSizeException 
     */
    public static void main(String[] args) throws IOException, ImageInvalidSizeException
    {
	new GameFrame();
	/*
	try
	{
	    
	    new GameFrame();
	}
	catch (Exception ex)
	{
	    ex.printStackTrace();
	    System.exit(2);
	}*/
    }

}
