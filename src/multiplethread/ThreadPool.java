package multiplethread;

import java.util.LinkedList;

/*
 * �Զ����̳߳�
 */
public class ThreadPool {

	//�̳߳ش�С
	int threadPoolSize;
	
	//��������
	LinkedList<Runnable> tasks = new LinkedList<Runnable>();
	
	//��ͼ����������߳�
	public ThreadPool() {
		threadPoolSize = 10;
		
		//����10�������������߳�
		synchronized (tasks) {
			for(int i = 0; i < threadPoolSize; i++) {
				new TaskConsumeThread("�����������߳�"+i).start();
			}
		}
	}
	
	//�������
	public void add(Runnable r) {
		synchronized (tasks) {
			tasks.add(r);
			//���ѵȴ�������������߳�
			tasks.notifyAll();
		}
	}
	
	class TaskConsumeThread extends Thread {
		
		Runnable task;
		
		public TaskConsumeThread(String name) {
			super(name);
		}
		
		public void run() {
			System.out.println("����"+this.getName());
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
					//�������������߳̿��Լ����������
					tasks.notifyAll();
				}
				System.out.println(this.getName() + "�������ִ��");
				task.run();
			}
			
		}
		
	}
	
	
}
