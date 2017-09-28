package JCat.Interaction;





import JCat.RenderSystem;
import JCat.Canvas.Canvas;
import JCat.Event.EventManager;
import JCat.Event.KeyEvent;
import JCat.Event.MouseEvent;
import JCat.Math.Vector2;

public class InteractionManager {

	private Canvas canvas;
	private RenderSystem renderSystem;

	public InteractionManager(RenderSystem renderSystem) {
	
		this.renderSystem=renderSystem;
		this.canvas=renderSystem.getCanvas();
		addListeners();
	}

	/**
	 * add listener
	 */
	private void addListeners() {
	
		canvas.addKeyListener(new CanvasKeyListener() {
			
			@Override
			public void keyUp(CanvasKeyEvent event) {
				
				//create keyEvent and send to all object in the main display tree
				KeyEvent keyEvent=createKeyEvent(event,KeyEvent.KEY_UP);
				EventManager.boardCast(renderSystem.getStage(), keyEvent);
				
			}
			
			@Override
			public void keyDown(CanvasKeyEvent event) {
				
				//create keyEvent and send to all object in the main display tree
				KeyEvent keyEvent=createKeyEvent(event,KeyEvent.KEY_DOWN);
				EventManager.boardCast(renderSystem.getStage(), keyEvent);
				
			}
		});
		
		canvas.addMouseListener(new CanvasMouseListener() {
			
			@Override
			public void mouseUp(CanvasMouseEvent event) {
				
				MouseEvent mouseEvent=createMouseEvent(event,MouseEvent.MOUSE_UP);
				
			}
			
			@Override
			public void mouseDown(CanvasMouseEvent event) {
				
				MouseEvent mouseEvent=createMouseEvent(event,MouseEvent.MOUSE_DOWN);
				
			}
		});
		
	}

	protected MouseEvent createMouseEvent(CanvasMouseEvent event, String type) {
		
		MouseEvent mouseEvent=new MouseEvent(type);
		mouseEvent.globalX=event.x;
		mouseEvent.globalY=event.y;
		
		Vector2 vector2=new Vector2(event.x, event.y);
		//recursive check which child object hitTest it
		
		
		return null;
	}

	/**
	 * create key event from canvaskeyevent
	 * @param event
	 * @param type
	 * @return
	 */
	protected KeyEvent createKeyEvent(CanvasKeyEvent event, String type) {
	
		KeyEvent keyEvent=new KeyEvent(type);
		keyEvent.keyCode=event.keycode;
		
		return keyEvent;
	}

}
