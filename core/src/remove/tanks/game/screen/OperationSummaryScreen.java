package remove.tanks.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.GameApplication;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;
import remove.tanks.game.constant.LevelProperty;
import remove.tanks.game.constant.TranslationEntryKey;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.presentation.LevelPresenter;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.screen.gui.buttons.Button;
import remove.tanks.game.screen.gui.buttons.ButtonGroup;
import remove.tanks.game.screen.gui.labels.Label;
import remove.tanks.game.screen.gui.listeners.KeyListener;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class OperationSummaryScreen extends GameScreen {
    private final Locale locale;
    private final LevelPresenter levelPresenter;
    private final Skin skin;
    private final EventBus eventBus;
    private final AssetStorage assetStorage;

    private final Properties properties;

    private Stage stage;
    private Window window;
    private Table wrapper;

    private TextButton contentLabel;
    private TextButton titleLabel;
    private Button backButton;

    private ButtonGroup buttonGroup;

    public OperationSummaryScreen(GameApplication gameApplication, Properties properties) {
        super(gameApplication);
        this.stage = new Stage(
                gameApplication.getContext()
                        .getComponent("MenuCamera", Game2DCamera.class).getViewport(),
                gameApplication.getContext()
                        .getComponent("SpriteBatch", SpriteBatch.class));
        this.locale = gameApplication.getContext()
                .getComponent("Locale", Locale.class);
        this.levelPresenter = gameApplication.getContext()
                .getComponent("MenuLevelPresenter", LevelPresenter.class);
        this.skin = gameApplication.getContext().getComponent("UiSkin", Skin.class);
        this.eventBus = gameApplication.getContext()
                .getComponent("EventBus", EventBus.class);
        this.assetStorage = gameApplication.getContext()
                .getComponent("MainAssetStorage", AssetStorage.class);

        this.properties = properties;

        this.window = createWindow();
        this.wrapper = createWrapper();
        this.contentLabel = createContentLabel();
        this.titleLabel = createTitleLabel();
        this.backButton = createBackButton();
        this.buttonGroup = createButtonGroup();
        initStage();
    }

    @Override
    public void show() {
        buttonGroup.reset();
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    private void initStage() {
        window.setFillParent(false);
        window.pad(70);
        window.add(titleLabel.pad(5));
        window.row().padTop(80);
        window.add(contentLabel.pad(5));
        window.row().padTop(80);
        window.add(backButton.pad(5));
        window.pack();
        window.setDebug(false);
        wrapper.add(window);
        stage.addActor(wrapper);
    }

    private Window createWindow() {
        Window window = new Window("", skin);
        window.setFillParent(false);
        window.setMovable(false);
        return window;
    }

    private Table createWrapper() {
        Table wrapper = new Table();
        wrapper.setFillParent(true);
        return wrapper;
    }

    private TextButton createTitleLabel() {
        return new Label(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenOperationSummaryTitle.getName()
        ).toUpperCase(), skin);
    }

    private TextButton createContentLabel() {
        return new Button(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenOperationSummaryCongratulations.getName()
        ).toUpperCase(), skin);
    }

    private Button createBackButton() {
        Button backButton = new Button(
                locale.getTranslation().getEntry(
                        TranslationEntryKey.GameScreenButtonBack.getName())
                        .toUpperCase(),
                skin);
        backButton.setKeyListener(new KeyListener() {
            @Override
            public void keyDown(int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    getGameApplication().switchScreen(MainMenuScreen.class);
                    eventBus.post(new PlaySoundEvent(
                            assetStorage.getAsset("button-select", Sound.class)
                    ));
                    buttonGroup.lockButtons();
                }
            }
        });
        return backButton;
    }

    private ButtonGroup createButtonGroup() {
        return new ButtonGroup(Lists.newArrayList(backButton));
    }

    @Override
    public void render(float delta) {
        levelPresenter.update(delta, eventBus);
        this.titleLabel.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenOperationSummaryTitle.getName()
        ).toUpperCase());
        this.backButton.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenButtonBack.getName()
        ).toUpperCase());
        this.contentLabel.setText(locale.getTranslation().getFormattedEntry(
                TranslationEntryKey.GameScreenOperationSummaryCongratulations.getName(),
                properties.getString(LevelProperty.LevelPoints.getName())
        ).toUpperCase());

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            buttonGroup.getActiveButton().getKeyListener().ifPresent(l -> l.keyDown(Input.Keys.ENTER));
        }

        super.render(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
