package JGame.GameCore.GameObject.Component.Event;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import JGame.GameCore.GameObject.Component.BaseComponent;
import JGame.RenderSystem.Display.EventDispatcher;

/**
 * 事件处理器
 * @author Administrator
 *
 */
public class EventHandler extends BaseComponent{

	private class EventListener
	{
		public EventType type;
		public EventRecall recall;
		
	}
	
	
	
	/**
	 * 事件处理器
	 */
	private List<EventListener> listeners=new ArrayList<>();

	/**
	 * 事件队列
	 */
	private LinkedList<AbstractEvent> eventQuene=new LinkedList();
	
	
	
	public EventHandler(EventDispatcher abstractEntity) {
	
		super(abstractEntity);
		
	}


	
	/**
	 * 添加事件处理器
	 * @param type
	 * @param recall
	 */
	public void addEventListener(EventType type, EventRecall recall) {
		EventListener bean=new EventListener();
		bean.recall=recall;
		bean.type=type;
		
		listeners.add(bean);
		
	}
	
	/**
	 * 发送消息
	 * @param type
	 * @param recall
	 */
	public void sendEvent() {
	
	}
	
	
	/**
	 * 接受消息
	 * @param type
	 * @param recall
	 */
	public void reciveEvent(AbstractEvent event) {
		eventQuene.add(event);
		
	}
	

	/**
	 * 处理事件队列中的消息(每帧调用一次)
	 */
	public void dealMessage() {
		
		//根据监听器 过滤出需要处理的数据
		while(!eventQuene.isEmpty())
		{
			//取出一条消息
			AbstractEvent event=eventQuene.remove();
			//根据监听器处理该消息
			for(EventListener bean:listeners)
			{
				if(bean.type==event.getType())
				{
					bean.recall.dealEvent(event);
				}

			}
		}
	}

}
