package jage.screens;

import jage.input.ClickSource;
import jage.input.Clickable;

import java.util.Collection;
import java.util.HashSet;


public abstract class MenuScene extends SyncLayeredGameScene {
	protected Collection<Clickable> clickables;
	protected ClickSource clickSource;
	public MenuScene(int layerCount, ClickSource clickSource) {
		super(layerCount);
		this.clickSource = clickSource;
		clickables = new HashSet<Clickable>();
	}
	
	protected void activateClickables() {
		for(Clickable cl : clickables) {
			cl.setEnabled(true);
		}
	}
	
	protected void deactivateClickables() {
		for(Clickable cl : clickables) {
			cl.setEnabled(false);
		}
	}
	
	@Override
	public void pause() {
		deactivateClickables();
	}
	
	@Override
	public void resume() {
		activateClickables();		
	}
	
	@Override
	public void destroy() {
		super.destroy();
		deactivateClickables();
		for(Clickable cl : clickables) {
			clickSource.removeListener(cl);
		}
		clickables = null;
		clickSource = null;
	}

}
