package Example.Basic;

import JCat.RenderSystem;
import JCat.Display.Bitmap;
import JCat.Display.Texture;
import JCat.Utils.Loader;
import JCat.Utils.Loader.onAchieveListener;

public class Slice {
	public static void main(String[] args) {
		Loader loader=new Loader();
		loader
		.add("resources\\move.png")
		.start(new onAchieveListener() {

			@Override
			public void onAchieve(Loader loader) {
				
				loadAchieve();
			}

			
		});
	}

	protected static void loadAchieve() {
		RenderSystem system=new RenderSystem(800, 600);
		//slice it
		system.getImageManager().sliceTexture("move",3,2);
		//the slice will be auto rename
		Texture slice1=system.getImageManager().getTextureByName("move00");
		Bitmap bitmap=new Bitmap(slice1);
		Texture slice2=system.getImageManager().getTextureByName("move10");
		Bitmap bitmap2=new Bitmap(slice2);
		bitmap2.x=100;
		Texture slice3=system.getImageManager().getTextureByName("move20");
		Bitmap bitmap3=new Bitmap(slice3);
		bitmap3.x=200;
		
		system.getStage().addChildAll(bitmap,bitmap2,bitmap3);
		
		
	}
}
