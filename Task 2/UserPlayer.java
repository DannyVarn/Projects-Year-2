//Meir Kadosh 318870763
//Daniel Varnovitski 206369688

import java.util.Scanner;
public class UserPlayer extends Player{
    
//self player is a player thread with a constructor get type and run funcs


    public UserPlayer(char type,Game game,char playerType){
        super(type,game,playerType);
    
    }
    public char getType(){
        return this.type;
    }
    
    public void run(){
        if (game instanceof UserGame) game.playGame(type,playerType);
        else game.playGame(type);
        return;
       
        }
        
    }

