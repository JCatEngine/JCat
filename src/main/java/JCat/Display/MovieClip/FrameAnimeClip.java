package JCat.Display.MovieClip;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import JCat.Textures.Texture;

/**
 * FrameAnimeClip,which depend on a couple of frame
 * @author Administrator
 *
 */
public class FrameAnimeClip extends AnimeClip {

	public class Frame {

		public int index;
		public Texture texture;

		public Frame(int index, Texture texture) {
			this.index = index;
			this.texture = texture;
			// TODO Auto-generated constructor stub
		}

	}

	/**
	 * name of the anime
	 */
	private String name;
	/**
	 * frames
	 */
	private List<Frame> frames=new ArrayList<>();
	/**
	 * max frame
	 */
	private int maxFrame;
	private boolean stop;
	private int currentFrame=1;
	
	public FrameAnimeClip(String name,int maxFrame)
	{
		this.name = name;
		this.maxFrame=maxFrame;
		
	}
	
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
	

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
	/**
	 * insert one frame,the first frame must set index 1!
	 * @param index
	 * @param texture
	 */
	public void insertFrame(int index,Texture texture)
	{
		if(frames.size()==0&&index!=1)
		{
			throw new RuntimeException("the first inserted frame must set index 1");
		}
		Frame frame=new Frame(index,texture);
		frames.add(frame);
		frames.sort(Comparator.comparing(a->frame.index));
	}
	
	/**
	 * calculate the current texture based on the index
	 * @param currentFrame
	 * @return
	 */
		public Texture getTexture()
		{
			//just return first texture
			if(currentFrame==1)
			{
				return frames.get(0).texture;
			}
			//just return last
			else if(currentFrame>=frames.get(frames.size()-1).index)
			{
				return frames.get(frames.size()-1).texture;
			}
			//in the center area
			else
			{
				
				for(int i=0;i<frames.size();i++)
				{
					if(currentFrame<frames.get(i).index)
					{
						if(i-1<0)
						{
							throw new RuntimeException("invalid index");
						}
						
						return frames.get(i-1).texture;
					}
				}
			}
			
			throw new RuntimeException("invalid index "+currentFrame);
		}



	@Override
	public int getCurrentFrame() {
		// TODO Auto-generated method stub
		return currentFrame;
	}



	@Override
	public void stop() {
		
		stop=true;
		
	}



	@Override
	public void play() {
		stop=false;
		
	}



	@Override
	public int getTotalFrames() {
		// TODO Auto-generated method stub
		return maxFrame;
	}

	@Override
	public void gotoAndStop(int index) {
		checkIndex(1, getTotalFrames(),index);
		this.currentFrame=index;
		stop=true;
		
	}

	
		
		
	

	

	

}
