package JGame.RenderSystem.Display.Calculation;

import JGame.RenderSystem.Math.Matrix;
import JGame.RenderSystem.Math.Vector2;

public class Transform {

	private Matrix matrix;
	
	public int x;
	public int y;
	public double rotation;
	public double scaleX;
	public double scaleY;

	
	


	public Transform(int x, int y, double rotation2, double scaleX2, double scaleY2) {
		this.x = x;
		this.y = y;
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


	public Vector2 apply(Vector2 vector2) {
		// TODO Auto-generated method stub
		return matrix.apply(vector2);
	}




	

}
