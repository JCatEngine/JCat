package JCat.Event;

import JCat.Display.DisplayObject;

public class RemovedEvent extends Event {

	private DisplayObject removedObject;

	public RemovedEvent(DisplayObject displayObject) {
		super(Event.REMOVE);
		// TODO Auto-generated constructor stub
		this.removedObject = displayObject;
	}

	@Override
	public RemovedEvent clone() {
		RemovedEvent removedEvent=new RemovedEvent(removedObject);
		defaultClone(removedEvent);
		return removedEvent;
	}

	public DisplayObject getRemovedObject() {
		return removedObject;
	}
	
	
	
}
