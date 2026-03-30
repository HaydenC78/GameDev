import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends GameObject {
    private int speed;

   public Player(double x, double y) { // Simplified parameters
    super(x, y, 50, 50, "assets/ship.png"); // Fixed filename
    this.speed = 200;
}
    public void move(double deltaTime) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            setX(getX() - speed  * deltaTime);
}
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            setX(getX() + speed  * deltaTime);
}
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            setY(getY() + speed  * deltaTime);
}
   if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            setY(getY() - speed  * deltaTime);
}



    }
}
