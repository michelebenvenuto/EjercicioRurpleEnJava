import com.sun.org.apache.xpath.internal.functions.FuncSubstring;

import java.util.ArrayList;

public class Map {
    private int Height;
    private int Width;
    private ArrayList<Wall> Walls = new ArrayList();
    private ArrayList<CoinStack> CoinStacks = new ArrayList();
    private Robot robot;
    //Constructor
    public void createMap(ArrayList<String> readMap) {
        this.Height=readMap.size();
        this.Width=readMap.get(0).length();
        String actualRow;
        Character character;
        for (int row = 0; row < readMap.size(); row++) {
            actualRow=readMap.get(row);
            for (int column=0; column < actualRow.length();column++){
                character=actualRow.charAt(column);
                String symbol=String.valueOf(character);
                if(character==42){
                    Wall newWall= new Wall(row,column);
                    this.addWall(newWall);
                }
                else if(character==94){
                    Robot newRobot= new Robot(row, column,0);
                    this.robot=newRobot;
                }
                else if(character==62){
                    Robot newRobot= new Robot(row, column,1);
                    this.robot=newRobot;
                }
                else if(character== 86){
                    Robot newRobot= new Robot(row, column,2);
                    this.robot=newRobot;
                }
                else if(character==6){
                    Robot newRobot= new Robot(row, column,3);
                    this.robot=newRobot;
                }
                else if (checkIfCoin(symbol)){
                    CoinStack newCoinstack= new CoinStack(row,column,Integer.parseInt(symbol));
                    this.addCoinStack(newCoinstack);
                }

            }
        }
    }
    private boolean checkIfCoin(String letter){
        try{
            int numero= Integer.valueOf(letter);
            if(1<= numero && numero<=9){
                return true;
            }
            else{
                return false;
            }
        }catch (NumberFormatException exeption){
            return false;
        }
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

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
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
            if (robotRow==coinStackRow && robotColumn==coinStackColumn){
                return coinStack;

            }
        }
        return null;
    }
    public ArrayList<CoinStack> getCoinStacks() {
        return CoinStacks;
    }
    public String toString(){
        String map="";
        Robot robot= this.getRobot();
        for(int Row=0; Row < this.Height; Row++){
            map+="\n";
            for(int Column=0; Column <this.Width; Column ++){
                for(Wall wall:this.Walls){
                    if (wall.getRow()== Row && wall.getColumn()==Column){
                        map += wall;
                    }
                }
                for (CoinStack coinStack: this.CoinStacks){
                    if (coinStack.getRow()==Row && coinStack.getColumn()==Column){
                        map+=coinStack;
                    }
                }
                if(robot.getRow()==Row && robot.getColumn()==Column){
                    map+=this.getRobot();
                }else{map+="";}
            }
        }
        return map;
    }
}
