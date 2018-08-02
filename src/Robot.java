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
    public void rotate(){
        if (this.getDirreccion()<3){
            this.Dirreccion+=1;
        }
        else{
            this.Dirreccion=0;
        }
    }
    public void addCoin(){
        this.CoinPurse++;
    }
    public boolean moveRobot(Map map){
        boolean succes=false;
        if (map.frontIsClear()){
            if(this.getDirreccion()==0){
                this.setRow(this.getRow()+1);
                succes=true;
            }
            else if(this.getDirreccion()==1){
                this.setColumn(this.getColumn()+1);
                succes=true;
            }
            else if(this.getDirreccion()==2){
                this.setRow(this.getRow()-1);
                succes=true;
            }
            else if(this.getDirreccion()==3){
                this.setColumn(this.getColumn()-1);
                succes=true;
            }
        }
        return succes;
    }
    public boolean pickCoin(Map map){
        if (map.robotIsOnCoin()!=null){
            this.addCoin();
            CoinStack coinStack=map.robotIsOnCoin();
            coinStack.setCoinAmount(coinStack.getCoinAmount()-1);
            return true;
        }
        else{return false;}
    }

    //Getters & Setters
    public int getDirreccion() {
        return Dirreccion;
    }

    public void setDirreccion(int dirreccion) {
        Dirreccion = dirreccion;
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

    public String toString(){
        String direction="";
        switch (this.getDirreccion()){
            case 0: direction= "^";
            case 1: direction= ">";
            case 2: direction= "V";
            case 3: direction= "<";
        }
        return direction;
    }
}