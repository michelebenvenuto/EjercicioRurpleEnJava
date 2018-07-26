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
