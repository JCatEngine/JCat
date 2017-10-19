package Example.Basic;

import JCat.RenderSystem;
import JCat.Display.Text.SimpleText;
import JCat.Event.Event;
import JCat.Event.EventListener;
import JCat.Graphics.Color;
import JCat.Graphics.Shape.Rect;

public class Text {
	public static void main(String[] args) {

		RenderSystem system = new RenderSystem(800, 600);
		Rect rect = new Rect();
		
		rect.x = (system.getStage().getStageWidth() - rect.getWidth()) / 2;
		rect.y = (system.getStage().getStageHeight() - rect.getHeight()) / 2;
		rect.setAnchorX(0.5);
		rect.setAnchorY(0.5);

		rect.addEventListener(Event.UPDATE, new EventListener() {

			@Override
			public void onResponce(Event event) {
				rect.rotation += 5;
			}
		});

		system.getStage().addChildAll(rect);
	}

}
