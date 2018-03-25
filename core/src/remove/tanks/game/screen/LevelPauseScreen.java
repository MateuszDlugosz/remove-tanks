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
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.LevelDisposer;
import remove.tanks.game.level.LevelPresenter;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.TranslationEntryKey;
import remove.tanks.game.screen.gui.button.Button;
import remove.tanks.game.screen.gui.button.ButtonGroup;
import remove.tanks.game.screen.gui.label.Label;

/**
 * @author Mateusz Długosz
 */
public final class LevelPauseScreen extends GameScreen {
    private final LevelPresenter levelPresenter;
    private final EventBus eventBus;
    private final AssetStorage assetStorage;
    private final LevelDisposer levelDisposer;
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
    private remove.tanks.game.screen.gui.label.Label titleLabel;
    private TextButton contentLabel;

    private ButtonGroup buttonGroup;

    public LevelPauseScreen(GameApplication gameApplication, LevelScreen levelScreen) {
        super(gameApplication);
        this.levelScreen = levelScreen;
        this.levelPresenter = gameApplication.getContext()
                .getComponent("LevelPresenter", LevelPresenter.class);
        this.eventBus = gameApplication.getContext()
                .getComponent("EventBus", EventBus.class);
        this.assetStorage = gameApplication.getContext()
                .getComponent("MainAssetStorage", AssetStorage.class);
        this.levelDisposer = gameApplication.getContext()
                .getComponent("LevelDisposer", LevelDisposer.class);
        this.locale = gameApplication.getContext()
                .getComponent("Locale", Locale.class);
        this.skin = gameApplication.getContext()
                .getComponent("UISkin", Skin.class);
        this.stage = new Stage(
                gameApplication.getContext().getComponent("MenuCamera", Game2DCamera.class).getViewport(),
                gameApplication.getContext().getComponent("SpriteBatch", SpriteBatch.class)
        );

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
        return new Label(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenPauseTitle.getName()).toUpperCase(), skin);
    }

    private TextButton createContentLabel() {
        return new TextButton(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenPauseContent.getName()).toUpperCase(), skin);
    }

    private Button createYesButton() {
        Button button = new Button(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenButtonYes.getName()
        ).toUpperCase(), skin);
        button.setKeyListener(keycode -> {
            if (keycode == Input.Keys.ENTER) {
                levelDisposer.disposeLevel(levelScreen.getLevelController().getLevel());
                getGameApplication().switchScreenWithoutTransition(MainMenuScreen.class);
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.UIEffectSoundChannel,
                        assetStorage.getAsset("UIButtonSelect0Sound", Sound.class)
                ));
                buttonGroup.lockButtons();
            }
        });
        return button;
    }

    private Button createNoButton() {
        Button button = new Button(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenButtonNo.getName()
        ).toUpperCase(), skin);
        button.setKeyListener(keycode -> {
            if (keycode == Input.Keys.ENTER) {
                getGameApplication().switchScreenWithTransition(levelScreen);
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.UIEffectSoundChannel,
                        assetStorage.getAsset("UIButtonSelect0Sound", Sound.class)
                ));
                buttonGroup.lockButtons();
            }
        });
        return button;
    }

    @Override
    public void render(float delta) {
        levelPresenter.update(delta);
        titleLabel.setText(locale.getSelectedTranslation()
                .getEntry(TranslationEntryKey.GameScreenPauseTitle.getName()).toUpperCase());
        contentLabel.setText(locale.getSelectedTranslation()
                .getEntry(TranslationEntryKey.GameScreenPauseContent.getName()).toUpperCase());
        yesButton.setText(locale.getSelectedTranslation()
                .getEntry(TranslationEntryKey.GameScreenButtonYes.getName()).toUpperCase());
        noButton.setText(locale.getSelectedTranslation()
                .getEntry(TranslationEntryKey.GameScreenButtonNo.getName()).toUpperCase());

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            buttonGroup.getActiveButton().getKeyListener().ifPresent(l -> l.keyDown(Input.Keys.ENTER));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            buttonGroup.activateNextButton();
            eventBus.post(new PlaySoundEvent(
                    SoundChannelName.UIEffectSoundChannel,
                    assetStorage.getAsset("UIButtonChange0Sound", Sound.class)
            ));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            buttonGroup.activatePreviousButton();
            eventBus.post(new PlaySoundEvent(
                    SoundChannelName.UIEffectSoundChannel,
                    assetStorage.getAsset("UIButtonChange0Sound", Sound.class)
            ));
        }
        super.render(delta);
    }
 }
