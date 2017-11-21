package remove.tanks.game.level.constant;

/**
 * @author Mateusz Długosz
 */
public enum LevelMapLayer {
    ObjectsLayer("objects_layer");

    private final String name;

    LevelMapLayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
