package Example.Basic;

import JCat.RenderSystem;
import JCat.Event.EventListener;
import JCat.Event.MouseEvent;
import JCat.Graphics.Color;
import JCat.Graphics.Graphics;

public class Draw {


	protected static boolean isDraw=false;

	public static void main(String[] args) {
		RenderSystem system = new RenderSystem(800, 600);
		Graphics graphics = new Graphics();
		graphics.setColor(Color.RED);
		system.getStage().addChildAll(graphics);

		system.getStage().addEventListener(MouseEvent.MOUSE_DOWN, new EventListener<MouseEvent>() {

			@Override
			public void onResponce(MouseEvent event) {
				isDraw=true;
				graphics.moveTo(event.localX,event.localY);
			}
		});

		system.getStage().addEventListener(MouseEvent.MOUSE_MOVE, new EventListener<MouseEvent>() {

			@Override
			public void onResponce(MouseEvent event) {

				if(isDraw)
				{				
					graphics.lineTo(event.localX,event.localY);

				}
			}
		});
		system.getStage().addEventListener(MouseEvent.MOUSE_UP, new EventListener<MouseEvent>() {

			@Override
			public void onResponce(MouseEvent event) {
				
				isDraw=false;
			}
		});

	}
}
