package JGame.RenderSystem;


import JGame.RenderSystem.Canvas.Canvas;
import JGame.RenderSystem.Canvas.CanvasType;
import JGame.RenderSystem.Canvas.SwingCanvas;
import JGame.RenderSystem.Display.Stage;
import JGame.RenderSystem.Render.Renderer;

public class RenderSystem {

	/**
	 * draw texture on canvas
	 */
	private Canvas canvas;
	
	
	/**
	 * root displayobject
	 */
	private Stage root;
	
	
	private Renderer renderer;


	
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
	 * 主循环
	 */
	protected void mainLoop() {	
		
		
		
	}


	
	/**
	 * render once
	 */
	public void render()
	{
		
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

	
	
}
