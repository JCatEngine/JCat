package JCat.Canvas;

import JCat.Display.Texture;
import JCat.Display.Text.FontStyle;
import JCat.Graphics.Color;
import JCat.Interaction.CanvasKeyListener;
import JCat.Interaction.CanvasMouseListener;
import JCat.Render.RenderData.TextureRenderData;
import JCat.Render.RenderData.TextRenderData;

/**
 * a canvas have ability to draw texture and receive origin event
 * @author Administrator
 *
 */
public interface Canvas {

	/**
	 * draw texture to screen
	 * @param texture
	 * @param renderData 
	 */
	void drawTexture(Texture texture, TextureRenderData renderData);

	/**
	 * called before render
	 */
	void preRender();

	/**
	 * called after render
	 */
	void postRender();
	/**
	 * 
	 */
	void addMouseListener(CanvasMouseListener listener);
	/**
	 * 
	 */
	void addKeyListener(CanvasKeyListener listener);
	/**
	 * draw default background,it's called before every time rendering
	 */
	void drawDefaultBackground(Color color);
	/**
	 * translate canvas
	 * @param x
	 * @param y
	 */
	void translate(double x, double y);
	/**
	 * rotation canvas,in radian
	 * @param d
	 */
	void rotate(double radian);

	/**
	 * 
	 * @param text
	 * @param renderData
	 */
	void drawText(String text, TextRenderData renderData);

	/**
	 * 
	 * @param fontName 
	 * @param style 
	 * @param fontSize 
	 * @param string
	 * @return
	 */
	double getStringWidth(String text, double fontSize, FontStyle style, String fontName);
	/**
	 * 
	 * @param text
	 * @param fontName 
	 * @param style 
	 * @param fontSize 
	 * @return
	 */
	double getStringHeight(String text, double fontSize, FontStyle style, String fontName);
}
