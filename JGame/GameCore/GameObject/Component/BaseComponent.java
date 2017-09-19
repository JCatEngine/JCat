package JGame.GameCore.GameObject.Component;

import JGame.RenderSystem.Display.EventDispatcher;

public class BaseComponent {

	

	private EventDispatcher host;

	public BaseComponent(EventDispatcher host) {
		this.host = host;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取组件宿主
	 * @return
	 */
	public EventDispatcher getHost() {
		return host;
	}
	
	
	
}
