package multiplethread;

import java.util.LinkedList;

/*
 * �̰߳�ȫ��ջ
 */
public class MyStack<T> {
		
	LinkedList<T> values = new LinkedList<T>();
	
	//ѹ��
	public synchronized void push(T t) {
		while(values.size()>=200) {
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		values.addLast(t);
	}
	
	//����
	public synchronized T pull() {
		while(values.isEmpty()) {
			try {
				this.wait();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		return values.removeLast();
	}
	
	//�鿴
	public T peek() {
		return values.getLast();
	}
}
