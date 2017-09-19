package JGame.RenderSystem;


import java.sql.Time;

import JGame.Common.Ticker;
import JGame.GameCore.GameObject.Component.Event.UpdateEvent;
import JGame.Manager.EventManager;
import JGame.Manager.GameObjectManager;
import JGame.Manager.LoopManager;
import JGame.Manager.InputManager.InputManager;
import JGame.Manager.LoopManager.OnResponceListener;
import JGame.Render.RenderManager;
import JGame.RenderSystem.Canvas.Canvas;
import JGame.RenderSystem.Canvas.CanvasType;
import JGame.RenderSystem.Canvas.SwingCanvas;
import JGame.RenderSystem.Display.DisplayObject;
import JGame.RenderSystem.Display.EventDispatcher;
import JGame.RenderSystem.Display.Stage;
import JGame.RenderSystem.Render.Renderer;

public class RenderSystem {

	/**
	 * draw texture on canvas
	 */
	private Canvas canvas;
	
	/**
	 * ticker
	 */
	private Ticker ticker;
	
	/**
	 * root displayobject
	 */
	private Stage root;
	
	
	private Renderer renderer;


	
	public RenderSystem(int width, int height, int frameRate,CanvasType type) 
	{
		
		this.root=new Stage();
		
		this.ticker=new Ticker();

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

	
	public RenderSystem(int width, int height, int frameRate) {
		
		//use swing as default canvas
		this(width,height,frameRate,CanvasType.swing);
		
	}


	/**
	 * 主循环
	 */
	protected void mainLoop() {	
		
		
		
	}


	public Canvas getCanvas() {
		return canvas;
	}


	public Ticker getTicker() {
		return ticker;
	}


	public Stage getRoot() {
		return root;
	}


	public Renderer getRenderer() {
		return renderer;
	}

	
	
}
