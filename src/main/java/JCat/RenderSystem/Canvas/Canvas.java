package JCat.RenderSystem.Canvas;

import JCat.RenderSystem.Display.Calculation.Transform;
import JCat.RenderSystem.Render.RenderData;
import JCat.RenderSystem.Textures.Texture;

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
