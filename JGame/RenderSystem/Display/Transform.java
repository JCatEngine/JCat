package JGame.RenderSystem.Display;

import JGame.RenderSystem.Math.Matrix;

public class Transform {

	private Matrix matrix;
	
	private int x;
	private int y;
	private int rotation;
	private int scaleX;
	private int scaleY;

	

	public Transform(int x, int y, int rotation, int scaleX, int scaleY) {
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		
		this.matrix=new Matrix();
	
	}

	public Transform append(Transform transform2) {
		// TODO Auto-generated method stub
		return null;
	}
}
