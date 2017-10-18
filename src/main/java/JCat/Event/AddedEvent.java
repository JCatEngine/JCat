package JCat.Event;

import JCat.Display.DisplayObject;

public class AddedEvent extends Event {

	DisplayObject addedObject;

	public AddedEvent(DisplayObject displayObject) {
		super(Event.ADD);
		// TODO Auto-generated constructor stub
		this.addedObject = displayObject;
	}

	/**
	 * get the added obejct
	 * @return
	 */
	public DisplayObject getAddedObject() {
		return addedObject;
	}
	
	
	@Override
	public AddedEvent clone() {
		AddedEvent event=new AddedEvent(addedObject);
		defaultClone(event);
		return event;
	}

	
}
