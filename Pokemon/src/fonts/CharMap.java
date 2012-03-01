package fonts;


public class CharMap {
    private FontChar charmap[];
    
    public CharMap(FontChar[] charmap)
    {
	this.charmap = charmap;
    }
    public FontChar getFontChar(int index)
    {
	return charmap[index];
    }
    public int getSize()
    {
	return charmap.length;
    }
}
