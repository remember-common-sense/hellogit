package multiplethread;

public class ConsumerThread extends Thread{

	private MyStack<Character> stack;
	
	public ConsumerThread(MyStack<Character> stack, String name) {
		super(name);
		this.stack = stack;
	}
	
	public void run() {
		char c = stack.pull();
		System.out.println(this.getName()+"µ¯³ö£º"+c);
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
