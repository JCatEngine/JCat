package JCat.Interaction;





import java.util.LinkedList;

import JCat.RenderSystem;
import JCat.Canvas.Canvas;
import JCat.Display.DisplayObject;
import JCat.Display.DisplayObjectContainer;
import JCat.Event.EventDispatcher;
import JCat.Event.EventManager;
import JCat.Event.KeyEvent;
import JCat.Event.MouseEvent;
import JCat.Math.Vector2;

/**
 * manager system interaction such as key event,mouse event
 * @author Administrator
 *
 */
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
				EventManager.dispatchEvent((EventDispatcher) mouseEvent.getTarget(), mouseEvent);
				
			}
			
			@Override
			public void mouseDown(CanvasMouseEvent event) {
				
		
				MouseEvent mouseEvent=createMouseEvent(event,MouseEvent.MOUSE_DOWN);
				EventManager.dispatchEvent((EventDispatcher) mouseEvent.getTarget(), mouseEvent);
			
				
			}
		});
		
	}

	/**
	 * create a mouse event
	 * @param event
	 * @param type
	 * @return
	 */
	protected MouseEvent createMouseEvent(CanvasMouseEvent event, String type) {
		
		MouseEvent mouseEvent=new MouseEvent(type,true);
		mouseEvent.globalX=event.x;
		mouseEvent.globalY=event.y;
		
		Vector2 vector2=new Vector2(event.x, event.y);
		
		//recursive check which child object hitTest it
		DisplayObject displayObject=renderSystem.getStage();
		
		while(true)
		{
			if(displayObject instanceof DisplayObjectContainer)
			{
				
				LinkedList<DisplayObject> linkedList=((DisplayObjectContainer)displayObject).getChilds();
				//through high z-order to low,consequently high z-order object will receive event
				//if part of a object cover by the high z-order object will not receive event
				for (int i = linkedList.size()-1; i >=0 ; i--) {
					DisplayObject object=linkedList.get(i);
					if(object.hitTestPoint(vector2))
					{
						displayObject=object;
						continue;
					}
				}
				
				//the container no child
				break;

			}
			else if(displayObject.hitTestPoint(vector2))
			{
				break;
				
			}
		}
		

		
		vector2=displayObject.getWorldTransform().applyInverse(vector2);
		mouseEvent.setTarget(displayObject);
		mouseEvent.localX=vector2.x;
		mouseEvent.localY=vector2.y;
		
		
		return mouseEvent;
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
