package JGame.RenderSystem.Display.Calculation;

import JGame.RenderSystem.Math.Matrix;

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
		matrix.translate(x, y);
		matrix.rotate(rotation);
		matrix.scale(scaleX, scaleY);
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




	

}
