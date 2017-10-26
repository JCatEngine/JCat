package Example.Basic;

import JCat.RenderSystem;
import JCat.Display.Texture;
import JCat.Display.MovieClip.FrameAnimeClip;
import JCat.Display.MovieClip.FrameMovieClip;
import JCat.Utils.ImageLoader;
import JCat.Utils.ImageLoader.onAchieveListener;

public class PlayAnimation2 {
	public static void main(String[] args) {
		ImageLoader loader=new ImageLoader();
		loader
		.add("resources\\move.png")
		.start(new onAchieveListener() {

			@Override
			public void onAchieve(ImageLoader loader) {
				
				loadAchieve();
			}

			
		});
	}

	protected static void loadAchieve() {
		RenderSystem system=new RenderSystem(800, 600,20);
		system.getImageManager().sliceTexture("move",3,2);
		Texture texture1=system.getImageManager().getTextureByName("move00");
		Texture texture2=system.getImageManager().getTextureByName("move10");
		Texture texture3=system.getImageManager().getTextureByName("move20");
		
		FrameAnimeClip animation=new FrameAnimeClip("move",6);
		animation.insertFrame(1, texture1);
		animation.insertFrame(3, texture2);
		animation.insertFrame(5, texture3);
		
		
		FrameMovieClip movieClip=new FrameMovieClip();
		movieClip.addAnime(animation);
		
		movieClip.x=system.getStage().getStageWidth()/2;
		movieClip.y=system.getStage().getStageHeight()/2;
		
		movieClip.setAnchorX(0.5);
		movieClip.setAnchorY(0.5);
	
		
		movieClip.playAnime("move");
		
		system.getStage().addChild(movieClip);
		
		
	}
}
