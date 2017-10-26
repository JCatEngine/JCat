package Example.Basic;

import JCat.RenderSystem;
import JCat.Display.Bitmap;
import JCat.Display.Sprite;
import JCat.Display.Texture;
import JCat.Display.MovieClip.FrameAnimeClip;
import JCat.Display.MovieClip.MovieClip;
import JCat.Event.Event;
import JCat.Event.EventListener;
import JCat.Utils.ImageLoader;
import JCat.Utils.ImageLoader.onAchieveListener;

public class PlayAnimation {
	public static void main(String[] args) {
		ImageLoader loader=new ImageLoader();
		loader
		.add("resources\\testAnime1.png")
		.add("resources\\testAnime2.png")
		.add("resources\\testAnime3.png")
		.add("resources\\testAnime4.png")
		.start(new onAchieveListener() {

			@Override
			public void onAchieve(ImageLoader loader) {
				
				loadAchieve();
			}

			
		});
	}

	protected static void loadAchieve() {
		RenderSystem system=new RenderSystem(800, 600);
		Texture texture1=system.getImageManager().getTextureByName("testAnime1");
		Texture texture2=system.getImageManager().getTextureByName("testAnime2");
		Texture texture3=system.getImageManager().getTextureByName("testAnime3");
		Texture texture4=system.getImageManager().getTextureByName("testAnime4");
		
		FrameAnimeClip animation=new FrameAnimeClip("simpleAnimation", 16);
		animation.insertFrame(1, texture1);
		animation.insertFrame(5, texture2);
		animation.insertFrame(9, texture3);
		animation.insertFrame(13, texture4);
		
		//System.out.println(animation.getTexture(3)==texture2);
		
		MovieClip movieClip=new MovieClip();
		movieClip.addAnime(animation);
		
		movieClip.x=system.getStage().getStageWidth()/2;
		movieClip.y=system.getStage().getStageHeight()/2;
		
		movieClip.setAnchorX(0.5);
		movieClip.setAnchorY(0.5);
	
		
		movieClip.playAnime("simpleAnimation");
		
		system.getStage().addChild(movieClip);
		
		
	}
}
