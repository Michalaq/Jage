package jage.objects;

import jage.graphicengine.SpriteObjectGraphicData;
import jage.menus.controls.GameButton;
import jage.menus.controls.GameImage;
import jage.menus.controls.GameButton.State;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ControlObjectFactory extends GraphicalObjectFactory {

	public static GameButton createButton(Map<State, String> statesSprites, float x, float y, float priority_z, int width, int height, final int layerId,
									  final Callable<Void> onClickEvent) {
		Map<State, SpriteObjectGraphicData> graphicsMap = new HashMap<State, SpriteObjectGraphicData>();
		for (State s : State.values()) {
			graphicsMap.put(s, graphicDataFactory.createResizedSpriteObjectGraphicData
											(statesSprites.get(s), width, height));
		}
		
		return new GameButton(x, y, priority_z, width, height, layerId, graphicsMap) {
			@Override
			public void onRelease(float x, float y) {
				if (currentState == State.PRESSED) {
					super.onRelease(x, y);
					try {
						onClickEvent.call();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
	}
	
	public static GameImage createImage(float x, float y, int width, int height, int layerId, String image) {
		return new GameImage(x, y, width, height, graphicDataFactory.createResizedSpriteObjectGraphicData(image, width, height), layerId);
	}
}
