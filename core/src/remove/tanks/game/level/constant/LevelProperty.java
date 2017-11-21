package remove.tanks.game.level.constant;

/**
 * @author Mateusz Długosz
 */
public enum LevelProperty {
    WorldGravityX("world.gravity.x", "0"),
    WorldGravityY("world.gravity.y", "0"),
    WorldAllowSleep("world.allow.sleep", "true"),
    WorldLightNumberOfRays("world.light.number.of.rays", "100"),
    WorldLightAmbientR("world.light.ambient.r", "0"),
    WorldLightAmbientG("world.light.ambient.r", "0"),
    WorldLightAmbientB("world.light.ambient.r", "0"),
    WorldLightAmbientA("world.light.ambient.r", "1"),
    LevelEnemies("level.enemies", "0"),
    LevelPoints("level.points", "0"),
    LevelPointsMultiplier("level.points.multiplier", "1"),
    LevelLifes("level.lifes", "3"),
    LevelStatus("level.status", "none");

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
