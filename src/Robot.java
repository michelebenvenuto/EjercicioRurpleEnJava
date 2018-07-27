import java.util.ArrayList;

import java.util.ArrayList;

public class Robot {
    private int Row;
    private int Column;
    private int Dirreccion;
    private int CoinPurse= 0;

    //Constructor
    public Robot(int row, int column, int dirreccion) {
        this.Row = row;
        this.Column = column;
        Dirreccion = dirreccion;
    }

    //Methods
    public void pickCoin(){
        this.CoinPurse++;
    }

    public void rotate(){
        if (this.getDirreccion()<3){
            this.Dirreccion++;
        }
        else{
            this.Dirreccion=0;
        }
    }
    public boolean frontIsClear(ArrayList<Wall> walls){
        boolean clear= true;
        for (Wall wall: walls){
            if (this.Dirreccion==0&& this.Row++==wall.getRow() && this.Column==wall.getColumn()){
                clear=false;
            }
            else if(this.Dirreccion==1&& this.Column++==wall.getColumn() && this.Row==wall.getRow()){
                clear= false;
            }
            else if(this.Dirreccion==2 && this.Row--==wall.getColumn() && this.Column==wall.getColumn()){
                clear=false;
            }
            else if(this.Dirreccion==3 && this.Column--==wall.getColumn() && this.Row==wall.getRow()){
                clear= false;
            }
        }
        return clear;
    }
    //Getters & Setters
    public int getDirreccion() {
        return Dirreccion;
    }

    public int getCoinPurse() {
        return CoinPurse;
    }

    public int getRow() {
        return Row;
    }

    public void setRow(int row) {
        this.Row = row;
    }

    public int getColumn() {
        return Column;
    }

    public void setColumn(int column) {
        this.Column = column;
    }
}