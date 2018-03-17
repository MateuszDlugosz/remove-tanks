package remove.tanks.game.level.engine.entity;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabStorageFactory {
    private final EntityPrefabXmlReader entityPrefabXmlReader;

    public EntityPrefabStorageFactory(EntityPrefabXmlReader entityPrefabXmlReader) {
        this.entityPrefabXmlReader = entityPrefabXmlReader;
    }

    public EntityPrefabStorage createEntityPrefabStorage(EntityPrefabRepository repository) {
        try {
            return new EntityPrefabStorage(repository, entityPrefabXmlReader);
        } catch (Exception e) {
            throw new EntityPrefabStorageCreateException(e);
        }
    }
}
