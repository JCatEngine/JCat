package JCat.Event;

public class UpdateEvent extends Event {

	public UpdateEvent() {
		super(Event.UPDATE);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Event clone() {
		UpdateEvent event=new UpdateEvent();
		defaultClone(event);
		return event;
	}

}
