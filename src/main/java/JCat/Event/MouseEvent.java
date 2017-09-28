package JCat.Event;

public class MouseEvent extends Event {

	/**
	 * key up event
	 */
	static public String MOUSE_UP="mouseup";
	/**
	 * key down event
	 */
	static public String MOUSE_DOWN="mousedown";
	/**
	 * x in the stage Coordinate
	 */
	public double globalX;
	/**
	 * y in the stage Coordinate
	 */
	public double globalY;
	/**
	 * x in the local Coordinate
	 */
	public double localX;
	/**
	 * y in the local Coordinate
	 */
	public double localY;
	
	public MouseEvent(String type, boolean bubbles) {
		super(type, bubbles);
		// TODO Auto-generated constructor stub
	}
	public MouseEvent(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MouseEvent [globalX=" + globalX + ", globalY=" + globalY + ", localX=" + localX + ", localY=" + localY
				+ ", " + (type != null ? "type=" + type + ", " : "")
				+ (currentTarget != null ? "currentTarget=" + currentTarget + ", " : "")
				+ (eventPhase != null ? "eventPhase=" + eventPhase + ", " : "")
				+ (target != null ? "target=" + target + ", " : "") + "bubbles=" + bubbles + ", isStop=" + isStop + "]";
	}
	

	@Override
	public MouseEvent clone() {
		MouseEvent event=(MouseEvent) super.clone();
		event.globalX=globalX;
		event.globalY=globalY;
		event.localX=localX;
		event.localY=localY;
		
		return event;
	}
	
	
}
