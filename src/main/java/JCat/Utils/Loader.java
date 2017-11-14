package JCat.Utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import JCat.Manager.ResourceManager;
import JCat.Platform.Texture.SwingTexture;

public class Loader {

	
	public interface onAchieveListener
	{
		public void onAchieve(Loader loader);
	}
	
	private ResourceManager cache;
	
	private LinkedList<String> paths=new LinkedList<>();
	
	private onAchieveListener listener;
	
	private boolean isRunning=false;

	public Loader() {
		this.cache=ResourceManager.getInstance();
	}

	public Loader add(String path) {
		
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
					//load data file
					if(path.endsWith("dgsb"))
					{
						new Parser(Loader.this).parse(path);
					}
					//load normal image
					else
					{
						if(cache.getTextureByPath(path)==null)
						{
							
							try {
								BufferedImage image=ImageIO.read(new File(path));
								SwingTexture texture=new SwingTexture(image);
								cache.addToCache(texture,path,true);
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}
					
					
				}
				
				listener.onAchieve(Loader.this);
				
				
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
