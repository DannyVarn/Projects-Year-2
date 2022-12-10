//Meir Kadosh 318870763
//Daniel Varnovitski 206369688

import java.util.Scanner;

public class UserGame extends Game {
    //self game will control a game played by user player and a self player
    public UserGame(){
        super();
    }


    public synchronized void playGame(char type,char playerType){
        //play game is running until the board is full or there is a winner
        //it will check what type the player using it is and the symbol, and wait/notify accordingly,
        //will print the boards two times each turn one before and on after a symbol is played
        //will change turns and notify after, and will wait until the other player notifies it.
        //will ask the player when its his turn for input according to the printer board while the pc is waiting, when the player chooses the 
        //player thread waits and will check if its time for it to play each 0.5 seconds
        Scanner in = new Scanner(System.in);
        while (!isFull()){
            
            if (type=='X'&&playerType == 'U'){
                
                while(!xplayed){
                    printBoard();
                    System.out.println("Choose Row and column of the cell to play into");
                    int row = in.nextInt();
                    int col = in.nextInt();
                    setCell(row, col, 'X');
                    printBoard();
                    if (isWinner()){
                        System.out.println("you are the fucking winner jonhy!");
                        fillWhenDone();
                        
                        notifyAll();
                        return;
                    }
                    System.out.println("PC turn");
                    changeTurn();
                    notifyAll();
                    if (isFull()) return;
                    boolean turn = false;
                    while (!turn){
                    try{
                        Thread.sleep(500);
                        wait();
                        turn = true;
                    }catch(Exception e){};
                }
                    
                }
            }
            if (type!='X'&&playerType == 'U'){
                while(xplayed){
                   
                    printBoard();
                    System.out.println("Choose Row and column of the cell to play into from 0 - 2 and is not occupied");
                    int row = in.nextInt();
                    int col = in.nextInt();
                    setCell(row, col, 'O');
                    printBoard();
                    if (isWinner()){
                        System.out.println("you are the fucking winner jonhy!");
                        fillWhenDone();
                        notifyAll();
                        return;
                    }
                    System.out.println("PC turn");
                    changeTurn();
                    notifyAll();
                    
                }   
                boolean turn = false;
                while (!turn){
                    try{
                        Thread.sleep(500);
                        wait();
                        turn = true;
                    }catch(Exception e){};
                
            }           
        }
        if (type=='X'&&playerType == 'P'){
               
            while(!xplayed){
                
                printBoard();
                chooseEmptyCell('X');
                printBoard();
                if (isWinner()){
                    System.out.println("PC WINS!!!");
                    fillWhenDone();
                    
                    notifyAll();
                    return;
                }
                changeTurn();
               
                notifyAll();
                if (isFull()) return;
                
                try{wait();}catch(Exception e){};
                
            }}
        if (type!='X'&&playerType == 'P'){
           
          
            while(xplayed){
                
                
                printBoard();
                chooseEmptyCell('O');
                printBoard();
                if (isWinner()){
                    System.out.println("PC WINS!!!");
                    fillWhenDone();
                    notifyAll();
                    return;
                }
                changeTurn();
                notifyAll();
                if (isFull()) return;
                
            }    try{wait();}catch(Exception e){};  
        }           
    
        
    }System.out.println("Game ending");
    }
}
