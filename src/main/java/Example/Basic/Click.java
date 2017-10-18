package Example.Basic;

import JCat.RenderSystem;
import JCat.Display.Bitmap;
import JCat.Event.Event;
import JCat.Event.EventListener;
import JCat.Event.MouseEvent;
import JCat.Textures.Texture;
import JCat.Utils.ImageLoader;
import JCat.Utils.ImageLoader.onAchieveListener;

public class Click {
	public static void main(String[] args) {
		
		ImageLoader loader=new ImageLoader();
		loader
		.add("resources\\bunny.png")
		.start(new onAchieveListener() {

			@Override
			public void onAchieve(ImageLoader loader) {
				
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
		bitmap.addEventListener(MouseEvent.MOUSE_UP, new EventListener() {
			
			@Override
			public void onResponce(Event event) {
				bitmap.setScaleX(bitmap.getScaleX()*1.5);
				bitmap.setScaleY(bitmap.getScaleY()*1.5);
			}
		});
		
		
		system.getStage().addChildAll(bitmap);
		
		
		
	}
	
}
