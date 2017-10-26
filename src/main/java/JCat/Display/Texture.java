package JCat.Display;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Texture {

	private BufferedImage image;

	public Texture(BufferedImage image) {
		this.image = image;
		
	}

	public Image getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return image.getWidth(null);
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return image.getHeight(null);
	}

	/**
	 * get sub texture
	 * @param xPos
	 * @param yPos
	 * @param partWidth
	 * @param partHeight
	 * @return
	 */
	public Texture subTexture(int xPos, int yPos, int partWidth, int partHeight) {
		
		BufferedImage image=this.image.getSubimage(xPos, yPos, partWidth, partHeight);
		Texture texture=new Texture(image);
		
		return texture;
	}

}
