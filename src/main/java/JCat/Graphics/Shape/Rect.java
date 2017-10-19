package JCat.Graphics.Shape;

import JCat.Math.Shape.RectShape;

public class Rect extends BaseShape {

	private RectShape rectShape;


	
	public Rect(double width, double height) {

		this.rectShape = new RectShape(0, width, 0, height);
		this.height=rectShape.getHeight();
		this.width=rectShape.getWidth();
		

	}
}
