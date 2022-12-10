//Meir Kadosh 318870763
//Daniel Varnovitski 206369688

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class VehicleWasher {
    //the class vehiclewasher will store all the lists of the cars that are coming, staying in wash and leaving the wash
    //also will have a semaphore that will regulate the number of cars that can be washed at the same time
    //the constructor of VehicleWasher will get inputs for amount of cars, the time to get them washed and the amount of washing stations
    // also VehicleWasher has two funcs that updates the lists of cars that go into wash and finish washing and sorts them by type 
    //also has a randomize func that will calculate random values based on a value sent to it and a puasonic formula
    int  CountwhehiclesInStations=0;
    Wehicle whehiclesInStations [];
    Wehicle vehicles [];
    int vehicleCount;
    Car WashedCars [];
    SUV WashedSUVs [];
    Truck WashedTrucks [];
    MiniBus WashedMiniBuses [];
    String logId_Type[];
    Semaphore sem;
    Random rand;
    int stations;
    double lambdaWashTime;
    double lambdaArriveTime;
    int WashedSUVsCount = 0,WashedcarsCount=0,WashedTrucksCount=0, WashedMiniBusesCount=0;
    
        public VehicleWasher(){
            //constructor of VehicleWasher will get inputs for amount of cars, the time to get them washed and the amount of washing stations
            //the semaphore that will be controling how many cars can be washedd at the same time will be created based on recieved amount of stations and will
            //prioritize the cars that arrived first so no cars stay in line and enter after anyone arriving after them
            Scanner in = new Scanner(System.in);
            System.out.println("Enter number of washing stations");
            this.stations = in.nextInt();
            this.sem = new Semaphore(stations,true);
            this.whehiclesInStations = new Wehicle[stations];
            System.out.println("How many vehicles will be washed today?");
            this.vehicleCount = in.nextInt();
            this.vehicles  = new Wehicle[vehicleCount];
            this.WashedSUVs  = new SUV[vehicleCount];
            this.WashedCars  = new Car[vehicleCount];
            this.WashedTrucks  = new Truck[vehicleCount];
            this.WashedMiniBuses  = new MiniBus[vehicleCount];
            this.logId_Type =new String [vehicleCount];
            System.out.println("How much time does it take for a vehicle to be washed?");
            this.lambdaWashTime = in.nextInt();
            System.out.println("How much time does it take for a vehicle to arrive?");
            this.lambdaArriveTime = in.nextInt();
    }       
    
    public synchronized void updateInWash(Wehicle v){
        //get a vehicle and inserts it into the inwash list, also searches for it in the main cars list and remove it from there, will update count of both lists
        for (int i=0;i<vehicleCount;i++){
            if (vehicles[i].equals(v)){
                vehicles[i]=vehicles[vehicleCount-1];
                vehicleCount--;
            }
        }

        whehiclesInStations[CountwhehiclesInStations] = v;
        CountwhehiclesInStations++;
        

    }
    public synchronized void updateDoneWashing(Wehicle v){
        //will find and delete the given car from the inwash list and then insert the car into the washed cars by the type of the car and update counters accordingly
        for (int i=0;i<CountwhehiclesInStations;i++){
            if (whehiclesInStations[i].equals(v)){
                
                whehiclesInStations[i]=whehiclesInStations[CountwhehiclesInStations-1];
                CountwhehiclesInStations--;
            }
        }
        switch(v.getType()){
            case("Car"):{
                WashedCars[WashedcarsCount] = (Car)v;
                WashedcarsCount++;
                break;
            }
                
            case("SUV"):{
                WashedSUVs[WashedSUVsCount] = (SUV)v;
                WashedSUVsCount++;
                break;
            }
                
            case("Truck"):{
                WashedTrucks[WashedTrucksCount] = (Truck)v;
                WashedTrucksCount++;
                break;
            }
               
            case("MiniBus"):{
                WashedMiniBuses[WashedMiniBusesCount] = (MiniBus)v;
                WashedMiniBusesCount++;
                break;
            }
                
        }
    }

    public double randomize(double lambda){
        //will return a value with the puasonic formula for the time of a vehicle to arrive or get washed
        double x = -(Math.log( Math.random())/lambda);
        return x;
    }


    public static  void main(String []args){
        //main will create a washer and will create cars according to washer inputs, will store the car in the cars list 
        //the cars will be created of random type with random arrive and wash times
        //also the main will save the amount of time it took for the whole program to run and will save the washed cars by type and id
        //will write to a new text file the cars and the time.
        Random rand = new Random();
        long startTime = System.nanoTime();
        VehicleWasher v = new VehicleWasher();
        Thread []threads = new Thread[v.vehicleCount];
        for (int i=0;i<v.vehicleCount;i++){
            switch(rand.nextInt((4 - 1) + 1) + 1){
                case(1): v.vehicles[i] = new Car(v.randomize(v.lambdaWashTime),(rand.nextInt((10 - 1) + 1) + 1)*v.randomize(v.lambdaArriveTime),v.sem,v); break;
                case(2): v.vehicles[i] = new SUV(v.randomize(v.lambdaWashTime),(rand.nextInt((10 - 1) + 1) + 1)*v.randomize(v.lambdaArriveTime),v.sem,v);  break; 
                case(3): v.vehicles[i] = new Truck(v.randomize(v.lambdaWashTime),(rand.nextInt((10 - 1) + 1) + 1)*v.randomize(v.lambdaArriveTime),v.sem,v);break;
                case(4): v.vehicles[i] = new MiniBus(v.randomize(v.lambdaWashTime),(rand.nextInt((10 - 1) + 1) + 1)*v.randomize(v.lambdaArriveTime),v.sem,v);break;
            }
        }
        for (int i=0;i<v.vehicleCount;i++){
            threads[i] = new Thread(v.vehicles[i],"Vehicle"+i);
            v.logId_Type[i] = "Vehicle"+i+" "+ v.vehicles[i].getType();
        }
        for (int i=0;i<v.vehicleCount;i++){
            threads[i].start();
        }
        
        long endTime   = System.nanoTime();
        long runtime = endTime - startTime;
        try{
        WehicleLogger l = new WehicleLogger(runtime,v.logId_Type);
        }catch(Exception exception){exception.printStackTrace();}
    }
    
    











}
