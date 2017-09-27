package JCat.RenderSystem.Math;

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
	 *根据角度返回 单位向量 
	 * @param param0
	 * 
	 */		
	public static Vector2 getRotationVector2(double angle)
	{
		
		//先转换为弧度
		double h=angle/180*Math.PI;
		
		Vector2 v=new Vector2(Math.cos(h),Math.sin(h));
	
		return v;
	}
	
	
	/**
	 *返回距离 
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
	 *减去一个向量 
	 * @param v
	 * @return 
	 * 
	 */		
	public Vector2 reduce(Vector2 v)
	{
		
		return new Vector2(x-v.x,y-v.y);

	}
	
	/**
	 *加上一个向量 
	 * @param v
	 * @return 
	 * 
	 */		
	public Vector2 add(Vector2 v)
	{
	
		
		return new Vector2(x+v.x,y+v.y);

	}
	
	/**
	 *向量标准化(转化为单位向量) 
	 * 
	 */		
	public Vector2 normalize()
	{
		double s=getSize();
		
		double newX =0;
		double newY =0;
		
		if(s==0)
		{
			//避免除0错
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
	 *返回向量的大小 
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
	 *翻转向量 
	 * @return 
	 * 
	 */		
	public Vector2 reverse()
	{
		return new Vector2(-x,-y);
	}
	
	
}
