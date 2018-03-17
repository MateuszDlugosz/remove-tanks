package remove.tanks.game.level.engine.entity;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabRepository {
    private final Map<String, String> entityPrefabFilenames;

    public EntityPrefabRepository(Map<String, String> entityPrefabFilenames) {
        this.entityPrefabFilenames = entityPrefabFilenames;
    }

    public String getPrefabFilename(String code) {
        if (!entityPrefabFilenames.containsKey(code)) {
            throw new EntityPrefabCodeNotFoundException(code);
        }
        return entityPrefabFilenames.get(code);
    }
}
