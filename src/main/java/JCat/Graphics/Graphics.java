package JCat.Graphics;

import JCat.Display.Sprite;
import JCat.Graphics.Shape.Line;
import JCat.Math.Vector2;

/**
 * a container class but has ability to draw shape
 * @author Administrator
 *
 */
public class Graphics extends Sprite {

	private Color color=Color.BLACK;
	private double startX=0;
	private double startY=0;
	
	
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void moveTo(double localX, double localY)
	{
		this.startX=localX;
		this.startY=localY;
	}
	
	public void lineTo(double localX, double localY)
	{
		Vector2 v1=getPostion();
		Vector2 v2=new Vector2(localX, localY);
		double length=Vector2.getDistance(v1, v2);
		double rotation=v2.reduce(v1).toRotation();
		
		Line line=new Line(length);
		line.setColor(color);
		line.rotation=rotation;
		
		line.x=startX;
		line.y=startY;
		
		startX=localX;
		startY=localY;
		
		addChild(line);
		
	}

	private Vector2 getPostion() {
		// TODO Auto-generated method stub
		return new Vector2(startX, startY);
	}
	
	
	
	
}
