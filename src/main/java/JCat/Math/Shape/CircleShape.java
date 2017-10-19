package JCat.Math.Shape;

import JCat.Math.Vector2;
import JCat.Utils.MathTool;

public class CircleShape implements BaseShape {

	private Vector2 _center;
	private double _radius;

	/**
	 * The constructor defines a DiscZone zone.
	 * 
	 * @param center
	 *            The centre of the disc.
	 * @param outerRadius
	 *            The radius of the outer edge of the disc.
	 * @param innerRadius
	 *            If set, this defines the radius of the inner edge of the disc.
	 *            Points closer to the center than this inner radius are excluded
	 *            from the zone. If this parameter is not set then all points inside
	 *            the outer radius are included in the zone.
	 */
	public CircleShape(Vector2 center, double radius) {
		this._center = center;
		this._radius = radius;

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
		Vector2 vector2 = new Vector2(x, y);

		return Vector2.getDistance(_center, vector2) < _radius;
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
		double randomX = Math.random() * _radius;
		double randomY = Math.random() * _radius;
		Vector2 vector2 = _center.clone();
		vector2.x += randomX * MathTool.randomZF();
		vector2.y += randomY * MathTool.randomZF();
		return vector2;
	}

	/**
	 * The getArea method returns the size of the zone. This method is used by the
	 * MultiZone class. Usually, it need not be called directly by the user.
	 * 
	 * @return a random point inside the zone.
	 */
	@Override
	public double getAreaSize() {
		return Math.PI * _radius * _radius;
	}

}
