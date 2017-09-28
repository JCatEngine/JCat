package JCat.Event;

import java.util.Stack;

import JCat.Display.DisplayObject;
import JCat.Display.Stage;

public class EventManager {

	/**
	 * dispatch a event
	 * @param eventDispatcher
	 * @param event
	 */
	static void dispatchEvent(EventDispatcher eventDispatcher, Event event) {
		
	
		event.target=eventDispatcher;
		
		//a bubbles event
		if(event.bubbles==true)
		{
			//check it is a sub-class of displayobject and in the main display tree
			if(!(eventDispatcher instanceof DisplayObject))
			{
				throw new RuntimeException("only event from DisplayObject can send bubble event");
			}
			else if(((DisplayObject)eventDispatcher).getStage()==null)
			{
				throw new RuntimeException("only DisplayObject in the main display tree can send bubble event");
			}
			else {
				
				_dispatchBubbleEvent((DisplayObject) eventDispatcher,event);
			}
			
		}
		//normal event
		else
		{
			//just send to the listenrs register in this object
			_sendEventTargetPhase(event,eventDispatcher);
			
		}
		
	}
	
	/**
	 * send this event to all object in the main dispay tree
	 * just used for system event,such as keyboard event or loop event
	 * @param event
	 */
	static void boardCast(Stage stage,Event event)
	{
		event.target=stage;
		event.eventPhase=EventPhase.AT_TARGET;
		
		
	}
	

	/**
	 * 
	 * @param event
	 * @param eventDispatcher
	 */
	private static void _sendEventTargetPhase(Event event, EventDispatcher eventDispatcher) {
		
		event.currentTarget=eventDispatcher;
		event.eventPhase=EventPhase.AT_TARGET;
		eventDispatcher.sendEventCurrentObject(event);
	}

	/**
	 * dispatch a bubble event
	 * @param eventDispatcher
	 * @param event
	 */
	private static void _dispatchBubbleEvent(DisplayObject object, Event event) {
		
		
		//the capture phase flow path
		Stack<DisplayObject> capturingStack=new Stack<>();
		//the bubbling phase flow path
		Stack<DisplayObject> bubblingStack=new Stack<>();
		
		//the path not inclued object 
		DisplayObject displayObject=object.getParent();
		
		//get the flow path first
		while(displayObject!=null)
		{
			capturingStack.add(displayObject);
			displayObject=displayObject.getParent();
		}
		
	
		//start capture phase
		while(!capturingStack.isEmpty())
		{
			//check whether event has stoped flow last time 
			if(event.isStop)
			{
				return;
			}
			
			DisplayObject currentTarget=capturingStack.pop();
			
			_sendEventCapturePhase(event, currentTarget);
			
			//add to bubbling Stack
			bubblingStack.add(currentTarget);
		}
		
		
		//the target phase
		_sendEventTargetPhase(event, object);
		
		
		while(!bubblingStack.isEmpty())
		{
			//check whether event has stoped flow last time 
			if(event.isStop)
			{
				return;
			}
			
			DisplayObject currentTarget=bubblingStack.pop();
		
			_sendEventBubblePhase(event, currentTarget);
		}
		
	}

	/**
	 * 
	 * @param event
	 * @param eventDispatcher
	 */
	private static void _sendEventCapturePhase(Event event, EventDispatcher eventDispatcher) {
	
		event.currentTarget=eventDispatcher;
		event.eventPhase=EventPhase.CAPTURING_PHASE;
		eventDispatcher.sendEventCurrentObject(event);
		
		
	}
	
	/**
	 * 
	 * @param event
	 * @param eventDispatcher
	 */
	private static void _sendEventBubblePhase(Event event, EventDispatcher eventDispatcher) {
	
		event.currentTarget=eventDispatcher;
		event.eventPhase=EventPhase.BUBBLING_PHASE;
		eventDispatcher.sendEventCurrentObject(event);
		
		
	}


}
