//Meir Kadosh 318870763
//Daniel Varnovitski 206369688

import java.util.Scanner;



public class Main {
    //main class will be getting inputs as to what type of game will be played and what type the player is playing (if applicable)
    //will be creating the threads and running them
    //will validate the X/O input of the player
    public static void main (String []args){

    
    Scanner in = new Scanner(System.in);
    System.out.println("Pick 1 for pc, 2 for Player");

    switch(in.nextInt()){
        case(1):{
            SelfGame game = new SelfGame();
            SelfPlayer px = new SelfPlayer('X', game);
            SelfPlayer po = new SelfPlayer('O', game);
            Thread t1 = new Thread(po,"po");
            Thread t2 = new Thread(px,"px");
            t1.start();
            t2.start();
            break;
        }
        case(2):{
            boolean valid=false;
            while (!valid){
            System.out.println("Are you playing X/O?");
            in.nextLine();
            switch(in.nextLine().charAt(0)){
                case('X'):{
                    UserGame game = new UserGame();
                    SelfPlayer po = new SelfPlayer('O', game,'P');
                    UserPlayer ux = new UserPlayer('X', game,'U');
                    Thread t1 = new Thread(po,"po");
                    Thread t2 = new Thread(ux,"ux");
                    t1.start();
                    t2.start();
                    valid = true;
                    break;
                }
                case('O'):{
                    UserGame game = new UserGame();
                    SelfPlayer po = new SelfPlayer('X', game,'P');
                    UserPlayer ux = new UserPlayer('O', game,'U');
                    Thread t1 = new Thread(po,"po");
                    Thread t2 = new Thread(ux,"ux");
                    t1.start();
                    t2.start();
              
                    valid = true;
                    break;
                }
                default:{
                    System.out.println("Invalid input try again.");
                  }
                }
                }
            }
    }
    







}
}
