package Example.Basic;

import JCat.RenderSystem;
import JCat.Display.Bitmap;
import JCat.Display.Texture;
import JCat.Display.MovieClip.MovieClip;
import JCat.Event.Event;
import JCat.Event.EventListener;
import JCat.Manager.TextureManager;
import JCat.Utils.Loader;
import JCat.Utils.Loader.onAchieveListener;

public class Loaddgsb {
public static void main(String[] args) {
		
		Loader loader=new Loader();
		loader
		.add("resources\\1234.dgsb")
		.start(new onAchieveListener() {

			@Override
			public void onAchieve(Loader loader) {
				
				loadAchieve();
			}
		});
	}

	protected static void loadAchieve() {
		
		
		
		RenderSystem system=new RenderSystem(800, 600);
		MovieClip movieClip=new MovieClip();
		movieClip.addAnime(TextureManager.getInstance().getAnimeclipByName("moveanime0"));
		
		movieClip.x=system.getStage().getStageWidth()/2;
		movieClip.y=system.getStage().getStageHeight()/2;
		
		movieClip.setAnchorX(0.5);
		movieClip.setAnchorY(0.5);
	
		
		movieClip.playAnime("moveanime0");
		
		
		system.getStage().addChildAll(movieClip);
		
		
		
	}
}
