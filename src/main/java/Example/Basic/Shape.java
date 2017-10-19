package Example.Basic;

import JCat.RenderSystem;
import JCat.Display.Text.SimpleText;
import JCat.Event.Event;
import JCat.Event.EventListener;
import JCat.Graphics.Color;

public class Shape {
	public static void main(String[] args) {

		RenderSystem system = new RenderSystem(800, 600);
		SimpleText simpleText = new SimpleText("text");
		simpleText.setFontSize(50);
		simpleText.setColor(Color.AQUA);

		simpleText.x = (system.getStage().getStageWidth() - simpleText.getWidth()) / 2;
		simpleText.y = (system.getStage().getStageHeight() - simpleText.getHeight()) / 2;
		simpleText.setAnchorX(0.5);
		simpleText.setAnchorY(0.5);

		simpleText.addEventListener(Event.UPDATE, new EventListener() {

			@Override
			public void onResponce(Event event) {
				simpleText.rotation += 5;
			}
		});

		system.getStage().addChildAll(simpleText);
	}

}
