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
import remove.tanks.game.data.profile.Profile;
import remove.tanks.game.data.profile.ProfileController;
import remove.tanks.game.data.profile.ProfileProperty;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.LevelPresenter;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.TranslationEntryKey;
import remove.tanks.game.screen.gui.button.Button;
import remove.tanks.game.screen.gui.button.ButtonGroup;
import remove.tanks.game.screen.gui.label.Label;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ProfileScreen extends GameScreen {
    private final Locale locale;
    private final LevelPresenter levelPresenter;
    private final Skin skin;
    private final EventBus eventBus;
    private final AssetStorage assetStorage;
    private final ProfileController profileController;

    private Profile profile;

    private final Label titleLabel;
    private final Button backButton;
    private final Table profileTable;
    private final Map<ProfileProperty, Button> profilePropertyLabels;
    private final Map<ProfileProperty, Button> profilePropertyValueLabels;

    private final ButtonGroup buttonGroup;

    private final Stage stage;
    private final Window window;
    private final Table wrapper;

    public ProfileScreen(GameApplication gameApplication) {
        super(gameApplication);
        this.stage = new Stage(
                gameApplication.getContext().getComponent("MenuCamera", Game2DCamera.class).getViewport(),
                gameApplication.getContext().getComponent("SpriteBatch", SpriteBatch.class));
        this.skin = gameApplication.getContext()
                .getComponent("UISkin", Skin.class);
        this.locale = gameApplication.getContext()
                .getComponent("Locale", Locale.class);
        this.levelPresenter = gameApplication.getContext()
                .getComponent("LevelPresenter", LevelPresenter.class);
        this.eventBus = gameApplication.getContext()
                .getComponent("EventBus", EventBus.class);
        this.assetStorage = gameApplication.getContext()
                .getComponent("MainAssetStorage", AssetStorage.class);
        this.profileController = gameApplication.getContext()
                .getComponent("ProfileController", ProfileController.class);
        this.profile = profileController.readProfile();

        this.titleLabel = createTitleLabel();
        this.profilePropertyLabels = createProfilePropertyLabels();
        this.profilePropertyValueLabels = createProfilePropertyValueLabels();
        this.profileTable = createProfileTable();
        this.backButton = createBackButton();
        this.buttonGroup = createButtonGroup();

        this.window = createWindow();
        this.wrapper = createWrapper();

        initStage();
    }

    @Override
    public void show() {
        buttonGroup.reset();
        profile = profileController.readProfile();
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    private void initStage() {
        window.setFillParent(false);
        window.pad(ScreenConstants.WINDOW_PADDING);
        window.add(titleLabel.pad(ScreenConstants.ELEMENT_PADDING));
        window.row().padTop(ScreenConstants.ROW_SEPARATOR_PADDING);
        window.add(profileTable.pad(ScreenConstants.ELEMENT_PADDING));
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

    private Label createTitleLabel() {
        return new Label(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenProfileTitle.getName()
        ).toUpperCase(), skin);
    }

    private Map<ProfileProperty, Button> createProfilePropertyLabels() {
        return Arrays.stream(ProfileProperty.values())
                .collect(Collectors.toMap(
                        p -> p,
                        p -> new Button(locale.getSelectedTranslation().getEntry(
                                TranslationEntryKey.valueOf("GameScreenProfileLabel" + p.name()).getName()
                        ).toUpperCase(), skin)
                ));
    }

    private Map<ProfileProperty, Button> createProfilePropertyValueLabels() {
        return Arrays.stream(ProfileProperty.values())
                .collect(Collectors.toMap(
                        p -> p,
                        p -> new Button(profile.getProperties().getString(p.getName()), skin)
                ));
    }

    private Table createProfileTable() {
        Table table = new Table();
        Arrays.stream(ProfileProperty.values()).forEach(p -> {
            table.add(profilePropertyLabels.get(p))
                    .pad(ScreenConstants.INNER_TABLE_ELEMENT_PADDING);
            table.add(profilePropertyValueLabels.get(p))
                    .pad(ScreenConstants.INNER_TABLE_ELEMENT_PADDING);
            table.row();
        });
        table.pack();
        return table;
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
        return new ButtonGroup(Lists.newArrayList(backButton));
    }

    @Override
    public void render(float delta) {
        levelPresenter.update(delta);
        this.titleLabel.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenProfileTitle.getName()
        ).toUpperCase());
        this.profilePropertyLabels.forEach((k, v) -> v.setText(
                locale.getSelectedTranslation().getEntry(
                        TranslationEntryKey.valueOf("GameScreenProfileLabel" + k.name()).getName()).toUpperCase()));
        this.profilePropertyValueLabels.forEach((k, v) -> v.setText(
                profile.getProperties().getString(k.getName())));
        this.backButton.setText(locale.getSelectedTranslation().getEntry(
                TranslationEntryKey.GameScreenButtonBack.getName()
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
