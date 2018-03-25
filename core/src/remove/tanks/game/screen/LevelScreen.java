package remove.tanks.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import remove.tanks.game.GameApplication;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.input.InputKey;
import remove.tanks.game.input.InputMapper;
import remove.tanks.game.level.LevelController;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.level.LevelState;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class LevelScreen extends GameScreen {
    private final LevelSequence levelSequence;
    private final int playedLevelIndex;
    private final InputMapper inputMapper;
    private final LevelController levelController;
    private final Properties properties;
    private final Skin skin;

    private Stage stage;
    private Window window;

    private boolean screenSwitched;

    public LevelScreen(
            GameApplication gameApplication,
            LevelController levelController,
            LevelSequence levelSequence,
            int playedLevelIndex
    ) {
        super(gameApplication);
        this.levelSequence = levelSequence;
        this.playedLevelIndex = playedLevelIndex;
        this.inputMapper = gameApplication.getContext().getComponent("InputMapper", InputMapper.class);
        this.levelController = levelController;
        this.skin = gameApplication.getContext()
                .getComponent("UISkin", Skin.class);
        this.stage = new Stage(
                gameApplication.getContext()
                        .getComponent("MenuCamera", Game2DCamera.class).getViewport(),
                gameApplication.getContext()
                        .getComponent("SpriteBatch", SpriteBatch.class));
        this.window = createWindow();
        this.properties = levelController.getLevel().getResourceRegistry()
                .getResource(ResourceType.LevelPropertiesResource, Properties.class);

        initStage();
    }

    private void initStage() {
        stage.addActor(window);
    }

    private Window createWindow() {
        Window window = new Window("", skin.get("window-clear", Window.WindowStyle.class));
        window.setFillParent(true);
        window.setMovable(false);
        return window;
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public void render(float delta) {
        if (!screenSwitched) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) inputMapper.keyDown(InputKey.Left);
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) inputMapper.keyDown(InputKey.Right);
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) inputMapper.keyDown(InputKey.Up);
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) inputMapper.keyDown(InputKey.Down);
            if (Gdx.input.isKeyJustPressed(Input.Keys.CONTROL_LEFT)) inputMapper.keyDown(InputKey.Shoot);

            if (properties.getString(LevelProperty.LevelState.getName()).equals(LevelState.End.getName())) {
                getGameApplication().switchScreenWithTransition(
                        new LevelLoadingScreen(
                                getGameApplication(),
                                levelSequence,
                                (playedLevelIndex + 1),
                                levelController.getLevel()
                        )
                );
                screenSwitched = true;
            }
        }
        levelController.update(delta);
        super.render(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
