package Example.Basic;

import JCat.RenderSystem;
import JCat.Utils.ImageLoader;
import JCat.Utils.ImageLoader.onAchieveListener;

public class Basic {
	public static void main(String[] args) {
		RenderSystem system=new RenderSystem(600, 800);
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
		// TODO Auto-generated method stub
		
	}
	
}
