package remove.tanks.game.physics.light.world;

/**
 * @author Mateusz Długosz
 */
public enum WorldLightProperty {
    WorldLightAmbientLightR("world.light.ambient.light.r", "0"),
    WorldLightAmbientLightG("world.light.ambient.light.g", "0"),
    WorldLightAmbientLightB("world.light.ambient.light.b", "0"),
    WorldLightAmbientLightA("world.light.ambient.light.a", "0.5"),
    WorldLightShadows("world.light.shadows", "true");

    private final String name;
    private final String defaultValue;

    WorldLightProperty(String name, String defaultValue) {
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
