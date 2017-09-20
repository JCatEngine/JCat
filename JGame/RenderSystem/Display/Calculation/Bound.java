package JGame.RenderSystem.Display.Calculation;

import JGame.RenderSystem.Math.Rect;
import JGame.RenderSystem.Math.Vector2;

public class Bound {

	
	public double x;
	public double y;
	public double width;
	public double height;
	
	public Rect toRect() {
		// TODO Auto-generated method stub
		return new Rect(x, y, width, height);
	}

	public void addVector2(Vector2 vector2) {
	
		if(vector2.x<getMinX())
		{
			setMinX(vector2.x);
		}
		if(vector2.x>getMaxX())
		{
			setMaxX(vector2.x);
		}
		if(vector2.y<getMinY())
		{
			setMinY(vector2.y);
		}
		if(vector2.x>getMaxY())
		{
			setMaxY(vector2.y);
		}
		
	}

	public void addBound(Rect rect) {
		
		addVector2(rect.getLeftTopPoint());
		addVector2(rect.getRightTopPoint());
		addVector2(rect.getLeftDownPoint());
		addVector2(rect.getRightDownPoint());
		
	}
	
	public double getMinX()
	{
		return x;
	}
	
	public void setMinX(double value)
	{
		x=value;
		width+=Math.abs(value);
	}
	
	public double getMaxX()
	{
		return x+width;
	}
	
	public void setMaxX(double value)
	{
		width=value-x;
	}
	
	public double getMinY()
	{
		return y;
	}

	public void setMinY(double value)
	{
		y=value;
		height+=Math.abs(value);
	}
	
	public double getMaxY()
	{
		return y+height;
	}
	
	public void setMaxY(double value)
	{
		height=value-y;
	}

	@Override
	public String toString() {
		return "Bound [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}

	
	
	
}
