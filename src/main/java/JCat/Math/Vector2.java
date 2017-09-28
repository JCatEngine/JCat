package JCat.Math;

public class Vector2 {
	
	static private Vector2 DOWN = new Vector2(0, 1);
	static private Vector2 UP = new Vector2(0, -1);
	static private Vector2 LEFT = new Vector2(-1, 0);
	static private Vector2 RIGHT=new Vector2(1,0);
	private static Vector2 ZERO=new Vector2(0,0);
	
	public double x;
	public double y;
	
	public Vector2(double x,double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public static Vector2 ZERO()
	{
		return ZERO.clone();
	}

	public static Vector2 DOWN()
	{
		return DOWN.clone();
	}
	
	public static Vector2 UP()
	{
		return UP.clone();
	}
	
	public static Vector2 LEFT()
	{
		return LEFT.clone();
	}
	
	public static Vector2 RIGHT()
	{
		return RIGHT.clone();
	}
	

	public Vector2 multiply(double i)
	{
		
		return new Vector2(x*i,y*i);
	}
	
	
	
	public Vector2 clone()
	{
		return new Vector2(x, y);
	}

	public String toString()
	{
		return "[x=" + x + " y=" + y + "]";
	}
	
	/**
	 *return vector based on angle
	 * @param param0
	 * 
	 */		
	public static Vector2 getRotationVector2(double angle)
	{
		
		//convert to radian
		double h=angle/180*Math.PI;
		
		Vector2 v=new Vector2(Math.cos(h),Math.sin(h));
	
		return v;
	}
	
	
	/**
	 *return distance
	 * @param point1
	 * @param point2
	 * @return 
	 * 
	 */		
	public static Number getDistance(Vector2 v1,Vector2 v2)
	{
		
		double xx=v1.x-v2.x;
		double yy=v1.y-v2.y;
		
		return Math.sqrt(Math.pow(xx,2)+Math.pow(yy,2));
	}
	
	
	
	
	public Vector2 divide(double i)
	{
	
		return new Vector2(x/i,y/i);
	}
	
	
	
	/**
	 *reduce a vector
	 * @param v
	 * @return 
	 * 
	 */		
	public Vector2 reduce(Vector2 v)
	{
		
		return new Vector2(x-v.x,y-v.y);

	}
	
	/**
	 *add a vector
	 * @param v
	 * @return 
	 * 
	 */		
	public Vector2 add(Vector2 v)
	{
	
		
		return new Vector2(x+v.x,y+v.y);

	}
	
	/**
	 *normalize a vector
	 * 
	 */		
	public Vector2 normalize()
	{
		double s=getSize();
		
		double newX =0;
		double newY =0;
		
		if(s==0)
		{
			//avoid error when divide a number to zero
			newX=0;
			newY=0;
		}
		else
		{
			newX=x/s;
			newY=y/s;
			
		}
		
		return new Vector2(newX,newY);
	}
	
	
	/**
	 *return the size of the vector
	 * @return 
	 * 
	 */		
	public double getSize()
	{
		return Math.sqrt(x*x+y*y);
	}
	
	
	
	public double toRotation()
	{
		Vector2 v=this.normalize();
	
		return Math.atan2(v.y,v.x)*180/Math.PI;
	}
	
	/**
	 *reverse the vector
	 * @return 
	 * 
	 */		
	public Vector2 reverse()
	{
		return new Vector2(-x,-y);
	}
	
	
}
