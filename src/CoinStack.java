public class CoinStack{
    private int Row;
    private int Column;
    private int CoinAmount;

    //Constructor
    public CoinStack(int row, int column, int amount) {
        Row = row;
        Column = column;
        CoinAmount = amount;
    }
    public int getCoinAmount() {
        return CoinAmount;
    }

    public void setCoinAmount(int coinAmount) {
        CoinAmount = coinAmount;
    }

    public int getRow() {
        return Row; }

    public void setRow(int row) {
        Row = row;
    }

    public int getColumn() {
        return Column;
    }

    public void setColumn(int column) {
        Column = column;
    }
    public String toString(){
        return Integer.toString(getCoinAmount());
    }
}
