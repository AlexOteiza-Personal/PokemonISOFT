import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.Iterator;

import graphics.GameFrame;
import pokemon.*;

public class Principal {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
	try
	{
	    new GameFrame();
	}
	catch (Exception ex)
	{
	    ex.printStackTrace();
	    System.exit(2);
	}
    }

}
