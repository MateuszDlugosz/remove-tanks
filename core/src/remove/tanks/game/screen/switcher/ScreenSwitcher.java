package remove.tanks.game.screen.switcher;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import remove.tanks.game.screen.GameScreen;
import remove.tanks.game.screen.switcher.storage.ScreenStorage;
import remove.tanks.game.screen.switcher.transitions.StageActionFactory;

/**
 * @author Mateusz Długosz
 */
public final class ScreenSwitcher {
    private final ScreenStorage screenStorage;
    private final StageActionFactory defaultHideStageActionFactory;
    private final StageActionFactory defaultShowStageActionFactory;

    public ScreenSwitcher(
            ScreenStorage screenStorage,
            StageActionFactory defaultHideStageActionFactory,
            StageActionFactory defaultShowStageActionFactory
    ) {
        this.screenStorage = screenStorage;
        this.defaultHideStageActionFactory = defaultHideStageActionFactory;
        this.defaultShowStageActionFactory = defaultShowStageActionFactory;
    }

    public void switchScreenWithTransition(Class<? extends GameScreen> screenClass, Game game) {
        switchScreenWithTransition(screenStorage.getScreen(screenClass), game);
    }

    public void switchScreenWithTransition(GameScreen screen, Game game) {
        if (game.getScreen() == null) {
            screen.getStage().addAction(defaultShowStageActionFactory.createStageAction(screen.getStage()));
            Gdx.input.setInputProcessor(screen.getStage());
            game.setScreen(screen);
        } else {
            SequenceAction action = new SequenceAction();
            action.addAction(defaultHideStageActionFactory.createStageAction(screen.getStage()));
            action.addAction(Actions.run(() -> {
                    screen.getStage().addAction(defaultShowStageActionFactory.createStageAction(screen.getStage()));
                    Gdx.input.setInputProcessor(screen.getStage());
                    game.setScreen(screen);
            }));
            ((GameScreen) game.getScreen()).getStage().getRoot().addAction(action);
        }
    }

    public void switchScreenWithoutTransition(Class<? extends GameScreen> screenClass, Game game) {
        game.setScreen(screenStorage.getScreen(screenClass));
    }

    public void switchScreenWithoutTransition(GameScreen screen, Game game) {
        game.setScreen(screen);
    }
}
