package JCat.Display.MovieClip;

import JCat.Utils.MathTool;

/**
 * change texture 
 * @author Administrator
 *
 */
public abstract class AnimeClip {
	
	/**
	 * name of the anime
	 */
	protected String name;
	/**
	 * max frame
	 */
	protected int maxFrame;
	/**
	 * whether stop
	 */
	protected boolean stop;
	/**
	 * currentframe
	 */
	protected int currentFrame=1;

	public AnimeClip(String name,int maxFrame) {
		this.name = name;
		this.maxFrame = maxFrame;
	}
	
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
	 * update, auto called every frame
	 */
	void update()
	{
		if(!stop)
		{
			currentFrame++;
			if(currentFrame>getTotalFrames())
			{
				currentFrame=1;
			}
		}	
	}
	
	/**
	 * return current frame
	 * @return
	 */
	public int getCurrentFrame() {
		// TODO Auto-generated method stub
		return currentFrame;
	}


	/**
	 * stop update
	 */
	public void stop() {
		
		stop=true;
		
	}


	/**
	 * start play
	 */
	public void play() {
		stop=false;
		
	}


	/**
	 * return total frames
	 * @return
	 */
	public int getTotalFrames() {
		// TODO Auto-generated method stub
		return maxFrame;
	}

	/**
	 * goto and stop
	 * @param index
	 */
	public void gotoAndStop(int index) {
		checkIndex(1, getTotalFrames(),index);
		this.currentFrame=index;
		stop=true;
		
	}
	
	/**
	 * goto and play
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxFrame() {
		return maxFrame;
	}

	public void setMaxFrame(int maxFrame) {
		this.maxFrame = maxFrame;
	}
	
	
	
}
