package remove.tanks.game.level.engine.system.world;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class WorldLightRenderSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<WorldLightRenderSystemPrototype>
{
    @Override
    public WorldLightRenderSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new WorldLightRenderSystemPrototype(priority);
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.WorldLightRenderSystem;
    }
}
