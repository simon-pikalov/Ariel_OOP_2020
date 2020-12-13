package Adapter;

public class Main
{
	public static void main(String[] args) 
	{	
		//Win95ShapePainter win95Lib = new Win95ShapePainter();
		Win10ShapePainter win10Lib = new Win10ShapePainter();
		Win10Adapter win10Adapter = new Win10Adapter(win10Lib);
		GUIManager painter = new GUIManager(win10Adapter);
	}
}
