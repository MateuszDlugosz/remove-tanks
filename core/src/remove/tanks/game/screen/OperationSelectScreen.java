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
import remove.tanks.game.level.mode.operation.Operation;
import remove.tanks.game.level.mode.operation.OperationStorage;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.TranslationEntryKey;
import remove.tanks.game.screen.gui.button.Button;
import remove.tanks.game.screen.gui.button.ButtonGroup;
import remove.tanks.game.screen.gui.label.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class OperationSelectScreen extends GameScreen {
    private final Locale locale;
    private final LevelPresenter levelPresenter;
    private final Skin skin;
    private final EventBus eventBus;
    private final AssetStorage assetStorage;
    private final OperationStorage operationStorage;

    private final Stage stage;
    private final Window window;
    private final Table wrapper;

    private final TextButton titleLabel;
    private final Map<String, Button> operationButtons;
    private final Button backButton;

    private final ButtonGroup buttonGroup;

    public OperationSelectScreen(GameApplication gameApplication) {
        super(gameApplication);
        this.stage = new Stage(
                gameApplication.getContext()
                        .getComponent("MenuCamera", Game2DCamera.class).getViewport(),
                gameApplication.getContext()
                        .getComponent("SpriteBatch", SpriteBatch.class));
        this.locale = gameApplication.getContext()
                .getComponent("Locale", Locale.class);
        this.levelPresenter = gameApplication.getContext()
                .getComponent("LevelPresenter", LevelPresenter.class);
        this.skin = gameApplication.getContext().getComponent("UISkin", Skin.class);
        this.eventBus = gameApplication.getContext()
                .getComponent("EventBus", EventBus.class);
        this.assetStorage = gameApplication.getContext()
                .getComponent("MainAssetStorage", AssetStorage.class);
        this.operationStorage = gameApplication.getContext()
                .getComponent("OperationStorage", OperationStorage.class);

        this.window = createWindow();
        this.wrapper = createWrapper();

        this.titleLabel = createTitleLabel();
        this.operationButtons = createOperationButtons();
        this.backButton = createBackButton();

        this.buttonGroup = createButtonGroup();

        initStage();
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public void show() {
        buttonGroup.reset();
    }

    private void initStage() {
        window.setFillParent(false);
        window.pad(ScreenConstants.WINDOW_PADDING);
        window.add(titleLabel.pad(ScreenConstants.ELEMENT_PADDING));
        window.row().padTop(ScreenConstants.ROW_SEPARATOR_PADDING);
        operationButtons.values().forEach(button -> {
            window.add(button.pad(ScreenConstants.ELEMENT_PADDING));
            window.row().padTop(ScreenConstants.INNER_ROW_SEPARATOR_PADDING);
        });
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
                TranslationEntryKey.GameScreenOperationSelectTitle.getName()
        ).toUpperCase(), skin);
    }

    private Map<String, Button> createOperationButtons() {
        return operationStorage.getOperationTitles().stream()
                .map(operationStorage::getOperation)
                .collect(Collectors.toMap(
                        Operation::getTitle,
                        operation -> new Button(
                                locale.getSelectedTranslation().getEntry(
                                        String.format(TranslationEntryKey.GameLevelSequenceTitleTemplate.getName(),
                                                operation.getTitle())
                                ).toUpperCase(),
                                skin
                        )
                ));
    }

    private Button createBackButton() {
        Button backButton = new Button(
                locale.getSelectedTranslation().getEntry(
                        TranslationEntryKey.GameScreenButtonBack.getName())
                        .toUpperCase(),
                skin);
        backButton.setKeyListener(k -> {
            if (k == Input.Keys.ENTER) {
                getGameApplication().switchScreenWithoutTransition(ModeSelectScreen.class);
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
        List<Button> group = new ArrayList<>(operationButtons.values());
        group.add(backButton);
        return new ButtonGroup(group);
    }

    @Override
    public void render(float delta) {
        levelPresenter.update(delta);
        this.titleLabel.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenOperationSelectTitle.getName()
        ).toUpperCase());
        operationButtons.forEach((title, button) -> button.setText(
                locale.getSelectedTranslation().getEntry(
                        String.format(TranslationEntryKey.GameLevelSequenceTitleTemplate.getName(), title)
                ).toUpperCase()
        ));
        this.backButton.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenButtonBack.getName()
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
