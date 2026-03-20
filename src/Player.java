public class Player extends GameObject {
    private double x;
    private double y;
    private int speed = 200;

    public Player(double x, double y, int width, int height,String imagePath){
        super(x,y, width:50, height:50, imagePath:assets/ships.png);
    }
}
