import java.util.ArrayList;

public class Map {
    private int Height;
    private int Width;
    private ArrayList<Wall> Walls = new ArrayList();
    private ArrayList<CoinStack> CoinStacks = new ArrayList();
    private Robot robot;
    //Constructor


    public Map(int height, int width, Robot robot) {
        Height = height;
        Width = width;
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
    private boolean frontIsClear(){
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
    public boolean moveRobot(){
        boolean succes=false;
        if (frontIsClear()){
            if(this.robot.getDirreccion()==0){
                this.robot.setRow(this.robot.getRow()+1);
                succes=true;
            }
            else if(this.robot.getDirreccion()==1){
                this.robot.setColumn(this.robot.getColumn()+1);
                succes=true;
            }
            else if(this.robot.getDirreccion()==2){
                this.robot.setRow(this.robot.getRow()-1);
                succes=true;
            }
            else if(this.robot.getDirreccion()==3){
                this.robot.setColumn(this.robot.getColumn()-1);
                succes=true;
            }
        }
        return succes;
    }
    private boolean robotIsOnCoin(){
        boolean onCoin=false;
        int robotRow= this.robot.getRow();
        int robotColumn= this.robot.getColumn();
        ArrayList<Wall> walls= this.getWalls();
        for (Wall wall : walls){
            int wallRow= wall.getRow();
            int wallColumn = wall.getColumn();
            if (robotRow==wallRow && robotColumn==wallColumn){
                onCoin= true;
            }
        }
        return onCoin;
    }

    public ArrayList<CoinStack> getCoinStacks() {
        return CoinStacks;
    }
}
