package remove.tanks.game.level.engine.system.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;
import remove.tanks.game.level.utility.spawner.SpawnerPrefab;
import remove.tanks.game.level.utility.spawner.SpawnerPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<AutoSpawnerSystemPrefab> {
    private final SpawnerPrefabXmlReader spawnerPrefabXmlReader;

    public AutoSpawnerSystemPrefabXmlReader(SpawnerPrefabXmlReader spawnerPrefabXmlReader) {
        this.spawnerPrefabXmlReader = spawnerPrefabXmlReader;
    }

    @Override
    public AutoSpawnerSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new AutoSpawnerSystemPrefab(
                    priority,
                    readSpawnerPrefabs(element)
            );
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    private List<SpawnerPrefab> readSpawnerPrefabs(XmlReader.Element element) {
        return spawnerPrefabXmlReader.readSpawnerPrefabs(
                element.getChildByName(SpawnerPrefabXmlReader.SPAWNERS_ELEMENT));
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.AutoSpawnerSystem;
    }
}
