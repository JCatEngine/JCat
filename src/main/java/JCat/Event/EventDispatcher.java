package JCat.Event;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import JCat.Display.DisplayObject;
import JCat.Display.DisplayObjectContainer;

/**
 * a object can send and receive event
 * @author Administrator
 *
 */
public class EventDispatcher{

	
	/**
	 * all ListenerData
	 */
	private ArrayList<ListenerData> listeners=new ArrayList<>();
	
	public EventDispatcher() {
		
		
	}
	
	/**
	 * 
	 * @param type
	 * @param listener
	 */
	public void addEventListener(String type, EventListener listener)
	{
		addEventListener(type, listener,0);
	}
	 
	/**
	 * 
	 * @param type
	 * @param listener
	 * @param priority
	 */
	public void addEventListener(String type, EventListener listener,int priority)
	{
		addEventListener(type, listener, priority, false);
	}
	
	
	/**
	 * 
	 * @param type
	 * @param listener
	 * @param priority
	 * @param listenerAllPhase if true,the listener will be trigger in all three phase,is false,
	 * the listener will only be trigged in the bubble or target phase
	 * note if set this field be true,a parent will be trigger twice by one event which it's child send
	 */
	public void addEventListener(String type, EventListener listener,int priority,boolean listenerAllPhase)
	{
		ListenerData eventData=new ListenerData();
		eventData.type=type;
		eventData.listener=listener;
		eventData.priority=priority;
		eventData.allPhase=listenerAllPhase;
		listeners.add(eventData);
		
		
		sortList();
	}
	

	/**
	 * sort list,it's was called every time new listener been add
	 */
	private void sortList() {
		
		listeners.sort(new Comparator<ListenerData>() {

			@Override
			public int compare(ListenerData o1, ListenerData o2) {
				// TODO Auto-generated method stub
				return o1.priority-o2.priority;
			}
		});
		
	}

	/**
	 * send event to listeners have registerd in this object,this function was called by
	 * EventManager
	 * @param event
	 */
	void sendEventCurrentObject(Event event)
	{
	
		//through high priority to low priority
		for(int i=listeners.size()-1;i>=0;i--)
		{
			ListenerData data=listeners.get(i);
			if(data.type==event.type)
			{
				//if in this two phase the listener will be trigged anyway
				if(event.eventPhase==EventPhase.AT_TARGET||event.eventPhase==EventPhase.BUBBLING_PHASE)
				{
					data.listener.onResponce(event);
				}
				//if in capture phase,only listener set to listener all phase wiil be triggerd
				else {
					
					if(data.allPhase==true)
					{
						data.listener.onResponce(event);
					}
				}	
			}
		}
	}

	/**
	 * 
	 * @param event
	 */
	public void dispatchEvent(Event event)
	{
		EventManager.dispatchEvent(this,event);
		
	}
	
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	public boolean hasEventListener(String type)
	{
		for (ListenerData eventData : listeners) {
			if(eventData.type.equals(type))
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
	/**
	 * remove listeners by type,listener,priority
	 * @param type
	 * @param listener
	 * @param priority
	 * @return
	 */
	public int removeEventListener(String type, EventListener listener,int priority)
	{
		return _removeEventListener(type, listener, priority,3);
	
	}

	
	/**
	 * remove listeners by type,listener
	 * @param type
	 * @param listener
	 * @return
	 */
	public int removeEventListener(String type, EventListener listener)
	{
		return _removeEventListener(type, listener, 0,2);
	
	}
	
	
	/**
	 * remove listeners by type
	 * @param type
	 * @return 
	 */
	public int removeEventListener(String type)
	{
		return _removeEventListener(type, null, 0,1);
	
	}
	
	

	/**
	 * 
	 * @param type
	 * @param listener
	 * @param priority
	 * @param i checkType
	 */
	private int _removeEventListener(String type, EventListener listener, int priority, int i) {
		
		List<ListenerData> removeList=new LinkedList<>();
		
	
			for (ListenerData eventData : listeners) {
				switch (i) {
				case 3:
						if(eventData.type.equals(type)&&eventData.listener.equals(listener)&&eventData.priority==priority)
						{
							removeList.add(eventData);
						}
					break;
				case 2:
						if(eventData.type.equals(type)&&eventData.listener.equals(listener))
						{
							removeList.add(eventData);
						}
					break;
				case 1:
						if(eventData.type.equals(type))
						{
							removeList.add(eventData);
						}
					break;
				default:
					break;
				}
	
			}
		

		for (ListenerData eventData : removeList) {
			
			listeners.remove(eventData);
		}
		
		return removeList.size();
	}





	/**
	 * inner class 
	 * @author Administrator
	 *
	 */
	private class ListenerData
	{

		public boolean allPhase;
		public int priority;
		public EventListener listener;
		public String type;
		
		@Override
		public String toString() {
			return "EventData [priority=" + priority + ", " + (listener != null ? "listener=" + listener + ", " : "")
					+ (type != null ? "type=" + type : "") + "]";
		}
		
		
		
		
	}





	/**
	 * send a event copy to all it's child,used internally just for system event need to 
	 * send all object in the main display tree such as keyboard event
	 * @param event
	 */
	 void _boardCast(Event event) {
		 //dispatch at this object
		this.dispatchEvent(event.clone());
		//if has childs,dispatch to all it's child
		if(this instanceof DisplayObjectContainer)
		{
			DisplayObjectContainer container=(DisplayObjectContainer) this;
			LinkedList<DisplayObject> linkedList=container.getChilds();
			for (DisplayObject displayObject : linkedList) {
				((EventDispatcher)displayObject)._boardCast(event.clone());
			}
			
		}
		
		
	}
}
