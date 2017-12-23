package remove.tanks.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import remove.tanks.game.application.context.ApplicationContext;
import remove.tanks.game.application.context.Context;
import remove.tanks.game.application.context.configuration.Configuration;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.level.LevelPresenter;
import remove.tanks.game.screen.*;
import remove.tanks.game.screen.switcher.ScreenSwitcher;
import remove.tanks.game.screen.switcher.storage.ScreenStorage;
import remove.tanks.game.screen.switcher.transitions.FadeInStageActionFactory;
import remove.tanks.game.screen.switcher.transitions.FadeOutStageActionFactory;

import java.util.Arrays;
import java.util.HashSet;

public final class GameApplication extends Game {
	public static final String TITLE = "Remove Tanks!";
	public static final String VERSION = "0.18.97";

	private final Configuration configuration;

	private Context context;
	private ScreenSwitcher screenSwitcher;

	public GameApplication(Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	public void create() {
		this.context = new ApplicationContext(configuration);
		this.screenSwitcher = new ScreenSwitcher(
				new ScreenStorage(new HashSet<>(Arrays.asList(
						new MainMenuScreen(this),
						new CreditsScreen(this),
						new OptionsScreen(this),
						new CampaignSelectScreen(this),
						new ModeSelectScreen(this)
				))),
				new FadeOutStageActionFactory(0.5f),
				new FadeInStageActionFactory(0.5f)
		);
		this.screenSwitcher.switchScreenWithTransition(MainMenuScreen.class, this);
	}

	public Context getContext() {
		return context;
	}

	public void switchScreenWithTransition(Class<? extends GameScreen> screenClass) {
		this.screenSwitcher.switchScreenWithTransition(screenClass, this);
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
	}

	@Override
	public void dispose () {
		getContext().getComponent("SpriteBatch", SpriteBatch.class).dispose();
		getContext().getComponent("MainAssetStorage", AssetStorage.class).dispose();
		getContext().getComponent("MenuLevelPresenter", LevelPresenter.class).dispose();
		getContext().getComponent("UiSkin", Skin.class).dispose();
	}
}
