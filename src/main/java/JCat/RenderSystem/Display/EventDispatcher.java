package JCat.RenderSystem.Display;


import JCat.GameCore.GameObject.Component.Event.EventHandler;
import JCat.GameCore.GameObject.Component.Event.EventType;

/**
 * a object can send and receive event
 * @author Administrator
 *
 */
public class EventDispatcher{

	/**
	 * 组件 事件系统
	 */
	protected EventHandler com_eventhandler;
	protected void initComponent() {
		
		this.com_eventhandler=new EventHandler(this);
		//注册消息处理器
		//game.getEventManager().registerEventdealer(this);	
		
		
	
	}



	public EventHandler getCom_eventhandler() {
		return com_eventhandler;
	}



	

	
	
}
