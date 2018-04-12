package remove.tanks.game.data.profile;

/**
 * @author Mateusz Długosz
 */
public enum ProfileProperty {
    ProfileVersion("profile.version"),
    ProfilePoints("profile.points"),
    ProfileDestroyedEnemies("profile.destroyed.enemies");

    private final String name;

    ProfileProperty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
