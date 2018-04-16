package remove.tanks.game.level;

/**
 * @author Mateusz Długosz
 */
public enum LevelState {
    Play("Play"),
    Victory("Victory"),
    Defeat("Defeat"),
    Reset("Reset"),
    End("End");

    private final String name;

    LevelState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
