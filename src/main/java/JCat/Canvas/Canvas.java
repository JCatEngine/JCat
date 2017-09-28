package JCat.Canvas;

import JCat.Display.Calculation.Transform;
import JCat.Render.RenderData;
import JCat.Textures.Texture;

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
