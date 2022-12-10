//Meir Kadosh 318870763
//Daniel Varnovitski 206369688

public class Cell {
    //cell class will have row col and symbol stored, get and set for symbol, compare to symbols, get for row and col and to string for printing a cell
    int row;
    int col;
    char symbol;
    public Cell(int row,int col,char symbol)
    {//constructor with row col and symbol
        this.row=row;
        this.col = col;
        this.symbol=symbol;
    }
    public char getSymbol(){
        return this.symbol;
    }
    public void setSymbol(char symbol){
        this.symbol = symbol;
    }
    public boolean compare(Cell c1,Cell c2 ){//comparing three cells, itself with two others it gets
        if(this.symbol=='X'&&c1.getSymbol()=='X'&&c2.getSymbol()=='X') 
            return true;
        if(this.symbol=='O'&&c1.getSymbol()=='O'&&c2.getSymbol()=='O') 
            return true;
        return false;
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public String toString(){
        return ("["+symbol+"] ");
    }
   
}



























// int left int right 