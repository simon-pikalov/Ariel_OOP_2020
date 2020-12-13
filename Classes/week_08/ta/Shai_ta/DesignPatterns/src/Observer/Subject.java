package Observer;


public interface Subject 
{
	public void register(Listener o);
	public void unregister(Listener o);
	public void notifyListeners();
}