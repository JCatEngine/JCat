package JCat.Utils;

public class MathTool {

	public static void checkPositive(double value) {
		if(value<0)
		{
			throw new RuntimeException(value+" is not a positive value");
		}
		
	}

	public static void checkNonZero(double value) {
		if(value==0)
		{
			throw new RuntimeException(value+" is not non-zero");
		}
		
	}

	public static void checkRange(double min, double max, double value) {
		if(value<min||value>max)
		{
			throw new RuntimeException(value+" out of range,min:"+min+" max:"+max);
		}
		
	}

	public static double restrictRange(double min, double max, double value) {
		if(value<min)
		{
			value=min;
		}
		else if(value>max)
		{
			value=max;
		}
		
		return value;
	}

	/**
	 *random return 1 or -1 
	 * @return 
	 * 
	 */		
	public static double randomZF()
	{
		
		return Math.random()>=0.5?1:-1;
	}
	
	public static double random(double min,double max)
	{
	
		return Math.random()*(max-min)+min;
	}
	

	
	
	
}
