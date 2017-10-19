package JCat;


import JCat.Canvas.Canvas;
import JCat.Canvas.CanvasFactory;
import JCat.Canvas.CanvasType;
import JCat.Display.Stage;
import JCat.Event.EventDispatcher;
import JCat.Event.EventManager;
import JCat.Event.UpdateEvent;
import JCat.Interaction.InteractionManager;
import JCat.Manager.TextureManager;
import JCat.Render.Renderer;
import JCat.Utils.MathTool;
import JCat.Utils.Ticker;
import JCat.Utils.Ticker.OnResponceListener;

/**
 * a simple class assemble a couple of sub system that let 
 * you make a application easily,but if you want more flexible control,
 * you can initial sub system and work with then manually
 * @author Administrator
 *
 */
public class RenderSystem extends EventDispatcher{

	private static final int DEFAULT_FRAMERATE = 60;
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
	 * interaction manager
	 */
	private InteractionManager interactionManager;
	/**
	 * the ticker will only by initial when input a frameRate param
	 */
	private Ticker ticker;
	
	
	/**
	 * set frameRate
	 * @return
	 */
	public int getFrameRate()
	{
		return (int) (1000.0/ticker.getDelay());
		
	}
	
	/**
	 * get frameRate
	 * @param frameRate
	 */
	public void setFrameRate(int frameRate) {
		
		ticker.setDelay(1000.0/frameRate);
		
	}

	/**
	 * create a render system au not auto-update
	 * @param width
	 * @param height
	 * @param type
	 */
	public RenderSystem(int width, int height,int frameRate,CanvasType type) 
	{
		
	
		this.root=new Stage(width,height);

		this.renderer=new Renderer();
		
		this.canvas=CanvasFactory.getCanvas(type,width,height);
		
		this.interactionManager=new InteractionManager(this);
		
		this.ticker=new Ticker(1000.0/frameRate);
		ticker.addListener(new OnResponceListener() {

			@Override
			public void onResponce() {
				EventManager.boardCast(root, new UpdateEvent());
				render();
				
			}
		});
		
	}
	
	/**
	 * create a render System
	 * @param width
	 * @param height
	 * @param frameRate
	 */
	public RenderSystem(int width, int height,int frameRate) 
	{
		this(width,height,frameRate,CanvasType.swing);
		MathTool.checkPositive(frameRate);
		MathTool.checkNonZero(frameRate);
	}

	
	


	public RenderSystem(int width, int height) {
		this(width, height, DEFAULT_FRAMERATE);
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
		return TextureManager.getInstance();
	}

	
	
}
