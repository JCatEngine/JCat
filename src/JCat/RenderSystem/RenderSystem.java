package JCat.RenderSystem;


import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

import JCat.RenderSystem.Canvas.Canvas;
import JCat.RenderSystem.Canvas.CanvasType;
import JCat.RenderSystem.Canvas.SwingCanvas;
import JCat.RenderSystem.Display.Bitmap;
import JCat.RenderSystem.Display.DisplayObject;
import JCat.RenderSystem.Display.DisplayObjectContainer;
import JCat.RenderSystem.Display.EventDispatcher;
import JCat.RenderSystem.Display.Stage;
import JCat.RenderSystem.Manager.TextureManager;
import JCat.RenderSystem.Render.RenderData;
import JCat.RenderSystem.Render.Renderer;
import JCat.RenderSystem.Textures.Texture;

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
	
		renderer.render(root,canvas);

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
