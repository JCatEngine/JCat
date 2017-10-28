package Example.Basic;

import JCat.RenderSystem;
import JCat.Display.Bitmap;
import JCat.Display.Texture;
import JCat.Event.EventListener;
import JCat.Event.MouseEvent;
import JCat.Utils.Loader;
import JCat.Utils.Loader.onAchieveListener;

public class MouseDrag {
	public static void main(String[] args) {

		Loader loader = new Loader();
		loader.add("resources\\bunny.png").start(new onAchieveListener() {

			@Override
			public void onAchieve(Loader loader) {

				loadAchieve();
			}
		});
	}

	protected static boolean drag=false;
	protected static double startX=0;
	protected static double startY=0;
	protected static double bitmapStartX;
	protected static double bitmapStartY;

	protected static void loadAchieve() {

		RenderSystem system = new RenderSystem(800, 600);
		Texture texture = system.getImageManager().getTextureByName("bunny");
		Bitmap bitmap = new Bitmap(texture);
		bitmap.x = system.getStage().getStageWidth() / 2;
		bitmap.y = system.getStage().getStageHeight() / 2;
		bitmap.addEventListener(MouseEvent.MOUSE_DOWN, new EventListener<MouseEvent>() {

			@Override
			public void onResponce(MouseEvent event) {
				drag = true;
				startX=event.globalX;
				startY=event.globalY;
				bitmapStartX=bitmap.x;
				bitmapStartY=bitmap.y;
			}
		});

		system.getStage().addEventListener(MouseEvent.MOUSE_MOVE, new EventListener<MouseEvent>() {

			@Override
			public void onResponce(MouseEvent event) {
				if(drag)
				{
					bitmap.x=bitmapStartX+(event.globalX-startX);
					bitmap.y=bitmapStartY+(event.globalY-startY);
				}
			}
		});
		
		bitmap.addEventListener(MouseEvent.MOUSE_UP, new EventListener<MouseEvent>() {

			@Override
			public void onResponce(MouseEvent event) {
				drag = false;
			}
		});
		
		system.getStage().addChildAll(bitmap);

	}
}
