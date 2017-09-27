package JCat.GameCore.GameObject.Component.Anime;

import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Assert;

import JCat.GameCore.GameObject.Component.BaseComponent;
import JCat.RenderSystem.Display.DisplayObject;
import JCat.RenderSystem.Display.EventDispatcher;

/**
 * 动画管理器
 * @author Administrator
 *
 */
public class AnimeComponent extends BaseComponent{

	private class keyAndImage
	{
		public int index;
		public BufferedImage image;
		@Override
		public String toString() {
			return "keyAndImage [index=" + index + "]";
		}
		
		
		
	}
	
	private class AnimeClip
	{
		public String name;
		public int length;
		
		
		//保证索引大的在后面 遍历的时候方便
		public PriorityQueue<keyAndImage> list=new PriorityQueue<>(new Comparator<keyAndImage>() {

			@Override
			public int compare(keyAndImage o1, keyAndImage o2) {
				
				return o1.index-o2.index;
			}
		});


		@Override
		public String toString() {
			return "AnimeClip [" + (name != null ? "name=" + name + ", " : "") + "length=" + length + ", "
					+ (list != null ? "list=" + list : "") + "]";
		}
		
		
	}
	
	
	/**
	 * 所有的动画
	 */
	private Map<String, AnimeClip> map=new HashMap<>();
	/**
	 * 当前正在播放的动画
	 */
	private AnimeClip nowClip;
	
	/**
	 * 当前帧
	 */
	public int currentFrame=1;
	
	public AnimeComponent(EventDispatcher host) {
		super(host);
		
	}
	
	/**
	 * 循环更新动画
	 */
	public void loopAnime() {
	
		if(nowClip!=null)
		{
			currentFrame++;
			if(currentFrame==nowClip.length+1)
			{
				currentFrame=1;
			}	
		}
		
	}
	
	/**
	 * 获取当前帧的图片
	 */
	public BufferedImage getImage() {
	
		
		//根据当前帧计算应该返回哪一张图片
		BufferedImage image = null;
		if(nowClip!=null)
		{
			for(keyAndImage kImage:nowClip.list)
			{
				if(currentFrame>=kImage.index)
				{
					image=kImage.image;
				}
			}
		}
		return image;	
	}
	
	
	
	/**
	 * 创建一个动画
	 * @param name 名字
	 * @param length 长度
	 * @param firstImage 第一帧的图像
	 */
	public void CreateAnime(String name,int length,BufferedImage firstImage) {
	
		Assert.assertFalse(map.containsKey(name));
		Assert.assertTrue(length>0);
		Assert.assertNotNull(firstImage);
		
		AnimeClip animeClip=new AnimeClip();
		animeClip.name=name;
		animeClip.length=length;
		map.put(name, animeClip);
		//默认图片插入到第一帧
		addKeyFrame(name, 1, firstImage);
		
		//初始化长宽为图片的长宽
		if(getHost().width==0&&getHost().height==0)
		{
			getHost().width=firstImage.getWidth();
			getHost().height=firstImage.getHeight();
		}
		
		//如果当前还没有播放动画则立即开始播放该动画
		if(nowClip==null)
		{
			nowClip=animeClip;
		}
	}
	
	
	
	/**
	 * 插入动画帧
	 * @param name
	 * @param index 索引(从1开始)
	 * @param firstImage
	 */
	public void addKeyFrame(String name,int index,BufferedImage firstImage) {
	
		Assert.assertNotNull(map.get(name));
		
		AnimeClip clip=map.get(name);
		Assert.assertTrue(index>=1&&index<=clip.length);
		
		keyAndImage k=new keyAndImage();
		k.image=firstImage;
		k.index=index;
		
		clip.list.add(k);
		
	
	}
	
	
	/**
	 * 插入单帧动画(背景之类的)
	 * @param name
	 * @param firstImage
	 */
	public void addImage(String name,BufferedImage firstImage) {
	
		CreateAnime(name, 1, firstImage);
		
	}

	/**
	 * 插入单帧动画
	 * @param firstImage
	 */
	public void addImage(BufferedImage firstImage) {
	
		addImage("image"+new Object().hashCode(), firstImage);
		
	}

	
	@Override
	public DisplayObject getHost() {
		// TODO Auto-generated method stub
		return (DisplayObject) super.getHost();
	}
}
