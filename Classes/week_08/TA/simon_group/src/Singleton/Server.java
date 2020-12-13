package Singleton;

public class Server 
{
	private static Server onlyInstance = null;
	
	private Server()
	{
		
	}
	
	public static Server getInstance()
	{		
		if(onlyInstance == null)
		{
			synchronized(Server.class)
			{
				if(onlyInstance == null)
				{
					onlyInstance = new Server();
				}
			}
		}
		return onlyInstance;
	}
}
