package multiplethread;

import java.util.LinkedList;

/*
 * 自定义线程池
 */
public class ThreadPool {

	//线程池大小
	int threadPoolSize;
	
	//任务容器
	LinkedList<Runnable> tasks = new LinkedList<Runnable>();
	
	//试图消费任务的线程
	public ThreadPool() {
		threadPoolSize = 10;
		
		//启动10个任务消费者线程
		synchronized (tasks) {
			for(int i = 0; i < threadPoolSize; i++) {
				new TaskConsumeThread("任务消费者线程"+i).start();
			}
		}
	}
	
	//添加任务
	public void add(Runnable r) {
		synchronized (tasks) {
			tasks.add(r);
			//唤醒等待任务的消费者线程
			tasks.notifyAll();
		}
	}
	
	class TaskConsumeThread extends Thread {
		
		Runnable task;
		
		public TaskConsumeThread(String name) {
			super(name);
		}
		
		public void run() {
			System.out.println("启动"+this.getName());
			while(true) {
				synchronized (tasks) {
					while(tasks.isEmpty()) {
						try {
							tasks.wait();
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
					task = tasks.removeLast();
					//允许添加任务的线程可以继续添加任务
					tasks.notifyAll();
				}
				System.out.println(this.getName() + "获得任务并执行");
				task.run();
			}
			
		}
		
	}
	
	
}
