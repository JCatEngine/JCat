package JCat.RenderSystem.Textures;

import java.awt.Image;

public class Texture {

	private Image image;

	public Texture(Image image) {
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

}
