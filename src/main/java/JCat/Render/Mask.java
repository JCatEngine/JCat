package JCat.Render;

import JCat.Math.Rect;

public class Mask {

	public static Mask createFromRect(Rect rect) {
		Mask mask=new Mask();
		mask.x=(int) rect.x;
		mask.y=(int) rect.y;
		mask.width=(int) rect.width;
		mask.height=(int) rect.height;
		
		return mask;
	}
	
	
	public int x;
	public int y;
	public int width;
	public int height;
	@Override
	public String toString() {
		return "Mask [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}
	
	

}
