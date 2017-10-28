package Example.Basic;

import JCat.RenderSystem;
import JCat.Display.Bitmap;
import JCat.Display.Texture;
import JCat.Event.Event;
import JCat.Event.EventListener;
import JCat.Utils.Loader;
import JCat.Utils.Loader.onAchieveListener;

public class Basic {
	public static void main(String[] args) {
		
		Loader loader=new Loader();
		loader
		.add("resources\\bunny.png")
		.start(new onAchieveListener() {

			@Override
			public void onAchieve(Loader loader) {
				
				loadAchieve();
			}
		});
	}

	protected static void loadAchieve() {
		
		
		
		RenderSystem system=new RenderSystem(800, 600);
		Texture texture=system.getImageManager().getTextureByName("bunny");
		Bitmap bitmap=new Bitmap(texture);
		bitmap.x=system.getStage().getStageWidth()/2;
		bitmap.y=system.getStage().getStageHeight()/2;
		bitmap.setAnchorX(0.5);
		bitmap.setAnchorY(0.5);
		bitmap.addEventListener(Event.UPDATE, new EventListener() {
			
			@Override
			public void onResponce(Event event) {
				bitmap.rotation+=5;
			}
		});
		
		
		
		system.getStage().addChildAll(bitmap);
		
		
		
	}
	
}
