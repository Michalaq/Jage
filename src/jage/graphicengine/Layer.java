package jage.graphicengine;

import java.util.Collection;
import java.util.HashSet;

public class Layer implements Drawable {
	public static final int MAX_LAYER_COUNT = 128;
	public static final int TOP_LAYER = MAX_LAYER_COUNT;
	public static final int BOTTOM_LAYER = 0;
	private final int id;
	private final Collection<InLayerDrawable> drawables = new HashSet<InLayerDrawable>();
	
	public Layer(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void addInLayerDrawable(InLayerDrawable d) {
		drawables.add(d);
	}
	
	public void addInLayerDrawables(Collection<? extends InLayerDrawable> drawables) {
		this.drawables.addAll(drawables);
	}
	
	public void removeInLayerDrawable(InLayerDrawable d) {
		drawables.remove(d);
	}
	
	public void removeInLayerDrawables(Collection<? extends InLayerDrawable> drawables) {
		this.drawables.removeAll(drawables);
	}
	
	public void removeAll() {
		drawables.removeAll(drawables);
	}
	
	@Override
	public void draw(final GraphicsDrawer graphicsDrawer) {
		if(drawables.size() > 0)
		for (InLayerDrawable d : drawables) {
			d.draw(graphicsDrawer);
		}
	}
}
