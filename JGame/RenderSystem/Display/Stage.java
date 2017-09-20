package JGame.RenderSystem.Display;

public class Stage extends DisplayObjectContainer{

	@Override
	public void addChildAt(DisplayObject displayObject, int index) {
		// TODO Auto-generated method stub
		super.addChildAt(displayObject, index);
		
		displayObject.updateStage(this);
		
	}

}
