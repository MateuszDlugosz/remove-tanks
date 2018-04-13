package remove.tanks.game.level.mode.arena;

import com.badlogic.gdx.Gdx;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

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

    public ArenaStorage createArenaStorage(ArenaPrefabFilenameRepository repository, AssetStorage assetStorage, Scale scale) {
        try {
            return new ArenaStorage(createArenaMap(repository, assetStorage, scale));
        } catch (Exception e) {
            throw new ArenaStorageCreateException(e);
        }
    }

    private Map<String, Arena> createArenaMap(ArenaPrefabFilenameRepository repository, AssetStorage assetStorage, Scale scale) {
        return arenaPrefabXmlReader.readArenaPrefabs(
                repository.getArenaPrefabFilenames().stream().map(Gdx.files::internal).collect(Collectors.toList())
        ).stream()
                .collect(Collectors.toMap(
                        ArenaPrefab::getTitle,
                        c -> arenaFactory.createArena(c, assetStorage, scale)
                ));
    }
}
