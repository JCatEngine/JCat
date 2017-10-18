package JCat.Display;

import JCat.Display.Calculation.Bound;
import JCat.Textures.Texture;

public class Bitmap extends DisplayObject{

	private Texture texture;

	public Bitmap(Texture texture) {
		this.texture=texture;
		this.width=texture.getWidth();
		this.height=texture.getHeight();
	}

	public Texture getTexture() {
		// TODO Auto-generated method stub
		return texture;
	}

	@Override
	void updateLocalBound() {
		
		//for displayobject,bound is base on origin width,height,and rotation,scale
		Bound bound=new Bound();
		
		//localbound x,y always is 0
		bound.minX=0;
		bound.minY=0;
		bound.maxX=width;
		bound.maxY=height;
		
		localBound=bound;
		
	}

	

}
