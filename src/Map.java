import java.util.ArrayList;

public class Map {
    private int Height;
    private int Width;
    private ArrayList<Wall> Walls = new ArrayList();
    private ArrayList<CoinStack> CoinStacks = new ArrayList();
    private Robot robot;
    //Constructor

    public Map(int height, int width, ArrayList<Wall> walls, ArrayList<CoinStack> coinStacks, Robot robot) {
        Height = height;
        Width = width;
        Walls = walls;
        CoinStacks = coinStacks;
        this.robot = robot;
    }

    //Methods
    public void addWall(Wall wall){
        Walls.add(wall);
    }

    public void addCoinStack(CoinStack coinStack){
        CoinStacks.add(coinStack);
    }

    public ArrayList<Wall> getWalls() {
        return Walls;
    }

    public boolean frontIsClear(){
        boolean clear= true;
        ArrayList<Wall> walls= this.getWalls();
        for ( Wall wall: walls){
            if (this.robot.getDirreccion()==0&& this.robot.getRow()+1==wall.getRow() && this.robot.getColumn()==wall.getColumn()){
                clear=false;
            }
            else if(this.robot.getDirreccion()==1 && this.robot.getColumn()+1==wall.getColumn() && this.robot.getRow()==wall.getRow()){
                clear= false;
            }
            else if(this.robot.getDirreccion()==2 && this.robot.getRow()-1==wall.getColumn() && this.robot.getColumn()==wall.getColumn()){
                clear=false;
            }
            else if(this.robot.getDirreccion()==3 && this.robot.getColumn()-1==wall.getColumn() && this.robot.getRow()==wall.getRow()){
                clear= false;
            }
        }
        return clear;
    }
    public CoinStack robotIsOnCoin(){
        int robotRow= this.robot.getRow();
        int robotColumn= this.robot.getColumn();
        ArrayList<CoinStack> coinStacks= this.getCoinStacks();
        for (CoinStack coinStack : coinStacks){
            int coinStackRow= coinStack.getRow();
            int coinStackColumn = coinStack.getColumn();
            if (this.robot.getRow()==coinStackRow && this.robot.getColumn()==coinStackColumn){
                return coinStack;

            }
        }
        return null;
    }
    public ArrayList<CoinStack> getCoinStacks() {
        return CoinStacks;
    }
    public String toString(){
        String map= null;
        for(int Row=0; Row<= this.Height; Row++){
            for(int Column=0; Column<= this.Width; Column ++){
                for(Wall wall:this.Walls){
                    if (wall.getRow()== Row && wall.getColumn()==Column){
                        map+=wall.toString();
                    }
                }
                for (CoinStack coinStack: this.CoinStacks){
                    if (coinStack.getRow()==Row && coinStack.getColumn()==Column){
                        map+=coinStack.toString();
                    }
                }
                if(this.robot.getRow()==Row && this.robot.getColumn()==Column){
                    map+=this.robot.toString();

                }
                else{map+="";}
            }
        }
        return map;
    }
}
