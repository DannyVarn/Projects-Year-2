//Meir Kadosh 318870763
//Daniel Varnovitski 206369688

import java.util.concurrent.Semaphore;

public class MiniBus extends Wehicle{
    //MiniBus class exntends vehicle and in its constructor updates its type 
    public MiniBus (double washTime,double waitTime, Semaphore sem ,VehicleWasher washer){
        super(washTime, waitTime, sem,washer);
        type = "MiniBus";
    }
}
