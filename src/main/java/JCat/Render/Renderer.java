package JCat.Render;

import JCat.Canvas.Canvas;
import JCat.Display.AnchorAble;
import JCat.Display.Bitmap;
import JCat.Display.DisplayObject;
import JCat.Display.DisplayObjectContainer;
import JCat.Display.Stage;
import JCat.Display.Texture;
import JCat.Display.MovieClip.MovieClip;
import JCat.Display.Text.SimpleText;
import JCat.Event.EventManager;
import JCat.Event.PostRenderEvent;
import JCat.Event.PreRenderEvent;
import JCat.Graphics.Color;

public class Renderer {

	private ShapeRenderer shapeRenderer;
	private TextureRenderer textureRenderer;
	private TextRenderer textRenderer;

	public Renderer() {
		this.textRenderer = new TextRenderer();
		this.textureRenderer = new TextureRenderer();
		this.shapeRenderer = new ShapeRenderer();
	}

	/**
	 * render object tree to canvas
	 * 
	 * @param stage
	 * @param canvas
	 */
	public void render(Stage stage, Canvas canvas) {

		// dispatch event before render
		EventManager.boardCast(stage, new PreRenderEvent());

		// pre render state,canvas need to init sth
		canvas.preRender();

		// draw back ground color
		canvas.drawDefaultBackground(Color.ALICEBLUE);

		// start render object recursively
		renderObject(stage, canvas);

		// post render state,canvas need to clear sth
		canvas.postRender();

		// dispatch event after render
		EventManager.boardCast(stage, new PostRenderEvent());

	}

	/**
	 * render a object and it's child
	 * 
	 * @param displayObject
	 * @param canvas
	 */
	private void renderObject(DisplayObject displayObject, Canvas canvas) {
		// move to left-top corner(default zero point)
		canvas.translate(displayObject.x, displayObject.y);
		// move to anchor(only the bitmap support it..)
		double anchorX = 0.0;
		double anchorY = 0.0;
		// it the displayObject support anchor
		if (displayObject instanceof AnchorAble) {
			AnchorAble anchorAble = (AnchorAble) displayObject;
			anchorX = anchorAble.getAnchorX() * anchorAble.getRawWidth() * displayObject.getScaleX();
			anchorY = anchorAble.getAnchorY() * anchorAble.getRawHeight() * displayObject.getScaleY();
		}
		//translate to anchor point
		canvas.translate(anchorX, anchorY);
		// rotate
		canvas.rotate(displayObject.rotation / 180 * Math.PI);

		if (displayObject.visible) {

			// render bitmap
			if (displayObject instanceof Bitmap) {
				Bitmap bitmap = (Bitmap) displayObject;
				Texture texture = bitmap.getTexture();
				textureRenderer.render(bitmap, texture, anchorX, anchorY, canvas);

			}
			// render text
			else if (displayObject instanceof SimpleText) {
				SimpleText simpleText = (SimpleText) displayObject;
				textRenderer.render(simpleText,anchorX,anchorY,canvas);
			}

			// render the current frame of the movieclip
			else if (displayObject instanceof MovieClip) {
				MovieClip movieClip = (MovieClip) displayObject;
				Texture texture = movieClip.getTexture();
				textureRenderer.render(movieClip, texture, anchorX, anchorY, canvas);

			}

			// if it's a container,render it's childs
			else if (displayObject instanceof DisplayObjectContainer) {
				DisplayObjectContainer displayObjectContainer = (DisplayObjectContainer) displayObject;
				for (DisplayObject child : displayObjectContainer.getChilds()) {

					renderObject(child, canvas);

				}
			}
		}

		canvas.rotate(-displayObject.rotation / 180 * Math.PI);
		canvas.translate(-anchorX, -anchorY);
		canvas.translate(-displayObject.x, -displayObject.y);

	}

	

}
