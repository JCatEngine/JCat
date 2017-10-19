package JCat.Math.Shape;

import JCat.Math.Vector2;

public class RectShape implements BaseShape {

	private double left;
	private double top;
	private double right;
	private double bottom;

	/**
	 * The constructor creates a RectangleZone zone.
	 * 
	 * @param left
	 *            The left coordinate of the rectangle defining the region of the
	 *            zone.
	 * @param top
	 *            The top coordinate of the rectangle defining the region of the
	 *            zone.
	 * @param right
	 *            The right coordinate of the rectangle defining the region of the
	 *            zone.
	 * @param bottom
	 *            The bottom coordinate of the rectangle defining the region of the
	 *            zone.
	 */
	public RectShape(double left, double right, double top, double bottom) {

		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;

	}

	public double getLeft() {
		return left;
	}

	public void setLeft(double left) {
		this.left = left;
	}

	public double getTop() {
		return top;
	}

	public void setTop(double top) {
		this.top = top;
	}

	public double getRight() {
		return right;
	}

	public void setRight(double right) {
		this.right = right;
	}

	public double getBottom() {
		return bottom;
	}

	public void setBottom(double bottom) {
		this.bottom = bottom;
	}

	/**
	 * The contains method determines whether a point is inside the zone. This
	 * method is used by the initializers and actions that use the zone. Usually, it
	 * need not be called directly by the user.
	 * 
	 * @param x
	 *            The x coordinate of the location to test for.
	 * @param y
	 *            The y coordinate of the location to test for.
	 * @return true if point is inside the zone, false if it is outside.
	 */
	public boolean contains(double x, double y) {
		return x >= left && x <= right && y >= top && y <= bottom;
	}

	/**
	 * The getLocation method returns a random point inside the zone. This method is
	 * used by the initializers and actions that use the zone. Usually, it need not
	 * be called directly by the user.
	 * 
	 * @return a random point inside the zone.
	 */
	@Override
	public Vector2 getRandomPoint() {
		return new Vector2(left + Math.random() * getWidth(), top + Math.random() * getHeight());
	}

	public double getHeight() {
		return bottom - top;
	}

	public double getWidth() {
		// TODO Auto-generated method stub
		return right - left;
	}

	/**
	 * The getArea method returns the size of the zone. This method is used by the
	 * MultiZone class. Usually, it need not be called directly by the user.
	 * 
	 * @return a random point inside the zone.
	 */
	@Override
	public double getAreaSize() {
		// TODO Auto-generated method stub
		return getWidth() * getHeight();
	}

}
