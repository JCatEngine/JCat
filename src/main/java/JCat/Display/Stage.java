package JCat.Display;

import JCat.Display.Calculation.Bound;

public class Stage extends DisplayObjectContainer{

	private int width;
	private int height;

	public Stage(int width,int height) {
		this.width = width;
		this.height = height;
		
	}
	
	
	
	public int getStageWidth() {
		return width;
	}

	public int getStageHeight() {
		return height;
	}



	@Override
	public void addChildAt(DisplayObject displayObject, int index) {
		// TODO Auto-generated method stub
		super.addChildAt(displayObject, index);
		
		displayObject.recursiveUpdateStage(this,true);
		
	}
	
	@Override
	public void addChild(DisplayObject displayObject) {
		// TODO Auto-generated method stub
		super.addChild(displayObject);
		
		displayObject.recursiveUpdateStage(this,true);
	}

	
	@Override
	void updateBound() {
		//the stage has the width and height even it's has no child,because all hitTest need to be triggered at stage
		localBound=new Bound();
		localBound.maxX=getStageWidth();
		localBound.maxY=getStageHeight();
		localBound.minX=0;
		localBound.minY=0;
	}
	
	
}
