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
	public int globalX;
	/**
	 * y in the stage Coordinate
	 */
	public int globalY;
	
	
	public MouseEvent(String type, boolean bubbles) {
		super(type, bubbles);
		// TODO Auto-generated constructor stub
	}
	public MouseEvent(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	

	
	
}
