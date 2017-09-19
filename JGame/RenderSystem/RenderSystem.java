package JGame.RenderSystem;


import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

import JGame.RenderSystem.Canvas.Canvas;
import JGame.RenderSystem.Canvas.CanvasType;
import JGame.RenderSystem.Canvas.SwingCanvas;
import JGame.RenderSystem.Display.Bitmap;
import JGame.RenderSystem.Display.DisplayObject;
import JGame.RenderSystem.Display.DisplayObjectContainer;
import JGame.RenderSystem.Display.EventDispatcher;
import JGame.RenderSystem.Display.Stage;
import JGame.RenderSystem.Manager.TextureManager;
import JGame.RenderSystem.Render.Renderer;
import JGame.RenderSystem.Textures.Texture;

public class RenderSystem extends EventDispatcher{

	/**
	 * draw texture on canvas
	 */
	private Canvas canvas;
	/**
	 * root display object
	 */
	private Stage root;
	/**
	 * renderer
	 */
	private Renderer renderer;
	/**
	 * image manager
	 */
	private TextureManager imageManager=new TextureManager();


	
	public RenderSystem(int width, int height,CanvasType type) 
	{
		
		this.root=new Stage();

		this.renderer=new Renderer();
		
		if(type==CanvasType.swing)
		{

			this.canvas=new SwingCanvas(width, height);
		}
		else
		{
			throw new RuntimeException("unsupport canvas currently");
		}
		
	}

	
	public RenderSystem(int width, int height) {
		
		//use swing as default canvas
		this(width,height,CanvasType.swing);
		
	}


	/**
	 * render once
	 */
	public void render()
	{
		//dispatch event before render
		
		canvas.preRender();
		
		renderObject(root);
		
		canvas.postRender();
		
		//dispatch event after render

	}
	
	/**
	 * render a object and it's child
	 * @param displayObject
	 */
	private void renderObject(DisplayObject displayObject) 
	{

		//update its transform before render
		//the renderer needs the transform to render the texture
		displayObject.updateTransform();
		
		if(displayObject instanceof Bitmap)
		{
			Bitmap bitmap=(Bitmap) displayObject;
			Texture texture=bitmap.getTexture();
			
			//render the texture to screen
			canvas.drawTexture(texture,bitmap.getWorldTransform());
		}
		
		//if it's a container,render it's childs
		else if(displayObject instanceof DisplayObjectContainer)
		{
			DisplayObjectContainer displayObjectContainer=(DisplayObjectContainer) displayObject;
			for(DisplayObject child:displayObjectContainer.getChilds())
			{
				renderObject(child);
			}
		}
		
	
	}


	public Canvas getCanvas() {
		return canvas;
	}
	

	public Stage getStage() {
		return root;
	}


	public Renderer getRenderer() {
		return renderer;
	}


	public TextureManager getImageManager() {
		// TODO Auto-generated method stub
		return imageManager;
	}

	
	
}
