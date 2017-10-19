package JCat.Display.MovieClip;

import JCat.Utils.MathTool;

public abstract class AnimeClip {
	
	/**
	 * check LastFrame
	 * @return 
	 * 
	 */		
	public boolean isLastFrame()
	{
		
		return getCurrentFrame()==getTotalFrames();
		
	}
	
	
	/**
	 *currentFrame
	 * @return 
	 * 
	 */		
	public abstract int getCurrentFrame();
	
	
	/**
	 *stop play
	 * @return 
	 * 
	 */		
	public abstract void stop();
	
	
	/**
	 * start play
	 * @return 
	 * 
	 */
	public abstract void play();
	
	
	/**
	 * get totalframes
	 */
	public abstract int getTotalFrames();
	
	/**
	 * 
	 * @param index
	 */
	public void gotoAndPlay(int index)
	{
		checkIndex(1,getTotalFrames(),index);
		gotoAndStop(index);
		play();
	}
	
	
	protected void checkIndex(int min, int max, int value) {
		MathTool.checkRange(min, max, value);
		
	}


	/**
	 * 
	 * @param index
	 */
	public abstract void gotoAndStop(int index);
	
	/**
	 * 
	 * @param index
	 */
	public void nextFrame()
	{
		int i=(int) MathTool.restrictRange(1, getTotalFrames(), getCurrentFrame()+1);
		gotoAndPlay(i);
		
	}
	
	/**
	 * 
	 * @param index
	 */
	public void prevFrame()
	{
		int i=(int) MathTool.restrictRange(1, getTotalFrames(), getCurrentFrame()-1);
		gotoAndPlay(i);
		
	}
	
	
	
}
