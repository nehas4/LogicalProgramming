package practice;

import java.util.concurrent.*; 

public class SimpleExecutor { 
  
    public static void main(String[] args) 
    { 
        CountDownLatch cd1 = new CountDownLatch(5); 
        CountDownLatch cd2 = new CountDownLatch(5); 
        CountDownLatch cd3 = new CountDownLatch(5); 
        CountDownLatch cd4 = new CountDownLatch(5); 
  
        ExecutorService es = Executors.newFixedThreadPool(2); 
  
        System.out.println("Starting"); 
  
        es.execute(new MyThread(cd1, "A")); 
        es.execute(new MyThread(cd2, "B")); 
        es.execute(new MyThread(cd3, "C")); 
        es.execute(new MyThread(cd4, "D")); 
  
        try { 
            cd1.await(); 
            cd2.await(); 
            cd3.await(); 
            cd4.await(); 
        } 
        catch (InterruptedException e) { 
            System.out.println(e); 
        } 
  
        es.shutdown(); 
       
        try {
			if(!es.awaitTermination(0, TimeUnit.SECONDS))
			{
			    System.out.println("Is shut down = "+es.isShutdown());
		        System.out.println("Is terminated = "+es.isTerminated());
			}
			else
			{
				 System.out.println("Is shut down 1= "+es.isShutdown());
			        System.out.println("Is terminated 1= "+es.isTerminated());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    } 
} 
  
class MyThread implements Runnable { 
    String name; 
    CountDownLatch latch; 
  
    MyThread(CountDownLatch latch, String name) 
    { 
        this.name = name; 
        this.latch = latch; 
  
        new Thread(this); 
    } 
  
    public void run() 
    { 
        for (int i = 0; i < 5; i++) { 
            System.out.println(name + ":  " + i); 
            latch.countDown(); 
        } 
    } 
} 