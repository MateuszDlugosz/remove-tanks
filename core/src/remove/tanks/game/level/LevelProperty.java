package remove.tanks.game.level;

/**
 * @author Mateusz Długosz
 */
public enum LevelProperty {
    LevelEnemiesLeft("level.enemies.left", "0"),
    LevelEnemiesDestroyed("level.enemies.destroyed", "0"),
    LevelPoints("level.points", "0"),
    LevelPointsMultiplier("level.points.multiplier", "1"),
    LevelLifes("level.lifes", "3"),
    LevelState("level.state", "Play"),
    LevelTimeLeft("level.time.left", "0.0");

    private final String name;
    private final String defaultValue;

    LevelProperty(String name, String defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
