package JCat.Manager;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import JCat.Display.Texture;

/**
 * a instace,used to cache image
 * @author Administrator
 *
 */
public class TextureManager {

	private static TextureManager instance;


	static public TextureManager getInstance()
	{
		if(instance==null)
		{
			instance=new TextureManager();
		}
		return instance;
	}
	
	
	/**
	 * instace class
	 */
	private TextureManager() {
		// TODO Auto-generated constructor stub
	}
	
	private class TextureData
	{
		public Texture texture;
		public String name;
		public String path;
		
	}
	
	private LinkedList<TextureData> caches=new LinkedList<>();

	
	/**
	 * try get a texture from cache,by it load path
	 * @param path
	 * @return
	 */
	public Texture getTextureByPath(String path) {
		
		List<TextureData> list=caches.stream().filter(t->t.path.equals(path)).collect(Collectors.toList());
		
		return list.size()==1?list.get(0).texture:null;
	}

	
	/**
	 * 
	 * @param texture
	 * @param name
	 * @param isPath
	 */
	public void addToCache(Texture texture, String name,boolean isPath) {
		
		TextureData textureData=new TextureData();
		textureData.texture=texture;
		if(isPath)
		{
			textureData.path=name;
			textureData.name=pathToName(name);
		}
		else
		{
			textureData.name=name;
		}
		
		caches.add(textureData);
		
	}
	
	private String pathToName(String path) {
		
		String[] strings=path.split("\\\\");
		
		String aString=strings[strings.length-1];
		
		
		String[] strings2=aString.split("\\.");
		
		String result=strings2[0];
		
		return result;
	}

	/**
	 * try get a texture from cache,by it name
	 * @param name
	 * @return
	 */
	public Texture getTextureByName(String name)
	{
		List<TextureData> list=caches.stream().filter(t->t.name.equals(name)).collect(Collectors.toList());
		
		return list.size()==1?list.get(0).texture:null;
	}
	
	/**
	 * releaseAll cache,it's used when you enter a level and do not need previous resources anymore
	 */
	public void releaseAll()
	{
		caches.clear();
	}

	
	/**
	 * slice texture to sub texture,and auto renameIt,add it to cache
	 * @param name texture name
	 * @param xAmount
	 * @param yAmount
	 */
	public void sliceTexture(String name, int xAmount, int yAmount) {
		
		Texture texture=getTextureByName(name);
		if(texture==null)
		{
			throw new RuntimeException(name+" texture isn't exist!");
		}
		
		int partWidth=texture.getWidth()/xAmount;
		int partHeight=texture.getHeight()/yAmount;
		
		for(int x=0;x<xAmount;x++)
		{
			for(int y=0;y<yAmount;y++)
			{
				int xPos=x*partWidth;
				int yPos=y*partHeight;
				String autoNewName=name+x+y;
				
				sliceTexture(name,xPos,yPos,partWidth,partHeight,autoNewName);
			}
		}
		
		
		
		
	}


	/**
	 * slice texture(be notice the sub texture can't be search by path,because it's do not have a path
	 * only the mainTexture can be searched by path)
	 * @param name
	 * @param xPos
	 * @param yPos
	 * @param partWidth
	 * @param partHeight
	 * @param newName
	 */
	public void sliceTexture(String name, int xPos, int yPos, int partWidth, int partHeight, String newName) {
		Texture texture=getTextureByName(name);
		if(texture==null)
		{
			throw new RuntimeException(name+" texture isn't exist!");
		}
		
		Texture newTexture=texture.subTexture(xPos,yPos,partWidth,partHeight);
		addToCache(newTexture,newName,false);
		
	}

}
