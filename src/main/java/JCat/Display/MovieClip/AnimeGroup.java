package JCat.Display.MovieClip;

public interface AnimeGroup {
	
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
