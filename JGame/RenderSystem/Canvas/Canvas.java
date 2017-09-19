package JGame.RenderSystem.Canvas;

import JGame.RenderSystem.Display.Calculation.Transform;
import JGame.RenderSystem.Textures.Texture;

public interface Canvas {

	/**
	 * draw texture to screen
	 * @param texture
	 * @param transform
	 */
	void drawTexture(Texture texture, Transform transform);

	void preRender();

	void postRender();

}
