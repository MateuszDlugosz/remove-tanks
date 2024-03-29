package remove.tanks.game.level.mode.arena;

import com.badlogic.gdx.Gdx;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ArenaStorageFactory {
    private final ArenaPrefabXmlReader arenaPrefabXmlReader;
    private final ArenaFactory arenaFactory;

    public ArenaStorageFactory(ArenaPrefabXmlReader arenaPrefabXmlReader, ArenaFactory arenaFactory) {
        this.arenaPrefabXmlReader = arenaPrefabXmlReader;
        this.arenaFactory = arenaFactory;
    }

    public ArenaStorage createArenaStorage(ArenaPrefabFilenameRepository repository) {
        try {
            return new ArenaStorage(createArenaMap(repository));
        } catch (Exception e) {
            throw new ArenaStorageCreateException(e);
        }
    }

    private Map<String, Arena> createArenaMap(ArenaPrefabFilenameRepository repository) {
        return arenaPrefabXmlReader.readArenaPrefabs(
                repository.getArenaPrefabFilenames().stream().map(Gdx.files::internal).collect(Collectors.toList())
        ).stream()
                .collect(Collectors.toMap(
                        ArenaPrefab::getTitle,
                        arenaFactory::createArena
                ));
    }
}
