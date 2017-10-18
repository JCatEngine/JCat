package JCat.Utils;

public class MathTool {

	public static void checkPositive(double value) {
		if(value<0)
		{
			throw new RuntimeException(value+"is not a positive value");
		}
		
	}

	public static void checkNonZero(double value) {
		if(value==0)
		{
			throw new RuntimeException(value+"is not non-zero");
		}
		
	}

}
