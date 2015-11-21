package jage.input;

public interface Clickable {
	//public static final int RELEASED = 0, PRESSED = 1, CLICKED = 2;
	//kazde Clickable powinno tez implementowac protected boolean isWithin(float x, float y)
	//ktore sprawdza, czy klikniecie zaszlo wewnatrz tego obiektu
	public void setClickSource(ClickSource cs);
	public boolean isInitialPressWithin(float x, float y);
	public void onInitialPress(float x, float y);
	public void onHold(float x, float y);
	public void onRelease(float x, float y);
	public void setEnabled(boolean enabled);
	public boolean isEnabled();
	public int getPriority();
}
