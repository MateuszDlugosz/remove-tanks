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
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.LevelPresenter;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.LevelSequence;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.TranslationEntryKey;
import remove.tanks.game.screen.gui.button.Button;
import remove.tanks.game.screen.gui.button.ButtonGroup;
import remove.tanks.game.screen.gui.label.Label;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class LevelSummaryScreen extends GameScreen {
    private final LevelSequence levelSequence;
    private final Properties properties;
    private final LevelPresenter levelPresenter;
    private final EventBus eventBus;
    private final Locale locale;
    private final AssetStorage assetStorage;
    private final Skin skin;

    private TextButton titleLabel;
    private TextButton contentLabel;
    private Button backButton;

    private ButtonGroup buttonGroup;

    private Stage stage;
    private Table wrapper;
    private Window window;

    public LevelSummaryScreen(GameApplication gameApplication, LevelSequence levelSequence, Properties properties) {
        super(gameApplication);
        this.levelSequence = levelSequence;
        this.properties = properties;
        this.skin = gameApplication.getContext()
                .getComponent("UISkin", Skin.class);
        this.stage = new Stage(
                gameApplication.getContext()
                        .getComponent("MenuCamera", Game2DCamera.class).getViewport(),
                gameApplication.getContext()
                        .getComponent("SpriteBatch", SpriteBatch.class));
        this.assetStorage = gameApplication.getContext()
                .getComponent("MainAssetStorage", AssetStorage.class);
        this.locale = gameApplication.getContext()
                .getComponent("Locale", Locale.class);
        this.eventBus = gameApplication.getContext()
                .getComponent("EventBus", EventBus.class);
        this.levelPresenter = gameApplication.getContext()
                .getComponent("LevelPresenter", LevelPresenter.class);

        this.window = createWindow();
        this.wrapper = createWrapper();

        this.contentLabel = createContentLabel();
        this.titleLabel = createTitleLabel();
        this.backButton = createBackButton();

        this.buttonGroup = createButtonGroup();

        initStage();
    }

    private void initStage() {
        window.setFillParent(false);
        window.pad(ScreenConstants.WINDOW_PADDING);
        window.add(titleLabel.pad(ScreenConstants.ELEMENT_PADDING));
        window.row().padTop(ScreenConstants.ROW_SEPARATOR_PADDING);
        window.add(contentLabel.pad(ScreenConstants.ELEMENT_PADDING));
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
        window.setMovable(false);
        return window;
    }

    private Table createWrapper() {
        Table wrapper = new Table();
        wrapper.setFillParent(true);
        return wrapper;
    }

    private TextButton createTitleLabel() {
        return new Label(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenSummaryTitle.getName()
        ).toUpperCase(), skin);
    }

    private TextButton createContentLabel() {
        return new Button(String.format(
                locale.getSelectedTranslation().getEntry(
                        TranslationEntryKey.GameScreenSummaryContent.getName()
                ),
                locale.getSelectedTranslation().getEntry(
                        String.format(
                                TranslationEntryKey.GameLevelSequenceTitleTemplate.getName(),
                                levelSequence.getTitleTranslationEntryKey()
                        )
                ),
                properties.getString(LevelProperty.LevelPoints.getName())
        ).toUpperCase(), skin);
    }

    private Button createBackButton() {
        Button backButton = new Button(
                locale.getSelectedTranslation().getEntry(
                        TranslationEntryKey.GameScreenButtonBack.getName())
                        .toUpperCase(),
                skin);
        backButton.setKeyListener(k -> {
            if (k == Input.Keys.ENTER) {
                getGameApplication().switchScreenWithoutTransition(MainMenuScreen.class);
                eventBus.post(new PlaySoundEvent(
                        SoundChannelName.EffectSoundChannel,
                        assetStorage.getAsset("UIButtonSelect0Sound", Sound.class)
                ));
                buttonGroup.lockButtons();
            }
        });
        return backButton;
    }

    private ButtonGroup createButtonGroup() {
        return new ButtonGroup(Lists.newArrayList(backButton));
    }

    @Override
    public void show() {
        buttonGroup.reset();
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public void render(float delta) {
        levelPresenter.update(delta);
        this.titleLabel.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenSummaryTitle.getName()
        ).toUpperCase());
        this.backButton.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenButtonBack.getName()
        ).toUpperCase());
        this.contentLabel.setText(
                String.format(
                        locale.getSelectedTranslation().getEntry(
                                TranslationEntryKey.GameScreenSummaryContent.getName()
                        ),
                        locale.getSelectedTranslation().getEntry(
                                String.format(
                                        TranslationEntryKey.GameLevelSequenceTitleTemplate.getName(),
                                        levelSequence.getTitleTranslationEntryKey()
                                )
                        ),
                        properties.getString(LevelProperty.LevelPoints.getName())
                ).toUpperCase()
        );

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
