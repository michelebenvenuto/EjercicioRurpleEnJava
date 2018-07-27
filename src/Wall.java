public class Wall {
    private int Row;
    private int Column;
    //Constructor
    public Wall(int row, int column) {
        Row = row;
        Column = column;
    }
    //Getters & Setters
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