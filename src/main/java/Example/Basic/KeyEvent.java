package Example.Basic;

import JCat.RenderSystem;
import JCat.Display.Text.SimpleText;
import JCat.Event.EventListener;

public class KeyEvent {
	public static void main(String[] args) {

		RenderSystem system = new RenderSystem(800, 600);
		SimpleText simpleText=new SimpleText("please type");
		simpleText.x = (system.getStage().getStageWidth() - simpleText.getWidth()) / 2;
		simpleText.y = (system.getStage().getStageHeight() - simpleText.getHeight()) / 2;
		
		
		SimpleText input=new SimpleText("");
		input.x=simpleText.x;
		input.y=simpleText.y+50;
		system.getStage().addEventListener(JCat.Event.KeyEvent.KEY_DOWN, new EventListener<JCat.Event.KeyEvent>() {

			@Override
			public void onResponce(JCat.Event.KeyEvent event) {
				input.setText(input.getText()+event.keyChar);
				
			}
		});
		
		system.getStage().addChildAll(simpleText);
		system.getStage().addChildAll(input);

	}
}
