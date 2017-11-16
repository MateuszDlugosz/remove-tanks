package remove.tanks.game.level.engine.utility.spwan.entry;

import remove.tanks.game.utility.position.PositionPrototype;

/**
 * @author Mateusz Długosz
 */
public final class SpawnEntryPrototype {
    private final PositionPrototype positionPrototype;
    private final String prototypeCode;

    public SpawnEntryPrototype(PositionPrototype positionPrototype, String prototypeCode) {
        this.positionPrototype = positionPrototype;
        this.prototypeCode = prototypeCode;
    }

    public PositionPrototype getPositionPrototype() {
        return positionPrototype;
    }

    public String getPrototypeCode() {
        return prototypeCode;
    }
}
