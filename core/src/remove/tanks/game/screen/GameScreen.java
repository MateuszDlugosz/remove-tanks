package remove.tanks.game.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import remove.tanks.game.GameApplication;

/**
 * @author Mateusz Długosz
 */
public abstract class GameScreen implements Screen {
    private final GameApplication gameApplication;

    public GameScreen(GameApplication gameApplication) {
        this.gameApplication = gameApplication;
    }

    public GameApplication getGameApplication() {
        return gameApplication;
    }

    public abstract Stage getStage();

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        getStage().draw();
        getStage().getCamera().update();
        getStage().getBatch().setProjectionMatrix(getStage().getCamera().combined);
        getStage().act(delta);
        getStage().draw();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
}
