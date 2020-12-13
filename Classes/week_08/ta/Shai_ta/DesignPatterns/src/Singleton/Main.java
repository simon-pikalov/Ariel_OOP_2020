package Singleton;

public class Main 
{

	public static void main(String[] args) 
	{
		Server s1 = Server.getInstance();
		Server s2 = Server.getInstance();

		System.out.println(s1);
		System.out.println(s2);
	}

}
