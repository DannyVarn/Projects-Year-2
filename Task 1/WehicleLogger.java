//Meir Kadosh 318870763
//Daniel Varnovitski 206369688

import java.io.File;
import java.io.PrintWriter;



public class WehicleLogger {
//logger class will have a constructor that creates a new text file and openes an input stream to it
//writes into it all the cars that were washed with their id and type and also
//the run time for the whole program

    public WehicleLogger(long runTime, String[] vehicles)throws Exception{
        File file = new File("D:\\Dany\\Java\\Year 2\\Concurrency\\Assignment 2\\Task 1\\log.txt");
        PrintWriter pr = new PrintWriter(file);
        pr.print("Program Running time was: " + runTime/1000+"\n");
        for (int i=0;i<vehicles.length;i++){
            pr.print (vehicles[i]+ "\n");
        }

        pr.close();
    }
    
}
