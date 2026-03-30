import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class MyGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private ArrayList<GameObject> activeObjects;
    private Player player; // Storing a reference to the player for easy collision checking

    @Override
    public void create() {
        batch = new SpriteBatch();
        activeObjects = new ArrayList<GameObject>();

        // TODO 3: Instantiate Player and add to list
        // Note: Using the simplified constructor we discussed
        player = new Player(100, 100); 
        activeObjects.add(player);

        // TODO 4: Instantiate 5 Enemy objects in a loop
        for(int i = 0; i < 5; i++){
            int y = 100 + (i * 60);
            Enemy enemy = new Enemy(400, y, 50, 50, "assets/fish_blue.png");
            activeObjects.add(enemy);
        }
    }

    @Override
    public void render() {
        // Clear the screen
        Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        double deltaTime = (double) Gdx.graphics.getDeltaTime();

        // --- 1. UPDATE PHASE (Polymorphism) ---
        // Move every object in the list
        for(GameObject obj : activeObjects){
            obj.move(deltaTime);
        }

        // --- 2. DRAW PHASE ---
        batch.begin();
        for (GameObject obj : activeObjects) {
            obj.draw(batch);
        }
        batch.end();

        // --- 3. COLLISION PHASE (Safe Removal) ---
        // TODO 7: Traverse backwards to avoid IndexOutOfBoundsException or skipping
        for (int i = activeObjects.size() - 1; i >= 0; i--) {
            GameObject obj = activeObjects.get(i);
            
            // Check if the object is an Enemy (we don't want the player to "capture" themselves)
            if (obj instanceof Enemy) {
                // If the player's hitbox overlaps the enemy's hitbox
                if (player.getHitbox().overlaps(obj.getHitbox())) {
                    activeObjects.remove(i);
                }
            }
        }
    }
    
    @Override
    public void dispose() {
        batch.dispose();
        // In a real game, you would also dispose of the textures inside the GameObjects
    }
}