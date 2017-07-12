package JGame.Manager;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument;


import JGame.GameObject.EventDispatcher;
import JGame.GameObject.Component.Event.AbstractEvent;

/**
 * event管理器(注意并不是所有可收发事件的对象都是游戏对象,游戏对象更加高级)
 * @author Administrator
 *
 */
public class EventManager extends BaseManager{

	private List<EventDispatcher> list=new ArrayList<>();
	
	public void registerEventdealer(EventDispatcher eventDispatcher) {
		
		list.add(eventDispatcher);
		
	}

	
	/**
	 * 给指定对象发送消息
	 * @param entity
	 * @param updateEvent
	 */
	public void sendEvent(EventDispatcher eventDispatcher, AbstractEvent abstractEvent) {
	
		eventDispatcher.getCom_eventhandler().reciveEvent(abstractEvent);
	}
	
	
	/**
	 * 发送广播消息
	 * @param updateEvent
	 */
	public void sendBroadCast(AbstractEvent event) {
		
		for(EventDispatcher eventDispatcher:list)
		{
			sendEvent(eventDispatcher,event);
		}
		
	}


	public void dealMessage() {
		
		//让注册对象去处理他们的消息
		for(EventDispatcher eventDispatcher:list)
		{
			eventDispatcher.getCom_eventhandler().dealMessage();
		}
	}




}
