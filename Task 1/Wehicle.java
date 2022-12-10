//Meir Kadosh 318870763
//Daniel Varnovitski 206369688

import java.util.concurrent.Semaphore;

public abstract class Wehicle implements Runnable{
    //class vehicle that will be a thread, has the washer as a shared resource and a shared semaphore to control the number of cars in wash 
    //also has a toString and gettype funcs
    double washTime;
    double waitTime;
    VehicleWasher washer;
    Semaphore sem;
    String type;
    public Wehicle(double washTime,double waitTime, Semaphore sem, VehicleWasher washer){
        //constructor for vehicle getting wash time and wait time, semaphore and washer
        this.washTime = washTime;
        this.sem =sem;
        this.waitTime = waitTime;
        this.washer = washer;
      
    }
    
   




    public void run(){
        //will wait the amount of time it needs until "arriving to wash" then will aqquire a permit from the semaphore when one is available 
        //will sleep with the aquired permit the given time for it to get washed and then realease it
        //while running will call the washer's list update funcs
        
        try{
            Thread.sleep((long)waitTime*1000);
            System.out.println(this.type +" "+ Thread.currentThread().getName() + " Arrived to queue");
            sem.acquire();
            System.out.println(this.type +" "+ Thread.currentThread().getName() + " Entered Washing Station");
            washer.updateInWash(this);
            Thread.sleep((long)washTime*1000);
            washer.updateDoneWashing(this);
            System.out.println(this.type +" "+ Thread.currentThread().getName() + " Finished Washing");
            sem.release();

        }
        catch(InterruptedException e){e.printStackTrace();}
        
       

       

    



    }





    public String getType() {
        return this.type;
    }
    public String toString(){
        return this.type + Thread.currentThread().getName();
    }


    
























    
}
