package JCat.Manager;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import JCat.Textures.Texture;

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
	 * @param path
	 */
	public void addToCache(Texture texture, String path) {
		
		TextureData textureData=new TextureData();
		textureData.texture=texture;
		textureData.path=path;
		textureData.name=pathToName(path);
		
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

}
