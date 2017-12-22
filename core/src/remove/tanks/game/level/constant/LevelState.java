package remove.tanks.game.level.constant;

/**
 * @author Mateusz Długosz
 */
public enum LevelState {
    Playing("Playing"),
    Victory("Victory"),
    Defeat("Defeat"),
    End("End");

    private final String name;

    LevelState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
