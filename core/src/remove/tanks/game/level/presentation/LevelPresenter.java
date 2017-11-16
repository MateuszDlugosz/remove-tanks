package remove.tanks.game.level.presentation;

import com.badlogic.gdx.utils.Disposable;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.LevelController;
import remove.tanks.game.level.LevelDisposer;
import remove.tanks.game.utility.random.RandomNumberGenerator;
import remove.tanks.game.utility.time.Timer;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class LevelPresenter implements Disposable {
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<LevelController> levelControllers;
    private final Timer timer;

    private int currentLevelIndex;

    public LevelPresenter(
            RandomNumberGenerator randomNumberGenerator,
            List<LevelController> levelControllers,
            float presentationTime
    ) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.levelControllers = levelControllers;
        this.timer = new Timer(presentationTime);
        this.currentLevelIndex = getRandomIndex();
    }

    private int getRandomIndex() {
        return randomNumberGenerator.getRandomInt(0, levelControllers.size()-1);
    }

    public void update(float delta, EventBus eventBus) {
        if (timer.isComplete()) {
            currentLevelIndex = getRandomIndex();
            timer.reset();
        } else {
            timer.update(delta);
        }
        levelControllers.get(currentLevelIndex).update(delta, eventBus);
    }

    @Override
    public void dispose() {
        LevelDisposer levelDisposer = new LevelDisposer();
        for (LevelController levelController : levelControllers) {
            levelDisposer.disposeLevel(levelController.getLevel());
        }
    }
}
