package JCat.Math.Shape;

import JCat.Math.Vector2;

public class LineShape implements BaseShape {

	private Vector2 start;
	private Vector2 end;
	private Vector2 length;

	/**
	 * The constructor creates a LineZone zone.
	 * 
	 * @param start
	 *            The point at one end of the line.
	 * @param end
	 *            The point at the other end of the line.
	 */
	public LineShape(Vector2 start, Vector2 end) {
		this.start = start;
		this.end = end;
		recalculateLength();
	}

	private void recalculateLength() {
		length = end.reduce(start);

	}

	public Vector2 getStart() {
		return start;
	}

	public void setStart(Vector2 _start) {
		this.start = _start;
		recalculateLength();
	}

	public Vector2 getEnd() {
		return end;
	}

	public void setEnd(Vector2 _end) {
		this.end = _end;
		recalculateLength();
	}

	@Override
	public boolean contains(double x, double y) {
		// not on line if dot product with perpendicular is not zero
		if ((x - start.x) * length.y - (y - start.y) * length.x != 0) {
			return false;
		}
		// is it between the points, dot product of the vectors towards each point is
		// negative
		return (x - start.x) * (x - end.x) + (y - start.y) * (y - end.y) <= 0;
	}

	@Override
	public Vector2 getRandomPoint() {
		Vector2 ret = start.clone();
		double scale = Math.random();
		ret.x += length.x * scale;
		ret.y += length.y * scale;

		return ret;
	}

	@Override
	public double getAreaSize() {
		// treat as one pixel tall rectangle
		return length.getSize();
	}

}
