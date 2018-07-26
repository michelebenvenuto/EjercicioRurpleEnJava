public class Robot {
    private int PosicionX;
    private int PosicionY;
    private int Dirreccion;
    private int CoinPurse= 0;

    public void addCoin(){
        this.CoinPurse++;
    }
    public void rotate(){
        this.Dirreccion++;
    }

}
