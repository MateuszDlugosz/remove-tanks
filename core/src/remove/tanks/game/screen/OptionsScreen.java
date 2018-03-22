package remove.tanks.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.GameApplication;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.AudioConfiguration;
import remove.tanks.game.audio.AudioPlayer;
import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.audio.music.event.PlayMusicEvent;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.LevelPresenter;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.TranslationEntryKey;
import remove.tanks.game.screen.gui.button.Button;
import remove.tanks.game.screen.gui.button.ButtonGroup;
import remove.tanks.game.screen.gui.button.HorizontalButton;
import remove.tanks.game.screen.gui.label.Label;
import remove.tanks.game.utility.preferences.PreferenceName;

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
    private final Preferences preferences;

    private final AudioConfiguration soundEffectAudioConfiguration;
    private final AudioConfiguration soundUIEffectAudioConfiguration;
    private final AudioConfiguration musicAudioConfiguration;

    private Stage stage;
    private Window window;
    private Table wrapper;

    private TextButton titleLabel;

    private VerticalGroup leftColumn;
    private VerticalGroup rightColumn;
    private HorizontalGroup optionsGroup;

    private Button languageButton;
    private Button currentLanguageButton;
    private Button soundEffectVolumeButton;
    private Button currentSoundEffectVolumeButton;
    private Button soundUIEffectVolumeButton;
    private Button currentSoundUIEffectVolumeButton;
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
        this.skin = gameApplication.getContext().getComponent("UISkin", Skin.class);
        this.eventBus = gameApplication.getContext()
                .getComponent("EventBus", EventBus.class);
        this.levelPresenter = gameApplication.getContext()
                .getComponent("LevelPresenter", LevelPresenter.class);
        this.locale = gameApplication.getContext()
                .getComponent("Locale", Locale.class);
        this.assetStorage = gameApplication.getContext()
                .getComponent("MainAssetStorage", AssetStorage.class);
        this.preferences = gameApplication.getContext()
                .getComponent("Preferences", Preferences.class);

        AudioPlayer audioPlayer = gameApplication.getContext()
                .getComponent("AudioPlayer", AudioPlayer.class);

        this.soundEffectAudioConfiguration = audioPlayer.getSoundPlayer()
                .getSoundChannel(SoundChannelName.EffectSoundChannel).getAudioConfiguration();
        this.soundUIEffectAudioConfiguration = audioPlayer.getSoundPlayer()
                .getSoundChannel(SoundChannelName.UIEffectSoundChannel).getAudioConfiguration();
        this.musicAudioConfiguration = audioPlayer.getMusicPlayer()
                .getMusicChannel(MusicChannelName.MainMusicChannel).getAudioConfiguration();

        this.window = createWindow();
        this.wrapper = createWrapper();

        this.titleLabel = createTitleLabel();

        this.leftColumn = new VerticalGroup();
        this.rightColumn = new VerticalGroup();
        this.optionsGroup = new HorizontalGroup();

        this.languageButton = createLanguageButton();
        this.currentLanguageButton = createCurrentLanguageButton();
        this.soundEffectVolumeButton = createSoundEffectVolumeButton();
        this.currentSoundEffectVolumeButton = createCurrentSoundEffectVolumeButton();
        this.soundUIEffectVolumeButton = createSoundUIEffectVolumeButton();
        this.currentSoundUIEffectVolumeButton = createCurrentSoundUIEffectVolumeButton();
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
        leftColumn.addActor(soundEffectVolumeButton);
        leftColumn.addActor(soundUIEffectVolumeButton);
        leftColumn.addActor(musicVolumeButton);
        leftColumn.padRight(50);
    }

    private void initRightColumn() {
        rightColumn.addActor(currentLanguageButton);
        rightColumn.addActor(currentSoundEffectVolumeButton);
        rightColumn.addActor(currentSoundUIEffectVolumeButton);
        rightColumn.addActor(currentMusicVolumeButton);
    }

    private void initOptionsGroup() {
        optionsGroup.addActor(leftColumn);
        optionsGroup.addActor(rightColumn);
    }

    private void initStage() {
        window.setFillParent(false);
        window.pad(ScreenConstants.WINDOW_PADDING);
        window.add(titleLabel.pad(ScreenConstants.ELEMENT_PADDING));
        window.row().padTop(ScreenConstants.ROW_SEPARATOR_PADDING);
        window.add(optionsGroup.pad(ScreenConstants.ELEMENT_PADDING));
        window.row().padTop(ScreenConstants.ROW_SEPARATOR_PADDING);
        window.add(backButton.pad(ScreenConstants.ELEMENT_PADDING));
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
        return new Label(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsTitle.getName()
        ).toUpperCase(), skin);
    }

    private Button createLanguageButton() {
        Button button = new HorizontalButton(locale.getSelectedTranslationId(), skin);
        button.setKeyListener(k -> {
            if (k == Input.Keys.LEFT) {
                locale.selectPreviousTranslation();
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.UIEffectSoundChannel,
                        assetStorage.getAsset("UIButtonSelect0Sound", Sound.class)
                ));
                preferences.putString(PreferenceName.LanguagePreference.getName(), locale.getSelectedTranslationId());
            }
            if (k == Input.Keys.RIGHT) {
                locale.selectNextTranslation();
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.UIEffectSoundChannel,
                        assetStorage.getAsset("UIButtonSelect0Sound", Sound.class)
                ));
                preferences.putString(PreferenceName.LanguagePreference.getName(), locale.getSelectedTranslationId());
            }
        });
        button.padBottom(ScreenConstants.INNER_ROW_SEPARATOR_PADDING);
        return button;
    }

    private Button createCurrentLanguageButton() {
        Button button = new Button(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonLanguage.getName()
        ).toUpperCase(), skin);
        button.padBottom(ScreenConstants.INNER_ROW_SEPARATOR_PADDING);
        return button;
    }

    private Button createSoundEffectVolumeButton() {
        Button button = new HorizontalButton(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonSoundEffectVolume.getName()
        ).toUpperCase(), skin);
        button.setKeyListener(k -> {
            if (k == Input.Keys.LEFT) {
                soundEffectAudioConfiguration.setOptionValue(
                        AudioConfiguration.Option.Volume,
                        soundEffectAudioConfiguration.getOptionValueAsInt(AudioConfiguration.Option.Volume)
                                - SOUND_VOLUME_STEP
                );
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.EffectSoundChannel,
                        assetStorage.getAsset("Tester0Sound", Sound.class)
                ));
            }
            if (k == Input.Keys.RIGHT) {
                soundEffectAudioConfiguration.setOptionValue(
                        AudioConfiguration.Option.Volume,
                        soundEffectAudioConfiguration.getOptionValueAsInt(AudioConfiguration.Option.Volume)
                                + SOUND_VOLUME_STEP
                );
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.EffectSoundChannel,
                        assetStorage.getAsset("Tester0Sound", Sound.class)
                ));
            }
        });
        button.padBottom(ScreenConstants.INNER_ROW_SEPARATOR_PADDING);
        return button;
    }

    private Button createCurrentSoundEffectVolumeButton() {
        Button button = new Button(String.valueOf(
                soundEffectAudioConfiguration.getOptionValueAsInt(AudioConfiguration.Option.Volume)), skin);
        button.padBottom(ScreenConstants.INNER_ROW_SEPARATOR_PADDING);
        return button;
    }

    private Button createSoundUIEffectVolumeButton() {
        Button button = new HorizontalButton(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonSoundUIEffectVolume.getName()
        ).toUpperCase(), skin);
        button.setKeyListener(k -> {
            if (k == Input.Keys.LEFT) {
                soundUIEffectAudioConfiguration.setOptionValue(
                        AudioConfiguration.Option.Volume,
                        soundUIEffectAudioConfiguration.getOptionValueAsInt(AudioConfiguration.Option.Volume)
                                - SOUND_VOLUME_STEP
                );
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.UIEffectSoundChannel,
                        assetStorage.getAsset("Tester0Sound", Sound.class)
                ));
            }
            if (k == Input.Keys.RIGHT) {
                soundUIEffectAudioConfiguration.setOptionValue(
                        AudioConfiguration.Option.Volume,
                        soundUIEffectAudioConfiguration.getOptionValueAsInt(AudioConfiguration.Option.Volume)
                                + SOUND_VOLUME_STEP
                );
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.UIEffectSoundChannel,
                        assetStorage.getAsset("Tester0Sound", Sound.class)
                ));
            }
        });
        button.padBottom(ScreenConstants.INNER_ROW_SEPARATOR_PADDING);
        return button;
    }

    private Button createCurrentSoundUIEffectVolumeButton() {
        Button button = new Button(String.valueOf(
                soundUIEffectAudioConfiguration.getOptionValueAsInt(AudioConfiguration.Option.Volume)), skin);
        button.padBottom(ScreenConstants.INNER_ROW_SEPARATOR_PADDING);
        return button;
    }

    private Button createMusicVolumeButton() {
        Button button = new HorizontalButton(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonMusicVolume.getName()
        ).toUpperCase(), skin);
        button.setKeyListener(k -> {
            if (k == Input.Keys.LEFT) {
                musicAudioConfiguration.setOptionValue(
                        AudioConfiguration.Option.Volume,
                        musicAudioConfiguration.getOptionValueAsInt(AudioConfiguration.Option.Volume)
                                - MUSIC_VOLUME_STEP
                );
                eventBus.post(new PlayMusicEvent(
                        MusicChannelName.MainMusicChannel,
                        assetStorage.getAsset("Tester0Music", Music.class)
                ));
            }
            if (k == Input.Keys.RIGHT) {
                musicAudioConfiguration.setOptionValue(
                        AudioConfiguration.Option.Volume,
                        musicAudioConfiguration.getOptionValueAsInt(AudioConfiguration.Option.Volume)
                                + MUSIC_VOLUME_STEP
                );
                eventBus.post(new PlayMusicEvent(
                        MusicChannelName.MainMusicChannel,
                        assetStorage.getAsset("Tester0Music", Music.class)
                ));
            }
        });
        return button;
    }

    private Button createCurrentMusicVolumeButton() {
        return new Button(String.valueOf(
                musicAudioConfiguration.getOptionValueAsInt(AudioConfiguration.Option.Volume)), skin);
    }

    private Button createBackButton() {
        Button backButton = new Button(
                locale.getSelectedTranslation().getEntry(
                        TranslationEntryKey.GameScreenButtonBack.getName())
                        .toUpperCase(),
                skin);
        backButton.setKeyListener(keycode -> {
            if (keycode == Input.Keys.ENTER) {
                getGameApplication().switchScreenWithoutTransition(MainMenuScreen.class);
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.UIEffectSoundChannel,
                        assetStorage.getAsset("UIButtonSelect0Sound", Sound.class)
                ));
                buttonGroup.lockButtons();
            }
        });
        return backButton;
    }

    private ButtonGroup createButtonGroup() {
        return new ButtonGroup(
                Lists.newArrayList(
                        languageButton,
                        soundEffectVolumeButton,
                        soundUIEffectVolumeButton,
                        musicVolumeButton,
                        backButton
                )
        );
    }

    @Override
    public void render(float delta) {
        levelPresenter.update(delta);
        titleLabel.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsTitle.getName()).toUpperCase());
        languageButton.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonLanguage.getName()
        ).toUpperCase());
        currentLanguageButton.setText(locale.getSelectedTranslationId().toUpperCase());
        soundEffectVolumeButton.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonSoundEffectVolume.getName()
        ).toUpperCase());
        currentSoundEffectVolumeButton.setText(String.valueOf(
                soundEffectAudioConfiguration.getOptionValueAsInt(AudioConfiguration.Option.Volume)));
        soundUIEffectVolumeButton.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonSoundUIEffectVolume.getName()
        ).toUpperCase());
        currentSoundUIEffectVolumeButton.setText(String.valueOf(
                soundUIEffectAudioConfiguration.getOptionValueAsInt(AudioConfiguration.Option.Volume)));
        musicVolumeButton.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenOptionsButtonMusicVolume.getName()
        ).toUpperCase());
        currentMusicVolumeButton.setText(String.valueOf(
                musicAudioConfiguration.getOptionValueAsInt(AudioConfiguration.Option.Volume)));
        backButton.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenButtonBack.getName()).toUpperCase());

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

        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            buttonGroup.getActiveButton().getKeyListener().ifPresent(l -> l.keyDown(Input.Keys.LEFT));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            buttonGroup.getActiveButton().getKeyListener().ifPresent(l -> l.keyDown(Input.Keys.RIGHT));
        }

        super.render(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}