package remove.tanks.game.level.engine.system.world;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class WorldDebugRenderSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<WorldDebugRenderSystemPrototype>
{
    @Override
    public WorldDebugRenderSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new WorldDebugRenderSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.WorldDebugRenderSystem;
    }
}
