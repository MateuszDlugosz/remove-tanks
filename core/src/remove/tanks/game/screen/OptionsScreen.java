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
import remove.tanks.game.audio.AudioOptions;
import remove.tanks.game.audio.AudioPlayer;
import remove.tanks.game.audio.event.ChangeAudioOptionEvent;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;
import remove.tanks.game.constant.TranslationEntryKey;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.presentation.LevelPresenter;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.screen.gui.buttons.Button;
import remove.tanks.game.screen.gui.buttons.ButtonGroup;
import remove.tanks.game.screen.gui.buttons.HorizontalButton;
import remove.tanks.game.screen.gui.labels.Label;
import remove.tanks.game.screen.gui.listeners.KeyListener;

/**
 * @author Mateusz Długosz
 */
public final class OptionsScreen extends GameScreen {
    private static final int SOUND_VOLUME_STEP = 5;
    private static final int MUSIC_VOLUME_STEP = 5;

    private final Skin skin;
    private final EventBus eventBus;
    private final Locale locale;
    private final LevelPresenter levelPresenter;
    private final AssetStorage assetStorage;
    private final AudioPlayer audioPlayer;

    private Stage stage;
    private Window window;
    private Table wrapper;

    private TextButton titleLabel;

    private VerticalGroup leftColumn;
    private VerticalGroup rightColumn;
    private HorizontalGroup optionsGroup;

    private Button languageButton;
    private Button currentLanguageButton;
    private Button soundVolumeButton;
    private Button currentSoundVolumeButton;
    private Button musicVolumeButton;
    private Button currentMusicVolumeButton;
    private Button backButton;

    private ButtonGroup buttonGroup;

    public OptionsScreen(GameApplication gameApplication) {
        super(gameApplication);
        this.stage = new Stage(
                gameApplication.getContext()
                        .getComponent("MenuCamera", Game2DCamera.class).getViewport(),
                gameApplication.getContext()
                        .getComponent("SpriteBatch", SpriteBatch.class));
        this.skin = gameApplication.getContext().getComponent("UiSkin", Skin.class);
        this.eventBus = gameApplication.getContext()
                .getComponent("EventBus", EventBus.class);
        this.levelPresenter = gameApplication.getContext()
                .getComponent("MenuLevelPresenter", LevelPresenter.class);
        this.locale = gameApplication.getContext()
                .getComponent("Locale", Locale.class);
        this.assetStorage = gameApplication.getContext()
                .getComponent("MainAssetStorage", AssetStorage.class);
        this.audioPlayer = gameApplication.getContext()
                .getComponent("AudioPlayer", AudioPlayer.class);

        this.window = createWindow();
        this.wrapper = createWrapper();

        this.titleLabel = createTitleLabel();

        this.leftColumn = new VerticalGroup();
        this.rightColumn = new VerticalGroup();
        this.optionsGroup = new HorizontalGroup();

        this.languageButton = createLanguageButton();
        this.currentLanguageButton = createCurrentLanguageButton();
        this.soundVolumeButton = createSoundVolumeButton();
        this.currentSoundVolumeButton = createCurrentSoundVolumeButton();
        this.musicVolumeButton = createMusicVolumeButton();
        this.currentMusicVolumeButton = createCurrentMusicVolumeButton();
        this.backButton = createBackButton();

        this.buttonGroup = createButtonGroup();

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

    private void initLeftColumn() {
        leftColumn.addActor(languageButton);
        leftColumn.addActor(soundVolumeButton);
        leftColumn.addActor(musicVolumeButton);
        leftColumn.padRight(50);
    }

    private void initRightColumn() {
        rightColumn.addActor(currentLanguageButton);
        rightColumn.addActor(currentSoundVolumeButton);
        rightColumn.addActor(currentMusicVolumeButton);
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
        window.add(optionsGroup);
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
        return window;
    }

    private Table createWrapper() {
        Table wrapper = new Table();
        wrapper.setFillParent(true);
        return wrapper;
    }

    private TextButton createTitleLabel() {
        return new Label(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsTitle.getName()
        ).toUpperCase(), skin);
    }

    private Button createLanguageButton() {
        Button button = new Button(locale.getTranslation().getId().toUpperCase(), skin);
        button.setKeyListener(new KeyListener() {
            @Override
            public void keyDown(int keycode) {
                if (keycode == Input.Keys.LEFT) {
                    locale.selectPreviousTranslation();
                    eventBus.post(new PlaySoundEvent(
                            assetStorage.getAsset("button-change", Sound.class)
                    ));
                }
                if (keycode == Input.Keys.RIGHT) {
                    locale.selectNextTranslation();
                    eventBus.post(new PlaySoundEvent(
                            assetStorage.getAsset("button-change", Sound.class)
                    ));
                }
            }
        });
        button.padBottom(50);
        return button;
    }

