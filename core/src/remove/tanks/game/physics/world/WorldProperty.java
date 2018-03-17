package remove.tanks.game.physics.world;

/**
 * @author Mateusz Długosz
 */
public enum WorldProperty {
    WorldGravityX("world.gravity.x", "0"),
    WorldGravityY("world.gravity.y", "0"),
    WorldAllowSleep("world.allow.sleep", "true");

    private String name;
    private String defaultValue;

    WorldProperty(String name, String defaultValue) {
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
