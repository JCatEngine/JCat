package JCat.Graphics.Shape;

import JCat.Math.Vector2;
import JCat.Math.Shape.CircleShape;

public class Circle extends BaseShape {

	

	private CircleShape circleShape;

	public Circle(double radius) {
		this.circleShape=new CircleShape(Vector2.ZERO, radius);
		this.width=radius*2;
		this.height=radius*2;
		
	}

}
