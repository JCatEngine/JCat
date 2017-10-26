package JCat.Display.MovieClip;

import JCat.Interaction.InteractiveObject;

public abstract class AnimeGroup extends InteractiveObject{
	
	/**
	 *play child anime by name,be notice 
	 * @param labelName
	 * 
	 */		
	public abstract void playAnime(String name);
	
	
	
	/**
	 *
	 */
	public abstract AnimeClip getCurrentClip();
	
	
	
	/**
	 * 
	 */
	public abstract int childAnimeCount();
	
	
	 /**
	  *
	  * 
	  */		
	 public abstract void stopCurrentAnime();
	
		

}
