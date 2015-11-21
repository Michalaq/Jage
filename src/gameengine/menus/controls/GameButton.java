package gameengine.menus.controls;

import gameengine.graphicengine.GraphicsDrawer;
import gameengine.graphicengine.SpriteObjectGraphicData;
import gameengine.input.ClickSource;
import gameengine.input.Clickable;

import java.util.HashMap;
import java.util.Map;

public abstract class GameButton extends GameControl implements Clickable {
	public enum ButtonSize { MEDIUM_RECTANGLE(128, 64, "CLOUD_BUTTON_DEFAULT", "CLOUD_BUTTON_PRESSED", 48, 16),
							//MEDIUM_SQUARE(width, height...), LARGE(width, height...),....
							;
							public final int width, height, xMargin, yMargin;
							private final Map<State, String> sprites = new HashMap<State, String>();
							private ButtonSize(int width, int height, String defaultSprite, String pressedSprite, int xMargin, int yMargin) {
								this.width = width;
								this.height = height;
								this.xMargin = xMargin;
								this.yMargin = yMargin;
								sprites.put(State.DEFAULT, defaultSprite);
								sprites.put(State.PRESSED, pressedSprite);
							}
							public String getStateSprite(State state) {
								return sprites.get(state);
							}
	}
	public enum State { DEFAULT, /*FOCUSED,*/ PRESSED, /* DISABLED, /*????*/ ; }
	protected Map<State, SpriteObjectGraphicData> statesGraphics
				= new HashMap<State, SpriteObjectGraphicData>();
	protected State currentState = State.DEFAULT;
	protected boolean enabled = true;
	protected GameText text = null;
	protected GameImage image = null;
	
	public GameButton(float x, float y, float priority_z, int width, int height, int layerId, Map<State, SpriteObjectGraphicData> graphics) {
		super(x, y, width, height);
		this.z = priority_z;
		this.layerId = layerId;
		statesGraphics.putAll(graphics);
		for(SpriteObjectGraphicData so : statesGraphics.values()) {
			so.update(this);
		}
		graphics.values().removeAll(graphics.values());
	}
	
	public void setText(GameText text) {
		this.text = text;
	}
	public void setImage(GameImage image) {
		this.image = image;
	}
	/* When it gots something on it (e.g. text or image), update their location too. */
	@Override
	public void setX(float x) {
		super.setX(x);
		if(image != null) { image.setX(x); image.update(); }
		if(text != null) text.setX(x);
	}
	
	@Override
	public void setY(float y) {
		super.setY(y);
		if(image != null) { image.setY(y); image.update(); }
		if(text != null) text.setY(y);
	}

	@Override
	public void addX(float x) {
		super.addX(x);
		if(image != null) { image.addX(x); image.update(); }
		if(text != null) text.addX(x);
	}
	
	@Override
	public void addY(float y) {
		super.addY(y);
		if(image != null) { image.addY(y); image.update(); }
		if(text != null) text.addY(y);
	}
	/**/
	
	public State getCurrentState() {
		return currentState;
	}
	
	public void setCurrentState(State state) {
		currentState = state;
	}
	
	protected boolean isWithin(float x, float y) {
		return (x >= (this.x-width/2)) && (y >= (this.y-height/2))
				&& (x <= (this.x+width/2)) && (y <= (this.y+height/2));
	}
	
	@Override
	public boolean isInitialPressWithin(float x, float y) {
		return isWithin(x, y);
	}
	
	@Override
	public void setVisibility(boolean visible) {
		super.setVisibility(visible);
		this.enabled = visible;
	};
	
	@Override
	public void setClickSource(ClickSource cs) {
		cs.addListener(this);
	}
	
	@Override
	public void onInitialPress(float x, float y) {
		if (isWithin(x, y)) {
			setCurrentState(State.PRESSED);
			update();
		}
	}
	
	@Override
	public void onHold(float x, float y) {
		currentState = (currentState == State.PRESSED && isWithin(x, y))
						? State.PRESSED : State.DEFAULT;
		update();
	}
	
	@Override
	public void onRelease(float x, float y) {
		currentState = State.DEFAULT;
		update();
	}
	
	@Override
	public SpriteObjectGraphicData getGraphicData() {
		statesGraphics.get(currentState).update(this);
		return statesGraphics.get(currentState);
	}
	
	@Override
	public void draw(final GraphicsDrawer gd) {
		super.draw(gd);
		if(image != null) {
			image.draw(gd);
		}
		if(text != null) {
			text.draw(gd);
		}
	}
	
	@Override
	public int getPriority() {
		return (int) z;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return String.format("Button: [x: %f, y: %f].", getX(), getY());
	}
}
