package SampleAircraftGame;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.lang.model.element.VariableElement;

import JGame.JGame;
import JGame.Common.Ticker;
import JGame.Common.Ticker.OnResponceListener;
import JGame.GameCore.Loader.ImageLoader;
import JGame.GameCore.Loader.ImageLoader.onAchieveListener;
import JGame.RenderSystem.RenderSystem;
import JGame.RenderSystem.Display.Bitmap;
import JGame.RenderSystem.Display.EventDispatcher;
import JGame.RenderSystem.Display.Sprite;
import JGame.RenderSystem.Display.Stage;
import JGame.RenderSystem.Math.Vector2;
import JGame.RenderSystem.Textures.Texture;
import JGame.RenderSystem.Utils.MathUtil;
import SampleAircraftGame.Util.Util;

public class main {

	public static void main(String[] args) throws IOException {
		

		RenderSystem system=new RenderSystem(600, 800);
		
		ImageLoader loader=new ImageLoader(system);
		loader
		.add("src\\resources\\aircraft.png")
		.add("src\\resources\\back.jpeg")
		.start(new onAchieveListener() {

			@Override
			public void onAchieve(ImageLoader loader) {
				
				loadAchieve(system);
			}
		});
		
		
		

		
		
//		jGame.addObject(aircraft);
//		jGame.addToRoot(aircraft);
//		aircraft.x=300;
//		aircraft.y=600;
//		aircraft.width=50;
//		aircraft.height=50;
//		aircraft.getCom_anime().addImage(Util.LoadImg("aircraft.png"));
//		
//		
//		//添加到顶层渲染中 这和上面的add不一样 上面的只是为了一种资源绑定关系
//		//而也不是所有的对象都在顶层渲染中 
//		
//		
//		Money money=new Money();
//		jGame.addObject(money);
//		jGame.addToRoot(money);
//		money.x=100;
//		money.y=100;
//		money.getCom_anime().CreateAnime("test", 12, Util.LoadImg("testAnime1.png"));
//		money.getCom_anime().addKeyFrame("test", 4, Util.LoadImg("testAnime2.png"));
//		money.getCom_anime().addKeyFrame("test", 7, Util.LoadImg("testAnime3.png"));
//		money.getCom_anime().addKeyFrame("test", 10, Util.LoadImg("testAnime4.png"));
//		
//		
//		jGame.getRoot().getCom_anime().addImage(Util.LoadImg("back.jpeg"));
	}

	protected static void loadAchieve(RenderSystem system) {
		
		Stage stage=system.getStage();

		Sprite sprite=new Sprite();
		sprite.x=10;
		sprite.y=10;
	
		
		Texture texture=system.getImageManager().getTextureByName("aircraft");
		Bitmap bitmap=new Bitmap(texture);
		
		
		Bitmap bitmap2=new Bitmap(texture);
		
		
		sprite.addChild(bitmap);
		sprite.addChild(bitmap2);
		bitmap2.x=100;
		bitmap2.y=50;
		
		
		bitmap.x=100;
		bitmap.y=100;
		
		stage.addChild(sprite);
		
		
		Ticker ticker=new Ticker(50);
		ticker.addListener(new OnResponceListener() {

			@Override
			public void onResponce() {
				loop(sprite,system,bitmap);
				
			}
		});
		
		
//		System.out.println(bitmap.globalToLocal(new Vector2(120, 120)));	
		
		//bitmap.rotation-=45;
		//System.out.println(bitmap.getBound(bitmap));
		//System.out.println(bitmap.getBound(bitmap.stage));
		
		//System.out.println(bitmap.localToGlobal(new Vector2(200, 200)));

	}

	protected static void loop(Sprite sprite, RenderSystem system, Bitmap bitmap) {
		
	
		//sprite.x+=5;
		//sprite.rotation--;
		sprite.alpha=0.5;
		

		//sprite.setWidth(sprite.getWidth()+10);

		//sprite.setScaleX(sprite.getScaleX()+0.01);

		
		//System.out.println(sprite.getWidth());
		//System.out.println(bitmap.getBound(bitmap.stage));
		
		
		
		system.render();
		
		
		
	}
}
