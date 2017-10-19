package JCat.Graphics.Shape;

import JCat.Math.Vector2;
import JCat.Math.Shape.LineShape;

public class Line extends BaseShape {

	

	private LineShape lineShape;

	public Line(double length) {
		this.lineShape = new LineShape(Vector2.ZERO,new Vector2(length, 0));
		this.height=1;
		this.width=length;
	}

}
