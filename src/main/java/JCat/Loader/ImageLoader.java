package JCat.Loader;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import JCat.RenderSystem;
import JCat.Manager.TextureManager;
import JCat.Textures.Texture;

public class ImageLoader {

	
	public interface onAchieveListener
	{
		public void onAchieve(ImageLoader loader);
	}
	
	private TextureManager cache;
	
	private LinkedList<String> paths=new LinkedList<>();
	
	private onAchieveListener listener;
	
	private boolean isRunning=false;

	public ImageLoader(RenderSystem system) {
		this.cache=system.getImageManager();
	}

	public ImageLoader add(String path) {
		
		if(isRunning)
		{
			throw new RuntimeException("a loader only can start once,please use a new loader");
		}
		
		this.paths.add(path);
		
		return this;
		
	}

	
	/**
	 * start load
	 */
	public void start(onAchieveListener listener) {
		
		if(isRunning)
		{
			throw new RuntimeException("a loader only can start once,please use a new loader");
		}
		
		this.listener=listener;
		this.isRunning=true;
		
		new Thread()
		{
			@Override
			public void run() 
			{
				
				//check the target image is not in the imageCache
				for (String path : paths) {
					
					checkPathExist(path);
					if(cache.getTextureByPath(path)==null)
					{
						
						try {
							Image image=ImageIO.read(new File(path));
							Texture texture=new Texture(image);
							cache.addToCache(texture,path);
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
				
				listener.onAchieve(ImageLoader.this);
				
				
			}
		}.start();
		
	}

	protected void checkPathExist(String path) {
		File file=new File(path);
		if(!file.exists())
		{
			throw new RuntimeException("the path "+path+" don't exist");
		}
		
	}

}
