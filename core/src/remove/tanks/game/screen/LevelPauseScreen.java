package remove.tanks.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.GameApplication;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.LevelDisposer;
import remove.tanks.game.level.LevelPresenter;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.constant.TranslationEntryKey;
import remove.tanks.game.screen.gui.buttons.Button;
import remove.tanks.game.screen.gui.buttons.ButtonGroup;
import remove.tanks.game.screen.gui.labels.Label;
import remove.tanks.game.screen.gui.listeners.KeyListener;

/**
 * @author Mateusz Długosz
 */
public final class LevelPauseScreen extends GameScreen {
    private final LevelPresenter levelPresenter;
    private final LevelDisposer levelDisposer;
    private final EventBus eventBus;
    private final AssetStorage assetStorage;
    private final LevelScreen levelScreen;
    private final Locale locale;
    private final Skin skin;

    private Stage stage;
    private Window window;
    private Table wrapper;

    private VerticalGroup leftColumn;
    private VerticalGroup rightColumn;
    private HorizontalGroup optionsGroup;

    private Button yesButton;
    private Button noButton;
    private Label titleLabel;
    private TextButton contentLabel;

    private ButtonGroup buttonGroup;

    public LevelPauseScreen(GameApplication gameApplication, LevelScreen levelScreen) {
        super(gameApplication);
        this.levelScreen = levelScreen;
        this.stage = new Stage(
                gameApplication.getContext()
                        .getComponent("MenuCamera", Game2DCamera.class).getViewport(),
                gameApplication.getContext()
                        .getComponent("SpriteBatch", SpriteBatch.class));

        this.levelPresenter = gameApplication.getContext().getComponent("MenuLevelPresenter", LevelPresenter.class);
        this.levelDisposer = gameApplication.getContext().getComponent("LevelDisposer", LevelDisposer.class);
        this.eventBus = gameApplication.getContext().getComponent("EventBus", EventBus.class);
        this.assetStorage = gameApplication.getContext().getComponent("MainAssetStorage", AssetStorage.class);
        this.locale = gameApplication.getContext().getComponent("Locale", Locale.class);
        this.skin = gameApplication.getContext().getComponent("UiSkin", Skin.class);

        this.leftColumn = new VerticalGroup();
        this.rightColumn = new VerticalGroup();
        this.optionsGroup = new HorizontalGroup();

        this.titleLabel = createTitleLabel();
        this.contentLabel = createContentLabel();
        this.yesButton = createYesButton();
        this.noButton = createNoButton();
        this.buttonGroup = createButtonGroup();

        this.window = createWindow();
        this.wrapper = createWrapper();

        initLeftColumn();
        initRightColumn();
        initOptionsGroup();
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

    private ButtonGroup createButtonGroup() {
        return new ButtonGroup(
                Lists.newArrayList(
                        yesButton,
                        noButton
                )
        );
    }

    private void initLeftColumn() {
        leftColumn.addActor(yesButton);
        leftColumn.padRight(50);
    }

    private void initRightColumn() {
        rightColumn.addActor(noButton);
    }

    private void initOptionsGroup() {
        optionsGroup.addActor(leftColumn);
        optionsGroup.addActor(rightColumn);
    }

    private void initStage() {
        window.setFillParent(false);
        window.pad(70);
        window.add(titleLabel.pad(5));
        window.row().padTop(80);
        window.add(contentLabel.pad(5));
        window.row().padTop(80);
        window.add(optionsGroup.pad(5));
        window.pack();
        window.setDebug(false);
        wrapper.add(window);
        stage.addActor(wrapper);
    }

    private Label createTitleLabel() {
        return new Label(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenPauseTitle.getName()).toUpperCase(), skin);
    }

    private TextButton createContentLabel() {
        return new TextButton(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenPauseContent.getName()).toUpperCase(), skin);
    }

    private Button createYesButton() {
        Button button = new Button(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenButtonYes.getName()
        ).toUpperCase(), skin);
        button.setKeyListener(new KeyListener() {
            @Override
            public void keyDown(int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    getGameApplication().switchScreenWithoutTransition(MenuMainScreen.class);
                    eventBus.post(new PlaySoundEvent(
                            assetStorage.getAsset("button-select", Sound.class)
                    ));
                    buttonGroup.lockButtons();
                    levelDisposer.disposeLevel(levelScreen.getLevelController().getLevel());
                }
            }
        });
        return button;
    }

    private Button createNoButton() {
        Button button = new Button(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenButtonNo.getName()
        ).toUpperCase(), skin);
        button.setKeyListener(new KeyListener() {
            @Override
            public void keyDown(int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    getGameApplication().switchScreenWithTransition(levelScreen);
                    eventBus.post(new PlaySoundEvent(
                            assetStorage.getAsset("button-select", Sound.class)
                    ));
                    buttonGroup.lockButtons();
                }
            }
        });
        return button;
    }

    @Override
    public void render(float delta) {
        levelPresenter.update(delta, eventBus);
        titleLabel.setText(locale.getTranslation()
                .getEntry(TranslationEntryKey.GameScreenPauseTitle.getName()).toUpperCase());
        contentLabel.setText(locale.getTranslation()
                .getEntry(TranslationEntryKey.GameScreenPauseContent.getName()).toUpperCase());
        yesButton.setText(locale.getTranslation()
                .getEntry(TranslationEntryKey.GameScreenButtonYes.getName()).toUpperCase());
        noButton.setText(locale.getTranslation()
                .getEntry(TranslationEntryKey.GameScreenButtonNo.getName()).toUpperCase());

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            buttonGroup.getActiveButton().getKeyListener().ifPresent(l -> l.keyDown(Input.Keys.ENTER));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            buttonGroup.activateNextButton();
            eventBus.post(new PlaySoundEvent(
                    assetStorage.getAsset("button-change", Sound.class)
            ));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            buttonGroup.activatePreviousButton();
            eventBus.post(new PlaySoundEvent(
                    assetStorage.getAsset("button-change", Sound.class)
            ));
        }

        super.render(delta);
    }
}
