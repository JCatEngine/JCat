package JCat.Display;

public class Stage extends DisplayObjectContainer{

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

}
