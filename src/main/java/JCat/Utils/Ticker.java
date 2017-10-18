package JCat.Utils;

import java.util.ArrayList;

public class Ticker {
	
	public interface OnResponceListener {

		public void	onResponce();
	}



	/**
	 * loop thread
	 */
	private Thread loopThread;
	/**
	 * listeners
	 */
	private ArrayList<OnResponceListener> listeners=new ArrayList<>();
	/**
	 * callback delay
	 */
	private double delay;
	/**
	 * is this ticker running or stop?This two state can switch
	 */
	private boolean isRunning;
	/**
	 * is this ticker close? if so,this ticker can't be reuse.
	 * it always need to close ticker before set ticker to null
	 */
	private boolean close;

	
	
	
	
	/**
	 * 
	 * @param d
	 * @param once
	 */
	public Ticker(double d) {
		
		this.delay=d;
	
		initLoopThread();
		
	}
	
	
	
	/**
	 * 进行循环
	 * @param frameRate
	 */
	public void start() {
	
		if(close)
		{
			throw new RuntimeException("close ticker can't be restart,please use a new ticker!");
		}
		isRunning=true;

	}

	/**
	 * 初始化世界的循环线程
	 */
	private void initLoopThread() {
		
		isRunning=true;
		close=false;
		
		this.loopThread=new Thread()
		{
			public void run() 
			{
				
				while(!close)
				{
				
					try {
						Thread.sleep((long) delay);
						if(isRunning)
						{
							
							listeners.forEach(l->l.onResponce());
						}
						
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		};
		
		loopThread.start();
		
	
	}
	
	
	
	/**
	 * close the ticker,if has closed,the ticker can't be restart
	 */
	public void close()
	{
		close=true;
	}

	/**
	 * stop the ticker,the ticker can be restart
	 */
	public void stop()
	{
		isRunning=false;
	}

	
	/**
	 * add listener
	 * @param listener
	 */
	public void addListener(OnResponceListener listener) {
		listeners.add(listener);
	}

	
	/**
	 * remove listener
	 * @param listener
	 */
	public void removeListener(OnResponceListener listener) {
		listeners.remove(listener);
	}



	public void setDelay(double d) {
		this.delay=d;
		
	}



	public double getDelay() {
		// TODO Auto-generated method stub
		return delay;
	}
	
}
