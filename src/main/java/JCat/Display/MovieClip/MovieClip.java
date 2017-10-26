package JCat.Display.MovieClip;

import java.util.HashMap;
import java.util.Map;

import JCat.Display.AnchorAble;
import JCat.Display.Texture;
import JCat.Display.Calculation.Bound;
import JCat.Event.Event;
import JCat.Event.EventListener;
import JCat.Interaction.InteractiveObject;
import JCat.Utils.MathTool;


/**
 * a object can change texture dynamicly,and can contain a couple of animations
 * @author Administrator
 *
 */
public class MovieClip extends AnimeGroup implements AnchorAble{
	
	private Map<String, FrameAnimeClip> datas=new HashMap<>();
	private FrameAnimeClip nowAnime;
	
	public MovieClip()
	{
		
		this.addEventListener(Event.UPDATE, new EventListener() {
			
			@Override
			public void onResponce(Event event) {
				updateFrame();
				
			}
		});
		
	}
	
	
	protected void updateFrame() {	
		if(nowAnime!=null)
		{
			nowAnime.update();	
			
			Texture texture=getTexture();
			width=texture.getWidth();
			height=texture.getHeight();
		}		
	}
	
	/**
	 * play anime
	 * @param name
	 */
	public void playAnime(String name) 
	{
		nowAnime=datas.get(name);
		nowAnime.gotoAndPlay(1);
		
	}


	public void addAnime(FrameAnimeClip data)
	{
		datas.put(data.getName(), data);
	}
	
	
	
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return nowAnime.getTexture();
	}


	@Override
	protected void updateLocalBound() {
		
		//for displayobject,bound is base on origin width,height,and rotation,scale
		Bound bound=new Bound();
		localBound=bound;
		
		if(nowAnime!=null)
		{
			//localbound x,y always is 0
			bound.minX=0;
			bound.minY=0;
			bound.maxX=width+bound.minX;
			bound.maxY=height+bound.minY;
			
			
		}
		
		
	}

	/**
	 * anchor the rotate center
	 * 0,0 equal left-top corner of the object
	 * 1,1 equal right-down corner of the object
	 */
	protected double anchorX;
	protected double anchorY;


	public double getAnchorX() {
		return anchorX;
	}


	public void setAnchorX(double anchorX) {
		MathTool.checkRange(0, 1, anchorX);
		this.anchorX = anchorX;
	}


	public double getAnchorY() {
		return anchorY;
	}


	public void setAnchorY(double anchorY) {
		MathTool.checkRange(0, 1, anchorY);
		this.anchorY = anchorY;
	}
	
	
	/**
	 * return the width before any rotate and scale
	 * @return
	 */
	public double getRawWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	/**
	 * return the height before any rotate and scale
	 * @return
	 */
	public double getRawHeight() {
		// TODO Auto-generated method stub
		return height;
	}


	@Override
	public AnimeClip getCurrentClip() {
		
		return nowAnime;
	}


	@Override
	public int childAnimeCount() {
		
		return datas.size();
	}


	@Override
	public void stopCurrentAnime() {
		if(nowAnime!=null)
		{
			nowAnime.stop();
		}
		
	}
	
	
	
}
