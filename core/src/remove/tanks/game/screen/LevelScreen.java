package remove.tanks.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import remove.tanks.game.GameApplication;
import remove.tanks.game.input.InputKey;
import remove.tanks.game.input.InputMapper;
import remove.tanks.game.level.*;

/**
 * @author Mateusz Długosz
 */
public final class LevelScreen extends GameScreen {
    private final Stage stage;
    private final InputMapper inputMapper;
    private final LevelController levelController;

    public LevelScreen(GameApplication gameApplication, LevelController levelController) {
        super(gameApplication);
        this.stage = new Stage();
        this.inputMapper = gameApplication.getContext().getComponent("InputMapper", InputMapper.class);
        this.levelController = levelController;
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) inputMapper.keyDown(InputKey.Left);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) inputMapper.keyDown(InputKey.Right);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) inputMapper.keyDown(InputKey.Up);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) inputMapper.keyDown(InputKey.Down);
        if (Gdx.input.isKeyJustPressed(Input.Keys.CONTROL_LEFT)) inputMapper.keyDown(InputKey.Shoot);

        levelController.update(delta);
        super.render(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
