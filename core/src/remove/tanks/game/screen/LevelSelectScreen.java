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
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.LevelPresenter;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.level.LevelSequenceXmlLoader;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.constant.TranslationEntryKey;
import remove.tanks.game.screen.gui.buttons.Button;
import remove.tanks.game.screen.gui.buttons.ButtonGroup;
import remove.tanks.game.screen.gui.labels.Label;
import remove.tanks.game.screen.gui.listeners.KeyListener;

/**
 * @author Mateusz Długosz
 */
public final class LevelSelectScreen extends GameScreen {
    private final Locale locale;
    private final LevelPresenter levelPresenter;
    private final Skin skin;
    private final EventBus eventBus;
    private final AssetStorage assetStorage;
    private final LevelSequenceXmlLoader levelSequenceXmlLoader;

    private Stage stage;
    private Window window;
    private Table wrapper;
    private Label titleLabel;

    private ButtonGroup buttonGroup;

    private Button operationEarlyMorningButton;
    private Button backButton;

    public LevelSelectScreen(GameApplication gameApplication) {
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
        this.assetStorage = gameApplication.getContext()
                .getComponent("MainAssetStorage", AssetStorage.class);
        this.levelSequenceXmlLoader = gameApplication.getContext()
                .getComponent("LevelSequenceXmlLoader", LevelSequenceXmlLoader.class);

        this.operationEarlyMorningButton = createOperationButton(
                "prototypes/operations/early-morning-operation.xml",
                locale.getTranslation().getEntry(TranslationEntryKey.GameOperationEarlyMorning.getName())
        );

        this.titleLabel = createTitleLabel();
        this.backButton = createBackButton();
        this.buttonGroup = createButtonGroup();
        this.window = createWindow();
        this.wrapper = createWrapper();

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
        window.add(operationEarlyMorningButton.pad(5));
        window.row().padTop(80);
        window.add(backButton.pad(5));
        window.pack();
        wrapper.add(window);
        stage.addActor(wrapper);
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
                    getGameApplication().switchScreenWithTransition(ModeSelectScreen.class);
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
                        operationEarlyMorningButton,
                        backButton
                )
        );
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

    private Label createTitleLabel() {
        return new Label(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenOperationTitle.getName()
        ).toUpperCase(), skin);
    }

    private Button createOperationButton(String operationFilename, String operationName) {
        Button textButton = new Button(operationName.toUpperCase(), skin);
        LevelSequence levelSequence = levelSequenceXmlLoader.loadCampaign(operationFilename);
        textButton.setKeyListener(new KeyListener() {
            @Override
            public void keyDown(int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    getGameApplication().switchScreenWithTransition(new LevelLoadingScreen(
                            getGameApplication(),
                            levelSequence,
                            0,
                            null
                    ));
                    eventBus.post(new PlaySoundEvent(
                            assetStorage.getAsset("button-select", Sound.class)
                    ));
                    buttonGroup.lockButtons();
                }
            }
        });
        textButton.setChecked(true);
        return textButton;
    }

    @Override
    public void render(float delta) {
        levelPresenter.update(delta, eventBus);
        titleLabel.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenOperationTitle.getName()
        ).toUpperCase());
        operationEarlyMorningButton.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameOperationEarlyMorning.getName()
        ).toUpperCase());
        backButton.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameScreenButtonBack.getName()).toUpperCase());

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
            buttonGroup.getActiveButton().getKeyListener().ifPresent(l -> l.keyDown(Input.Keys.ENTER));
        }

        super.render(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
