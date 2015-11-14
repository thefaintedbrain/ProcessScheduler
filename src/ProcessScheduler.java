
import java.util.Scanner;

/**
 *
 * @author Umair Qamar
 */
public class ProcessScheduler extends Thread{
   private Thread t;
   private String threadName;
   private static int execTime;
   
    ProcessScheduler(String name,int time){
        threadName=name;
        execTime=time;
        System.out.println("Creating " +  threadName + " Exection time:" +execTime  );
    }

    public void run(){
    System.out.println("Running " +  threadName + " Exection time:" +execTime   );
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + " Exection time:" +execTime   + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
     } catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
     }
     System.out.println("Thread " +  threadName + " exiting.");
    
}
    public static void main(String[] args) {
        int execTime =5;    //execution time Default=5s
        int io=0;            // how many times this process would go to “waiting” state.two seconds sleep for waiting
        int timeSlice=1;    //1 sec As soon as the time slice is expired the process must go to ready queue.
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Execution time in seconds: ");
        execTime = in.nextInt();
        System.out.println("Execution Time: "+execTime);
        
        ProcessScheduler T1 = new ProcessScheduler( "Thread-1",execTime);
        T1.start();
      
        
    }   
    
}
