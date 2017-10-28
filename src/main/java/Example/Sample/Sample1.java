package Example.Sample;

import JCat.RenderSystem;
import JCat.Display.Bitmap;
import JCat.Display.Sprite;
import JCat.Display.Texture;
import JCat.Event.Event;
import JCat.Event.EventListener;
import JCat.Graphics.Color;
import JCat.Graphics.Shape.Rect;
import JCat.Utils.Loader;
import JCat.Utils.Loader.onAchieveListener;

public class Sample1 {
	public static void main(String[] args) {

		Loader loader = new Loader();
		loader.add("resources\\bunny.png").start(new onAchieveListener() {

			@Override
			public void onAchieve(Loader loader) {

				loadAchieve();
			}
		});
	}

	protected static double yspeed;
	protected static double g = 0.2;

	protected static void loadAchieve() {

		RenderSystem system = new RenderSystem(800, 600);
		Texture texture = system.getImageManager().getTextureByName("bunny");
		Bitmap bitmap = new Bitmap(texture);
		bitmap.x = (system.getStage().getStageWidth() - bitmap.getWidth()) / 2;
		bitmap.y = (system.getStage().getStageHeight() - bitmap.getHeight()) / 2;
		Rect rect = new Rect(1000, 200);
		rect.setColor(Color.AQUAMARINE);
		rect.x = 0;
		rect.y = bitmap.y + 200;

		system.getStage().addChildAll(bitmap, rect);

		system.getStage().addEventListener(Event.UPDATE, new EventListener<Event>() {

			@Override
			public void onResponce(Event event) {
				bitmap.y += yspeed;
				yspeed += g;
				if(bitmap.hitTestObject(rect))
				{
					yspeed*=-1;
				}
			}
		});

	}
}