    private Button createCurrentLanguageButton() {
        Button button = new HorizontalButton(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonLanguage.getName()
        ).toUpperCase(), skin);
        button.padBottom(50);
        return button;
    }

    private Button createSoundVolumeButton() {
        Button button = new Button(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonSoundVolume.getName()
        ), skin);
        button.setKeyListener(new KeyListener() {
            @Override
            public void keyDown(int keycode) {
                if (keycode == Input.Keys.RIGHT) {
                    eventBus.post(new ChangeAudioOptionEvent(
                            AudioOptions.Option.SoundVolume,
                            audioPlayer.getAudioOptions().getOptionValueAsInt(
                                    AudioOptions.Option.SoundVolume
                            ) + SOUND_VOLUME_STEP
                    ));
                    eventBus.post(new PlaySoundEvent(
                            assetStorage.getAsset("button-change", Sound.class)
                    ));
                }
                if (keycode == Input.Keys.LEFT) {
                    eventBus.post(new ChangeAudioOptionEvent(
                            AudioOptions.Option.SoundVolume,
                            audioPlayer.getAudioOptions().getOptionValueAsInt(
                                    AudioOptions.Option.SoundVolume
                            ) - SOUND_VOLUME_STEP
                    ));
                    eventBus.post(new PlaySoundEvent(
                            assetStorage.getAsset("button-change", Sound.class)
                    ));
                }
            }
        });
        button.padBottom(50);
        return button;
    }

    private Button createCurrentSoundVolumeButton() {
        Button button = new HorizontalButton(String.valueOf(
                audioPlayer.getAudioOptions().getOptionValueAsInt(AudioOptions.Option.SoundVolume)
        ), skin);
        button.padBottom(50);
        return button;
    }

    private Button createMusicVolumeButton() {
        Button button = new Button(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonMusicVolume.getName()
        ), skin);
        button.setKeyListener(new KeyListener() {
            @Override
            public void keyDown(int keycode) {
                if (keycode == Input.Keys.RIGHT) {
                    eventBus.post(new ChangeAudioOptionEvent(
                            AudioOptions.Option.MusicVolume,
                            audioPlayer.getAudioOptions().getOptionValueAsInt(
                                    AudioOptions.Option.MusicVolume
                            ) + MUSIC_VOLUME_STEP
                    ));
                    eventBus.post(new PlaySoundEvent(
                            assetStorage.getAsset("button-change", Sound.class)
                    ));
                }
                if (keycode == Input.Keys.LEFT) {
                    eventBus.post(new ChangeAudioOptionEvent(
                            AudioOptions.Option.MusicVolume,
                            audioPlayer.getAudioOptions().getOptionValueAsInt(
                                    AudioOptions.Option.MusicVolume
                            ) - MUSIC_VOLUME_STEP
                    ));
                    eventBus.post(new PlaySoundEvent(
                            assetStorage.getAsset("button-change", Sound.class)
                    ));
                }
            }
        });
        return button;
    }

    private Button createCurrentMusicVolumeButton() {
        return new HorizontalButton(String.valueOf(
                audioPlayer.getAudioOptions().getOptionValueAsInt(AudioOptions.Option.MusicVolume)
        ), skin);
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
        return new ButtonGroup(
                Lists.newArrayList(
                        languageButton,
                        soundVolumeButton,
                        musicVolumeButton,
                        backButton
                )
        );
    }

    @Override
    public void render(float delta) {
        levelPresenter.update(delta, eventBus);
        titleLabel.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsTitle.getName()).toUpperCase());
        languageButton.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonLanguage.getName()
        ).toUpperCase());
        currentLanguageButton.setText(locale.getTranslation().getId().toUpperCase());
        backButton.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenButtonBack.getName()).toUpperCase());
        soundVolumeButton.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonSoundVolume.getName()).toUpperCase());
        currentSoundVolumeButton.setText(String.valueOf(audioPlayer.getAudioOptions()
                .getOptionValueAsInt(AudioOptions.Option.SoundVolume)));
        musicVolumeButton.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonMusicVolume.getName()).toUpperCase());
        currentMusicVolumeButton.setText(String.valueOf(audioPlayer.getAudioOptions()
                .getOptionValueAsInt(AudioOptions.Option.MusicVolume)));

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

        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            buttonGroup.getActiveButton().getKeyListener().ifPresent(l -> {
                l.keyDown(Input.Keys.LEFT);
            });
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            buttonGroup.getActiveButton().getKeyListener().ifPresent(l -> {
                l.keyDown(Input.Keys.RIGHT);
            });
        }

        super.render(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
