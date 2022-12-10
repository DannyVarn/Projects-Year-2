//Meir Kadosh 318870763
//Daniel Varnovitski 206369688

import java.util.Random;
public abstract class Game {
    //class game will be the abstract class that the other two game types will run using it
    //has a borad, the constructor will create, will have methods for printing the board,get free cells,is winner,set cell change turn,fill when done
    //choose empty cell and two play game methods
     Cell [][] board;
     int freeCells;
     boolean xplayed;

     public Game(){
        //constructor for the game will inicialize new cells in every place on the board with default "-" symbol
        //also sets xplayed to false as the x should be playing first
        this.board  = new Cell[3][3];
        int freeCells;
        this.xplayed = false;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                board[i][j] = new Cell(i,j,'-');
            }
        }
     }
     public synchronized void printBoard(){//printing all the cells on the board
         for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                 System.out.print(board[i][j]);  
            }
            System.out.println();
        }
        System.out.println();
     }
     public synchronized Cell[] getFreeCels(){//finds all free cells that has "-" in them
     //returns all free celss in a list of cells, updates the count of free cells
     
        Cell [] freeCells = new Cell[9];
        this.freeCells=0;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (board[i][j].getSymbol() == '-'){
                    freeCells[this.freeCells] = board[i][j];  
                    this.freeCells++;
                }
            }
        }
        this.freeCells--;
        return freeCells;
    }

     public synchronized boolean isWinner(){
//is winner func will check all the possible conditions for winning a game
        for (int i=0;i<3;i++) { // finding x/o in rows 
        if (board[i][0].compare(board[i][1],board[i][2]))
            return true;
        if (board[0][i].compare(board[1][i],board[2][i]))
            return true;
        }
        int row=0;
        if (board[row][row].compare(board[row+1][row+1],board[row+2][row+2]))
            return true;
        if (board[row][row+2].compare(board[row+1][row+1],board[row+2][row]))
            return true;
        return false;
     }
     public synchronized  boolean isFull(){
        //will check if the board is full by first calling getfree cells which will update the counter of free cells and return according to the value of free cells
        getFreeCels();
        if (this.freeCells ==-1){
            
            
            return true;
        }
        return false;
}

    public synchronized  void setCell(int row, int col, char symbol){
        //getting row and col for a cell to change the symbol and the symbol to change to
        this.board[row][col].setSymbol(symbol);
    }
    public synchronized  void  setCell(Cell c,char symbol){
        //getting a cell to change the symbol and the symbol to change to
        this.board[c.getRow()][c.getCol()].setSymbol(symbol);
    }
    public synchronized  void  changeTurn(){
        //chenging the turn 
        if (this.xplayed) xplayed = false;
        else xplayed = true;

    }
    public synchronized void  fillWhenDone(){
        //when the game is done we call the func to fill the board with "*" that will indicate the game is finished and board will be "full" and the game will end
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                 this.board[i][j].setSymbol('*');
            }
    }
}
    public synchronized void  chooseEmptyCell(char symbol){
        //choosing the cell to play for the pc,will get a symbol to play, will get an array of possible cells from get free cells func 
        //will just end if there are no free cells, otherwise will pick a random cell to play to
        Cell[] fc = getFreeCels();
        if (this.freeCells == -1) return; 
        else{
        Random rand  = new Random();
       
        setCell(fc[rand.nextInt(((this.freeCells-0)+1)+0)],symbol);
        }
    }
    public void playGame(char type){};
    public void playGame(char type,char playerType){};
    

}


