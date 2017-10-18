package JCat.Event;

public class Event {

	

	/**
	 * a object is removed from a container
	 */
	public static final String REMOVE = "Removed";


	/**
	 * a object is added to a container
	 */
	static public final String ADD="Added";

	/**
	 * 
	 */
	public static final String UPDATE = "update";
	
	
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
	 * copy the data in to the event
	 */
	protected void defaultClone(Event event)
	{
		
		event.bubbles=bubbles;
		event.type=type;
		event.currentTarget=currentTarget;
		event.target=target;
		event.isStop=isStop;
		event.eventPhase=eventPhase;
		
	}
	
	/**
	 * clone the event,in the implemention you need to call defaultClone
	 */
	public Event clone()
	{
		Event event=new Event(type);
		defaultClone(event);
		return event;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
	 
	
	
}
