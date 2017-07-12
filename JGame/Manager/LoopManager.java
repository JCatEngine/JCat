package JGame.Manager;

import JGame.Manager.LoopManager.OnResponceListener;

public class LoopManager extends BaseManager{

	
	public interface OnResponceListener {

		public void	onResponce();
	}



	/**
	 * 循环线程
	 */
	private Thread loopThread;
	/**
	 * 帧数
	 */
	private int frameRate;
	/**
	 * 每帧持续时间 根据帧数算出
	 */
	private int sleepDelay;
	private OnResponceListener listener;

	
	
	
	
	public LoopManager() {
		initLoopThread();
	}
	
	
	
	/**
	 * 进行循环
	 * @param frameRate
	 */
	public void startLoop(int frameRate) {
		this.frameRate = frameRate;
		this.sleepDelay = 1000/frameRate;
	
		loopThread.resume();
	}

	/**
	 * 初始化世界的循环线程
	 */
	private void initLoopThread() {
		this.loopThread=new Thread()
		{
			public void run() 
			{
				while(true)
				{
				try {
					Thread.sleep(sleepDelay);
					if(listener!=null)
					{
						listener.onResponce();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}

		};
		
		loopThread.start();
		//先挂起线程
		loopThread.suspend();
	
	}



	public void addOnResponceListener(OnResponceListener listener) {
		this.listener = listener;
		
		
	}

}
