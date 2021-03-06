package JCat.Display.MovieClip;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import JCat.Display.Texture;

/**
 * FrameAnimeClip,which depend on a couple of frame
 * @author Administrator
 *
 */
public class FrameAnimeClip extends AnimeClip {

	public FrameAnimeClip(String name, int maxFrame) {
		super(name, maxFrame);
		// TODO Auto-generated constructor stub
	}

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
	 * frames
	 */
	private List<Frame> frames=new ArrayList<>();
	
	
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



	

	
		
		
	

	

	

}
