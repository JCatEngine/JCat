package Example.Basic;

import JCat.RenderSystem;
import JCat.Display.Texture;
import JCat.Display.MovieClip.FrameAnimeClip;
import JCat.Display.MovieClip.FrameMovieClip;
import JCat.Display.MovieClip.SliceAnimeClip;
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
		RenderSystem system=new RenderSystem(800, 600);
		Texture texture1=system.getImageManager().getTextureByName("move");
		//slice it
		system.getImageManager().sliceTexture("move",3,2);
		
//		SliceAnimeClip sliceClip=new SliceAnimeClip(3,2,"move",6,texture1);
//		sliceClip.setClice(1,0,0);
//		sliceClip.setClice(3,1,0);
//		sliceClip.setClice(5,2,0);
		
		//System.out.println(animation.getTexture(3)==texture2);
		
		FrameMovieClip movieClip=new FrameMovieClip();
		movieClip.addAnime(animation);
		
		movieClip.x=system.getStage().getStageWidth()/2;
		movieClip.y=system.getStage().getStageHeight()/2;
		
		movieClip.setAnchorX(0.5);
		movieClip.setAnchorY(0.5);
	
		
		movieClip.playAnime("simpleAnimation");
		
		system.getStage().addChild(movieClip);
		
		
	}
}
