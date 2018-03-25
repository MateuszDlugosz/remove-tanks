package remove.tanks.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import remove.tanks.game.GameApplication;
import remove.tanks.game.data.profile.Profile;
import remove.tanks.game.data.profile.ProfileController;
import remove.tanks.game.level.*;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class LevelLoadingScreen extends GameScreen {
    private final LevelSequence levelSequence;
    private final Level previousLevel;
    private final int levelToLoadIndex;

    private final LevelDisposer levelDisposer;
    private final LevelTransferablePropertiesExtractor
            levelTransferablePropertiesExtractor;
    private final LevelFactory levelFactory;
    private final LevelControllerFactory levelControllerFactory;
    private final LevelPrefabXmlReader levelPrefabXmlReader;
    private final ProfileController profileController;
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
        this.levelFactory = gameApplication.getContext()
                .getComponent("LevelFactory", LevelFactory.class);
        this.levelControllerFactory = gameApplication.getContext()
                .getComponent("LevelControllerFactory", LevelControllerFactory.class);
        this.levelPrefabXmlReader = gameApplication.getContext()
                .getComponent("LevelPrefabXmlReader", LevelPrefabXmlReader.class);
        this.levelTransferablePropertiesExtractor = gameApplication.getContext()
                .getComponent("LevelTransferablePropertiesExtractor",
                        LevelTransferablePropertiesExtractor.class);
        this.profileController = gameApplication.getContext()
                .getComponent("ProfileController", ProfileController.class);
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
        if (!levelLoaded) {
            loadLevel();
            if (!levelDisposed) {
                disposeLevel();
                levelDisposed = true;
            }
        } else {
            switchScreen();
        }
        super.render(delta);
    }

    private void loadLevel() {
        if (levelSequence.getLevelPrefabFilenames().size() - 1 >= levelToLoadIndex) {
            LevelPrefab levelPrefab = levelPrefabXmlReader.readLevelPrefab(Gdx.files.internal(
                    levelSequence.getLevelPrefabFilenames().get(levelToLoadIndex)
            ));
            levelController = levelControllerFactory.createLevelController(levelFactory.createLevel(levelPrefab));
            Optional.ofNullable(previousLevel).ifPresent(p ->
                    levelController.getLevel().getResourceRegistry()
                            .getResource(ResourceType.LevelPropertiesResource, Properties.class)
                            .merge(extractProperties(p))
            );
        }
        levelLoaded = true;
    }

    private void switchScreen() {
        if (!screenSwitched) {
            if (levelSequence.getLevelPrefabFilenames().size() - 1 >= levelToLoadIndex) {
                switchScreenToNextLevel();
            } else {
                switchScreenToSummary();
            }
            screenSwitched = true;
        }
    }

    private void switchScreenToNextLevel() {
        getGameApplication().switchScreenWithTransition(
                new LevelScreen(getGameApplication(), levelController, levelSequence, levelToLoadIndex));
    }

    private void switchScreenToSummary() {
        updateProfile();
        getGameApplication().switchScreenWithTransition(
                new LevelSummaryScreen(
                        getGameApplication(),
                        levelSequence,
                        extractProperties(previousLevel)
                )
        );
    }

    private void updateProfile() {
        Optional.ofNullable(previousLevel).ifPresent(l -> profileController.writeProfile(
                l.getResourceRegistry().getResource(ResourceType.PlayerProfileResource, Profile.class),
                l.getResourceRegistry().getResource(ResourceType.LevelPropertiesResource, Properties.class)
        ));
    }

    private void disposeLevel() {
        Optional.ofNullable(previousLevel).ifPresent(l -> levelDisposer.disposeLevel(previousLevel));
    }

    private Properties extractProperties(Level level) {
        return levelTransferablePropertiesExtractor.extractProperties(level);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
