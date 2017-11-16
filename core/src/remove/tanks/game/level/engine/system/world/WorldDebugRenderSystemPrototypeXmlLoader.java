package remove.tanks.game.level.engine.system.world;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class WorldDebugRenderSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<WorldDebugRenderSystemPrototype>
{
    @Override
    protected WorldDebugRenderSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new WorldDebugRenderSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.WorldDebugRenderSystem;
    }
}
