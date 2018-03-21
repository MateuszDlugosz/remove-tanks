package remove.tanks.game.data.profile;

/**
 * @author Mateusz Długosz
 */
public enum ProfileProperty {
    ProfilePoints("profile.points", "0"),
    ProfileDestroyedEnemies("profile.destroyed.enemies", "0"),
    ProfileMapsEnded("profile.maps.ended", "0");

    private final String name;
    private final String defaultValue;

    ProfileProperty(String name, String defaultValue) {
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
