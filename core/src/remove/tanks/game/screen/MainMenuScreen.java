package remove.tanks.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.GameApplication;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;
import remove.tanks.game.constant.TranslationEntryKey;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.presentation.LevelPresenter;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.screen.gui.buttons.Button;
import remove.tanks.game.screen.gui.buttons.ButtonGroup;
import remove.tanks.game.screen.gui.labels.Label;
import remove.tanks.game.screen.gui.listeners.KeyListener;

/**
 * @author Mateusz Długosz
 */
public final class MainMenuScreen extends GameScreen {
    private final Locale locale;
    private final LevelPresenter levelPresenter;
    private final Skin skin;
    private final EventBus eventBus;
    private final AssetStorage assetStorage;

    private Stage stage;
    private Window window;
    private Table wrapper;

    private Label titleLabel;
    private Label versionLabel;

    private Button startButton;
    private Button optionsButton;
    private Button creditsButton;
    private Button exitButton;

    private ButtonGroup buttonGroup;

    public MainMenuScreen(GameApplication gameApplication) {
        super(gameApplication);
        this.stage = new Stage(
                gameApplication.getContext()
                    .getComponent("MenuCamera", Game2DCamera.class).getViewport(),
                gameApplication.getContext()
                    .getComponent("SpriteBatch", SpriteBatch.class));
        this.locale = gameApplication.getContext()
                .getComponent("Locale", Locale.class);
        this.levelPresenter = gameApplication.getContext().getComponent("MenuLevelPresenter", LevelPresenter.class);
        this.skin = gameApplication.getContext().getComponent("UiSkin", Skin.class);
        this.eventBus = gameApplication.getContext()
                .getComponent("EventBus", EventBus.class);
        this.assetStorage = gameApplication.getContext().getComponent("MainAssetStorage", AssetStorage.class);

        this.titleLabel = createTitleLabel();
        this.versionLabel = createVersionLabel();

        this.startButton = createStartButton();
        this.optionsButton = createOptionsButton();
        this.creditsButton = createCreditsButton();
        this.exitButton = createExitButton();

        this.window = createWindow();
        this.wrapper = createWrapper();
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
        window.pad(70);
        window.add(titleLabel.pad(5));
        window.row().padTop(80);
        window.add(startButton.pad(5));
        window.row().padTop(50);
        window.add(optionsButton.pad(5));
        window.row().padTop(50);
        window.add(creditsButton.pad(5));
        window.row().padTop(50);
        window.add(exitButton.pad(5));
        window.row().padTop(80);
        window.add(versionLabel.pad(5));
        window.pack();
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

    private Label createTitleLabel() {
        return new Label(GameApplication.TITLE.toUpperCase(), skin);
    }

    private Label createVersionLabel() {
        return new Label(GameApplication.VERSION.toUpperCase(), skin);
    }

    private Button createStartButton() {
        Button startButton = new Button(
                locale.getTranslation().getEntry(
                        TranslationEntryKey.GameScreenMainMenuButtonStart.getName())
                        .toUpperCase(),
                skin);
        startButton.setKeyListener(new KeyListener() {
            @Override
            public void keyDown(int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    getGameApplication().switchScreen(ModeSelectScreen.class);
                    eventBus.post(new PlaySoundEvent(
                            assetStorage.getAsset("button-select", Sound.class)
                    ));
                    buttonGroup.lockButtons();
                }
            }
        });
        return startButton;
    }

    private Button createOptionsButton() {
        Button optionsButton = new Button(
                locale.getTranslation().getEntry(
                        TranslationEntryKey.GameScreenMainMenuButtonOptions.getName())
                        .toUpperCase(),
                skin);
        optionsButton.setKeyListener(new KeyListener() {
            @Override
            public void keyDown(int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    getGameApplication().switchScreen(OptionsScreen.class);
                    eventBus.post(new PlaySoundEvent(
                            assetStorage.getAsset("button-select", Sound.class)
                    ));
                    buttonGroup.lockButtons();
                }
            }
        });
        return optionsButton;
    }

    private Button createCreditsButton() {
        Button creditsButton = new Button(
                locale.getTranslation().getEntry(
                        TranslationEntryKey.GameScreenMainMenuButtonCredits.getName())
                        .toUpperCase(),
                skin);
        creditsButton.setKeyListener(new KeyListener() {
            @Override
            public void keyDown(int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    getGameApplication().switchScreen(CreditsScreen.class);
                    eventBus.post(new PlaySoundEvent(
                            assetStorage.getAsset("button-select", Sound.class)
                    ));
                    buttonGroup.lockButtons();
                }
            }
        });
        return creditsButton;
    }

    private Button createExitButton() {
        Button exitButton = new Button(
                locale.getTranslation().getEntry(
                        TranslationEntryKey.GameScreenMainMenuButtonExit.getName())
                        .toUpperCase(),
                skin);
        exitButton.setKeyListener(new KeyListener() {
            @Override
            public void keyDown(int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    Gdx.app.exit();
                }
            }
        });
        return exitButton;
    }

    private ButtonGroup createButtonGroup() {
        return new ButtonGroup(Lists.newArrayList(startButton, optionsButton, creditsButton, exitButton));
    }

    @Override
    public void render(float delta) {
        levelPresenter.update(delta, eventBus);
        startButton.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenMainMenuButtonStart.getName()
        ).toUpperCase());
        optionsButton.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenMainMenuButtonOptions.getName()
        ).toUpperCase());
        creditsButton.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenMainMenuButtonCredits.getName()
        ).toUpperCase());
        exitButton.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenMainMenuButtonExit.getName()
        ).toUpperCase());

        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            buttonGroup.activateNextButton();
            eventBus.post(new PlaySoundEvent(
                    assetStorage.getAsset("button-change", Sound.class)
            ));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            buttonGroup.activatePreviousButton();
            eventBus.post(new PlaySoundEvent(
                    assetStorage.getAsset("button-change", Sound.class)
            ));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            buttonGroup.getActiveButton().getKeyListener().ifPresent(l -> {
                l.keyDown(Input.Keys.ENTER);
            });
        }

        super.render(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
