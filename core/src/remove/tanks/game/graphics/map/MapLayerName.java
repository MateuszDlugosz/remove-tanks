package remove.tanks.game.graphics.map;

/**
 * @author Mateusz Długosz
 */
public enum MapLayerName {
    GroundTiledLayer("ground_layer", 0),
    FogOfWarTiledLayer("fog_of_war_layer", 1),
    ObjectsLayer("objects_layer", 2);

    private final String name;
    private final int index;

    MapLayerName(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
