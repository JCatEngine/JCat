package JCat.Event;

import JCat.Interaction.MouseButton;

public class MouseEvent extends Event {

	/**
	 * mouse move event
	 */
	static public final String MOUSE_MOVE = "mousemove";
	/**
	 * key up event
	 */
	static public final String MOUSE_UP="mouseup";
	/**
	 * key down event
	 */
	static public final String MOUSE_DOWN="mousedown";
	/**
	 * key click event
	 */
	public static final String MOUSE_CLICK = "click";
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
	/**
	 * pressed mouse button 
	 */
	public MouseButton button;
	/**
	 * click count
	 */
	public int clickCount;
	
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
				+ ", " + (button != null ? "button=" + button + ", " : "") + "clickCount=" + clickCount + "]";
	}
	@Override
	public MouseEvent clone() {
		MouseEvent event=new MouseEvent(type);
		event.globalX=globalX;
		event.globalY=globalY;
		event.localX=localX;
		event.localY=localY;
		event.button=button;
		event.clickCount=clickCount;
		
		defaultClone(event);
		
		return event;
	}
	
	
}
