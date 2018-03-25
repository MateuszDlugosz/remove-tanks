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
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.LevelPresenter;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.TranslationEntryKey;
import remove.tanks.game.screen.gui.button.Button;
import remove.tanks.game.screen.gui.button.ButtonGroup;
import remove.tanks.game.screen.gui.label.Label;

import java.util.Arrays;

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
    private Button profileButton;
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
        this.levelPresenter = gameApplication.getContext().getComponent("LevelPresenter", LevelPresenter.class);
        this.skin = gameApplication.getContext().getComponent("UISkin", Skin.class);
        this.eventBus = gameApplication.getContext()
                .getComponent("EventBus", EventBus.class);
        this.assetStorage = gameApplication.getContext().getComponent("MainAssetStorage", AssetStorage.class);

        this.titleLabel = createTitleLabel();
        this.versionLabel = createVersionLabel();

        this.startButton = createStartButton();
        this.optionsButton = createOptionsButton();
        this.creditsButton = createCreditsButton();
        this.profileButton = createProfileButton();
        this.exitButton = createExitButton();

        this.window = createWindow();
        this.wrapper = createWrapper();
        this.buttonGroup = createButtonGroup();

        initStage();
    }

    @Override
    public void show() {
        buttonGroup.reset();
        stage.getRoot().getColor().a = 1f;
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    private void initStage() {
        window.pad(ScreenConstants.WINDOW_PADDING);
        window.add(titleLabel.pad(ScreenConstants.ELEMENT_PADDING));
        window.row().padTop(ScreenConstants.ROW_SEPARATOR_PADDING);
        window.add(startButton.pad(ScreenConstants.ELEMENT_PADDING));
        window.row().padTop(ScreenConstants.INNER_ROW_SEPARATOR_PADDING);
        window.add(optionsButton.pad(ScreenConstants.ELEMENT_PADDING));
        window.row().padTop(ScreenConstants.INNER_ROW_SEPARATOR_PADDING);
        window.add(profileButton.pad(ScreenConstants.ELEMENT_PADDING));
        window.row().padTop(ScreenConstants.INNER_ROW_SEPARATOR_PADDING);
        window.add(creditsButton.pad(ScreenConstants.ELEMENT_PADDING));
        window.row().padTop(ScreenConstants.INNER_ROW_SEPARATOR_PADDING);
        window.add(exitButton.pad(ScreenConstants.ELEMENT_PADDING));
        window.row().padTop(ScreenConstants.ROW_SEPARATOR_PADDING);
        window.add(versionLabel.pad(ScreenConstants.ELEMENT_PADDING));
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
                locale.getSelectedTranslation().getEntry(
                        TranslationEntryKey.GameScreenMainMenuButtonStart.getName())
                        .toUpperCase(),
                skin);
        startButton.setKeyListener(keycode -> {
            if (keycode == Input.Keys.ENTER) {
                getGameApplication().switchScreenWithTransition(
                        new LevelLoadingScreen(
                                getGameApplication(),
                                new LevelSequence(
                                        "early-morning",
                                        Arrays.asList(
                                                "prefabs/levels/level-prefab.xml",
                                                "prefabs/levels/level-prefab.xml"
                                        )
                                ),
                                0,
                                null
                        ));
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.UIEffectSoundChannel,
                        assetStorage.getAsset("UIButtonSelect0Sound", Sound.class)
                ));
                buttonGroup.lockButtons();
            }
        });
        return startButton;
    }

    private Button createOptionsButton() {
        Button optionsButton = new Button(
                locale.getSelectedTranslation().getEntry(
                        TranslationEntryKey.GameScreenMainMenuButtonOptions.getName())
                        .toUpperCase(),
                skin);
        optionsButton.setKeyListener(keycode -> {
            if (keycode == Input.Keys.ENTER) {
                getGameApplication().switchScreenWithoutTransition(OptionsScreen.class);
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.UIEffectSoundChannel,
                        assetStorage.getAsset("UIButtonSelect0Sound", Sound.class)
                ));
                buttonGroup.lockButtons();
            }
        });
        return optionsButton;
    }

    private Button createProfileButton() {
        Button profileButton = new Button(
                locale.getSelectedTranslation().getEntry(
                        TranslationEntryKey.GameScreenMainMenuButtonProfile.getName())
                        .toUpperCase(),
                skin);
        profileButton.setKeyListener(keycode -> {
            if (keycode == Input.Keys.ENTER) {
                getGameApplication().switchScreenWithoutTransition(ProfileScreen.class);
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.UIEffectSoundChannel,
                        assetStorage.getAsset("UIButtonSelect0Sound", Sound.class)
                ));
                buttonGroup.lockButtons();
            }
        });
        return profileButton;
    }

    private Button createCreditsButton() {
        Button creditsButton = new Button(
                locale.getSelectedTranslation().getEntry(
                        TranslationEntryKey.GameScreenMainMenuButtonCredits.getName())
                        .toUpperCase(),
                skin);
        creditsButton.setKeyListener(keycode -> {
            if (keycode == Input.Keys.ENTER) {
                getGameApplication().switchScreenWithoutTransition(CreditsScreen.class);
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.UIEffectSoundChannel,
                        assetStorage.getAsset("UIButtonSelect0Sound", Sound.class)
                ));
                buttonGroup.lockButtons();
            }
        });
        return creditsButton;
    }

    private Button createExitButton() {
        Button exitButton = new Button(
                locale.getSelectedTranslation().getEntry(
                        TranslationEntryKey.GameScreenMainMenuButtonExit.getName())
                        .toUpperCase(),
                skin);
        exitButton.setKeyListener(keycode -> {
            if (keycode == Input.Keys.ENTER) {
                Gdx.app.exit();
            }
        });
        return exitButton;
    }

    private ButtonGroup createButtonGroup() {
        return new ButtonGroup(Lists.newArrayList(
                startButton,
                optionsButton,
                profileButton,
                creditsButton,
                exitButton
        ));
    }

    @Override
    public void render(float delta) {
        levelPresenter.update(delta);
        startButton.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenMainMenuButtonStart.getName()
        ).toUpperCase());
        optionsButton.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenMainMenuButtonOptions.getName()
        ).toUpperCase());
        profileButton.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenMainMenuButtonProfile.getName()
        ).toUpperCase());
        creditsButton.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenMainMenuButtonCredits.getName()
        ).toUpperCase());
        exitButton.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenMainMenuButtonExit.getName()
        ).toUpperCase());

        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            buttonGroup.activateNextButton();
            eventBus.post(new PlaySoundEvent(
                    SoundChannelName.UIEffectSoundChannel,
                    assetStorage.getAsset("UIButtonChange0Sound", Sound.class)
            ));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            buttonGroup.activatePreviousButton();
            eventBus.post(new PlaySoundEvent(
                    SoundChannelName.UIEffectSoundChannel,
                    assetStorage.getAsset("UIButtonChange0Sound", Sound.class)
            ));
        }

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
