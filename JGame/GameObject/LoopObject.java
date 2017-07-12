package JGame.GameObject;

import JGame.JGame;
import JGame.GameObject.Component.Event.AbstractEvent;
import JGame.GameObject.Component.Event.EventRecall;
import JGame.GameObject.Component.Event.EventType;

/**
 * 需要循环的对象 具有生命周期
 * @author Administrator
 *
 */
public abstract class LoopObject extends EventDispatcher{

	@Override
	public void addToGame(JGame jGame) {
		super.addToGame(jGame);

		objectInit();
		
		
		getCom_eventhandler().addEventListener(EventType.UPDATE, new EventRecall() {

			@Override
			public void dealEvent(AbstractEvent event) {
				
				_loop();
			}
		});
	}
	
	
	protected void _loop() {	
		objectLoop();
	}
	
	
	abstract protected void objectLoop();
	abstract protected void objectInit();
	

}
