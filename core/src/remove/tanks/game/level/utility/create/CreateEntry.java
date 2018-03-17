package remove.tanks.game.level.utility.create;

import remove.tanks.game.utility.surface.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class CreateEntry {
    private final String prefabCode;
    private final Position position;

    public CreateEntry(String prefabCode, Position position) {
        this.prefabCode = prefabCode;
        this.position = position;
    }

    public String getPrefabCode() {
        return prefabCode;
    }

    public Position getPosition() {
        return position;
    }
}
