package JCat.Display.Calculation;

import JCat.Math.Matrix;
import JCat.Math.Vector2;

public class Transform {

	/**
	 * instance,for inner use to improve efficiency
	 */
	public static final Transform staticTransform=new Transform(0, 0, 0, 1, 1);

	private Matrix matrix;
	
	public double x;
	public double y;
	public double rotation;
	public double scaleX;
	public double scaleY;

	
	


	@Override
	public String toString() {
		return "Transform [x=" + x + ", y=" + y + ", rotation=" + rotation + ", scaleX=" + scaleX + ", scaleY=" + scaleY
				+ "]";
	}


	public Transform(double x2, double y2, double rotation2, double scaleX2, double scaleY2) {
		this.x = x2;
		this.y = y2;
		this.rotation = rotation2;
		this.scaleX = scaleX2;
		this.scaleY = scaleY2;
		
		updateMatrix();
	
	}

	
	public void updateMatrix()
	{
		this.matrix=new Matrix();
		
		matrix.rotate(rotation/180f*Math.PI);
		matrix.scale(scaleX, scaleY);
		matrix.translate(x, y);
		
	}
	
	public Transform append(Transform transform2) {
		
		this.matrix.append(transform2.matrix);
		
		
		return this;
	}
	
	public Transform clone()
	{
		Transform transform=new Transform(x, y, rotation, scaleX, scaleY);
		return transform;
	}

	
	/**
	 * 
	 * @param vector2
	 * @return
	 */
	public Vector2 apply(Vector2 vector2) {
		// TODO Auto-generated method stub
		return matrix.apply(vector2);
	}


	/**
	 * 
	 * @param vector2
	 * @return
	 */
	public Vector2 applyInverse(Vector2 vector2)
	{
		return matrix.appInverse(vector2);
	}


	

}
