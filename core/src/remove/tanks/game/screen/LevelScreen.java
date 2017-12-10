package remove.tanks.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.GameApplication;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.LevelController;
import remove.tanks.game.level.LevelControllerFactory;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.constant.LevelState;
import remove.tanks.game.level.input.InputMapper;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.constant.TranslationEntryKey;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class LevelScreen extends GameScreen {
    private final LevelController levelController;
    private final Skin skin;
    private final EventBus eventBus;
    private final LevelSequence levelSequence;
    private final int currentLevelIndex;
    private final Locale locale;

    private String levelStatus;
    private Label levelStatusLabel;

    private Stage stage;
    private Window window;

    public LevelScreen(
            GameApplication gameApplication,
            LevelSequence levelSequence,
            int currentLevelIndex,
            Level level
    ) {
        super(gameApplication);
        this.stage = new Stage(
                gameApplication.getContext()
                        .getComponent("MenuCamera", Game2DCamera.class).getViewport(),
                gameApplication.getContext()
                        .getComponent("SpriteBatch", SpriteBatch.class));
        this.levelController = gameApplication.getContext()
                .getComponent("LevelControllerFactory", LevelControllerFactory.class)
                .createLevelController(level);
        this.skin = gameApplication.getContext().getComponent("UiSkin", Skin.class);
        this.eventBus = gameApplication.getContext()
                .getComponent("EventBus", EventBus.class);
        this.levelSequence = levelSequence;
        this.currentLevelIndex = currentLevelIndex;
        this.locale = gameApplication.getContext()
                .getComponent("Locale", Locale.class);

        this.levelStatus = "";
        this.levelStatusLabel = createLevelStateLabel();

        this.window = createWindow();
        initStage();
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    private void initStage() {
        stage.addActor(window);
        window.add(levelStatusLabel);
    }

    private Window createWindow() {
        Window window = new Window("", skin.get("window-clear", Window.WindowStyle.class));
        window.setFillParent(true);
        window.setMovable(false);
        return window;
    }

    private Label createLevelStateLabel() {
        return new Label(levelStatus, skin);
    }

    @Override
    public void render(float delta) {
        processInput();
        levelController.update(delta, eventBus);
        if (levelController.getLevel().getResourceRegistry().getResource(LevelResource.Properties.toString(), Properties.class)
                .getString(LevelProperty.LevelState.getName()).equals(LevelState.Defeat.getName()))
        {
                levelStatusLabel.setText(locale.getTranslation().getEntry(
                        TranslationEntryKey.GameLevelStatusDefeat.getName()
                ).toUpperCase());
        } else if (levelController.getLevel().getResourceRegistry().getResource(LevelResource.Properties.toString(), Properties.class)
                .getString(LevelProperty.LevelState.getName()).equals(LevelState.Victory.getName()))
        {
                levelStatusLabel.setText(locale.getTranslation().getEntry(
                        TranslationEntryKey.GameLevelStatusVictory.getName()
                ).toUpperCase());
        }
        if (levelController.getLevel().getResourceRegistry().getResource(LevelResource.Properties.toString(), Properties.class)
                .getString(LevelProperty.LevelState.getName()).equals(LevelState.End.getName()))
        {
            switchToSummaryScreen();
        }
        super.render(delta);
    }

    private void switchToNextLevel() {
        if (levelSequence.getLevelPrototypeFilenames().size() - 1 > currentLevelIndex) {
            getGameApplication().switchScreenWithTransition(new LevelLoadingScreen(
                    getGameApplication(),
                    levelSequence,
                    currentLevelIndex + 1,
                    levelController.getLevel()
            ));
        } else {
            switchToSummaryScreen();
        }
    }

    private void switchToSummaryScreen() {
        getGameApplication().switchScreenWithTransition(new LevelSummaryScreen(
                getGameApplication(), levelController.getLevel().getResourceRegistry()
                        .getResource(LevelResource.Properties.name(), Properties.class)
        ));
    }

    private void processInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            levelController.getLevel().getResourceRegistry().getResource(LevelResource.InputMapper.toString(), InputMapper.class)
                    .apply(InputMapper.Key.MoveRight);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            levelController.getLevel().getResourceRegistry().getResource(LevelResource.InputMapper.toString(), InputMapper.class)
                    .apply(InputMapper.Key.MoveUp);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            levelController.getLevel().getResourceRegistry().getResource(LevelResource.InputMapper.toString(), InputMapper.class)
                    .apply(InputMapper.Key.MoveLeft);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            levelController.getLevel().getResourceRegistry().getResource(LevelResource.InputMapper.toString(), InputMapper.class)
                    .apply(InputMapper.Key.MoveDown);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            getGameApplication().switchScreenWithTransition(MainMenuScreen.class);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.CONTROL_LEFT)) {
            levelController.getLevel().getResourceRegistry().getResource(LevelResource.InputMapper.toString(), InputMapper.class)
                    .apply(InputMapper.Key.Shoot);
        }
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
