package multiplethread;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
 
public class TestThread {
    
    private static int value = 0;
    private static AtomicInteger atomicValue =new AtomicInteger();
    public static void main(String[] args) throws IOException{
    	int moneyEachDay = 0;
    	int day = 100000;
    	int sum = 0;
    	for(int i = 1;i <= day;i++) {
    		if(moneyEachDay == 0)
    			moneyEachDay = 1;
    		else
    			moneyEachDay *= 2;
    		
    		sum += moneyEachDay;
    		
    		System.out.println(i + "Ç®×ÜÊýÊÇ£º" + sum);
    }
        
}
}