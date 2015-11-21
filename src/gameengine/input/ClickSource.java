package gameengine.input;

public interface ClickSource {
	public void addListener(Clickable c);
	public void removeListener(Clickable c);
	public void update(Clickable c);
	public void notifyListeners();
}
