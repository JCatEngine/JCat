package JGame.Manager;

import java.util.HashMap;
import java.util.Map;

public class ManagerInstaceFactory {

	
	static private Map<Class<? extends BaseManager>, BaseManager> map=new HashMap<>();
	
	/**
	 * 返回管理器的单例
	 * @param class1
	 * @return
	 */
	static public <T extends BaseManager> T getManagerInstance(Class<T> class1)
	{
		
		if(map.get(class1)==null)
		{
			T manager = null;
			try {
				manager = class1.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put(class1, manager);
		}
		
		return (T) map.get(class1);
		
	}
}
