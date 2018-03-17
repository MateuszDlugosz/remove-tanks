package remove.tanks.game.level;

import remove.tanks.game.utility.number.random.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LevelPresenterFactory {
    private final RandomNumberGenerator randomNumberGenerator;
    private final LevelFactory levelFactory;
    private final LevelControllerFactory levelControllerFactory;

    public LevelPresenterFactory(
            RandomNumberGenerator randomNumberGenerator,
            LevelFactory levelFactory,
            LevelControllerFactory levelControllerFactory
    ) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.levelFactory = levelFactory;
        this.levelControllerFactory = levelControllerFactory;
    }

    public LevelPresenter createLevelPresenter(LevelPresenterPrefab prefab) {
        try {
            return new LevelPresenter(
                    randomNumberGenerator,
                    createLevelControllers(prefab.getLevelPrefabs()),
                    prefab.getPresentationTime()
            );
        } catch (Exception e) {
            throw new LevelPresenterCreateException(prefab, e);
        }
    }

    private List<LevelController> createLevelControllers(List<LevelPrefab> prefabs) {
        return levelFactory.createLevels(prefabs).stream()
                .map(levelControllerFactory::createLevelController)
                .collect(Collectors.toList());
    }
}
