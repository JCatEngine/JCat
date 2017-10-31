package JCat.Platform.Texture;

import java.awt.Image;
import java.awt.image.BufferedImage;

import JCat.Display.Texture;

public class SwingTexture implements Texture {

	private BufferedImage image;

	public SwingTexture(BufferedImage image) {
		this.image = image;
		
	}

	/* (non-Javadoc)
	 * @see JCat.Display.Texture#getImage()
	 */
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	/* (non-Javadoc)
	 * @see JCat.Display.Texture#getWidth()
	 */
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return image.getWidth(null);
	}

	/* (non-Javadoc)
	 * @see JCat.Display.Texture#getHeight()
	 */
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return image.getHeight(null);
	}

	/* (non-Javadoc)
	 * @see JCat.Display.Texture#subTexture(int, int, int, int)
	 */
	@Override
	public SwingTexture subTexture(int xPos, int yPos, int partWidth, int partHeight) {
		
		BufferedImage image=this.image.getSubimage(xPos, yPos, partWidth, partHeight);
		SwingTexture texture=new SwingTexture(image);
		
		return texture;
	}

}
