package JGame.RenderSystem.Canvas;

import JGame.RenderSystem.Display.Calculation.Transform;
import JGame.RenderSystem.Render.RenderData;
import JGame.RenderSystem.Textures.Texture;

public interface Canvas {

	/**
	 * draw texture to screen
	 * @param texture
	 * @param renderData
	 */
	void drawTexture(Texture texture, RenderData renderData);

	/**
	 * called before render
	 */
	void preRender();

	/**
	 * called after render
	 */
	void postRender();

}
