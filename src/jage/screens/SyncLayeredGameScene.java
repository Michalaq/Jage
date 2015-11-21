package jage.screens;

import jage.graphicengine.GraphicsDrawer;
import jage.graphicengine.InLayerDrawable;
import jage.graphicengine.Layer;

import java.util.Collection;

public abstract class SyncLayeredGameScene implements GameScene {
	protected final Layer[] layers;
	protected final int topLayer;
	protected boolean paused = false;
	
	
	protected void placeInLayer(InLayerDrawable d) {
		layers[d.getTargetLayerId()].addInLayerDrawable(d);
	}
	
	protected void placeInLayer(Collection<? extends InLayerDrawable> ds) {
		layers[ds.iterator().next().getTargetLayerId()].addInLayerDrawables(ds);
	}
	
	protected void removeFromLayer(InLayerDrawable d) {
		layers[d.getTargetLayerId()].removeInLayerDrawable(d);
	}
	
	protected void removeFromLayer(Collection<? extends InLayerDrawable> ds) {
		layers[ds.iterator().next().getTargetLayerId()].removeInLayerDrawables(ds);
	}
	
	protected void placeAllInLayers(Collection<? extends InLayerDrawable> ds) {
		for (InLayerDrawable d : ds) {
			layers[d.getTargetLayerId()].addInLayerDrawable(d);
		}
	}
	
	
	public SyncLayeredGameScene(int layerCount) {
		topLayer = layerCount-1;
		layers = new Layer[layerCount];
		for (int i=0; i<layerCount; i++) {
			layers[i] = new Layer(i);
		}
	}
	
	@Override
	public synchronized void update() {
		throw new IllegalStateException("Unimplemented update in game scene class.");
	}
	
	@Override
	public synchronized void destroy() {
		for (int i=0; i<layers.length; i++) {
			layers[i].removeAll();
		}
	}
	
	@Override
	public void pause() {
		paused = true;
	}
	
	public void resume() {
		paused = false;
	}
	
	@Override
	public synchronized final void draw(final GraphicsDrawer gd) {
		for (int i=0; i<layers.length; i++) {
			layers[i].draw(gd);
		}
	}
}
