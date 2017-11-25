package remove.tanks.game.level.engine.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrototypeRepository {
    private final Map<String, EntityPrototype> prototypes;

    public EntityPrototypeRepository(Map<String, EntityPrototype> prototypes) {
        this.prototypes = prototypes;
    }

    public EntityPrototype getPrototype(String code) {
        if (!prototypes.containsKey(code)) {
            throw new EntityPrototypeNotFoundException(code);
        }
        return new EntityPrototype(
                prototypes.get(code).getFilename(),
                new HashMap<>(prototypes.get(code).getComponentPrototypes())
        );
    }
}
