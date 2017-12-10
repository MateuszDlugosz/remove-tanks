package remove.tanks.game.level.engine.system.world;

import com.badlogic.gdx.utils.XmlReader;
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
        return new WorldLightRenderSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.WorldLightRenderSystem;
    }
}
