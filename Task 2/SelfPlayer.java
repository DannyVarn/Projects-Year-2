//Meir Kadosh 318870763
//Daniel Varnovitski 206369688

public class SelfPlayer extends Player{
    //self player is a computer player thread with two possible constructors like player and a run which will run the game according to pc vs pc or player vs pc

    public SelfPlayer(char type,Game game){
        super(type,game);
        
    }
    public SelfPlayer(char type,Game game,char playerType){
        super(type,game,playerType);
    
    }
    public  void run(){
        if (game instanceof UserGame) game.playGame(type,playerType);
        else game.playGame(type);
        return;
        
}
    
}
