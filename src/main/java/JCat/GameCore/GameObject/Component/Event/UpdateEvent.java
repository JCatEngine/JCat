package JCat.GameCore.GameObject.Component.Event;

public class UpdateEvent extends AbstractEvent{

	public UpdateEvent() {
		setType(EventType.UPDATE);
	}
}
