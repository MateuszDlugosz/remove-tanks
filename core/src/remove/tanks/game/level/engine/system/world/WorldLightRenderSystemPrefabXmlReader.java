package remove.tanks.game.level.engine.system.world;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class WorldLightRenderSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<WorldLightRenderSystemPrefab> {
    @Override
    public WorldLightRenderSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new WorldLightRenderSystemPrefab(priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.WorldLightRenderSystem;
    }
}
