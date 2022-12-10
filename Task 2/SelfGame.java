//Meir Kadosh 318870763
//Daniel Varnovitski 206369688

public class SelfGame extends Game {
    //self game will control a game played by two self players will have play game func
    public SelfGame(){
        super();
    }
   
    public synchronized void  playGame(char type){
        //play game is running until the board is full or there is a winner
        //it will check what type of symbol the player is playing, and wait/notify accordingly,
        //will print the boards two times each turn one before and on after a symbol is played
        //will change turns and notify after, and will wait until the other player notifies it.
        while (!isFull()){
            
            if (type=='X'){
               
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
                    
                    
                } 
            }
            if (type!='X'){
               
              
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
                    
                }      try{wait();}catch(Exception e){};
            }           
        
    }System.out.println("Game ending");
    }
    }
    

