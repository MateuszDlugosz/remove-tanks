package remove.tanks.game.screen;

import com.badlogic.gdx.scenes.scene2d.Stage;
import remove.tanks.game.GameApplication;

/**
 * @author Mateusz Długosz
 */
public final class LevelLoadingScreen extends GameScreen {
    private final Stage stage;

    public LevelLoadingScreen(GameApplication gameApplication) {
        super(gameApplication);
        this.stage = new Stage();
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }
}
