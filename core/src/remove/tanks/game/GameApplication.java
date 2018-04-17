package remove.tanks.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import remove.tanks.game.application.context.ApplicationContext;
import remove.tanks.game.application.context.Context;
import remove.tanks.game.application.context.configuration.Configuration;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.AudioConfigurationController;
import remove.tanks.game.data.screenshot.ScreenshotMaker;
import remove.tanks.game.level.LevelPresenter;
import remove.tanks.game.screen.*;
import remove.tanks.game.screen.switcher.ScreenSwitcher;
import remove.tanks.game.screen.switcher.storage.ScreenStorage;
import remove.tanks.game.screen.switcher.transition.FadeInStageActionFactory;
import remove.tanks.game.screen.switcher.transition.FadeOutStageActionFactory;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Mateusz Długosz
 */
public final class GameApplication extends Game {
    public static final String TITLE = "Remove Tanks!";
    public static final String VERSION = "0.19.120";

    private final Configuration configuration;
    private Context context;
    private ScreenSwitcher screenSwitcher;
    private ScreenshotMaker screenshotMaker;

    public GameApplication(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void create() {
        this.context = new ApplicationContext(configuration);
        this.screenSwitcher = new ScreenSwitcher(
                new ScreenStorage(new HashSet<>(Arrays.asList(
                        new MainMenuScreen(this),
                        new OptionsScreen(this),
                        new ProfileScreen(this),
                        new CreditsScreen(this)
                ))),
                new FadeOutStageActionFactory(0.3f),
                new FadeInStageActionFactory(0.3f)
        );
        this.screenshotMaker = context.getComponent("ScreenshotMaker", ScreenshotMaker.class);
        this.screenSwitcher.switchScreenWithTransition(MainMenuScreen.class, this);
    }

    public Context getContext() {
        return context;
    }

    public void switchScreenWithTransition(GameScreen screen) {
        this.screenSwitcher.switchScreenWithTransition(screen, this);
    }

    public void switchScreenWithoutTransition(Class<? extends GameScreen> screenClass) {
        this.screenSwitcher.switchScreenWithoutTransition(screenClass, this);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();

        if (Gdx.input.isKeyJustPressed(Input.Keys.F12)) {
            screenshotMaker.makeScreenshot();
        }
    }

    @Override
    public void dispose () {
        getContext().getComponent("AudioConfigurationController", AudioConfigurationController.class)
                .saveAudioConfiguration();
        getContext().getComponent("Preferences", Preferences.class).flush();
        getContext().getComponent("LevelPresenter", LevelPresenter.class).dispose();
        getContext().getComponent("SpriteBatch", SpriteBatch.class).dispose();
        getContext().getComponent("MainAssetStorage", AssetStorage.class).dispose();
        getContext().getComponent("UISkin", Skin.class).dispose();
    }
}
