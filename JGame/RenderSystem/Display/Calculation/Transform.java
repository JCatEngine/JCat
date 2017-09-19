package JGame.RenderSystem.Display.Calculation;

import JGame.RenderSystem.Math.Matrix;

public class Transform {

	private Matrix matrix;
	
	private int x;
	private int y;
	private int rotation;
	private int scaleX;
	private int scaleY;

	
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRotation() {
		return rotation;
	}

	public int getScaleX() {
		return scaleX;
	}

	public int getScaleY() {
		return scaleY;
	}

	public Transform(int x, int y, int rotation, int scaleX, int scaleY) {
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		
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
