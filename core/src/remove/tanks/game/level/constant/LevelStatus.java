package remove.tanks.game.level.constant;

/**
 * @author Mateusz Długosz
 */
public enum LevelStatus {
    Playing("playing"),
    Victory("victory"),
    Defeat("defeat");

    private final String name;

    LevelStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
