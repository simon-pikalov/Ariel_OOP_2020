package Adapter;

public class Win10Adapter implements ShapePainterLibrary
{
	Win10ShapePainter win10Painter;

	public Win10Adapter(Win10ShapePainter newPainter)
	{
		this.win10Painter = newPainter;
	}
	
	@Override
	public void drawLine(int x1, int y1, int x2, int y2) 
	{
		win10Painter.drawLine(x1, y1, x2, y2);
	}
	
	@Override
	public void drawRectangle(int x1, int y1, int x2, int y2) 
	{
	    int x = Math.min(x1, x2);
	    int y = Math.min(y1, y2);
	    int width = Math.abs(x2 - x1);
	    int height = Math.abs(y2 - y1);
	    win10Painter.drawRectangle(x, y, width, height);
	}
}

