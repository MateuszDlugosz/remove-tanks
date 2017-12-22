package remove.tanks.game.level.constant;

/**
 * @author Mateusz Długosz
 */
public enum LevelProperty {
    LevelResourceWorldGravityX("level.resource.world.gravity.x", "0"),
    LevelResourceWorldGravityY("level.resource.world.gravity.y", "0"),
    LevelResourceWorldAllowSleep("level.resource.world.allow.sleep", "true"),
    LevelResourceWorldLightNumberOfRays("level.resource.world.light.number.of.rays", "100"),
    LevelResourceWorldLightAmbientR("level.resource.world.light.ambient.r", "0"),
    LevelResourceWorldLightAmbientG("level.resource.world.light.ambient.r", "0"),
    LevelResourceWorldLightAmbientB("level.resource.world.light.ambient.r", "0"),
    LevelResourceWorldLightAmbientA("level.resource.world.light.ambient.r", "1"),
    LevelResourceThemeFilename("level.resource.theme.filename", "theme-filename"),
    LevelResourceTiledMapFilename("level.resource.tiled-map.filename", "tiled-map-filename"),
    LevelResourceEntityPrototypeRepositoryFilename("level.resource.entity-prototype-repository.filename",
            "entity-prototype-repository-filename"),
    LevelEnemies("level.enemies", "0"),
    LevelPoints("level.points", "0"),
    LevelPointsMultiplier("level.points-multiplier", "1"),
    LevelLifes("level.lifes", "3"),
    LevelState("level.state", "Playing");

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
