package JGame.Render;

import JGame.GameObject.DisplayObject;

public interface GameStage {

	/**
	 * 渲染对象
	 * @param displayObject
	 */
	void render(DisplayObject displayObject);
	/**
	 * 清屏
	 */
	void clear();

}
