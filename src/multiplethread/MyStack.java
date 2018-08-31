package multiplethread;

import java.util.LinkedList;

/*
 * 线程安全的栈
 */
public class MyStack<T> {
		
	LinkedList<T> values = new LinkedList<T>();
	
	//压入
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
	
	//弹出
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
	
	//查看
	public T peek() {
		return values.getLast();
	}
}
