package remove.tanks.game.physics.light;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class LightHandlerPrototype implements Serializable {
    private final String id;
    private final LightPrototype lightPrototype;

    public LightHandlerPrototype(String id, LightPrototype lightPrototype) {
        this.id = id;
        this.lightPrototype = lightPrototype;
    }

    public String getId() {
        return id;
    }

    public LightPrototype getLightPrototype() {
        return lightPrototype;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("lightPrototype", lightPrototype)
                .toString();
    }
}
