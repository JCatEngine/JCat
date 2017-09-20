package JGame.RenderSystem.Display;

import JGame.RenderSystem.Textures.Texture;

public class Bitmap extends DisplayObject{

	private Texture texture;

	public Bitmap(Texture texture) {
		this.texture=texture;
		width=texture.getWidth();
		height=texture.getHeight();
	}

	public Texture getTexture() {
		// TODO Auto-generated method stub
		return texture;
	}

	

}
