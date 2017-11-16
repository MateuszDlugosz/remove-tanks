package remove.tanks.game.level.engine.utility.spwan.entry;

import remove.tanks.game.utility.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class SpawnEntry {
    private final Position position;
    private final String prototypeCode;

    public SpawnEntry(Position position, String prototypeCode) {
        this.position = position;
        this.prototypeCode = prototypeCode;
    }

    public Position getPosition() {
        return position;
    }

    public String getPrototypeCode() {
        return prototypeCode;
    }
}
