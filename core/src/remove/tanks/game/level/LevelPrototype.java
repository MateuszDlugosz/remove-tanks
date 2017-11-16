package remove.tanks.game.level;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.EnginePrototype;
import remove.tanks.game.utility.properties.Properties;

import java.io.Serializable;

/**
 * @author Mateusz Długosz
 */
public final class LevelPrototype implements Serializable {
    private final EnginePrototype enginePrototype;
    private final Properties properties;

    public LevelPrototype(
            EnginePrototype enginePrototype,
            Properties properties
    ) {
        this.enginePrototype = enginePrototype;
        this.properties = properties;
    }

    public EnginePrototype getEnginePrototype() {
        return enginePrototype;
    }

    public Properties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("enginePrototype", enginePrototype)
                .add("properties", properties)
                .toString();
    }
}
