package remove.tanks.game.level.constant;

/**
 * @author Mateusz Długosz
 */
public enum LevelState {
    Playing("playing"),
    Victory("victory"),
    Defeat("defeat"),
    End("end");

    private final String name;

    LevelState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
