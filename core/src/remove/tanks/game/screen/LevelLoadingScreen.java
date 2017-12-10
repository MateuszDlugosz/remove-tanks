package remove.tanks.game.screen;

import com.badlogic.gdx.scenes.scene2d.Stage;
import remove.tanks.game.GameApplication;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.LevelDisposer;
import remove.tanks.game.level.LevelLoader;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.utility.properties.Properties;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class LevelLoadingScreen extends GameScreen {
    private final LevelLoader levelLoader;
    private final int levelIndex;
    private final LevelSequence levelSequence;
    private final LevelDisposer levelDisposer;
    private final Stage stage;

    private Level previousLevel;
    private Properties previousLevelProperties;

    private boolean propertiesExtracted;
    private boolean levelDisposed;
    private boolean levelLoaded;

    public LevelLoadingScreen(
            GameApplication gameApplication,
            LevelSequence levelSequence,
            int levelIndex,
            Level previousLevel
    ) {
        super(gameApplication);
        this.levelLoader = gameApplication.getContext()
                .getComponent("LevelLoader", LevelLoader.class);
        this.levelDisposer = gameApplication.getContext()
                .getComponent("LevelDisposer", LevelDisposer.class);
        this.levelIndex = levelIndex;
        this.previousLevel = previousLevel;
        this.levelSequence = levelSequence;
        this.propertiesExtracted = false;
        this.levelDisposed = false;
        this.levelLoaded = false;
        this.stage = new Stage();
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public void render(float delta) {
        if (!propertiesExtracted) {
            extractPreviousLevelProperties();
            propertiesExtracted = true;
        }

        if (!levelDisposed) {
            disposePreviousLevel();
            levelDisposed = true;
        }

        if (!levelLoaded) {
            Level newLevel = levelLoader.loadLevel(
                    levelSequence.getLevelPrototypeFilenames().get(levelIndex),
                    getGameApplication().getContext()
            );
            newLevel.getResourceRegistry().getResource(LevelResource.Properties.toString(), Properties.class)
                    .merge(previousLevelProperties);

            getGameApplication().switchScreen(
                    new LevelScreen(
                            getGameApplication(),
                            levelSequence,
                            levelIndex,
                            newLevel
                    )
            );

            levelLoaded = true;
        }

        super.render(delta);
    }

    private void disposePreviousLevel() {
        Optional.ofNullable(previousLevel).ifPresent(levelDisposer::disposeLevel);
    }

    private void extractPreviousLevelProperties() {
        previousLevelProperties = new Properties();
        Optional.ofNullable(previousLevel).ifPresent(level -> {
            Properties properties = previousLevel.getResourceRegistry().getResource(
                    LevelResource.Properties.toString(), Properties.class
            );
            previousLevelProperties.putString(
                    LevelProperty.LevelLifes.getName(),
                    properties.getString(LevelProperty.LevelLifes.getName())
            );
            previousLevelProperties.putString(
                    LevelProperty.LevelPoints.getName(),
                    properties.getString(LevelProperty.LevelPoints.getName())
            );
        });
    }
}
