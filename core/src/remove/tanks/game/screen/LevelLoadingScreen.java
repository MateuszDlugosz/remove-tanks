package remove.tanks.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import remove.tanks.game.GameApplication;
import remove.tanks.game.level.*;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class LevelLoadingScreen extends GameScreen {
    private final LevelSequence levelSequence;
    private final Level previousLevel;
    private final int levelToLoadIndex;

    private final LevelDisposer levelDisposer;

    private final LevelFactory levelFactory;
    private final LevelControllerFactory levelControllerFactory;
    private final LevelPrefabXmlReader levelPrefabXmlReader;
    private final String levelPrefabFilename;
    private final Stage stage;

    private LevelController levelController;

    private boolean levelDisposed;
    private boolean levelLoaded;
    private boolean screenSwitched;

    public LevelLoadingScreen(
            GameApplication gameApplication,
            LevelSequence levelSequence,
            int levelToLoadIndex,
            Level previousLevel
    ) {
        super(gameApplication);
        this.levelSequence = levelSequence;
        this.previousLevel = previousLevel;
        this.levelToLoadIndex = levelToLoadIndex;
        this.levelDisposer = gameApplication.getContext()
                .getComponent("LevelDisposer", LevelDisposer.class);

        this.levelPrefabFilename = levelSequence.getLevelPrefabFilenames().get(levelToLoadIndex);
        this.levelFactory = gameApplication.getContext()
                .getComponent("LevelFactory", LevelFactory.class);
        this.levelControllerFactory = gameApplication.getContext()
                .getComponent("LevelControllerFactory", LevelControllerFactory.class);
        this.levelPrefabXmlReader = gameApplication.getContext()
                .getComponent("LevelPrefabXmlReader", LevelPrefabXmlReader.class);
        this.stage = new Stage();
        this.levelLoaded = false;
        this.screenSwitched = false;
        this.levelDisposed = false;
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public void render(float delta) {
        if (!levelDisposed) {
            disposeLevel();
            levelDisposed = true;
        }

        if (!levelLoaded) {
            LevelPrefab levelPrefab = levelPrefabXmlReader.readLevelPrefab(Gdx.files.internal(levelPrefabFilename));
            levelController = levelControllerFactory.createLevelController(levelFactory.createLevel(levelPrefab));
            levelLoaded = true;
        } else {
            if (!screenSwitched) {
                getGameApplication().switchScreenWithTransition(
                        new LevelScreen(getGameApplication(), levelController, levelSequence, levelToLoadIndex));
                screenSwitched = true;
            }
        }

        super.render(delta);
    }

    private void disposeLevel() {
        Optional.ofNullable(previousLevel).ifPresent(l -> levelDisposer.disposeLevel(previousLevel));
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
