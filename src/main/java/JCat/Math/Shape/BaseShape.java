package JCat.Math.Shape;

import JCat.Math.Vector2;

public interface BaseShape {
	/**
	 * Determines whether a point is inside the zone.
	 * This method is used by the initializers and actions that
	 * use the zone. Usually, it need not be called directly by the user.
	 * 
	 * @param x The x coordinate of the location to test for.
	 * @param y The y coordinate of the location to test for.
	 * @return true if point is inside the zone, false if it is outside.
	 */
	boolean contains(double x,double y);

	/**
	 * Returns a random point inside the zone.
	 * This method is used by the initializers and actions that
	 * use the zone. Usually, it need not be called directly by the user.
	 * 
	 * @return a random point inside the zone.
	 */
	Vector2 getRandomPoint();

	/**
	 * Returns the size of the zone.
	 * This method is used by the MultiZone class to manage the balancing between the
	 * different zones.
	 * 
	 * @return the size of the zone.
	 */
	double getAreaSize();
}
