package JCat.Event;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Event {

	/**
	 * the type of the event
	 */
	 String type;
	 /**
	  * the current Object that has listener to deal with this event
	  */
	 Object currentTarget;
	 /**
	  * event phase
	  */
	 EventPhase eventPhase;
	 /**
	  * the object who send the event
	  */
	 Object target;
	 /**
	  * Is this a bubbling event?
	  */
	 boolean bubbles;
	 
	 /**
	  * is the event has stop?
	  */
	 boolean isStop=false;
	 
	 /**
	  * 
	  * @param type
	  */
	 public Event(String type)
	 {
		 this(type,false);
	 }
	 
	 /**
	  * 
	  * @param type
	  * @param bubbles
	  */
	 public Event(String type,boolean bubbles)
	 {
		 this.type=type;
		 this.bubbles=bubbles;
	 }
	 
	 /**
	  * stop the event flow,you should konw three event phase first before call this function
	  * for example,if you want stop a event flow just in the bubbling phase
	  * if(eventPhase==EventPhase.BUBBLING_PHASE)
	  * { event.stopFlow();
	  * }
	  * 
	  */
	 public void stopFlow()
	 {
		 isStop=true;
	 }

	@Override
	public String toString() {
		return "Event [" + (type != null ? "type=" + type + ", " : "")
				+ (currentTarget != null ? "currentTarget=" + currentTarget + ", " : "")
				+ (eventPhase != null ? "eventPhase=" + eventPhase + ", " : "")
				+ (target != null ? "target=" + target + ", " : "") + "bubbles=" + bubbles + ", isStop=" + isStop + "]";
	}

	public String getType() {
		return type;
	}

	public Object getCurrentTarget() {
		return currentTarget;
	}

	public EventPhase getEventPhase() {
		return eventPhase;
	}

	public Object getTarget() {
		return target;
	}

	public boolean isBubbles() {
		return bubbles;
	}

	 
	/**
	 * clone a event
	 */
	public Event clone()
	{
		
		Object object = null;
		Class<?> class1=this.getClass();
		try {
			Constructor<?> constructor=class1.getConstructor(String.class);
			 object=constructor.newInstance(type);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Event event=(Event) object;
		event.bubbles=bubbles;
		event.currentTarget=currentTarget;
		event.target=target;
		event.isStop=isStop;
		event.eventPhase=eventPhase;
		
		return event;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
	 
	
	
}
