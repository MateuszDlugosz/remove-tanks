package remove.tanks.game.level.engine.entity.component.spawn;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

/**
 * @author Mateusz Długosz
 */
public final class BombersSpawnerComponentPrototype implements ComponentPrototype {
    private final String prototypeCode;

    public BombersSpawnerComponentPrototype(String prototypeCode) {
        this.prototypeCode = prototypeCode;
    }

    public String getPrototypeCode() {
        return prototypeCode;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("prototypeCode", prototypeCode)
                .toString();
    }
}
