package remove.tanks.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import remove.tanks.game.GameApplication;
import remove.tanks.game.level.*;

/**
 * @author Mateusz Długosz
 */
public final class LevelLoadingScreen extends GameScreen {
    private final LevelFactory levelFactory;
    private final LevelControllerFactory levelControllerFactory;
    private final LevelPrefabXmlReader levelPrefabXmlReader;
    private final String levelPrefabFilename;
    private final Stage stage;

    private LevelPrefab levelPrefab;
    private LevelController levelController;

    private boolean levelLoaded;
    private boolean screenSwitched;

    public LevelLoadingScreen(GameApplication gameApplication, String levelPrefabFilename) {
        super(gameApplication);
        this.levelPrefabFilename = levelPrefabFilename;
        this.levelFactory = gameApplication.getContext()
                .getComponent("LevelFactory", LevelFactory.class);
        this.levelControllerFactory = gameApplication.getContext()
                .getComponent("LevelControllerFactory", LevelControllerFactory.class);
        this.levelPrefabXmlReader = gameApplication.getContext()
                .getComponent("LevelPrefabXmlReader", LevelPrefabXmlReader.class);

        this.stage = new Stage();
        this.levelLoaded = false;
        this.screenSwitched = false;
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public void render(float delta) {
        if (!levelLoaded) {
            levelPrefab = levelPrefabXmlReader.readLevelPrefab(Gdx.files.internal(levelPrefabFilename));
            levelController = levelControllerFactory.createLevelController(levelFactory.createLevel(levelPrefab));
            levelLoaded = true;
        } else {
            if (!screenSwitched) {
                getGameApplication().switchScreenWithTransition(
                        new LevelScreen(getGameApplication(), levelController));
                screenSwitched = true;
            }
        }
        super.render(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
