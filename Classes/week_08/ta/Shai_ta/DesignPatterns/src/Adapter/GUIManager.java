package Adapter;

public class GUIManager 
{
	private ShapePainterLibrary painterLib;
	
	public GUIManager(ShapePainterLibrary painter) 
	{
		this.painterLib = painter;
	}
	
	public void drawLine(Line line)
	{
		painterLib.drawLine(line.getP1().getX(), line.getP1().getY(), 
				line.getP2().getX(), line.getP2().getY());
	}
	
	public void drawRectangle(Rectangle rectangle)
	{
		painterLib.drawRectangle(rectangle.getP1().getX(), rectangle.getP1().getY(), 
				rectangle.getP2().getX(), rectangle.getP2().getY());
	}
}
