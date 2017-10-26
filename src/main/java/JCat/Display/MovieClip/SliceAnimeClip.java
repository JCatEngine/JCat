package JCat.Display.MovieClip;

import JCat.Display.Texture;

/**
 * mask texture
 * @author Administrator
 *
 */
public class SliceAnimeClip extends AnimeClip {

	private int partWidth;
	private int partHeight;



	public SliceAnimeClip(int xAmount, int yAmount, String name, int maxFrame, Texture texture) {
		super(name, maxFrame);
		this.xAmount = xAmount;
		this.yAmount = yAmount;
		this.texture = texture;
		
		this.partWidth=texture.getWidth();
		this.partHeight=texture.getHeight();
		
	}

	private int xAmount;
	private int yAmount;
	private Texture texture;

	
	
	
	public int getxAmount() {
		return xAmount;
	}

	public void setxAmount(int xAmount) {
		this.xAmount = xAmount;
	}

	public int getyAmount() {
		return yAmount;
	}

	public void setyAmount(int yAmount) {
		this.yAmount = yAmount;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	

	
	
	
}
