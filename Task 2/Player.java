//Meir Kadosh 318870763
//Daniel Varnovitski 206369688

public abstract class Player implements Runnable {
   //player class is a thread class of a player that will be used in computer and self player and will be running and playing the game with game as shared resource
   //has two constructors with type game and player type for the pc vs player game
      
   char type;
   Game game;
   char playerType;
   public Player(char type,Game game){
      this.type=type;
      this.game = game;
   }
   public Player(char type,Game game,char playerType){
      this.type=type;
      this.game = game;
      this.playerType = playerType;
   }



  


}
