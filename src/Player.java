import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends GameObject {
    private double x;
    private double y;
    private int speed = 200;

    public Player(double x, double y, int width, int height,String imagePath){
        super(x,y, 50, 50, "assets/ships.png");
    }
    public void move(double deltaTime) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= speed * deltaTime;
}
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += speed * deltaTime;
}


    }
}
