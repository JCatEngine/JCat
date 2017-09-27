package JCat.RenderSystem.Display.Calculation;

import JCat.RenderSystem.Math.Rect;
import JCat.RenderSystem.Math.Vector2;

public class Bound {

	
	public double minX=9999999;
	public double minY=9999999;
	public double maxX=-9999999;
	public double maxY=-999999;
	
	
	public Rect toRect() {
		// TODO Auto-generated method stub
		return new Rect(minX, minY, maxX-minX, maxY-minY);
	}

	public void addVector2(Vector2 vector2) {
		
	
		 this.minX = Math.min(this.minX, vector2.x);
	     this.maxX = Math.max(this.maxX, vector2.x);
	     this.minY = Math.min(this.minY, vector2.y);
	     this.maxY = Math.max(this.maxY, vector2.y);
		
	}

	public void addBound(Rect rect) {
		
		addVector2(rect.getLeftTopPoint());
		addVector2(rect.getRightTopPoint());
		addVector2(rect.getLeftDownPoint());
		addVector2(rect.getRightDownPoint());
		
	}

	@Override
	public String toString() {
		return "Bound [minX=" + minX + ", minY=" + minY + ", maxX=" + maxX + ", maxY=" + maxY + "]";
	}
	
	

	

	
	
	
}
