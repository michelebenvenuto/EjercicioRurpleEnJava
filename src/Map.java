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
}
