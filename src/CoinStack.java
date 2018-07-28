public class CoinStack{
    private int Row;
    private int Column;
    private int CoinAmount;

    public CoinStack(int row, int column, int amount) {
        Row = row;
        Column = column;
        CoinAmount = amount;
    }
    public int getCoinAmount() {
        return CoinAmount;
    }

    public int getRow() {
        return Row;
    }

    public void setRow(int row) {
        Row = row;
    }

    public int getColumn() {
        return Column;
    }

    public void setColumn(int column) {
        Column = column;
    }
}
