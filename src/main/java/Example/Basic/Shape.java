package Example.Basic;

import JCat.RenderSystem;
import JCat.Event.Event;
import JCat.Event.EventListener;
import JCat.Graphics.Color;
import JCat.Graphics.Shape.Circle;
import JCat.Graphics.Shape.Line;
import JCat.Graphics.Shape.Rect;

public class Shape {
	public static void main(String[] args) {

		RenderSystem system = new RenderSystem(800, 600);
		Rect rect = new Rect(50,50);
		
		rect.x = (system.getStage().getStageWidth() - rect.getWidth()) / 2;
		rect.y = (system.getStage().getStageHeight() - rect.getHeight()) / 2;
		rect.setAnchorX(0.5);
		rect.setAnchorY(0.5);
		rect.setColor(Color.RED);

		Line line = new Line(50);
		
		line.x = rect.x-100;
		line.y = (system.getStage().getStageHeight() - rect.getHeight()) / 2;
		line.setAnchorX(0.5);
		line.setAnchorY(0.5);
		line.setColor(Color.GREEN);

		Circle circle = new Circle(25);
		
		circle.x = rect.x+100;
		circle.y = (system.getStage().getStageHeight() - rect.getHeight()) / 2;
		circle.setAnchorX(0.5);
		circle.setAnchorY(0.5);
		circle.setColor(Color.BLUE);

		
		
		
		
		system.getStage().addChildAll(rect,line,circle);
		system.getStage().addEventListener(Event.UPDATE, new EventListener() {
			
			@Override
			public void onResponce(Event event) {
				rect.rotation+=5;
				line.rotation+=5;
				circle.rotation+=5;
				
			}
		});
	}

}
