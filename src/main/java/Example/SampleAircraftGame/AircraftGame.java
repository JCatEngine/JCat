package Example.SampleAircraftGame;

import java.io.IOException;

import JCat.RenderSystem;
import JCat.Display.Bitmap;
import JCat.Display.Sprite;
import JCat.Display.Stage;
import JCat.Event.KeyEvent;
import JCat.Event.MouseEvent;
import JCat.Textures.Texture;
import JCat.Utils.ImageLoader;
import JCat.Utils.Ticker;
import JCat.Utils.ImageLoader.onAchieveListener;
import JCat.Utils.Ticker.OnResponceListener;

public class AircraftGame {

	public static void main(String[] args) throws IOException {

		RenderSystem system=new RenderSystem(600, 800,30);
		ImageLoader loader=new ImageLoader();
		loader
		.add("resources\\aircraft.png")
		.add("resources\\back.jpeg")
		.start(new onAchieveListener() {

			@Override
			public void onAchieve(ImageLoader loader) {
				
				loadAchieve(system);
			}
		});
		
		

	}

	protected static void loadAchieve(RenderSystem system) {
		
//		Stage stage=system.getStage();
//
//		Sprite sprite=new Sprite();
//		sprite.x=10;
//		sprite.y=10;
//	
//		
//		Texture texture=system.getImageManager().getTextureByName("aircraft");
//		Bitmap bitmap=new Bitmap(texture);
//		
//		
//		Bitmap bitmap2=new Bitmap(texture);
//		
//		
//		sprite.addChild(bitmap);
//		//sprite.addChild(bitmap2);
//		bitmap2.x=100;
//		bitmap2.y=50;
//		
//		//sprite.addEventListener("test", e->System.out.println(e));
//		sprite.addEventListener(KeyEvent.KEY_DOWN, e->System.out.println(e));
//		
//		
//		bitmap.x=100;
//		bitmap.y=100;
//		
//		stage.addChild(sprite);
//		
//		sprite.addEventListener(MouseEvent.MOUSE_DOWN, e->System.out.println(e));
//		
//		Ticker ticker=new Ticker(50);
//		ticker.addListener(new OnResponceListener() {
//
//			@Override
//			public void onResponce() {
//				loop(sprite,system,bitmap);
//				
//			}
//		});
		
		
//		System.out.println(bitmap.globalToLocal(new Vector2(120, 120)));	
		
		//bitmap.rotation-=45;
		//System.out.println(bitmap.getBound(bitmap));
		//System.out.println(bitmap.getBound(bitmap.stage));
		
		//System.out.println(bitmap.localToGlobal(new Vector2(200, 200)));

	}

	protected static void loop(Sprite sprite, RenderSystem system, Bitmap bitmap) {
		
	
		//sprite.x+=5;
		//sprite.rotation--;
		//sprite.alpha=0.5;
		
		

		//bitmap.dispatchEvent(new Event("test", true));
		
	
		//sprite.setWidth(sprite.getWidth()+10);

		//sprite.setScaleX(sprite.getScaleX()+0.01);

		
		//System.out.println(sprite.getWidth());
		//System.out.println(bitmap.getBound(bitmap.stage));
		
		
		
		system.render();
		
		
		
		
	}
}
