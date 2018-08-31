package multiplethread;

public class ProducerThread extends Thread{
	
	private MyStack<Character> stack;
	
	public ProducerThread(MyStack<Character> stack,String name) {
		super(name);
		this.stack=stack;
	}
	
	public void run() {
		while(true) {
			char c = randomChar();
			System.out.println(this.getName()+"ѹ�룺"+c);
			stack.push(c);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public char randomChar() {
		return (char)(Math.random()*('Z'+1-'A')+'A');
	}
}
