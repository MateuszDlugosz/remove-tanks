package remove.tanks.game.level.engine.entity;

import com.badlogic.gdx.Gdx;

import java.util.*;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabStorage {
    private final EntityPrefabRepository entityPrefabRepository;
    private final EntityPrefabXmlReader entityPrefabXmlReader;
    private final Map<String, EntityPrefab> entityPrefabs;

    public EntityPrefabStorage(
            EntityPrefabRepository entityPrefabRepository,
            EntityPrefabXmlReader entityPrefabXmlReader
    ) {
        this.entityPrefabRepository = entityPrefabRepository;
        this.entityPrefabXmlReader = entityPrefabXmlReader;
        this.entityPrefabs = new HashMap<>();
    }

    public void loadEntityPrefabs(String[] codes) {
        loadEntityPrefabs(Arrays.asList(codes));
    }

    public void loadEntityPrefabs(List<String> codes) {
        codes.forEach(this::loadEntityPrefab);
    }

    public void loadEntityPrefab(String code) {
        if (!isEntityPrefabLoaded(code)) {
            try {
                entityPrefabs.put(code, entityPrefabXmlReader
                        .readEntityPrefab(Gdx.files.internal(entityPrefabRepository.getPrefabFilename(code))));
            } catch (Exception e) {
                throw new EntityPrefabLoadException(code, e);
            }
        }
    }

    public void unloadAllEntityPrefabs() {
        unloadEntityPrefabs(new ArrayList<>(entityPrefabs.keySet()));
    }

    public void unloadEntityPrefabs(String[] codes) {
        unloadEntityPrefabs(Arrays.asList(codes));
    }

    public void unloadEntityPrefabs(List<String> codes) {
        codes.forEach(this::unloadEntityPrefab);
    }

    public void unloadEntityPrefab(String code) {
        if (entityPrefabs.containsKey(code)) {
            try {
                entityPrefabs.remove(code);
            } catch (Exception e) {
                throw new EntityPrefabUnloadException(code, e);
            }
        }
    }

    public EntityPrefab getEntityPrefab(String code) {
        if (!isEntityPrefabLoaded(code)) {
            throw new EntityPrefabNotFoundException(code);
        }
        return entityPrefabs.get(code);
    }

    public EntityPrefab getEntityPrefabCopy(String code) {
        if (!isEntityPrefabLoaded(code)) {
            throw new EntityPrefabNotFoundException(code);
        }
        return new EntityPrefab(
                entityPrefabs.get(code).getPreloadData(),
                new HashMap<>(entityPrefabs.get(code).getComponentPrefabs())
        );
    }

    public Set<String> getEntityPrefabCodes() {
        return entityPrefabs.keySet();
    }

    public boolean isEntityPrefabLoaded(String code) {
        return entityPrefabs.containsKey(code);
    }
}
