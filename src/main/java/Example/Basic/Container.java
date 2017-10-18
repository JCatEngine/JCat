package Example.Basic;

import JCat.RenderSystem;
import JCat.Display.Bitmap;
import JCat.Display.Sprite;
import JCat.Event.Event;
import JCat.Event.EventListener;
import JCat.Math.Vector2;
import JCat.Textures.Texture;
import JCat.Utils.ImageLoader;
import JCat.Utils.ImageLoader.onAchieveListener;

public class Container {

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
		Sprite sprite=new Sprite();
		for(int i=0;i<25;i++)
		{
			Bitmap bitmap=new Bitmap(texture);
			bitmap.x = (i % 5) * 40-100;
			bitmap.y = Math.floor(i / 5) * 40-100;
			sprite.addChild(bitmap);
		}
		
		sprite.x=system.getStage().getStageWidth()/2;
		sprite.y=system.getStage().getStageHeight()/2;

		sprite.addEventListener(Event.UPDATE, new EventListener() {
			
			@Override
			public void onResponce(Event event) {
				sprite.rotation+=5;
			}
		});
		
		system.getStage().addChild(sprite);
		
		
		
	}
}
