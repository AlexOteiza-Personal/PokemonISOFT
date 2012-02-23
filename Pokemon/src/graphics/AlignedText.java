package graphics;

import java.awt.Graphics;

public class AlignedText {
    public static final int LEFT_ALIGN = 0;
    public static final int RIGHT_ALIGN = 1;
    public static final int CENTER_ALIGN = 2;
    private int align;
    public AlignedText(int align)
    {
	this.align = align;
    }
    public void drawString(String text,int x, int y,Graphics g)
    {
	if(align==LEFT_ALIGN)
	    g.drawString(text, x, y);
	else if(align==RIGHT_ALIGN)
	    g.drawString(text, x-g.getFontMetrics().stringWidth(text), y);
    }
    public void drawString(int text,int x, int y,Graphics g)
    {
	this.drawString(String.valueOf(text),x,y,g);
    }
}
