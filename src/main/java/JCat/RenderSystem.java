package JCat;


import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

import JCat.Canvas.Canvas;
import JCat.Canvas.CanvasFactory;
import JCat.Canvas.CanvasType;
import JCat.Canvas.SwingCanvas;
import JCat.Display.Bitmap;
import JCat.Display.DisplayObject;
import JCat.Display.DisplayObjectContainer;
import JCat.Display.Stage;
import JCat.Event.EventDispatcher;
import JCat.Interaction.InteractionManager;
import JCat.Manager.TextureManager;
import JCat.Render.RenderData;
import JCat.Render.Renderer;
import JCat.Textures.Texture;

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
	/**
	 * interaction manager
	 */
	private InteractionManager interactionManager;


	
	public RenderSystem(int width, int height,CanvasType type) 
	{
		
		this.root=new Stage();

		this.renderer=new Renderer();
		
		this.canvas=CanvasFactory.getCanvas(type,width,height);
		
		this.interactionManager=new InteractionManager(this);
		
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
	


	/**
	 * get the canvas of the render system
	 * @return
	 */
	public Canvas getCanvas() {
		return canvas;
	}
	

	/**
	 * get the stage of the render system,stage is the root container
	 * @return
	 */
	public Stage getStage() {
		return root;
	}


	/**
	 * get the renderer
	 * @return
	 */
	public Renderer getRenderer() {
		return renderer;
	}


	/**
	 * getImageManager
	 * @return
	 */
	public TextureManager getImageManager() {
		// TODO Auto-generated method stub
		return imageManager;
	}

	
	
}
